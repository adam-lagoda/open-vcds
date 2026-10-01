package com.ross_tech.vcds_mobile_assistant;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Enumeration;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    private static Context context;
    private static WifiManager.WifiLock wifi_lock;
    String current_page;
    ProgressDialog load_dialog;
    private TextView mTextMessage;
    WebView mWebView;

    /* JADX INFO: renamed from: s */
    DatagramSocket f68s;
    ProgressDialog scan_dialog;
    String device_ip = "192.168.0.1";
    String received_ip = "";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new C05511();

    /* JADX INFO: renamed from: com.ross_tech.vcds_mobile_assistant.MainActivity$1 */
    class C05511 implements BottomNavigationView.OnNavigationItemSelectedListener {
        C05511() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            final MainActivity mainActivity = MainActivity.this;
            switch (menuItem.getItemId()) {
                case C0566R.id.navigation_about /* 2131230859 */:
                    AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
                    builder.setMessage(MainActivity.this.getResources().getString(C0566R.string.app_name) + "\nVersion: 0.039 release\nScan mode: 3\n").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.create().show();
                    return true;
                case C0566R.id.navigation_exit /* 2131230860 */:
                    MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                            builder2.setMessage("Are you sure you want to exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.7.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    MainActivity.this.end_session_and_exit();
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.7.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            builder2.create().show();
                        }
                    });
                    return true;
                case C0566R.id.navigation_header_container /* 2131230861 */:
                default:
                    return true;
                case C0566R.id.navigation_refresh /* 2131230862 */:
                    final Handler handler = new Handler();
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(mainActivity);
                    builder2.setMessage("Refreshing may send repeated data to the car and have unintended consequences.  Are you sure you want to refresh?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (mainActivity.isFinishing()) {
                                return;
                            }
                            MainActivity mainActivity2 = mainActivity;
                            mainActivity2.load_dialog = ProgressDialog.show(mainActivity2, "", "Loading...", true);
                            handler.postDelayed(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    System.out.println("closing loader");
                                    if (MainActivity.this.load_dialog != null) {
                                        try {
                                            MainActivity.this.load_dialog.dismiss();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        MainActivity.this.load_dialog = null;
                                    }
                                }
                            }, 10000L);
                            mainActivity.mWebView.loadUrl(mainActivity.current_page);
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder2.create().show();
                    return true;
                case C0566R.id.navigation_scan /* 2131230863 */:
                    if (!MainActivity.this.isFinishing()) {
                        MainActivity.this.scan_dialog = ProgressDialog.show(mainActivity, "", "Scaning for interfaces...", true);
                        new Thread(new AnonymousClass1()).start();
                    }
                    return true;
                case C0566R.id.navigation_tochrome /* 2131230864 */:
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(mainActivity);
                    builder3.setMessage("Opening the browser may lose unsaved data from your current session.  Are you sure you want to continue?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(MainActivity.this.current_page)));
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder3.create().show();
                    return true;
            }
        }

        /* JADX INFO: renamed from: com.ross_tech.vcds_mobile_assistant.MainActivity$1$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int iScanForInterfaces;
                final int i = 0;
                do {
                    i++;
                    iScanForInterfaces = MainActivity.this.scanForInterfaces();
                    if (iScanForInterfaces < 0) {
                        try {
                            Thread.sleep(100L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MainActivity.this.scan_dialog != null) {
                                    try {
                                        MainActivity.this.scan_dialog.setMessage("Scanning for interfaces... " + (i * 20) + "%");
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                    if (iScanForInterfaces >= 0) {
                        break;
                    }
                } while (i < 5);
                if (MainActivity.this.scan_dialog != null) {
                    try {
                        MainActivity.this.scan_dialog.dismiss();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    MainActivity.this.scan_dialog = null;
                }
                if (iScanForInterfaces < 0) {
                    MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(MainActivity.context, "Failed to autodetect interface...", 0).show();
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Interface not found");
                            builder.setMessage("You may manually enter an IP, or cancel to scan again");
                            final EditText editText = new EditText(MainActivity.this);
                            editText.setInputType(1);
                            builder.setView(editText);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.1.2.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    MainActivity.this.device_ip = editText.getText().toString();
                                    MainActivity.this.current_page = "http://" + MainActivity.this.device_ip + "/";
                                    System.out.println("Loading " + MainActivity.this.current_page);
                                    MainActivity.this.mWebView.loadUrl(MainActivity.this.current_page);
                                }
                            });
                            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.1.1.2.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            });
                            builder.show();
                        }
                    });
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("d", "onCreate");
        requestWindowFeature(1);
        setContentView(C0566R.layout.activity_main);
        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(C0566R.id.nav_view);
        Context applicationContext = getApplicationContext();
        context = applicationContext;
        try {
            WifiManager.WifiLock wifiLockCreateWifiLock = ((WifiManager) applicationContext.getSystemService("wifi")).createWifiLock(3, "wlock1");
            wifi_lock = wifiLockCreateWifiLock;
            wifiLockCreateWifiLock.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(this.mOnNavigationItemSelectedListener);
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[]{android.R.attr.state_focused, android.R.attr.state_pressed}, new int[]{android.R.attr.state_enabled}}, new int[]{-7829368, ViewCompat.MEASURED_STATE_MASK, -7829368, ViewCompat.MEASURED_STATE_MASK});
        bottomNavigationView.setItemIconTintList(colorStateList);
        bottomNavigationView.setItemTextColor(colorStateList);
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), new OnApplyWindowInsetsListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return this.f$0.m640x5feaa272(bottomNavigationView, view, windowInsetsCompat);
            }
        });
        WebView webView = (WebView) findViewById(C0566R.id.webview);
        this.mWebView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setSupportZoom(true);
        this.mWebView.getSettings().setBuiltInZoomControls(true);
        this.mWebView.getSettings().setCacheMode(2);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.setInitialScale(75);
        C05511 c05511 = null;
        if (Build.VERSION.SDK_INT >= 19) {
            this.mWebView.setLayerType(2, null);
        } else {
            this.mWebView.setLayerType(1, null);
        }
        this.mWebView.setWebViewClient(new VCDSWebViewClient(this, c05511));
        this.mWebView.setWebChromeClient(new VCDSWebChromeClient(this, c05511));
        if (bundle == null || !bundle.containsKey("currentpage") || bundle.getString("currentpage") == null) {
            this.current_page = "http://" + this.device_ip + "/";
            if (!isFinishing()) {
                this.scan_dialog = ProgressDialog.show(this, "", "Scanning for interfaces...", false);
            }
            new Thread(new RunnableC05542()).start();
            return;
        }
        this.current_page = bundle.getString("currentpage");
        this.mWebView.restoreState(bundle);
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-ross_tech-vcds_mobile_assistant-MainActivity */
    /* synthetic */ WindowInsetsCompat m640x5feaa272(BottomNavigationView bottomNavigationView, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        bottomNavigationView.setPadding(insets.left, 0, insets.right, insets.bottom + 5);
        view.setPadding(insets.left, insets.top, insets.right, 0);
        this.mWebView.setPadding(insets.left, insets.top, insets.right, 0);
        getWindow().getDecorView().setPadding(insets.left, insets.top, insets.right, 0);
        return WindowInsetsCompat.CONSUMED;
    }

    /* JADX INFO: renamed from: com.ross_tech.vcds_mobile_assistant.MainActivity$2 */
    class RunnableC05542 implements Runnable {
        RunnableC05542() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iScanForInterfaces;
            final int i = 0;
            do {
                i++;
                iScanForInterfaces = MainActivity.this.scanForInterfaces();
                if (iScanForInterfaces < 0) {
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MainActivity.this.scan_dialog != null) {
                                try {
                                    MainActivity.this.scan_dialog.setMessage("Scanning for interfaces... " + (i * 20) + "%");
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                }
                if (iScanForInterfaces >= 0) {
                    break;
                }
            } while (i < 5);
            if (MainActivity.this.scan_dialog != null) {
                try {
                    MainActivity.this.scan_dialog.dismiss();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                MainActivity.this.scan_dialog = null;
            }
            if (iScanForInterfaces < 0) {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(MainActivity.context, "Failed to autodetect interface...", 0).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Interface not found");
                        builder.setMessage("You may manually enter an IP, or cancel to scan again");
                        final EditText editText = new EditText(MainActivity.this);
                        editText.setInputType(1);
                        builder.setView(editText);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.2.2.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                MainActivity.this.device_ip = editText.getText().toString();
                                MainActivity.this.current_page = "http://" + MainActivity.this.device_ip + "/";
                                System.out.println("Loading " + MainActivity.this.current_page);
                                MainActivity.this.mWebView.loadUrl(MainActivity.this.current_page);
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.2.2.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        builder.show();
                    }
                });
            }
        }
    }

    public int scanForInterfaces() {
        int i;
        int i2;
        byte b;
        int i3;
        String[] strArr = new String[50];
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i = 256;
            i2 = 777;
            b = 4;
            if (i4 < 2) {
                try {
                    DatagramSocket datagramSocket = new DatagramSocket();
                    this.f68s = datagramSocket;
                    datagramSocket.setSoTimeout(2000);
                    this.f68s.setReuseAddress(true);
                    this.f68s.setBroadcast(true);
                    this.f68s.send(new DatagramPacket(new byte[]{83, 4, 2, 85}, 4, InetAddress.getByName("255.255.255.255"), 777));
                    byte[] bArr = new byte[256];
                    while (true) {
                        DatagramPacket datagramPacket = new DatagramPacket(bArr, 256);
                        try {
                            this.f68s.receive(datagramPacket);
                            String hostAddress = datagramPacket.getAddress().getHostAddress();
                            int i6 = 0;
                            while (true) {
                                if (i6 < i5) {
                                    if (strArr[i6].equals(hostAddress)) {
                                        break;
                                    }
                                    i6++;
                                } else {
                                    strArr[i5] = hostAddress;
                                    i5++;
                                    System.out.println("Device found at ip:" + hostAddress);
                                    this.received_ip = hostAddress;
                                    runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.3
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Toast.makeText(MainActivity.context, "Device found at ip:" + MainActivity.this.received_ip, 0).show();
                                            if (MainActivity.this.scan_dialog != null) {
                                                try {
                                                    MainActivity.this.scan_dialog.setMessage("Scanning for interfaces... 50%");
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                    });
                                    break;
                                }
                            }
                        } catch (Exception unused) {
                            try {
                                DatagramPacket datagramPacket2 = new DatagramPacket(new byte[]{83, 4, 2, 85}, 4, InetAddress.getByName("169.254.255.255"), 777);
                                DatagramSocket datagramSocket2 = this.f68s;
                                if (datagramSocket2 != null) {
                                    datagramSocket2.close();
                                }
                                DatagramSocket datagramSocket3 = new DatagramSocket();
                                this.f68s = datagramSocket3;
                                datagramSocket3.setSoTimeout(1000);
                                this.f68s.setReuseAddress(true);
                                this.f68s.setBroadcast(true);
                                this.f68s.send(datagramPacket2);
                                byte[] bArr2 = new byte[256];
                                while (true) {
                                    DatagramPacket datagramPacket3 = new DatagramPacket(bArr2, 256);
                                    try {
                                        this.f68s.receive(datagramPacket3);
                                        String hostAddress2 = datagramPacket3.getAddress().getHostAddress();
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 < i5) {
                                                if (strArr[i7].equals(hostAddress2)) {
                                                    break;
                                                }
                                                i7++;
                                            } else {
                                                strArr[i5] = hostAddress2;
                                                i5++;
                                                System.out.println("Device found at ip:" + hostAddress2);
                                                this.received_ip = hostAddress2;
                                                runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.4
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        Toast.makeText(MainActivity.context, "Device found at ip:" + MainActivity.this.received_ip, 0).show();
                                                        if (MainActivity.this.scan_dialog != null) {
                                                            try {
                                                                MainActivity.this.scan_dialog.setMessage("Scanning for interfaces... 50%");
                                                            } catch (Exception e) {
                                                                e.printStackTrace();
                                                            }
                                                        }
                                                    }
                                                });
                                                break;
                                            }
                                        }
                                    } catch (Exception unused2) {
                                        try {
                                            DatagramPacket datagramPacket4 = new DatagramPacket(new byte[]{83, 4, 2, 85}, 4, InetAddress.getByName("192.168." + detect_wifi_tether() + ".255"), 777);
                                            DatagramSocket datagramSocket4 = this.f68s;
                                            if (datagramSocket4 != null) {
                                                datagramSocket4.close();
                                            }
                                            DatagramSocket datagramSocket5 = new DatagramSocket();
                                            this.f68s = datagramSocket5;
                                            datagramSocket5.setSoTimeout(1000);
                                            this.f68s.setReuseAddress(true);
                                            this.f68s.setBroadcast(true);
                                            this.f68s.send(datagramPacket4);
                                            byte[] bArr3 = new byte[256];
                                            while (true) {
                                                DatagramPacket datagramPacket5 = new DatagramPacket(bArr3, 256);
                                                try {
                                                    this.f68s.receive(datagramPacket5);
                                                    String hostAddress3 = datagramPacket5.getAddress().getHostAddress();
                                                    int i8 = 0;
                                                    while (true) {
                                                        if (i8 < i5) {
                                                            if (strArr[i8].equals(hostAddress3)) {
                                                                break;
                                                            }
                                                            i8++;
                                                        } else {
                                                            strArr[i5] = hostAddress3;
                                                            i5++;
                                                            System.out.println("Device found at ip:" + hostAddress3);
                                                            this.received_ip = hostAddress3;
                                                            runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.5
                                                                @Override // java.lang.Runnable
                                                                public void run() {
                                                                    Toast.makeText(MainActivity.context, "Device found at ip:" + MainActivity.this.received_ip, 0).show();
                                                                    if (MainActivity.this.scan_dialog != null) {
                                                                        try {
                                                                            MainActivity.this.scan_dialog.setMessage("Scanning for interfaces... 50%");
                                                                        } catch (Exception e) {
                                                                            e.printStackTrace();
                                                                        }
                                                                    }
                                                                }
                                                            });
                                                            break;
                                                        }
                                                    }
                                                } catch (Exception unused3) {
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            try {
                                                this.f68s.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } else {
                try {
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    try {
                        this.f68s.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            i4++;
        }
        DatagramPacket datagramPacket6 = new DatagramPacket(new byte[]{83, 4, 2, 85}, 4, InetAddress.getByName("10." + detect_ten_base_wifi_tether() + ".255"), 777);
        DatagramSocket datagramSocket6 = this.f68s;
        if (datagramSocket6 != null) {
            datagramSocket6.close();
        }
        DatagramSocket datagramSocket7 = new DatagramSocket();
        this.f68s = datagramSocket7;
        datagramSocket7.setSoTimeout(1000);
        this.f68s.setReuseAddress(true);
        this.f68s.setBroadcast(true);
        this.f68s.send(datagramPacket6);
        byte[] bArr4 = new byte[256];
        while (true) {
            DatagramPacket datagramPacket7 = new DatagramPacket(bArr4, 256);
            try {
                this.f68s.receive(datagramPacket7);
                String hostAddress4 = datagramPacket7.getAddress().getHostAddress();
                int i9 = 0;
                while (true) {
                    if (i9 < i5) {
                        if (strArr[i9].equals(hostAddress4)) {
                            break;
                        }
                        i9++;
                    } else {
                        strArr[i5] = hostAddress4;
                        i5++;
                        System.out.println("Device found at ip:" + hostAddress4);
                        this.received_ip = hostAddress4;
                        runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.6
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(MainActivity.context, "Device found at ip:" + MainActivity.this.received_ip, 0).show();
                                if (MainActivity.this.scan_dialog != null) {
                                    try {
                                        MainActivity.this.scan_dialog.setMessage("Scanning for interfaces... 50%");
                                    } catch (Exception e7) {
                                        e7.printStackTrace();
                                    }
                                }
                            }
                        });
                        break;
                    }
                }
            } catch (Exception unused4) {
                if (i5 > 0) {
                    boolean[] zArr = new boolean[i5];
                    int i10 = 0;
                    while (true) {
                        i3 = 9;
                        if (i10 >= i5) {
                            break;
                        }
                        byte[] bArr5 = {4, 10, 1, 0, 0, 12, 0, 0, 0, 3};
                        zArr[i10] = z;
                        try {
                            try {
                                this.f68s.send(new DatagramPacket(bArr5, 10, InetAddress.getByName(strArr[i10]), 777));
                                byte[] bArr6 = new byte[256];
                                while (true) {
                                    try {
                                        this.f68s.receive(new DatagramPacket(bArr6, 256));
                                        if (bArr6[0] == 4 && bArr6[5] == 12 && bArr6[8] == 4 && (bArr6[9] != 0 || bArr6[10] != 0 || bArr6[11] != 0 || bArr6[12] != 0)) {
                                            zArr[i10] = true;
                                        }
                                    } catch (Exception e7) {
                                        e7.printStackTrace();
                                        runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.7
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                if (MainActivity.this.scan_dialog != null) {
                                                    try {
                                                        MainActivity.this.scan_dialog.setMessage("Scanning for interfaces... 80%");
                                                    } catch (Exception e8) {
                                                        e8.printStackTrace();
                                                    }
                                                }
                                            }
                                        });
                                        i10++;
                                        z = false;
                                    }
                                }
                            } catch (Exception e8) {
                                e = e8;
                                e.printStackTrace();
                                i10++;
                                z = false;
                            }
                        } catch (Exception e9) {
                            e = e9;
                        }
                        i10++;
                        z = false;
                    }
                    String[] strArr2 = new String[i5];
                    int i11 = 0;
                    while (i11 < i5) {
                        try {
                            try {
                                this.f68s.send(new DatagramPacket(new byte[]{4, 10, 1, 0, 0, 23, 0, 0, 0, 24}, 10, InetAddress.getByName(strArr[i11]), i2));
                                byte[] bArr7 = new byte[i];
                                while (true) {
                                    try {
                                        this.f68s.receive(new DatagramPacket(bArr7, i));
                                        if (bArr7[0] == b && bArr7[5] == 23 && bArr7[8] >= 24) {
                                            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr7, i3, 33);
                                            byte[] bArr8 = new byte[6];
                                            for (int i12 = 0; i12 < 6; i12++) {
                                                int i13 = i12 * 2;
                                                try {
                                                    bArr8[i12] = (byte) Integer.parseInt(new String(new byte[]{bArrCopyOfRange[i13], bArrCopyOfRange[i13 + 1]}, "UTF-8"), 16);
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    try {
                                                        e.printStackTrace();
                                                        runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.8
                                                            @Override // java.lang.Runnable
                                                            public void run() {
                                                                if (MainActivity.this.scan_dialog != null) {
                                                                    try {
                                                                        MainActivity.this.scan_dialog.setMessage("Scanning for interfaces... 90%");
                                                                    } catch (Exception e11) {
                                                                        e11.printStackTrace();
                                                                    }
                                                                }
                                                            }
                                                        });
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        e.printStackTrace();
                                                        i11++;
                                                        i3 = 9;
                                                        i = 256;
                                                        i2 = 777;
                                                        b = 4;
                                                    }
                                                    i11++;
                                                    i3 = 9;
                                                    i = 256;
                                                    i2 = 777;
                                                    b = 4;
                                                }
                                            }
                                            strArr2[i11] = String.format("HN%d-%06d", Integer.valueOf(((bArr8[0] & UByte.MAX_VALUE) << 8) | (bArr8[1] & UByte.MAX_VALUE)), Integer.valueOf((bArr8[5] & UByte.MAX_VALUE) | ((bArr8[2] & UByte.MAX_VALUE) << 24) | ((bArr8[3] & UByte.MAX_VALUE) << 16) | ((bArr8[4] & UByte.MAX_VALUE) << 8)));
                                        }
                                        i3 = 9;
                                        i = 256;
                                        b = 4;
                                    } catch (Exception e12) {
                                        e = e12;
                                    }
                                }
                            } catch (Exception e13) {
                                e = e13;
                                e.printStackTrace();
                                i11++;
                                i3 = 9;
                                i = 256;
                                i2 = 777;
                                b = 4;
                            }
                        } catch (Exception e14) {
                            e = e14;
                        }
                    }
                    String[] strArr3 = new String[i5];
                    for (int i14 = 0; i14 < i5; i14++) {
                        if (zArr[i14]) {
                            if (strArr2[i14] != null) {
                                strArr3[i14] = strArr2[i14] + " " + strArr[i14] + "|busy";
                            } else {
                                strArr3[i14] = strArr[i14] + "|busy";
                            }
                        } else if (strArr2[i14] != null) {
                            strArr3[i14] = strArr2[i14] + " " + strArr[i14];
                        } else {
                            strArr3[i14] = strArr[i14];
                        }
                    }
                    runOnUiThread(new RunnableC05619(strArr3, strArr, this));
                    try {
                        this.f68s.close();
                    } catch (Exception e15) {
                        e15.printStackTrace();
                    }
                    return 0;
                }
                try {
                    this.f68s.close();
                    return -1;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return -1;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.ross_tech.vcds_mobile_assistant.MainActivity$9 */
    class RunnableC05619 implements Runnable {
        final /* synthetic */ MainActivity val$browser;
        final /* synthetic */ String[] val$dev_list;
        final /* synthetic */ String[] val$devices;

        RunnableC05619(String[] strArr, String[] strArr2, MainActivity mainActivity) {
            this.val$dev_list = strArr;
            this.val$devices = strArr2;
            this.val$browser = mainActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            final Handler handler = new Handler();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Connect to interface:").setItems(this.val$dev_list, new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.9.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.this.device_ip = RunnableC05619.this.val$devices[i];
                    MainActivity.this.current_page = "http://" + MainActivity.this.device_ip + "/";
                    System.out.println("Loading " + MainActivity.this.current_page);
                    if (!MainActivity.this.isFinishing()) {
                        RunnableC05619.this.val$browser.load_dialog = ProgressDialog.show(RunnableC05619.this.val$browser, "", "Loading...", true);
                        handler.postDelayed(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.9.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                System.out.println("closing loader");
                                if (MainActivity.this.load_dialog != null) {
                                    try {
                                        MainActivity.this.load_dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    MainActivity.this.load_dialog = null;
                                }
                            }
                        }, 10000L);
                    }
                    MainActivity.this.mWebView.loadUrl(MainActivity.this.current_page);
                }
            });
            if (MainActivity.this.isFinishing()) {
                return;
            }
            builder.create().show();
        }
    }

    public String detect_wifi_tether() {
        try {
            System.out.println("Scanning for wifi tether...");
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        String string = inetAddressNextElement.getHostAddress().toString();
                        System.out.println("addr:" + string);
                        if (string.startsWith("192.168")) {
                            String strSubstring = string.substring(8);
                            String strSubstring2 = strSubstring.substring(0, strSubstring.indexOf("."));
                            System.out.println("Found subnet:" + strSubstring2);
                            return strSubstring2;
                        }
                    }
                }
            }
            return "3";
        } catch (Exception e) {
            e.printStackTrace();
            return "3";
        }
    }

    public String detect_ten_base_wifi_tether() {
        try {
            System.out.println("Scanning for wifi tether...");
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        String string = inetAddressNextElement.getHostAddress().toString();
                        System.out.println("addr:" + string);
                        if (string.startsWith("10.")) {
                            String strSubstring = string.substring(3);
                            String strSubstring2 = strSubstring.substring(0, strSubstring.lastIndexOf("."));
                            System.out.println("Found subnet:" + strSubstring2);
                            return strSubstring2;
                        }
                    }
                }
            }
            return "0.0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0.0";
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Log.d("d", "onSave");
        bundle.putString("currentpage", this.current_page);
        this.mWebView.saveState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d("d", "onConfigChanged");
    }

    public void end_session_and_exit() {
        this.mWebView.loadUrl("http://" + this.device_ip + "/index.shtml?killsession=true");
        finishAffinity();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Handler handler = new Handler();
        if (this.current_page.contains("/logs") || this.current_page.contains("/debug")) {
            this.current_page = "http://" + this.device_ip + "/viewsavedfiles.shtml?getlist=true";
            if (!isFinishing()) {
                this.load_dialog = ProgressDialog.show(this, "", "Loading...", true);
                handler.postDelayed(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MainActivity.this.load_dialog != null) {
                            try {
                                MainActivity.this.load_dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 5000L);
            }
            this.mWebView.loadUrl("http://" + this.device_ip + "/viewsavedfiles.shtml?getlist=true");
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.11
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.11.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.end_session_and_exit();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.11.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
            }
        });
    }

    private class VCDSWebChromeClient extends WebChromeClient {
        private VCDSWebChromeClient() {
        }

        /* synthetic */ VCDSWebChromeClient(MainActivity mainActivity, C05511 c05511) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, final String str2, final JsResult jsResult) {
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.VCDSWebChromeClient.1
                @Override // java.lang.Runnable
                public void run() {
                    new AlertDialog.Builder(MainActivity.this).setTitle("Alert:").setMessage(str2).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.VCDSWebChromeClient.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }).setCancelable(false).create().show();
                }
            });
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, final int i) {
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.VCDSWebChromeClient.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (MainActivity.this.load_dialog != null) {
                            MainActivity.this.load_dialog.setMessage("Loading... " + i + "%");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private class VCDSWebViewClient extends WebViewClient {
        private Handler handler;

        private VCDSWebViewClient() {
            this.handler = new Handler();
        }

        /* synthetic */ VCDSWebViewClient(MainActivity mainActivity, C05511 c05511) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            MainActivity.this.current_page = str;
            if (!str.contains("gauges.shtml") && !str.contains("vlistg.shtml") && !str.contains("session_") && !str.contains("server_menu") && !str.contains("save") && !str.contains("delete") && !str.contains("-d") && !str.contains("statusmessage") && !str.contains("index")) {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.VCDSWebViewClient.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MainActivity.this.isFinishing()) {
                            return;
                        }
                        MainActivity.this.load_dialog = ProgressDialog.show(MainActivity.this, "", "Loading...", true);
                        VCDSWebViewClient.this.handler.postDelayed(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.VCDSWebViewClient.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                System.out.println("closing loader");
                                if (MainActivity.this.load_dialog != null) {
                                    try {
                                        MainActivity.this.load_dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    MainActivity.this.load_dialog = null;
                                }
                            }
                        }, 10000L);
                    }
                });
            }
            webView.loadUrl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            try {
                if (MainActivity.this.load_dialog != null) {
                    if (!str.contains("faultcode") && !str.contains("index")) {
                        MainActivity.this.load_dialog.setMessage("Rendering...");
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() { // from class: com.ross_tech.vcds_mobile_assistant.MainActivity.VCDSWebViewClient.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MainActivity.this.mWebView.getContentHeight() > 0) {
                                    try {
                                        if (MainActivity.this.load_dialog != null) {
                                            try {
                                                MainActivity.this.load_dialog.dismiss();
                                                MainActivity.this.load_dialog = null;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        return;
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        return;
                                    }
                                }
                                handler.postDelayed(this, 100L);
                            }
                        }, 100L);
                        return;
                    }
                    MainActivity.this.load_dialog.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        System.out.println("onStop");
        try {
            WifiManager.WifiLock wifiLock = wifi_lock;
            if (wifiLock != null) {
                wifiLock.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onStop();
    }
}
