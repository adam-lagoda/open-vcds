package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Combine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
@DebugMetadata(m660c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1", m661f = "Combine.kt", m662i = {}, m663l = {131}, m664m = "emit", m665n = {}, m666s = {})
final class CombineKt$zipImpl$1$1$2$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CombineKt$zipImpl$1$1.C08812.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$zipImpl$1$1$2$1$emit$1(CombineKt$zipImpl$1$1.C08812.AnonymousClass1<? super T> anonymousClass1, Continuation<? super CombineKt$zipImpl$1$1$2$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
