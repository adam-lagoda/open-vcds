package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.animation.AnimatorKt$$ExternalSyntheticApiModelOutline0;
import androidx.core.os.CancellationSignal;
import androidx.print.PrintHelper$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class FragmentTransitionCompat21 extends FragmentTransitionImpl {
    FragmentTransitionCompat21() {
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(Object obj) {
        return PrintHelper$$ExternalSyntheticApiModelOutline0.m$1(obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj));
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSetM509m = PrintHelper$$ExternalSyntheticApiModelOutline0.m509m(obj);
        List targets = transitionSetM509m.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bfsAddViewChildren(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(transitionSetM509m, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            Transition transitionM99m = AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj);
            final Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            transitionM99m.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                @Override // android.transition.Transition.EpicenterCallback
                public Rect onGetEpicenter(Transition transition) {
                    return rect;
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(Object obj, ArrayList<View> arrayList) {
        Transition transitionM99m = AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj);
        if (transitionM99m == null) {
            return;
        }
        int i = 0;
        if (PrintHelper$$ExternalSyntheticApiModelOutline0.m544m((Object) transitionM99m)) {
            TransitionSet transitionSetM509m = PrintHelper$$ExternalSyntheticApiModelOutline0.m509m((Object) transitionM99m);
            int transitionCount = transitionSetM509m.getTransitionCount();
            while (i < transitionCount) {
                addTargets(transitionSetM509m.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (hasSimpleTarget(transitionM99m) || !isNullOrEmpty(transitionM99m.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transitionM99m.addTarget(arrayList.get(i));
            i++;
        }
    }

    private static boolean hasSimpleTarget(Transition transition) {
        return (isNullOrEmpty(transition.getTargetIds()) && isNullOrEmpty(transition.getTargetNames()) && isNullOrEmpty(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition(AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj));
        }
        if (obj2 != null) {
            transitionSet.addTransition(AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj2));
        }
        if (obj3 != null) {
            transitionSet.addTransition(AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj3));
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object obj, final View view, final ArrayList<View> arrayList) {
        AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj).addListener(new Transition.TransitionListener() { // from class: androidx.fragment.app.FragmentTransitionCompat21.2
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Api19Impl.removeListener(transition, this);
                Api19Impl.addListener(transition, this);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Api19Impl.removeListener(transition, this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        Transition transitionM99m = AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj);
        Transition transitionM99m2 = AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj2);
        Transition transitionM99m3 = AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj3);
        if (transitionM99m != null && transitionM99m2 != null) {
            transitionM99m = new TransitionSet().addTransition(transitionM99m).addTransition(transitionM99m2).setOrdering(1);
        } else if (transitionM99m == null) {
            transitionM99m = transitionM99m2 != null ? transitionM99m2 : null;
        }
        if (transitionM99m3 == null) {
            return transitionM99m;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transitionM99m != null) {
            transitionSet.addTransition(transitionM99m);
        }
        transitionSet.addTransition(transitionM99m3);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj).addListener(new Transition.TransitionListener() { // from class: androidx.fragment.app.FragmentTransitionCompat21.3
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Object obj5 = obj2;
                if (obj5 != null) {
                    FragmentTransitionCompat21.this.replaceTargets(obj5, arrayList, null);
                }
                Object obj6 = obj3;
                if (obj6 != null) {
                    FragmentTransitionCompat21.this.replaceTargets(obj6, arrayList2, null);
                }
                Object obj7 = obj4;
                if (obj7 != null) {
                    FragmentTransitionCompat21.this.replaceTargets(obj7, arrayList3, null);
                }
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Api19Impl.removeListener(transition, this);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(Fragment fragment, Object obj, CancellationSignal cancellationSignal, final Runnable runnable) {
        AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj).addListener(new Transition.TransitionListener() { // from class: androidx.fragment.app.FragmentTransitionCompat21.4
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                runnable.run();
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSetM509m = PrintHelper$$ExternalSyntheticApiModelOutline0.m509m(obj);
        if (transitionSetM509m != null) {
            transitionSetM509m.getTargets().clear();
            transitionSetM509m.getTargets().addAll(arrayList2);
            replaceTargets(transitionSetM509m, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List targets;
        Transition transitionM99m = AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj);
        int i = 0;
        if (PrintHelper$$ExternalSyntheticApiModelOutline0.m544m((Object) transitionM99m)) {
            TransitionSet transitionSetM509m = PrintHelper$$ExternalSyntheticApiModelOutline0.m509m((Object) transitionM99m);
            int transitionCount = transitionSetM509m.getTransitionCount();
            while (i < transitionCount) {
                replaceTargets(transitionSetM509m.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (hasSimpleTarget(transitionM99m) || (targets = transitionM99m.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size) {
            transitionM99m.addTarget(arrayList2.get(i));
            i++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transitionM99m.removeTarget(arrayList.get(size2));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(Object obj, View view) {
        if (obj != null) {
            AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(Object obj, View view) {
        if (obj != null) {
            AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, final Rect rect) {
        if (obj != null) {
            AnimatorKt$$ExternalSyntheticApiModelOutline0.m99m(obj).setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.5
                @Override // android.transition.Transition.EpicenterCallback
                public Rect onGetEpicenter(Transition transition) {
                    Rect rect2 = rect;
                    if (rect2 == null || rect2.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static void addListener(Transition transition, Transition.TransitionListener transitionListener) {
            transition.addListener(transitionListener);
        }

        static void removeListener(Transition transition, Transition.TransitionListener transitionListener) {
            transition.removeListener(transitionListener);
        }
    }
}
