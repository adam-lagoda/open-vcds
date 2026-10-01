package kotlin;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UByte$$ExternalSyntheticBackport0 {
    /* JADX INFO: renamed from: m */
    public static /* synthetic */ int m651m(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ int m652m(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ int m653m(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ int m654m(long j, long j2) {
        return ((j ^ Long.MIN_VALUE) > (j2 ^ Long.MIN_VALUE) ? 1 : ((j ^ Long.MIN_VALUE) == (j2 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ long m655m(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j2) ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if ((j3 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j2)) {
            j2 = 0;
        }
        return j3 - j2;
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ boolean m657m(Object obj) {
        return obj == null;
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ boolean m658m(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ Throwable[] m659m(Throwable th) {
        try {
            return (Throwable[]) Throwable.class.getDeclaredMethod("getSuppressed", null).invoke(th, null);
        } catch (Exception unused) {
            return new Throwable[0];
        }
    }

    public static /* synthetic */ int m$1(int i, int i2) {
        return (int) ((((long) i) & 4294967295L) / (((long) i2) & 4294967295L));
    }

    public static /* synthetic */ long m$1(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return j3 + ((long) (((j - (j3 * j2)) ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0 : 1));
    }

    public static /* synthetic */ int m$2(int i, int i2) {
        return (int) ((((long) i) & 4294967295L) % (((long) i2) & 4294967295L));
    }
}
