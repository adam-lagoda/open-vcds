package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: SharingStarted.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0017J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m643d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", "", "replayExpiration", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "equals", "", "other", "", "hashCode", "toString", "", "kotlinx-coroutines-core"}, m644k = 1, m645mv = {1, 6, 0}, m647xi = 48)
final class StartedWhileSubscribed implements SharingStarted {
    private final long replayExpiration;
    private final long stopTimeout;

    public StartedWhileSubscribed(long j, long j2) {
        this.stopTimeout = j;
        this.replayExpiration = j2;
        if (j < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
        }
        if (j2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1 */
    /* JADX INFO: compiled from: SharingStarted.kt */
    @Metadata(m642d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, m643d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", ""}, m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    @DebugMetadata(m660c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", m661f = "SharingStarted.kt", m662i = {1, 2, 3}, m663l = {178, 180, 182, 183, 185}, m664m = "invokeSuspend", m665n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, m666s = {"L$0", "L$0", "L$0"})
    static final class C08701 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
        /* synthetic */ int I$0;
        private /* synthetic */ Object L$0;
        int label;

        C08701(Continuation<? super C08701> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super Unit> continuation) {
            return invoke(flowCollector, num.intValue(), continuation);
        }

        public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, int i, Continuation<? super Unit> continuation) {
            C08701 c08701 = StartedWhileSubscribed.this.new C08701(continuation);
            c08701.L$0 = flowCollector;
            c08701.I$0 = i;
            return c08701.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0078  */
        /* JADX WARN: Code duplicated, block: B:29:0x0088 A[PHI: r1
          0x0088: PHI (r1v4 kotlinx.coroutines.flow.FlowCollector) = (r1v3 kotlinx.coroutines.flow.FlowCollector), (r1v9 kotlinx.coroutines.flow.FlowCollector) binds: [B:27:0x0085, B:13:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:32:0x009c A[PHI: r1
          0x009c: PHI (r1v5 kotlinx.coroutines.flow.FlowCollector) = 
          (r1v3 kotlinx.coroutines.flow.FlowCollector)
          (r1v4 kotlinx.coroutines.flow.FlowCollector)
          (r1v11 kotlinx.coroutines.flow.FlowCollector)
         binds: [B:25:0x0076, B:30:0x0099, B:12:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
        
            if (r1.emit(kotlinx.coroutines.flow.SharingCommand.START, r9) == r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
        
            if (r1.emit(kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE, r9) == r0) goto L34;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                if (this.I$0 > 0) {
                    this.label = 1;
                } else {
                    this.L$0 = flowCollector;
                    this.label = 2;
                    if (DelayKt.delay(StartedWhileSubscribed.this.stopTimeout, this) != coroutine_suspended) {
                        if (StartedWhileSubscribed.this.replayExpiration > 0) {
                            this.L$0 = flowCollector;
                            this.label = 3;
                            if (flowCollector.emit(SharingCommand.STOP, this) != coroutine_suspended) {
                                this.L$0 = flowCollector;
                                this.label = 4;
                                if (DelayKt.delay(StartedWhileSubscribed.this.replayExpiration, this) != coroutine_suspended) {
                                    this.L$0 = null;
                                    this.label = 5;
                                }
                            }
                        } else {
                            this.L$0 = null;
                            this.label = 5;
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    flowCollector = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (StartedWhileSubscribed.this.replayExpiration > 0) {
                        this.L$0 = flowCollector;
                        this.label = 3;
                        if (flowCollector.emit(SharingCommand.STOP, this) != coroutine_suspended) {
                            this.L$0 = flowCollector;
                            this.label = 4;
                            if (DelayKt.delay(StartedWhileSubscribed.this.replayExpiration, this) != coroutine_suspended) {
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 3) {
                    flowCollector = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = flowCollector;
                    this.label = 4;
                    if (DelayKt.delay(StartedWhileSubscribed.this.replayExpiration, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 4) {
                    flowCollector = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.L$0 = null;
                this.label = 5;
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> command(StateFlow<Integer> subscriptionCount) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(subscriptionCount, new C08701(null)), new C08712(null)));
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$2 */
    /* JADX INFO: compiled from: SharingStarted.kt */
    @Metadata(m642d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m643d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/flow/SharingCommand;"}, m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    @DebugMetadata(m660c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", m661f = "SharingStarted.kt", m662i = {}, m663l = {}, m664m = "invokeSuspend", m665n = {}, m666s = {})
    static final class C08712 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C08712(Continuation<? super C08712> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08712 c08712 = new C08712(continuation);
            c08712.L$0 = obj;
            return c08712;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SharingCommand sharingCommand, Continuation<? super Boolean> continuation) {
            return ((C08712) create(sharingCommand, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((SharingCommand) this.L$0) != SharingCommand.START);
        }
    }

    public String toString() {
        List listCreateListBuilder = CollectionsKt.createListBuilder(2);
        if (this.stopTimeout > 0) {
            listCreateListBuilder.add("stopTimeout=" + this.stopTimeout + "ms");
        }
        if (this.replayExpiration < Long.MAX_VALUE) {
            listCreateListBuilder.add("replayExpiration=" + this.replayExpiration + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.joinToString$default(CollectionsKt.build(listCreateListBuilder), null, null, null, 0, null, null, 63, null) + ')';
    }

    public boolean equals(Object other) {
        if (!(other instanceof StartedWhileSubscribed)) {
            return false;
        }
        StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) other;
        return this.stopTimeout == startedWhileSubscribed.stopTimeout && this.replayExpiration == startedWhileSubscribed.replayExpiration;
    }

    public int hashCode() {
        return (UByte$$ExternalSyntheticBackport0.m653m(this.stopTimeout) * 31) + UByte$$ExternalSyntheticBackport0.m653m(this.replayExpiration);
    }
}
