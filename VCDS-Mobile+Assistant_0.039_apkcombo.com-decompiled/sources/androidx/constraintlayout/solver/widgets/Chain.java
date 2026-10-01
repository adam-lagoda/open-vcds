package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (constraintWidgetContainer.optimizeFor(4)) {
                if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, chainHead)) {
                    applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
                }
            } else {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:154:0x02be  */
    /* JADX WARN: Code duplicated, block: B:268:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:269:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:272:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:273:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:275:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:277:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:280:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:29:0x004a A[PHI: r13 r14
      0x004a: PHI (r13v4 boolean) = (r13v2 boolean), (r13v31 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r14v4 boolean) = (r14v2 boolean), (r14v33 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x004c A[PHI: r13 r14
      0x004c: PHI (r13v28 boolean) = (r13v2 boolean), (r13v31 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x004c: PHI (r14v30 boolean) = (r14v2 boolean), (r14v33 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:85:0x0158  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [androidx.constraintlayout.solver.LinearSystem] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.constraintlayout.solver.LinearSystem] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v90 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        Object obj;
        ?? r0;
        int i3;
        LinearSystem linearSystem2;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        int i4;
        ConstraintAnchor constraintAnchor3;
        int i5;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable5;
        ?? r5;
        ConstraintAnchor constraintAnchor5;
        SolverVariable solverVariable6;
        float f;
        int size;
        float f2;
        float f3;
        int i6;
        int i7;
        ConstraintWidget constraintWidget = chainHead.mFirst;
        ConstraintWidget constraintWidget2 = chainHead.mLast;
        ConstraintWidget constraintWidget3 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget4 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget5 = chainHead.mHead;
        float f4 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget6 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget7 = chainHead.mLastMatchConstraintWidget;
        boolean z4 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z = constraintWidget5.mHorizontalChainStyle == 0;
            z2 = constraintWidget5.mHorizontalChainStyle == 1;
            if (constraintWidget5.mHorizontalChainStyle == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            z = constraintWidget5.mVerticalChainStyle == 0;
            z2 = constraintWidget5.mVerticalChainStyle == 1;
            if (constraintWidget5.mVerticalChainStyle == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        ?? r7 = constraintWidget;
        boolean z5 = false;
        while (true) {
            obj = null;
            if (z5) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = r7.mListAnchors[i2];
            int i8 = (z4 || z3) ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            if (constraintAnchor6.mTarget != null && r7 != constraintWidget) {
                margin += constraintAnchor6.mTarget.getMargin();
            }
            int i9 = margin;
            if (!z3 || r7 == constraintWidget || r7 == constraintWidget3) {
                i6 = (z && z4) ? 4 : i8;
            } else {
                i6 = 6;
            }
            if (constraintAnchor6.mTarget != null) {
                if (r7 == constraintWidget3) {
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i9, 5);
                } else {
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i9, 6);
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i9, i6);
            } else {
                z = z;
                z2 = z2;
            }
            if (z4 != 0) {
                if (r7.getVisibility() == 8 || r7.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i7 = 0;
                } else {
                    i7 = 0;
                    linearSystem.addGreaterThan(r7.mListAnchors[i2 + 1].mSolverVariable, r7.mListAnchors[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r7.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i7, 6);
            }
            ConstraintAnchor constraintAnchor7 = r7.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor7 != null) {
                ConstraintWidget constraintWidget8 = constraintAnchor7.mOwner;
                if (constraintWidget8.mListAnchors[i2].mTarget != null && constraintWidget8.mListAnchors[i2].mTarget.mOwner == r7) {
                    obj = constraintWidget8;
                }
            }
            if (obj != null) {
                r7 = obj;
            } else {
                z5 = true;
            }
            z3 = z3;
            z4 = z4;
            z = z;
            z2 = z2;
            r7 = r7;
        }
        boolean z6 = z4;
        boolean z7 = z3;
        boolean z8 = z;
        boolean z9 = z2;
        if (constraintWidget4 != null) {
            int i10 = i2 + 1;
            if (constraintWidget2.mListAnchors[i10].mTarget != null) {
                ConstraintAnchor constraintAnchor8 = constraintWidget4.mListAnchors[i10];
                linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget2.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 5);
            }
        }
        if (z6) {
            int i11 = i2 + 1;
            linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i11].mSolverVariable, constraintWidget2.mListAnchors[i11].mSolverVariable, constraintWidget2.mListAnchors[i11].getMargin(), 6);
        }
        ArrayList<ConstraintWidget> arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f5 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f4 : chainHead.mWidgetsMatchCount;
            float f6 = 0.0f;
            ConstraintWidget constraintWidget9 = null;
            int i12 = 0;
            float f7 = 0.0f;
            while (i12 < size) {
                ConstraintWidget constraintWidget10 = arrayList.get(i12);
                float f8 = constraintWidget10.mWeight[i];
                if (f8 < f6) {
                    if (chainHead.mHasComplexMatchWeights) {
                        linearSystem.addEquality(constraintWidget10.mListAnchors[i2 + 1].mSolverVariable, constraintWidget10.mListAnchors[i2].mSolverVariable, 0, 4);
                    } else {
                        f2 = 0.0f;
                        f3 = 1.0f;
                    }
                    i12++;
                    f6 = 0.0f;
                } else {
                    f2 = 0.0f;
                    f3 = f8;
                }
                if (f3 == f2) {
                    linearSystem.addEquality(constraintWidget10.mListAnchors[i2 + 1].mSolverVariable, constraintWidget10.mListAnchors[i2].mSolverVariable, 0, 6);
                } else {
                    if (constraintWidget9 != null) {
                        SolverVariable solverVariable7 = constraintWidget9.mListAnchors[i2].mSolverVariable;
                        int i13 = i2 + 1;
                        SolverVariable solverVariable8 = constraintWidget9.mListAnchors[i13].mSolverVariable;
                        SolverVariable solverVariable9 = constraintWidget10.mListAnchors[i2].mSolverVariable;
                        SolverVariable solverVariable10 = constraintWidget10.mListAnchors[i13].mSolverVariable;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f7, f5, f3, solverVariable7, solverVariable8, solverVariable9, solverVariable10);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    }
                    constraintWidget9 = constraintWidget10;
                    f7 = f3;
                }
                i12++;
                f6 = 0.0f;
            }
        }
        if (constraintWidget3 != null && (constraintWidget3 == constraintWidget4 || z7)) {
            ConstraintAnchor constraintAnchor9 = constraintWidget.mListAnchors[i2];
            int i14 = i2 + 1;
            ConstraintAnchor constraintAnchor10 = constraintWidget2.mListAnchors[i14];
            SolverVariable solverVariable11 = constraintWidget.mListAnchors[i2].mTarget != null ? constraintWidget.mListAnchors[i2].mTarget.mSolverVariable : null;
            SolverVariable solverVariable12 = constraintWidget2.mListAnchors[i14].mTarget != null ? constraintWidget2.mListAnchors[i14].mTarget.mSolverVariable : null;
            if (constraintWidget3 == constraintWidget4) {
                constraintAnchor9 = constraintWidget3.mListAnchors[i2];
                constraintAnchor10 = constraintWidget3.mListAnchors[i14];
            }
            if (solverVariable11 != null && solverVariable12 != null) {
                if (i == 0) {
                    f = constraintWidget5.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget5.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor9.mSolverVariable, solverVariable11, constraintAnchor9.getMargin(), f, solverVariable12, constraintAnchor10.mSolverVariable, constraintAnchor10.getMargin(), 5);
            }
        } else {
            if (!z8 || constraintWidget3 == null) {
                if (z9 && constraintWidget3 != null) {
                    boolean z10 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                    ConstraintWidget constraintWidget11 = constraintWidget3;
                    ConstraintWidget constraintWidget12 = constraintWidget11;
                    while (constraintWidget11 != null) {
                        ConstraintWidget constraintWidget13 = constraintWidget11.mNextChainWidget[i];
                        while (constraintWidget13 != null && constraintWidget13.getVisibility() == 8) {
                            constraintWidget13 = constraintWidget13.mNextChainWidget[i];
                        }
                        if (constraintWidget11 != constraintWidget3 && constraintWidget11 != constraintWidget4 && constraintWidget13 != null) {
                            if (constraintWidget13 == constraintWidget4) {
                                constraintWidget13 = null;
                            }
                            ConstraintAnchor constraintAnchor11 = constraintWidget11.mListAnchors[i2];
                            SolverVariable solverVariable13 = constraintAnchor11.mSolverVariable;
                            if (constraintAnchor11.mTarget != null) {
                                SolverVariable solverVariable14 = constraintAnchor11.mTarget.mSolverVariable;
                            }
                            int i15 = i2 + 1;
                            SolverVariable solverVariable15 = constraintWidget12.mListAnchors[i15].mSolverVariable;
                            int margin2 = constraintAnchor11.getMargin();
                            int margin3 = constraintWidget11.mListAnchors[i15].getMargin();
                            if (constraintWidget13 != null) {
                                constraintAnchor = constraintWidget13.mListAnchors[i2];
                                solverVariable = constraintAnchor.mSolverVariable;
                                solverVariable2 = constraintAnchor.mTarget != null ? constraintAnchor.mTarget.mSolverVariable : null;
                            } else {
                                constraintAnchor = constraintWidget11.mListAnchors[i15].mTarget;
                                solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                                solverVariable2 = constraintWidget11.mListAnchors[i15].mSolverVariable;
                            }
                            if (constraintAnchor != null) {
                                margin3 += constraintAnchor.getMargin();
                            }
                            if (constraintWidget12 != null) {
                                margin2 += constraintWidget12.mListAnchors[i15].getMargin();
                            }
                            int i16 = z10 ? 6 : 4;
                            if (solverVariable13 != null && solverVariable15 != null && solverVariable != null && solverVariable2 != null) {
                                linearSystem.addCentering(solverVariable13, solverVariable15, margin2, 0.5f, solverVariable, solverVariable2, margin3, i16);
                            }
                            constraintWidget13 = constraintWidget13;
                        }
                        if (constraintWidget11.getVisibility() != 8) {
                            constraintWidget12 = constraintWidget11;
                        }
                        constraintWidget11 = constraintWidget13;
                    }
                    ConstraintAnchor constraintAnchor12 = constraintWidget3.mListAnchors[i2];
                    ConstraintAnchor constraintAnchor13 = constraintWidget.mListAnchors[i2].mTarget;
                    int i17 = i2 + 1;
                    ConstraintAnchor constraintAnchor14 = constraintWidget4.mListAnchors[i17];
                    ConstraintAnchor constraintAnchor15 = constraintWidget2.mListAnchors[i17].mTarget;
                    if (constraintAnchor13 != null) {
                        if (constraintWidget3 != constraintWidget4) {
                            i3 = 5;
                            linearSystem.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, constraintAnchor12.getMargin(), 5);
                        } else {
                            i3 = 5;
                            if (constraintAnchor15 != null) {
                                linearSystem2 = linearSystem;
                                linearSystem2.addCentering(constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, constraintAnchor12.getMargin(), 0.5f, constraintAnchor14.mSolverVariable, constraintAnchor15.mSolverVariable, constraintAnchor14.getMargin(), 5);
                            }
                        }
                        r0 = linearSystem;
                    } else {
                        r0 = linearSystem;
                        i3 = 5;
                    }
                    if (constraintAnchor15 != null && constraintWidget3 != constraintWidget4) {
                        r0.addEquality(constraintAnchor14.mSolverVariable, constraintAnchor15.mSolverVariable, -constraintAnchor14.getMargin(), i3);
                    }
                }
                if ((!z8 || z9) && constraintWidget3 != null) {
                    constraintAnchor3 = constraintWidget3.mListAnchors[i2];
                    i5 = i2 + 1;
                    constraintAnchor4 = constraintWidget4.mListAnchors[i5];
                    if (constraintAnchor3.mTarget != null) {
                        solverVariable5 = constraintAnchor3.mTarget.mSolverVariable;
                    } else {
                        solverVariable5 = null;
                    }
                    if (constraintAnchor4.mTarget != null) {
                        solverVariable6 = constraintAnchor4.mTarget.mSolverVariable;
                    } else {
                        r5 = 0;
                    }
                    if (constraintWidget2 != constraintWidget4) {
                        constraintAnchor5 = constraintWidget2.mListAnchors[i5];
                        if (constraintAnchor5.mTarget != null) {
                            r5 = solverVariable6;
                            obj = constraintAnchor5.mTarget.mSolverVariable;
                        }
                        r5 = solverVariable6;
                        r5 = obj;
                    }
                    if (constraintWidget3 == constraintWidget4) {
                        constraintAnchor3 = constraintWidget3.mListAnchors[i2];
                        constraintAnchor4 = constraintWidget3.mListAnchors[i5];
                    }
                    if (solverVariable5 != null || r5 == 0) {
                    }
                    int margin4 = constraintAnchor3.getMargin();
                    if (constraintWidget4 != null) {
                        constraintWidget2 = constraintWidget4;
                    }
                    r0.addCentering(constraintAnchor3.mSolverVariable, solverVariable5, margin4, 0.5f, r5, constraintAnchor4.mSolverVariable, constraintWidget2.mListAnchors[i5].getMargin(), 5);
                    return;
                }
                return;
            }
            boolean z11 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
            ConstraintWidget constraintWidget14 = constraintWidget3;
            ConstraintWidget constraintWidget15 = constraintWidget14;
            while (constraintWidget14 != null) {
                ConstraintWidget constraintWidget16 = constraintWidget14.mNextChainWidget[i];
                while (constraintWidget16 != null && constraintWidget16.getVisibility() == 8) {
                    constraintWidget16 = constraintWidget16.mNextChainWidget[i];
                }
                if (constraintWidget16 != null || constraintWidget14 == constraintWidget4) {
                    ConstraintAnchor constraintAnchor16 = constraintWidget14.mListAnchors[i2];
                    SolverVariable solverVariable16 = constraintAnchor16.mSolverVariable;
                    SolverVariable solverVariable17 = constraintAnchor16.mTarget != null ? constraintAnchor16.mTarget.mSolverVariable : null;
                    if (constraintWidget15 != constraintWidget14) {
                        solverVariable17 = constraintWidget15.mListAnchors[i2 + 1].mSolverVariable;
                    } else if (constraintWidget14 == constraintWidget3 && constraintWidget15 == constraintWidget14) {
                        solverVariable17 = constraintWidget.mListAnchors[i2].mTarget != null ? constraintWidget.mListAnchors[i2].mTarget.mSolverVariable : null;
                    }
                    int margin5 = constraintAnchor16.getMargin();
                    int i18 = i2 + 1;
                    int margin6 = constraintWidget14.mListAnchors[i18].getMargin();
                    if (constraintWidget16 != null) {
                        constraintAnchor2 = constraintWidget16.mListAnchors[i2];
                        solverVariable3 = constraintAnchor2.mSolverVariable;
                        solverVariable4 = constraintWidget14.mListAnchors[i18].mSolverVariable;
                    } else {
                        constraintAnchor2 = constraintWidget2.mListAnchors[i18].mTarget;
                        solverVariable3 = constraintAnchor2 != null ? constraintAnchor2.mSolverVariable : null;
                        solverVariable4 = constraintWidget14.mListAnchors[i18].mSolverVariable;
                    }
                    if (constraintAnchor2 != null) {
                        margin6 += constraintAnchor2.getMargin();
                    }
                    if (constraintWidget15 != null) {
                        margin5 += constraintWidget15.mListAnchors[i18].getMargin();
                    }
                    if (solverVariable16 == null || solverVariable17 == null || solverVariable3 == null || solverVariable4 == null) {
                        i4 = 8;
                    } else {
                        if (constraintWidget14 == constraintWidget3) {
                            margin5 = constraintWidget3.mListAnchors[i2].getMargin();
                        }
                        if (constraintWidget14 == constraintWidget4) {
                            margin6 = constraintWidget4.mListAnchors[i18].getMargin();
                        }
                        i4 = 8;
                        linearSystem.addCentering(solverVariable16, solverVariable17, margin5, 0.5f, solverVariable3, solverVariable4, margin6, z11 ? 6 : 4);
                    }
                } else {
                    i4 = 8;
                }
                if (constraintWidget14.getVisibility() != i4) {
                    constraintWidget15 = constraintWidget14;
                }
                constraintWidget14 = constraintWidget16;
            }
        }
        r0 = linearSystem;
        if (z8) {
        }
        constraintAnchor3 = constraintWidget3.mListAnchors[i2];
        i5 = i2 + 1;
        constraintAnchor4 = constraintWidget4.mListAnchors[i5];
        if (constraintAnchor3.mTarget != null) {
            solverVariable5 = constraintAnchor3.mTarget.mSolverVariable;
        } else {
            solverVariable5 = null;
        }
        if (constraintAnchor4.mTarget != null) {
            solverVariable6 = constraintAnchor4.mTarget.mSolverVariable;
        } else {
            r5 = 0;
        }
        if (constraintWidget2 != constraintWidget4) {
            constraintAnchor5 = constraintWidget2.mListAnchors[i5];
            if (constraintAnchor5.mTarget != null) {
                r5 = solverVariable6;
                obj = constraintAnchor5.mTarget.mSolverVariable;
            }
            r5 = solverVariable6;
            r5 = obj;
        }
        if (constraintWidget3 == constraintWidget4) {
            constraintAnchor3 = constraintWidget3.mListAnchors[i2];
            constraintAnchor4 = constraintWidget3.mListAnchors[i5];
        }
        if (solverVariable5 != null) {
        }
    }
}
