package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Reduce.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 176)
@DebugMetadata(m660c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2", m661f = "Reduce.kt", m662i = {}, m663l = {45}, m664m = "emit", m665n = {}, m666s = {})
public final class FlowKt__ReduceKt$fold$2$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowKt__ReduceKt.C08272<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$fold$2$emit$1(FlowKt__ReduceKt.C08272<? super T> c08272, Continuation<? super FlowKt__ReduceKt$fold$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = c08272;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
