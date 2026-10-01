package kotlin.internal;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;

/* JADX INFO: compiled from: UProgressionUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m643d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, m644k = 2, m645mv = {1, 8, 0}, m647xi = 48)
public final class UProgressionUtilKt {
    /* JADX INFO: renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m2084differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int iM$2 = UByte$$ExternalSyntheticBackport0.m$2(i, i3);
        int iM$3 = UByte$$ExternalSyntheticBackport0.m$2(i2, i3);
        int iM652m = UByte$$ExternalSyntheticBackport0.m652m(iM$2 ^ Integer.MIN_VALUE, iM$3 ^ Integer.MIN_VALUE);
        int iM962constructorimpl = UInt.m962constructorimpl(iM$2 - iM$3);
        return iM652m >= 0 ? iM962constructorimpl : UInt.m962constructorimpl(iM962constructorimpl + i3);
    }

    /* JADX INFO: renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m2085differenceModulosambcqE(long j, long j2, long j3) {
        long jM655m = UByte$$ExternalSyntheticBackport0.m655m(j, j3);
        long jM655m2 = UByte$$ExternalSyntheticBackport0.m655m(j2, j3);
        int iM654m = UByte$$ExternalSyntheticBackport0.m654m(jM655m, jM655m2);
        long jM1041constructorimpl = ULong.m1041constructorimpl(jM655m - jM655m2);
        return iM654m >= 0 ? jM1041constructorimpl : ULong.m1041constructorimpl(jM1041constructorimpl + j3);
    }

    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m2087getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            if (UByte$$ExternalSyntheticBackport0.m652m(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) < 0) {
                return UInt.m962constructorimpl(i2 - m2084differenceModuloWZ9TVnA(i2, i, UInt.m962constructorimpl(i3)));
            }
        } else if (i3 < 0) {
            if (UByte$$ExternalSyntheticBackport0.m652m(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) > 0) {
                return UInt.m962constructorimpl(i2 + m2084differenceModuloWZ9TVnA(i, i2, UInt.m962constructorimpl(-i3)));
            }
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
        return i2;
    }

    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m2086getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        if (j3 > 0) {
            return UByte$$ExternalSyntheticBackport0.m654m(j, j2) >= 0 ? j2 : ULong.m1041constructorimpl(j2 - m2085differenceModulosambcqE(j2, j, ULong.m1041constructorimpl(j3)));
        }
        if (j3 < 0) {
            return UByte$$ExternalSyntheticBackport0.m654m(j, j2) <= 0 ? j2 : ULong.m1041constructorimpl(j2 + m2085differenceModulosambcqE(j, j2, ULong.m1041constructorimpl(-j3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
