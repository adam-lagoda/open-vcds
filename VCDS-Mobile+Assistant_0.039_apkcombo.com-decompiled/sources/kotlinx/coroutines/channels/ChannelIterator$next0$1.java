package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 48)
@DebugMetadata(m660c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", m661f = "Channel.kt", m662i = {0}, m663l = {584}, m664m = "next", m665n = {"this"}, m666s = {"L$0"})
final class ChannelIterator$next0$1<E> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ChannelIterator$next0$1(Continuation<? super ChannelIterator$next0$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelIterator.DefaultImpls.next(null, this);
    }
}
