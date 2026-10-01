# open-vcds — project notes

## Starting point
- Repo is currently empty.
- User owns a genuine VCDS HEX-V2 cable (USB, works fine with VCDS on Windows).
- Ross-Tech only ships an official Android app for the HEX-NET cable (WiFi/Bluetooth), not for HEX-V2 (USB-only, PC-tethered).
- Goal: build an Android app that works with the HEX-V2 cable over USB-OTG, since no official Android support exists for it.

## HEX-V2 hardware facts
- HEX-V2 connects via USB, contains an FTDI USB-to-serial chip.
- FTDI provides VCP (virtual COM port) and D2XX drivers for Windows/PC use; not open source.
- Modern 32-bit microcontroller, updatable firmware, tri-color status LED, embedded VCDS license (dongle behavior).
- Protocol support: KWP2000 (ISO 14230-2, K-Line, incl. 2001+ Teves Mk.60 ABS and later modules), KWP6000 (CAN), KWP7000/UDS.
- Compatible with VW/Audi/Seat/Skoda vehicles from ~1990s (VW 1995+, Audi 1996+) through current, OBD-II connector.

## Android feasibility
- Android has no native support for HEX-NET-style wireless comms on HEX-V2 — HEX-V2 must connect via **USB-OTG** (phone/tablet ↔ cable, direct wired connection).
- Android's USB Host API + libraries like `usb-serial-for-android` support FTDI chips (and CH340/CP2102/Prolific) directly, so the transport layer is solvable without vendor drivers.
- KWP2000 fast-init sequence and VAG-specific services (0x18 read faults, 0x14 clear faults, etc.) form the protocol layer that needs implementing on top of the USB-serial transport.

## Prior art found (web research)
- **guns96x/vcds-android** (GitHub) — mobile diagnostic tool/logger for Bosch EDC16 ECUs on VAG PQ35 platforms (e.g. Golf 5 1.9 TDI BLS). Supports direct USB-OTG with FTDI (FT232R/BM), CH340, CP2102, Prolific adapters. Uses KWP2000 over K-Line at 10400 bps with fast init. Has an open issue specifically about reverse-engineering the "B03-V2" FTDI clone (relevant to HEX-V2-style hardware).
- **bri3d/kwp-android-logger** — KWP2000 logger for Android, originally built for VAG (Touareg, Cayenne). Uses an abstracted hardware interface (currently Bluetooth-based) with a `KWP2000IO`-style protocol class that could plausibly be extended for USB.
- **MartijnD92/PyVCDS** (GitHub) — Python-based VCDS-adjacent project, not yet investigated in depth.
- General open-source diagnostic tool landscape: multiple FOSS ECU diagnostic tools support KWP2000/UDS across brands including VAG (see medevel.com "23 Open-Source Car Diagnostic Apps" roundup).
- FTDI itself does not open-source VCP/D2XX, but there is a GPL'd open-source alternative referenced at intra2net.com (unverified throughput/feature parity).

## Direction discussed
- Primary goal selected: **Android app for HEX-V2 via USB-OTG** (not a broader cross-platform tool, not just research).
- Scope selected: **Full VCDS-style functionality** (not just VIN + basic fault read/clear) — aiming for parity with what the HEX-NET Android app already offers (coding, adaptation, live measuring blocks, etc.), not just the minimal DTC read/clear scope that vcds-android currently targets.
- User's proposed method to reach that scope: take the official Ross-Tech HEX-NET Android APK, decompile it, and replicate its functionality, adapting it to work with the HEX-V2 cable over USB-OTG instead of HEX-NET's wireless transport.

