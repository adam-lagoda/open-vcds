package androidx.core.util;

import android.os.Build;
import java.util.Arrays;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes.dex */
public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.equals(obj, obj2);
        }
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static int hash(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.hash(objArr);
        }
        return Arrays.hashCode(objArr);
    }

    public static String toString(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }

    public static <T> T requireNonNull(T t) {
        t.getClass();
        return t;
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean equals(Object obj, Object obj2) {
            return UByte$$ExternalSyntheticBackport0.m658m(obj, obj2);
        }

        static int hash(Object... objArr) {
            return Arrays.hashCode(objArr);
        }
    }
}
