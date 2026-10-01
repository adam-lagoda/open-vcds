package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: TickerChannels.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m643d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, m644k = 2, m645mv = {1, 6, 0}, m647xi = 48)
public final class TickerChannelsKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 */
    /* JADX INFO: compiled from: TickerChannels.kt */
    @Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    @DebugMetadata(m660c = "kotlinx.coroutines.channels.TickerChannelsKt", m661f = "TickerChannels.kt", m662i = {0, 0, 1, 1, 2, 2}, m663l = {106, 108, 109}, m664m = "fixedDelayTicker", m665n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, m666s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
    static final class C07561 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07561(Continuation<? super C07561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TickerChannelsKt.fixedDelayTicker(0L, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 */
    /* JADX INFO: compiled from: TickerChannels.kt */
    @Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    @DebugMetadata(m660c = "kotlinx.coroutines.channels.TickerChannelsKt", m661f = "TickerChannels.kt", m662i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, m663l = {84, 88, 94, 96}, m664m = "fixedPeriodTicker", m665n = {"channel", "delayMillis", "deadline", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs"}, m666s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
    static final class C07571 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07571(Continuation<? super C07571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TickerChannelsKt.fixedPeriodTicker(0L, 0L, null, this);
        }
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }

    public static final ReceiveChannel<Unit> ticker(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode) {
        if (j < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (j2 < 0) {
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new C07583(tickerMode, j, j2, null));
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3 */
    /* JADX INFO: compiled from: TickerChannels.kt */
    @Metadata(m642d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, m643d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    @DebugMetadata(m660c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", m661f = "TickerChannels.kt", m662i = {}, m663l = {72, 73}, m664m = "invokeSuspend", m665n = {}, m666s = {})
    static final class C07583 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ long $initialDelayMillis;
        final /* synthetic */ TickerMode $mode;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3$WhenMappings */
        /* JADX INFO: compiled from: TickerChannels.kt */
        @Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TickerMode.values().length];
                iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
                iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07583(TickerMode tickerMode, long j, long j2, Continuation<? super C07583> continuation) {
            super(2, continuation);
            this.$mode = tickerMode;
            this.$delayMillis = j;
            this.$initialDelayMillis = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07583 c07583 = new C07583(this.$mode, this.$delayMillis, this.$initialDelayMillis, continuation);
            c07583.L$0 = obj;
            return c07583;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
            return ((C07583) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        
            if (kotlinx.coroutines.channels.TickerChannelsKt.fixedDelayTicker(r10.$delayMillis, r10.$initialDelayMillis, r11.getChannel(), r10) == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        
            if (kotlinx.coroutines.channels.TickerChannelsKt.fixedPeriodTicker(r10.$delayMillis, r10.$initialDelayMillis, r11.getChannel(), r10) == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.$mode.ordinal()];
                if (i2 == 1) {
                    this.label = 1;
                } else if (i2 == 2) {
                    this.label = 2;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f5, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4, r1) == r2) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010e, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4, r1) == r2) goto L48;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00f5 -> B:18:0x0053). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x010e -> B:18:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedPeriodTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) throws Throwable {
        C07571 c07571;
        SendChannel sendChannel2;
        long j3;
        long j4;
        long jDelayToNanos;
        long j5;
        long j6;
        SendChannel sendChannel3;
        AbstractTimeSource timeSource;
        long jNanoTime;
        long jCoerceAtLeast;
        long j7;
        Unit unit;
        if (continuation instanceof C07571) {
            c07571 = (C07571) continuation;
            if ((c07571.label & Integer.MIN_VALUE) != 0) {
                c07571.label -= Integer.MIN_VALUE;
            } else {
                c07571 = new C07571(continuation);
            }
        } else {
            c07571 = new C07571(continuation);
        }
        Object obj = c07571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
            long jNanoTime2 = (timeSource2 != null ? timeSource2.nanoTime() : System.nanoTime()) + EventLoop_commonKt.delayToNanos(j2);
            sendChannel2 = sendChannel;
            c07571.L$0 = sendChannel2;
            j3 = j;
            c07571.J$0 = j3;
            c07571.J$1 = jNanoTime2;
            c07571.label = 1;
            if (DelayKt.delay(j2, c07571) != coroutine_suspended) {
                j4 = jNanoTime2;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            j4 = c07571.J$1;
            long j8 = c07571.J$0;
            SendChannel sendChannel4 = (SendChannel) c07571.L$0;
            ResultKt.throwOnFailure(obj);
            sendChannel2 = sendChannel4;
            j3 = j8;
        } else {
            if (i == 2) {
                j6 = c07571.J$1;
                j5 = c07571.J$0;
                sendChannel3 = (SendChannel) c07571.L$0;
                ResultKt.throwOnFailure(obj);
                timeSource = AbstractTimeSourceKt.getTimeSource();
                if (timeSource != null) {
                    jNanoTime = timeSource.nanoTime();
                } else {
                    jNanoTime = System.nanoTime();
                }
                jCoerceAtLeast = RangesKt.coerceAtLeast(j5 - jNanoTime, 0L);
                if (jCoerceAtLeast != 0 && j6 != 0) {
                    long j9 = j6 - ((jNanoTime - j5) % j6);
                    j5 = jNanoTime + j9;
                    long jDelayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(j9);
                    c07571.L$0 = sendChannel3;
                    c07571.J$0 = j5;
                    c07571.J$1 = j6;
                    c07571.label = 3;
                } else {
                    long jDelayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
                    c07571.L$0 = sendChannel3;
                    c07571.J$0 = j5;
                    c07571.J$1 = j6;
                    c07571.label = 4;
                }
                return coroutine_suspended;
            }
            if (i != 3 && i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j6 = c07571.J$1;
            j5 = c07571.J$0;
            sendChannel3 = (SendChannel) c07571.L$0;
            ResultKt.throwOnFailure(obj);
        }
        long j10 = j5;
        jDelayToNanos = j6;
        j4 = j10;
        sendChannel2 = sendChannel3;
        j7 = j4 + jDelayToNanos;
        unit = Unit.INSTANCE;
        c07571.L$0 = sendChannel2;
        c07571.J$0 = j7;
        c07571.J$1 = jDelayToNanos;
        c07571.label = 2;
        if (sendChannel2.send(unit, c07571) != coroutine_suspended) {
            long j11 = jDelayToNanos;
            j5 = j7;
            j6 = j11;
            sendChannel3 = sendChannel2;
            timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                jNanoTime = timeSource.nanoTime();
            } else {
                jNanoTime = System.nanoTime();
            }
            jCoerceAtLeast = RangesKt.coerceAtLeast(j5 - jNanoTime, 0L);
            if (jCoerceAtLeast != 0) {
                long jDelayNanosToMillis3 = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
                c07571.L$0 = sendChannel3;
                c07571.J$0 = j5;
                c07571.J$1 = j6;
                c07571.label = 4;
            } else {
                long jDelayNanosToMillis4 = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
                c07571.L$0 = sendChannel3;
                c07571.J$0 = j5;
                c07571.J$1 = j6;
                c07571.label = 4;
            }
        }
        return coroutine_suspended;
        jDelayToNanos = EventLoop_commonKt.delayToNanos(j3);
        j7 = j4 + jDelayToNanos;
        unit = Unit.INSTANCE;
        c07571.L$0 = sendChannel2;
        c07571.J$0 = j7;
        c07571.J$1 = jDelayToNanos;
        c07571.label = 2;
        if (sendChannel2.send(unit, c07571) != coroutine_suspended) {
            long j12 = jDelayToNanos;
            j5 = j7;
            j6 = j12;
            sendChannel3 = sendChannel2;
            timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                jNanoTime = timeSource.nanoTime();
            } else {
                jNanoTime = System.nanoTime();
            }
            jCoerceAtLeast = RangesKt.coerceAtLeast(j5 - jNanoTime, 0L);
            if (jCoerceAtLeast != 0) {
                long jDelayNanosToMillis5 = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
                c07571.L$0 = sendChannel3;
                c07571.J$0 = j5;
                c07571.J$1 = j6;
                c07571.label = 4;
            } else {
                long jDelayNanosToMillis6 = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
                c07571.L$0 = sendChannel3;
                c07571.J$0 = j5;
                c07571.J$1 = j6;
                c07571.label = 4;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r6, r0) == r1) goto L28;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007e -> B:14:0x0035). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedDelayTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) throws Throwable {
        C07561 c07561;
        SendChannel<? super Unit> sendChannel2;
        if (continuation instanceof C07561) {
            c07561 = (C07561) continuation;
            if ((c07561.label & Integer.MIN_VALUE) != 0) {
                c07561.label -= Integer.MIN_VALUE;
            } else {
                c07561 = new C07561(continuation);
            }
        } else {
            c07561 = new C07561(continuation);
        }
        Object obj = c07561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07561.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c07561.L$0 = sendChannel;
            c07561.J$0 = j;
            c07561.label = 1;
            if (DelayKt.delay(j2, c07561) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            j = c07561.J$0;
            sendChannel = (SendChannel) c07561.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            j = c07561.J$0;
            sendChannel2 = (SendChannel) c07561.L$0;
            ResultKt.throwOnFailure(obj);
            c07561.L$0 = sendChannel2;
            c07561.J$0 = j;
            c07561.label = 3;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c07561.J$0;
            sendChannel2 = (SendChannel) c07561.L$0;
            ResultKt.throwOnFailure(obj);
        }
        sendChannel = sendChannel2;
        Unit unit = Unit.INSTANCE;
        c07561.L$0 = sendChannel;
        c07561.J$0 = j;
        c07561.label = 2;
        if (sendChannel.send(unit, c07561) != coroutine_suspended) {
            sendChannel2 = sendChannel;
            c07561.L$0 = sendChannel2;
            c07561.J$0 = j;
            c07561.label = 3;
        }
        return coroutine_suspended;
    }
}
