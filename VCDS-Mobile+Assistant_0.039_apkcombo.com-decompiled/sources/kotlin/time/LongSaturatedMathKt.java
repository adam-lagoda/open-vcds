package kotlin.time;

import kotlin.Metadata;

/* JADX INFO: compiled from: longSaturatedMath.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0001H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m643d2 = {"checkInfiniteSumDefined", "", "longNs", "duration", "Lkotlin/time/Duration;", "durationNs", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAdd", "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAddInHalves", "saturatingAddInHalves-pTJri5U", "saturatingDiff", "valueNs", "originNs", "saturatingFiniteDiff", "value1Ns", "value2Ns", "saturatingOriginsDiff", "origin1Ns", "origin2Ns", "isSaturated", "", "kotlin-stdlib"}, m644k = 2, m645mv = {1, 8, 0}, m647xi = 48)
public final class LongSaturatedMathKt {
    private static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == Long.MAX_VALUE;
    }

    /* JADX INFO: renamed from: saturatingAdd-pTJri5U, reason: not valid java name */
    public static final long m2328saturatingAddpTJri5U(long j, long j2) {
        long jM2220getInWholeNanosecondsimpl = Duration.m2220getInWholeNanosecondsimpl(j2);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return m2327checkInfiniteSumDefinedPjuGub4(j, j2, jM2220getInWholeNanosecondsimpl);
        }
        if (((jM2220getInWholeNanosecondsimpl - 1) | 1) == Long.MAX_VALUE) {
            return m2329saturatingAddInHalvespTJri5U(j, j2);
        }
        long j3 = j + jM2220getInWholeNanosecondsimpl;
        if (((j ^ j3) & (jM2220getInWholeNanosecondsimpl ^ j3)) < 0) {
            return j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return j3;
    }

    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m2327checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m2232isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-pTJri5U, reason: not valid java name */
    private static final long m2329saturatingAddInHalvespTJri5U(long j, long j2) {
        long jM2203divUwyO8pc = Duration.m2203divUwyO8pc(j2, 2);
        if (((Duration.m2220getInWholeNanosecondsimpl(jM2203divUwyO8pc) - 1) | 1) == Long.MAX_VALUE) {
            double d = j;
            double dM2243toDoubleimpl = Duration.m2243toDoubleimpl(j2, DurationUnit.NANOSECONDS);
            Double.isNaN(d);
            return (long) (d + dM2243toDoubleimpl);
        }
        return m2328saturatingAddpTJri5U(m2328saturatingAddpTJri5U(j, jM2203divUwyO8pc), Duration.m2235minusLRDsOJo(j2, jM2203divUwyO8pc));
    }

    public static final long saturatingDiff(long j, long j2) {
        if ((1 | (j2 - 1)) == Long.MAX_VALUE) {
            return Duration.m2252unaryMinusUwyO8pc(DurationKt.toDuration(j2, DurationUnit.DAYS));
        }
        return saturatingFiniteDiff(j, j2);
    }

    public static final long saturatingOriginsDiff(long j, long j2) {
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            if (j == j2) {
                return Duration.INSTANCE.m2302getZEROUwyO8pc();
            }
            return Duration.m2252unaryMinusUwyO8pc(DurationKt.toDuration(j2, DurationUnit.DAYS));
        }
        if ((1 | (j - 1)) == Long.MAX_VALUE) {
            return DurationKt.toDuration(j, DurationUnit.DAYS);
        }
        return saturatingFiniteDiff(j, j2);
    }

    private static final long saturatingFiniteDiff(long j, long j2) {
        long j3 = j - j2;
        if (((j3 ^ j) & ((j3 ^ j2) ^ (-1))) < 0) {
            long j4 = DurationKt.NANOS_IN_MILLIS;
            long j5 = (j / j4) - (j2 / j4);
            long j6 = (j % j4) - (j2 % j4);
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(j5, DurationUnit.MILLISECONDS);
            Duration.Companion companion2 = Duration.INSTANCE;
            return Duration.m2236plusLRDsOJo(duration, DurationKt.toDuration(j6, DurationUnit.NANOSECONDS));
        }
        Duration.Companion companion3 = Duration.INSTANCE;
        return DurationKt.toDuration(j3, DurationUnit.NANOSECONDS);
    }
}
