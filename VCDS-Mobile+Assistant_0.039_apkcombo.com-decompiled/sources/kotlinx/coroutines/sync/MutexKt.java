package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: Mutex.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m642d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u001aB\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0018H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0019\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m643d2 = {"EMPTY_LOCKED", "Lkotlinx/coroutines/sync/Empty;", "getEMPTY_LOCKED$annotations", "()V", "EMPTY_UNLOCKED", "getEMPTY_UNLOCKED$annotations", "LOCKED", "Lkotlinx/coroutines/internal/Symbol;", "getLOCKED$annotations", "LOCK_FAIL", "getLOCK_FAIL$annotations", "UNLOCKED", "getUNLOCKED$annotations", "UNLOCK_FAIL", "getUNLOCK_FAIL$annotations", "Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", "T", "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m644k = 2, m645mv = {1, 6, 0}, m647xi = 48)
public final class MutexKt {
    private static final Empty EMPTY_LOCKED;
    private static final Empty EMPTY_UNLOCKED;
    private static final Symbol LOCKED;
    private static final Symbol UNLOCKED;
    private static final Symbol LOCK_FAIL = new Symbol("LOCK_FAIL");
    private static final Symbol UNLOCK_FAIL = new Symbol("UNLOCK_FAIL");

    /* JADX INFO: renamed from: kotlinx.coroutines.sync.MutexKt$withLock$1 */
    /* JADX INFO: compiled from: Mutex.kt */
    @Metadata(m644k = 3, m645mv = {1, 6, 0}, m647xi = 176)
    @DebugMetadata(m660c = "kotlinx.coroutines.sync.MutexKt", m661f = "Mutex.kt", m662i = {0, 0, 0}, m663l = {112}, m664m = "withLock", m665n = {"$this$withLock", "owner", "action"}, m666s = {"L$0", "L$1", "L$2"})
    static final class C08981<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C08981(Continuation<? super C08981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MutexKt.withLock(null, null, null, this);
        }
    }

    private static /* synthetic */ void getEMPTY_LOCKED$annotations() {
    }

    private static /* synthetic */ void getEMPTY_UNLOCKED$annotations() {
    }

    private static /* synthetic */ void getLOCKED$annotations() {
    }

    private static /* synthetic */ void getLOCK_FAIL$annotations() {
    }

    private static /* synthetic */ void getUNLOCKED$annotations() {
    }

    private static /* synthetic */ void getUNLOCK_FAIL$annotations() {
    }

    public static /* synthetic */ Mutex Mutex$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Mutex(z);
    }

    public static final Mutex Mutex(boolean z) {
        return new MutexImpl(z);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object withLock(Mutex mutex, Object obj, Function0<? extends T> function0, Continuation<? super T> continuation) throws Throwable {
        C08981 c08981;
        if (continuation instanceof C08981) {
            c08981 = (C08981) continuation;
            if ((c08981.label & Integer.MIN_VALUE) != 0) {
                c08981.label -= Integer.MIN_VALUE;
            } else {
                c08981 = new C08981(continuation);
            }
        } else {
            c08981 = new C08981(continuation);
        }
        Object obj2 = c08981.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08981.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            c08981.L$0 = mutex;
            c08981.L$1 = obj;
            c08981.L$2 = function0;
            c08981.label = 1;
            if (mutex.lock(obj, c08981) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function0 = (Function0) c08981.L$2;
            obj = c08981.L$1;
            mutex = (Mutex) c08981.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        try {
            return function0.invoke();
        } finally {
            mutex.unlock(obj);
        }
    }

    private static final <T> Object withLock$$forInline(Mutex mutex, Object obj, Function0<? extends T> function0, Continuation<? super T> continuation) {
        mutex.lock(obj, continuation);
        try {
            return function0.invoke();
        } finally {
            mutex.unlock(obj);
        }
    }

    public static /* synthetic */ Object withLock$default(Mutex mutex, Object obj, Function0 function0, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        mutex.lock(obj, continuation);
        try {
            return function0.invoke();
        } finally {
            mutex.unlock(obj);
        }
    }

    static {
        Symbol symbol = new Symbol("LOCKED");
        LOCKED = symbol;
        Symbol symbol2 = new Symbol("UNLOCKED");
        UNLOCKED = symbol2;
        EMPTY_LOCKED = new Empty(symbol);
        EMPTY_UNLOCKED = new Empty(symbol2);
    }
}
