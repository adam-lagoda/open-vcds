package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a/\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a9\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m643d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "receiveAsFlow", "kotlinx-coroutines-core"}, m644k = 5, m645mv = {1, 6, 0}, m647xi = 48, m648xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) throws Throwable {
        Object objEmitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        return objEmitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x006e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0077 A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #0 {all -> 0x0057, blocks: (B:13:0x0034, B:27:0x0071, B:29:0x0077, B:35:0x0085, B:36:0x0086, B:18:0x004d), top: B:48:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x007f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0085 A[Catch: all -> 0x0057, TRY_ENTER, TryCatch #0 {all -> 0x0057, blocks: (B:13:0x0034, B:27:0x0071, B:29:0x0077, B:35:0x0085, B:36:0x0086, B:18:0x004d), top: B:48:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0086 A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #0 {all -> 0x0057, blocks: (B:13:0x0034, B:27:0x0071, B:29:0x0077, B:35:0x0085, B:36:0x0086, B:18:0x004d), top: B:48:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0096, code lost:
    
        if (r9.emit(r10, r0) == r1) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowCollector<? super T>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r9v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0096 -> B:14:0x0037). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, boolean z, Continuation<? super Unit> continuation) throws Throwable {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        Object objMo2377receiveCatchingJP2dKIU;
        ?? r9;
        Throwable thM2388exceptionOrNullimpl;
        ?? r10;
        ?? r7;
        ?? r11;
        ?? r8;
        if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
            flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
            if ((flowKt__ChannelsKt$emitAllImpl$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ChannelsKt$emitAllImpl$1.label -= Integer.MIN_VALUE;
            } else {
                flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
            }
        } else {
            flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
        }
        Object obj = flowKt__ChannelsKt$emitAllImpl$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = flowKt__ChannelsKt$emitAllImpl$1.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowKt.ensureActive(flowCollector);
                    r7 = flowCollector;
                    r10 = z;
                    flowKt__ChannelsKt$emitAllImpl$1.L$0 = r7;
                    flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                    flowKt__ChannelsKt$emitAllImpl$1.Z$0 = r10;
                    flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                    objMo2377receiveCatchingJP2dKIU = receiveChannel.mo2377receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
                    if (objMo2377receiveCatchingJP2dKIU != coroutine_suspended) {
                        ?? r6 = r10;
                        r9 = r7;
                        flowCollector = (FlowCollector<? super T>) (r6 == true ? 1 : 0 ? 1 : 0);
                        if (ChannelResult.m2392isClosedimpl(objMo2377receiveCatchingJP2dKIU)) {
                            thM2388exceptionOrNullimpl = ChannelResult.m2388exceptionOrNullimpl(objMo2377receiveCatchingJP2dKIU);
                            if (thM2388exceptionOrNullimpl != null) {
                                throw thM2388exceptionOrNullimpl;
                            }
                            if (flowCollector != 0) {
                                ChannelsKt.cancelConsumed(receiveChannel, null);
                            }
                            return Unit.INSTANCE;
                        }
                        Object objM2390getOrThrowimpl = ChannelResult.m2390getOrThrowimpl(objMo2377receiveCatchingJP2dKIU);
                        flowKt__ChannelsKt$emitAllImpl$1.L$0 = r9;
                        flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAllImpl$1.Z$0 = (boolean) flowCollector;
                        flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                        throw th;
                    }
                    r8 = flowCollector;
                    r11 = r9;
                    return coroutine_suspended;
                }
                if (i == 1) {
                    boolean z2 = (FlowCollector<? super T>) flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                    receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                    FlowCollector flowCollector2 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    objMo2377receiveCatchingJP2dKIU = ((ChannelResult) obj).getHolder();
                    flowCollector = z2;
                    r9 = flowCollector2;
                    if (ChannelResult.m2392isClosedimpl(objMo2377receiveCatchingJP2dKIU)) {
                        thM2388exceptionOrNullimpl = ChannelResult.m2388exceptionOrNullimpl(objMo2377receiveCatchingJP2dKIU);
                        if (thM2388exceptionOrNullimpl != null) {
                            throw thM2388exceptionOrNullimpl;
                        }
                        if (flowCollector != 0) {
                            ChannelsKt.cancelConsumed(receiveChannel, null);
                        }
                        return Unit.INSTANCE;
                    }
                    Object objM2390getOrThrowimpl2 = ChannelResult.m2390getOrThrowimpl(objMo2377receiveCatchingJP2dKIU);
                    flowKt__ChannelsKt$emitAllImpl$1.L$0 = r9;
                    flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                    flowKt__ChannelsKt$emitAllImpl$1.Z$0 = (boolean) flowCollector;
                    flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                    try {
                        throw th;
                    } catch (Throwable th) {
                        if (flowCollector != 0) {
                            ChannelsKt.cancelConsumed(receiveChannel, th);
                        }
                        throw th;
                    }
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z3 = (FlowCollector<? super T>) flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                FlowCollector flowCollector3 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                ResultKt.throwOnFailure(obj);
                r8 = z3;
                r11 = flowCollector3;
                r8 = flowCollector;
                r11 = r9;
                ?? r12 = r11;
                r10 = r8;
                r7 = (FlowCollector<? super T>) r12;
                flowKt__ChannelsKt$emitAllImpl$1.L$0 = r7;
                flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                flowKt__ChannelsKt$emitAllImpl$1.Z$0 = r10;
                flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                objMo2377receiveCatchingJP2dKIU = receiveChannel.mo2377receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
                if (objMo2377receiveCatchingJP2dKIU != coroutine_suspended) {
                    ?? r13 = r10;
                    r9 = r7;
                    flowCollector = (FlowCollector<? super T>) (r13 == true ? 1 : 0 ? 1 : 0);
                    if (ChannelResult.m2392isClosedimpl(objMo2377receiveCatchingJP2dKIU)) {
                        thM2388exceptionOrNullimpl = ChannelResult.m2388exceptionOrNullimpl(objMo2377receiveCatchingJP2dKIU);
                        if (thM2388exceptionOrNullimpl != null) {
                            throw thM2388exceptionOrNullimpl;
                        }
                        if (flowCollector != 0) {
                            ChannelsKt.cancelConsumed(receiveChannel, null);
                        }
                        return Unit.INSTANCE;
                    }
                    Object objM2390getOrThrowimpl3 = ChannelResult.m2390getOrThrowimpl(objMo2377receiveCatchingJP2dKIU);
                    flowKt__ChannelsKt$emitAllImpl$1.L$0 = r9;
                    flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                    flowKt__ChannelsKt$emitAllImpl$1.Z$0 = (boolean) flowCollector;
                    flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                    throw th;
                }
                r8 = flowCollector;
                r11 = r9;
                return coroutine_suspended;
            } catch (Throwable th2) {
                ?? r14 = r10;
                th = th2;
                flowCollector = r14 == true ? 1 : 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, null, 0, null, 28, null);
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, null, 0, null, 28, null);
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> flow, CoroutineScope coroutineScope) {
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(coroutineScope);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> Flow<T> asFlow(final BroadcastChannel<T> broadcastChannel) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                Object objEmitAll = FlowKt.emitAll(flowCollector, broadcastChannel.openSubscription(), continuation);
                return objEmitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmitAll : Unit.INSTANCE;
            }
        };
    }
}
