package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m643d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m644k = 1, m645mv = {1, 6, 0}, m647xi = 48)
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ Flow $this_onStart$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    @DebugMetadata(m660c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", m661f = "Emitters.kt", m662i = {0, 0, 0}, m663l = {116, 120}, m664m = "collect", m665n = {"this", "$this$onStart_u24lambda_u2d1", "safeCollector"}, m666s = {"L$0", "L$1", "L$2"})
    public static final class C07971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C07971(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007c, code lost:
    
        if (r7.collect(r2, r0) == r1) goto L27;
     */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        C07971 c07971;
        Throwable th;
        SafeCollector safeCollector;
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
        FlowCollector<? super T> flowCollector2;
        if (continuation instanceof C07971) {
            c07971 = (C07971) continuation;
            if ((c07971.label & Integer.MIN_VALUE) != 0) {
                c07971.label -= Integer.MIN_VALUE;
            } else {
                c07971 = new C07971(continuation);
            }
        } else {
            c07971 = new C07971(continuation);
        }
        Object obj = c07971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07971.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SafeCollector safeCollector2 = new SafeCollector(flowCollector, c07971.getContext());
            try {
                Function2 function2 = this.$action$inlined;
                c07971.L$0 = this;
                c07971.L$1 = flowCollector;
                c07971.L$2 = safeCollector2;
                c07971.label = 1;
                if (function2.invoke(safeCollector2, c07971) != coroutine_suspended) {
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    safeCollector = safeCollector2;
                    safeCollector.releaseIntercepted();
                    Flow flow = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.$this_onStart$inlined;
                    c07971.L$0 = null;
                    c07971.L$1 = null;
                    c07971.L$2 = null;
                    c07971.label = 2;
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                th = th2;
                safeCollector = safeCollector2;
                safeCollector.releaseIntercepted();
                throw th;
            }
        }
        if (i == 1) {
            safeCollector = (SafeCollector) c07971.L$2;
            flowCollector2 = (FlowCollector) c07971.L$1;
            flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) c07971.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                safeCollector.releaseIntercepted();
                Flow flow2 = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.$this_onStart$inlined;
                c07971.L$0 = null;
                c07971.L$1 = null;
                c07971.L$2 = null;
                c07971.label = 2;
            } catch (Throwable th3) {
                th = th3;
                safeCollector.releaseIntercepted();
                throw th;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Function2 function2, Flow flow) {
        this.$action$inlined = function2;
        this.$this_onStart$inlined = flow;
    }
}
