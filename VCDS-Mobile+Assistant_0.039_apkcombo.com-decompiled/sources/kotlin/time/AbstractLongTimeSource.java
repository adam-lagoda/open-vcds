package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, m643d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "markNow", "Lkotlin/time/ComparableTimeMark;", "read", "", "LongTimeMark", "kotlin-stdlib"}, m644k = 1, m645mv = {1, 8, 0}, m647xi = 48)
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    protected abstract long read();

    public AbstractLongTimeSource(DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    /* JADX INFO: compiled from: TimeSources.kt */
    @Metadata(m642d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0015\u0010\n\u001a\u00020\u0007H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u0007H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0007H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001e"}, m643d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "effectiveDuration", "effectiveDuration-UwyO8pc$kotlin_stdlib", "()J", "elapsedNow", "elapsedNow-UwyO8pc", "equals", "", "other", "", "hashCode", "", "minus", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "toString", "", "kotlin-stdlib"}, m644k = 1, m645mv = {1, 8, 0}, m647xi = 48)
    private static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        private LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2) {
            this.startedAt = j;
            this.timeSource = abstractLongTimeSource;
            this.offset = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo2190minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m2195minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
        public long mo2189elapsedNowUwyO8pc() {
            return Duration.m2232isInfiniteimpl(this.offset) ? Duration.m2252unaryMinusUwyO8pc(this.offset) : Duration.m2235minusLRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo2192plusLRDsOJo(long duration) {
            return new LongTimeMark(this.startedAt, this.timeSource, Duration.m2236plusLRDsOJo(this.offset, duration), null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc */
        public long mo2191minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, longTimeMark.timeSource)) {
                    if (Duration.m2205equalsimpl0(this.offset, longTimeMark.offset) && Duration.m2232isInfiniteimpl(this.offset)) {
                        return Duration.INSTANCE.m2302getZEROUwyO8pc();
                    }
                    long jM2235minusLRDsOJo = Duration.m2235minusLRDsOJo(this.offset, longTimeMark.offset);
                    long duration = DurationKt.toDuration(this.startedAt - longTimeMark.startedAt, this.timeSource.getUnit());
                    return Duration.m2205equalsimpl0(duration, Duration.m2252unaryMinusUwyO8pc(jM2235minusLRDsOJo)) ? Duration.INSTANCE.m2302getZEROUwyO8pc() : Duration.m2236plusLRDsOJo(duration, jM2235minusLRDsOJo);
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object other) {
            return (other instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) other).timeSource) && Duration.m2205equalsimpl0(mo2191minusUwyO8pc((ComparableTimeMark) other), Duration.INSTANCE.m2302getZEROUwyO8pc());
        }

        /* JADX INFO: renamed from: effectiveDuration-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m2193effectiveDurationUwyO8pc$kotlin_stdlib() {
            if (Duration.m2232isInfiniteimpl(this.offset)) {
                return this.offset;
            }
            DurationUnit unit = this.timeSource.getUnit();
            if (unit.compareTo(DurationUnit.MILLISECONDS) >= 0) {
                return Duration.m2236plusLRDsOJo(DurationKt.toDuration(this.startedAt, unit), this.offset);
            }
            long jConvertDurationUnit = DurationUnitKt.convertDurationUnit(1L, DurationUnit.MILLISECONDS, unit);
            long j = this.startedAt;
            long j2 = j / jConvertDurationUnit;
            long j3 = j % jConvertDurationUnit;
            long j4 = this.offset;
            long jM2221getInWholeSecondsimpl = Duration.m2221getInWholeSecondsimpl(j4);
            int iM2223getNanosecondsComponentimpl = Duration.m2223getNanosecondsComponentimpl(j4);
            int i = iM2223getNanosecondsComponentimpl / DurationKt.NANOS_IN_MILLIS;
            int i2 = iM2223getNanosecondsComponentimpl % DurationKt.NANOS_IN_MILLIS;
            long duration = DurationKt.toDuration(j3, unit);
            Duration.Companion companion = Duration.INSTANCE;
            long jM2236plusLRDsOJo = Duration.m2236plusLRDsOJo(duration, DurationKt.toDuration(i2, DurationUnit.NANOSECONDS));
            Duration.Companion companion2 = Duration.INSTANCE;
            long jM2236plusLRDsOJo2 = Duration.m2236plusLRDsOJo(jM2236plusLRDsOJo, DurationKt.toDuration(j2 + ((long) i), DurationUnit.MILLISECONDS));
            Duration.Companion companion3 = Duration.INSTANCE;
            return Duration.m2236plusLRDsOJo(jM2236plusLRDsOJo2, DurationKt.toDuration(jM2221getInWholeSecondsimpl, DurationUnit.SECONDS));
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return Duration.m2228hashCodeimpl(m2193effectiveDurationUwyO8pc$kotlin_stdlib());
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m2249toStringimpl(this.offset)) + " (=" + ((Object) Duration.m2249toStringimpl(m2193effectiveDurationUwyO8pc$kotlin_stdlib())) + "), " + this.timeSource + ')';
        }
    }

    @Override // kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(read(), this, Duration.INSTANCE.m2302getZEROUwyO8pc(), null);
    }
}
