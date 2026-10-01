package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Count.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m643d2 = {"count", "", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m644k = 5, m645mv = {1, 6, 0}, m647xi = 48, m648xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__CountKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$1 */
    /* JADX INFO: compiled from: Count.kt */
    @Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    @DebugMetadata(m660c = "kotlinx.coroutines.flow.FlowKt__CountKt", m661f = "Count.kt", m662i = {0}, m663l = {18}, m664m = "count", m665n = {"i"}, m666s = {"L$0"})
    static final class C07851<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07851(Continuation<? super C07851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.count(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$3 */
    /* JADX INFO: compiled from: Count.kt */
    @Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    @DebugMetadata(m660c = "kotlinx.coroutines.flow.FlowKt__CountKt", m661f = "Count.kt", m662i = {0}, m663l = {30}, m664m = "count", m665n = {"i"}, m666s = {"L$0"})
    static final class C07873<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07873(Continuation<? super C07873> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.count(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object count(Flow<? extends T> flow, Continuation<? super Integer> continuation) throws Throwable {
        C07851 c07851;
        Ref.IntRef intRef;
        if (continuation instanceof C07851) {
            c07851 = (C07851) continuation;
            if ((c07851.label & Integer.MIN_VALUE) != 0) {
                c07851.label -= Integer.MIN_VALUE;
            } else {
                c07851 = new C07851(continuation);
            }
        } else {
            c07851 = new C07851(continuation);
        }
        Object obj = c07851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07851.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.IntRef intRef2 = new Ref.IntRef();
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__CountKt.count.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, Continuation<? super Unit> continuation2) {
                    intRef2.element++;
                    int i2 = intRef2.element;
                    return Unit.INSTANCE;
                }
            };
            c07851.L$0 = intRef2;
            c07851.label = 1;
            if (flow.collect(flowCollector, c07851) == coroutine_suspended) {
                return coroutine_suspended;
            }
            intRef = intRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef = (Ref.IntRef) c07851.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxInt(intRef.element);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object count(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Integer> continuation) throws Throwable {
        C07873 c07873;
        Ref.IntRef intRef;
        if (continuation instanceof C07873) {
            c07873 = (C07873) continuation;
            if ((c07873.label & Integer.MIN_VALUE) != 0) {
                c07873.label -= Integer.MIN_VALUE;
            } else {
                c07873 = new C07873(continuation);
            }
        } else {
            c07873 = new C07873(continuation);
        }
        Object obj = c07873.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07873.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.IntRef intRef2 = new Ref.IntRef();
            FlowCollector<? super Object> c07884 = new C07884<>(function2, intRef2);
            c07873.L$0 = intRef2;
            c07873.label = 1;
            if (flow.collect(c07884, c07873) == coroutine_suspended) {
                return coroutine_suspended;
            }
            intRef = intRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef = (Ref.IntRef) c07873.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxInt(intRef.element);
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$4 */
    /* JADX INFO: compiled from: Count.kt */
    @Metadata(m642d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m643d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
    static final class C07884<T> implements FlowCollector {

        /* JADX INFO: renamed from: $i */
        final /* synthetic */ Ref.IntRef f89$i;
        final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;

        /* JADX WARN: Multi-variable type inference failed */
        C07884(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Ref.IntRef intRef) {
            this.$predicate = function2;
            this.f89$i = intRef;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) throws Throwable {
            FlowKt__CountKt$count$4$emit$1 flowKt__CountKt$count$4$emit$1;
            C07884<T> c07884;
            if (continuation instanceof FlowKt__CountKt$count$4$emit$1) {
                flowKt__CountKt$count$4$emit$1 = (FlowKt__CountKt$count$4$emit$1) continuation;
                if ((flowKt__CountKt$count$4$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowKt__CountKt$count$4$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    flowKt__CountKt$count$4$emit$1 = new FlowKt__CountKt$count$4$emit$1(this, continuation);
                }
            } else {
                flowKt__CountKt$count$4$emit$1 = new FlowKt__CountKt$count$4$emit$1(this, continuation);
            }
            Object objInvoke = flowKt__CountKt$count$4$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = flowKt__CountKt$count$4$emit$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Function2<T, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                flowKt__CountKt$count$4$emit$1.L$0 = this;
                flowKt__CountKt$count$4$emit$1.label = 1;
                objInvoke = function2.invoke(t, flowKt__CountKt$count$4$emit$1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c07884 = this;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c07884 = (C07884) flowKt__CountKt$count$4$emit$1.L$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            if (((Boolean) objInvoke).booleanValue()) {
                c07884.f89$i.element++;
                int i2 = c07884.f89$i.element;
            }
            return Unit.INSTANCE;
        }
    }
}