## HEX-NET APK reverse engineering (decompiled `VCDS-Mobile+Assistant_0.039_apkcombo.com.apk`)
- Package `com.ross_tech.vcds_mobile_assistant`, v0.039 (39), decompiled with jadx to `VCDS-Mobile+Assistant_0.039_apkcombo.com-decompiled/`.
- **Key finding: the APK contains no VCDS/KWP2000/UDS protocol logic at all.** It's a thin single-Activity WebView shell (`MainActivity.java`) — no Retrofit/OkHttp, no third-party SDKs, no native `.so` libs. Permissions are just `INTERNET` + `WAKE_LOCK`.
- All real diagnostic logic (coding, adaptation, live measuring blocks, fault read/clear, etc.) lives on the **HEX-NET device's own embedded HTTP server**, rendered as `.shtml` pages (`index.shtml`, `gauges.shtml`, `vlistg.shtml`, `viewsavedfiles.shtml`, etc.) that the WebView just loads and navigates. `usesCleartextTraffic=true` — everything is plain HTTP.
- Device discovery: UDP broadcast on port **777**, packet `{0x53,0x04,0x02,0x55}` (`"S\x04\x02U"`), broadcast to `255.255.255.255` then subnet-scoped fallbacks (`192.168.x.255`, `169.254.255.255`, `10.x.x.255`) detected from local interface IPs. Replies parsed for device serial (`HN%d-%06d` format) and busy-status via follow-up UDP queries (opcodes `0x17`/`0x18`).
- **Implication for the HEX-V2 project**: decompiling/replicating the HEX-NET APK gets us nothing toward the actual protocol layer — there's no KWP2000/UDS implementation to port. The app-side "replicate HEX-NET's Android app" approach only gives a WebView UI shell; it doesn't reduce the real work, which is HEX-V2's own embedded firmware/protocol on the wire (FTDI serial ↔ KWP2000/UDS), not app-side logic. This pushes toward the **clean-room protocol implementation** option (referencing vcds-android, kwp-android-logger) rather than the decompile-and-adapt option, since there's no HEX-NET app code to adapt in the first place.

## Status
- No code written yet. No architecture/design finalized. No spec doc created.
- Open question resolved in part: decompiling the HEX-NET APK does not shortcut the protocol work (see above) — the app is a dumb WebView client. Still not decided: proceed via clean-room KWP2000/UDS implementation over USB-OTG referencing prior art, vs. some other approach. HEX-V2's actual diagnostic web server would need to be reverse-engineered separately (its `.shtml` API surface), since that's where the real logic lives on HEX-NET-style hardware — unclear if HEX-V2 exposes anything analogous or expects host-side protocol handling instead.

## Windows VCDS installer reverse engineering (`VCDS-Release-26.9.0-Installer.exe`, Release 26.9.0)

### Installer unpacking
- Installer is an **NSIS 3.12** self-extracting archive (`Nullsoft.NSIS.exehead`), signed, `requireAdministrator`. Unpacks cleanly with `7zz x` (macOS Homebrew 7-Zip) — 21,259 files, ~124MB uncompressed, LZMA solid archive.
- Extracted payload (`open-vcds/extracted/`) contains: main app binaries (`VCDS-64.exe`, `VCDS-32.exe`, `VCDS-ARM.exe`), USB driver stack (`RT-USB.sys`/`RT-USB64.sys`, `RT-USB.dll`/`RTUS64.dll`, `.inf`/`.cat` driver packages, `dpinst32/64.exe`), companion tools (`VCScope`, `TDIGraph`, `LCode`, `CSVConv`, `VCDSScan`), and data files (`Codes.dat`, `Labels/` dir, `HN121.bin`/`HP196.bin`-style firmware/config blobs, `VCIConfig/`).

### Key finding: RTUS64.dll is FTDI's own D2XX driver, just renamed
- `RTUS64.dll` (and by extension `RT-USB.dll`) is **not custom Ross-Tech code** — it's FTDI's official `FTD2XX64.dll` redistributable driver relabeled. Confirmed via: (1) embedded PDB path `c:\Users\andy.miller\Desktop\Windows Driver Development\v2.10.00.RC2\d2xxdll\x64\Release\FTD2XX64.pdb` (compiled 2014), (2) full set of exported symbols are standard `FT_*` calls (`FT_Open`, `FT_Read`, `FT_Write`, `FT_SetBaudRate`, `FT_SetBitMode`, `FT_EEPROM_*`, etc.).
- `VCDS-64.exe` calls into this DLL only via `Ordinal_6` (an `FT_*` function accessed by ordinal, not by name) plus HID/SetupAPI calls for device enumeration — confirming the USB interface cable is FTDI-chip-based, communicated with via the standard FTDI D2XX API, not a proprietary USB protocol.
- **Implication for the Android/open-vcds project**: this independently confirms (from the actual shipped driver, not just spec docs) that HEX-V2-style USB comms are plain FTDI D2XX/VCP — reinforces that Android's `usb-serial-for-android` (which already supports FTDI chips) is the correct transport-layer approach, no vendor-specific USB protocol to reverse-engineer at that layer.

