package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m643d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m644k = 1, m645mv = {1, 6, 0}, m647xi = 48)
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    @DebugMetadata(m660c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", m661f = "Emitters.kt", m662i = {0, 0, 1, 2}, m663l = {114, 121, 128}, m664m = "collect", m665n = {"this", "$this$onCompletion_u24lambda_u2d2", "e", "sc"}, m666s = {"L$0", "L$1", "L$0", "L$0"})
    public static final class C07951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C07951(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0083  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        C07951 c07951;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        ThrowingCollector throwingCollector;
        Function3 function3;
        SafeCollector safeCollector;
        Throwable th;
        SafeCollector safeCollector2;
        Function3 function4;
        if (continuation instanceof C07951) {
            c07951 = (C07951) continuation;
            if ((c07951.label & Integer.MIN_VALUE) != 0) {
                c07951.label -= Integer.MIN_VALUE;
            } else {
                c07951 = new C07951(continuation);
            }
        } else {
            c07951 = new C07951(continuation);
        }
        Object obj = c07951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07951.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                Flow flow = this.$this_onCompletion$inlined;
                c07951.L$0 = this;
                c07951.L$1 = flowCollector;
                c07951.label = 1;
                if (flow.collect(flowCollector, c07951) != coroutine_suspended) {
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                    safeCollector = new SafeCollector(flowCollector, c07951.getContext());
                    function4 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                    c07951.L$0 = safeCollector;
                    c07951.L$1 = null;
                    c07951.label = 3;
                    if (function4.invoke(safeCollector, null, c07951) != coroutine_suspended) {
                        safeCollector2 = safeCollector;
                        safeCollector2.releaseIntercepted();
                        return Unit.INSTANCE;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                throwingCollector = new ThrowingCollector(th);
                function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                c07951.L$0 = th;
                c07951.L$1 = null;
                c07951.label = 2;
                if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function3, th, c07951) == coroutine_suspended) {
                    throw th;
                }
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                Throwable th3 = (Throwable) c07951.L$0;
                ResultKt.throwOnFailure(obj);
                throw th3;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            safeCollector2 = (SafeCollector) c07951.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                safeCollector2.releaseIntercepted();
                return Unit.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
                safeCollector2.releaseIntercepted();
                throw th;
            }
        }
        flowCollector = (FlowCollector) c07951.L$1;
        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) c07951.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            safeCollector = new SafeCollector(flowCollector, c07951.getContext());
            try {
                function4 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                c07951.L$0 = safeCollector;
                c07951.L$1 = null;
                c07951.label = 3;
                if (function4.invoke(safeCollector, null, c07951) != coroutine_suspended) {
                    safeCollector2 = safeCollector;
                    safeCollector2.releaseIntercepted();
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th5) {
                th = th5;
                safeCollector2 = safeCollector;
                safeCollector2.releaseIntercepted();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            throwingCollector = new ThrowingCollector(th);
            function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
            c07951.L$0 = th;
            c07951.L$1 = null;
            c07951.label = 2;
            if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function3, th, c07951) == coroutine_suspended) {
                throw th;
            }
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }
}
