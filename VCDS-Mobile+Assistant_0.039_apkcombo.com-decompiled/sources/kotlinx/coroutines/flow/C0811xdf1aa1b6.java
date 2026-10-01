package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 */
/* JADX INFO: compiled from: Limit.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m643d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m644k = 1, m645mv = {1, 6, 0}, m647xi = 48)
public final class C0811xdf1aa1b6<T> implements FlowCollector<T> {
    final /* synthetic */ FlowCollector $$this$flow$inlined;
    final /* synthetic */ Function3 $transform$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Limit.kt */
    @Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    @DebugMetadata(m660c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1", m661f = "Limit.kt", m662i = {0}, m663l = {142}, m664m = "emit", m665n = {"this"}, m666s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return C0811xdf1aa1b6.this.emit(null, this);
        }
    }

    public C0811xdf1aa1b6(Function3 function3, FlowCollector flowCollector) {
        this.$transform$inlined = function3;
        this.$$this$flow$inlined = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        C0811xdf1aa1b6<T> c0811xdf1aa1b6;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objInvoke = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke);
            Function3 function3 = this.$transform$inlined;
            FlowCollector flowCollector = this.$$this$flow$inlined;
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objInvoke = function3.invoke(flowCollector, t, anonymousClass1);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            c0811xdf1aa1b6 = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c0811xdf1aa1b6 = (C0811xdf1aa1b6) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objInvoke);
        }
        if (((Boolean) objInvoke).booleanValue()) {
            return Unit.INSTANCE;
        }
        throw new AbortFlowException(c0811xdf1aa1b6);
    }
}
