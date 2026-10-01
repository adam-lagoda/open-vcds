package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Combine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
@DebugMetadata(m660c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", m661f = "Combine.kt", m662i = {}, m663l = {35, 36}, m664m = "emit", m665n = {}, m666s = {})
final class CombineKt$combineInternal$2$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CombineKt.C08792.AnonymousClass1.C09051<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$combineInternal$2$1$1$emit$1(CombineKt.C08792.AnonymousClass1.C09051<? super T> c09051, Continuation<? super CombineKt$combineInternal$2$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c09051;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