### VCDS-64.exe is packed with Enigma Protector
- `VCDS-64.exe`: PE32+ x86-64, "stripped to external PDB" (no debug symbols), not itself packed at first glance but static analysis (`radare2`) showed only 28 functions total and near-zero readable strings (~1,100 in a 4MB file) — signs of packing.
- Confirmed packer via literal marker strings in the binary: `"Enigma Protector CA"`, `"Enigma Protector CA0"`, `"Enigma Protector0"`, `"Enigma Protector1"`.
- Section entropy is ~7.99–8.0 (near-maximum) across almost all PE sections, generic unnamed sections (`sect_0`...`sect_7` instead of `.text`/`.data`/`.rdata`), and one section has a virtual size of ~312MB vs. a physical size of ~96KB (classic unpack-stub-allocates-huge-region-then-decompresses-into-it pattern) — all consistent with Enigma Protector's per-section encryption.
- PE Rich Header reveals the *original* pre-packing toolchain: **MSVC 2008 (v9.0, LTCG C/C++)** — i.e., VCDS's native codebase predates modern MSVC and has presumably been incrementally maintained since around that era.
- **Practical consequence**: static disassembly/decompilation (Ghidra/IDA/r2) of `VCDS-64.exe` as distributed only reveals Enigma's decryption stub, not the real VCDS logic (protocol framing, KWP2000/UDS command tables, coding/adaptation logic, license/dongle checks). Getting at the real code requires **dynamic unpacking**: run under a debugger, defeat Enigma's anti-debug checks, break at the tail-jump to the real OEP (original entry point) once Enigma finishes decrypting in memory, dump the process, then fix up the IAT.

### Dynamic unpacking attempt — environment setup (in progress)
- x64dbg (the debugger needed for OEP-finding) is Windows-only; this workstation is Apple Silicon macOS with no Wine/VM — had to stand up a Windows VM from scratch.
- Installed **UTM** (free, QEMU-based, via `brew install --cask utm`) as the VM host.
- Chose **Emulate** (not Virtualize) for the VM's CPU mode — full QEMU x86-64 emulation, deliberately avoiding Windows-on-ARM's built-in x64 emulation layer, since debugging an already anti-debug-hardened binary through *two* stacked translation layers (ARM64 Windows emulating x64 + x64dbg debugging within that) seemed likely to be more fragile than straight QEMU x86-64 emulation of genuine x64 Windows.
- Went through two wrong-ISO false starts before getting a working boot: first ISO grabbed was Windows 11 **ARM64** (bootloader was `bootaa64.efi`, no `bootx64.efi` present — silently incompatible with the x86_64-emulated VM). Re-downloaded via CrystalFetch with **Intel x64** explicitly selected fixed it (`bootx64.efi` present, `x64FRE` in filename).
- Windows 11 x64 install then blocked by TPM/Secure Boot system requirements check ("This PC doesn't currently meet Windows 11 system requirements") — switched to a **Windows 10 x64 ISO** instead, which has no TPM/Secure Boot gate and is fully sufficient for running x64dbg/ScyllaHide against VCDS-64.exe.
- Also hit: initial VM virtual disk was only 32GB, below Windows 11's 64GB minimum (moot now that we've switched to Windows 10, but worth noting the VM disk should be resized to 80–100GB+ regardless, to comfortably fit Windows + x64dbg + ScyllaHide + Scylla + the VCDS installer).
- **Status as of this note**: Windows 10 x64 installer is running inside the UTM VM. Not yet done: install x64dbg + ScyllaHide (needed to bypass Enigma's anti-debug detection) + Scylla (for post-unpack IAT reconstruction/dumping), copy `VCDS-64.exe` into the VM, perform OEP-finding and memory dump, then bring the unpacked binary back to macOS for Ghidra/r2 decompilation of the real protocol logic.
