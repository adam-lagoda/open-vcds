package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    private static final boolean USE_SNAPSHOT = true;
    int mDebugSolverPassCount;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    ChainHead[] mHorizontalChainsArray;
    int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem;
    ChainHead[] mVerticalChainsArray;
    int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    public List<ConstraintWidgetGroup> mWidgetGroups;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void fillMetrics(Metrics metrics) {
        this.mSystem.fillMetrics(metrics);
    }

    public ConstraintWidgetContainer() {
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public boolean optimizeFor(int i) {
        if ((this.mOptimizationLevel & i) == i) {
            return USE_SNAPSHOT;
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mWidgetGroups.clear();
        this.mSkipSolver = false;
        super.reset();
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return USE_SNAPSHOT;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem);
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = USE_SNAPSHOT;
            }
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = USE_SNAPSHOT;
            }
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z) {
        this.mIsRtl = z;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void analyze(int i) {
        super.analyze(i);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mChildren.get(i2).analyze(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0245  */
    /* JADX WARN: Code duplicated, block: B:107:0x0256  */
    /* JADX WARN: Code duplicated, block: B:110:0x0272  */
    /* JADX WARN: Code duplicated, block: B:112:0x0280  */
    /* JADX WARN: Code duplicated, block: B:114:0x0288 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:118:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:121:0x02a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:125:0x02bf A[PHI: r0 r18
      0x02bf: PHI (r0v36 boolean) = (r0v35 boolean), (r0v38 boolean), (r0v38 boolean), (r0v38 boolean) binds: [B:111:0x027e, B:120:0x02a7, B:121:0x02a9, B:123:0x02af] A[DONT_GENERATE, DONT_INLINE]
      0x02bf: PHI (r18v6 boolean) = (r18v5 boolean), (r18v7 boolean), (r18v7 boolean), (r18v7 boolean) binds: [B:111:0x027e, B:120:0x02a7, B:121:0x02a9, B:123:0x02af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:157:0x018d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x01d0 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0186  */
    /* JADX WARN: Code duplicated, block: B:72:0x0190  */
    /* JADX WARN: Code duplicated, block: B:74:0x0198  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d5  */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v22 */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    public void layout() {
        int i;
        boolean z;
        boolean zAddChildrenToSolver;
        int i2;
        ConstraintWidget constraintWidget;
        char c;
        boolean z2;
        int iMax;
        int iMax2;
        ?? r7;
        int i3 = this.f15mX;
        int i4 = this.f16mY;
        int iMax3 = Math.max(0, getWidth());
        int iMax4 = Math.max(0, getHeight());
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        if (this.mParent != null) {
            if (this.mSnapshot == null) {
                this.mSnapshot = new Snapshot(this);
            }
            this.mSnapshot.updateFrom(this);
            setX(this.mPaddingLeft);
            setY(this.mPaddingTop);
            resetAnchors();
            resetSolverVariables(this.mSystem.getCache());
        } else {
            this.f15mX = 0;
            this.f16mY = 0;
        }
        int i5 = 32;
        if (this.mOptimizationLevel != 0) {
            if (!optimizeFor(8)) {
                optimizeReset();
            }
            if (!optimizeFor(32)) {
                optimize();
            }
            this.mSystem.graphOptimizer = USE_SNAPSHOT;
        } else {
            this.mSystem.graphOptimizer = false;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mListDimensionBehaviors[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mListDimensionBehaviors[0];
        resetChains();
        if (this.mWidgetGroups.size() == 0) {
            this.mWidgetGroups.clear();
            this.mWidgetGroups.add(0, new ConstraintWidgetGroup(this.mChildren));
        }
        int size = this.mWidgetGroups.size();
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        boolean z3 = (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) ? USE_SNAPSHOT : false;
        boolean z4 = false;
        int i6 = 0;
        while (i6 < size && !this.mSkipSolver) {
            if (this.mWidgetGroups.get(i6).mSkipSolver) {
                i = size;
            } else {
                if (optimizeFor(i5)) {
                    if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED && getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                        this.mChildren = (ArrayList) this.mWidgetGroups.get(i6).getWidgetsToSolve();
                    } else {
                        this.mChildren = (ArrayList) this.mWidgetGroups.get(i6).mConstrainedGroup;
                    }
                }
                resetChains();
                int size2 = this.mChildren.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    ConstraintWidget constraintWidget2 = this.mChildren.get(i7);
                    if (constraintWidget2 instanceof WidgetContainer) {
                        ((WidgetContainer) constraintWidget2).layout();
                    }
                }
                boolean z5 = z4;
                int i8 = 0;
                boolean z6 = USE_SNAPSHOT;
                while (z6) {
                    int i9 = i8 + 1;
                    try {
                        this.mSystem.reset();
                        resetChains();
                        createObjectVariables(this.mSystem);
                        int i10 = 0;
                        while (i10 < size2) {
                            z = z5;
                            try {
                                this.mChildren.get(i10).createObjectVariables(this.mSystem);
                                i10++;
                                z5 = z;
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                System.out.println("EXCEPTION : " + e);
                                zAddChildrenToSolver = z6;
                                if (zAddChildrenToSolver) {
                                    updateChildrenFromSolver(this.mSystem, Optimizer.flags);
                                } else {
                                    updateFromSolver(this.mSystem);
                                    i2 = 0;
                                    while (true) {
                                        if (i2 < size2) {
                                            constraintWidget = this.mChildren.get(i2);
                                            c = 2;
                                            if (constraintWidget.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                                if (constraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                                }
                                                i2++;
                                            } else {
                                                if (constraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                                }
                                                i2++;
                                            }
                                        }
                                    }
                                    if (z3) {
                                        z2 = false;
                                    } else {
                                        z2 = false;
                                    }
                                    iMax = Math.max(this.mMinWidth, getWidth());
                                    if (iMax > getWidth()) {
                                        setWidth(iMax);
                                        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                                        z2 = USE_SNAPSHOT;
                                        z = USE_SNAPSHOT;
                                    }
                                    iMax2 = Math.max(this.mMinHeight, getHeight());
                                    if (iMax2 > getHeight()) {
                                        setHeight(iMax2);
                                        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                                        z2 = USE_SNAPSHOT;
                                        z = USE_SNAPSHOT;
                                    }
                                    if (z) {
                                        z6 = z2;
                                        z5 = z;
                                    } else {
                                        if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                            r7 = 1;
                                        } else {
                                            r7 = 1;
                                        }
                                        if (this.mListDimensionBehaviors[r7] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                            z6 = z2;
                                            z5 = z;
                                        } else {
                                            z6 = z2;
                                            z5 = z;
                                        }
                                    }
                                    i8 = i9;
                                    size = size;
                                }
                                c = 2;
                                if (z3) {
                                    z2 = false;
                                } else {
                                    z2 = false;
                                }
                                iMax = Math.max(this.mMinWidth, getWidth());
                                if (iMax > getWidth()) {
                                    setWidth(iMax);
                                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                                    z2 = USE_SNAPSHOT;
                                    z = USE_SNAPSHOT;
                                }
                                iMax2 = Math.max(this.mMinHeight, getHeight());
                                if (iMax2 > getHeight()) {
                                    setHeight(iMax2);
                                    this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                                    z2 = USE_SNAPSHOT;
                                    z = USE_SNAPSHOT;
                                }
                                if (z) {
                                    z6 = z2;
                                    z5 = z;
                                } else {
                                    if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                        r7 = 1;
                                    } else {
                                        r7 = 1;
                                    }
                                    if (this.mListDimensionBehaviors[r7] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                        z6 = z2;
                                        z5 = z;
                                    } else {
                                        z6 = z2;
                                        z5 = z;
                                    }
                                }
                                i8 = i9;
                                size = size;
                            }
                        }
                        z = z5;
                        zAddChildrenToSolver = addChildrenToSolver(this.mSystem);
                        if (zAddChildrenToSolver) {
                            this.mSystem.minimize();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        z = z5;
                    }
                    if (zAddChildrenToSolver) {
                        updateChildrenFromSolver(this.mSystem, Optimizer.flags);
                    } else {
                        updateFromSolver(this.mSystem);
                        i2 = 0;
                        while (true) {
                            if (i2 < size2) {
                                constraintWidget = this.mChildren.get(i2);
                                c = 2;
                                if (constraintWidget.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                                    Optimizer.flags[2] = USE_SNAPSHOT;
                                    break;
                                } else {
                                    if (constraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                                        Optimizer.flags[2] = USE_SNAPSHOT;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                        if (z3 || i9 >= 8 || !Optimizer.flags[c]) {
                            z2 = false;
                        } else {
                            int iMax5 = 0;
                            int iMax6 = 0;
                            for (int i11 = 0; i11 < size2; i11++) {
                                ConstraintWidget constraintWidget3 = this.mChildren.get(i11);
                                iMax5 = Math.max(iMax5, constraintWidget3.f15mX + constraintWidget3.getWidth());
                                iMax6 = Math.max(iMax6, constraintWidget3.f16mY + constraintWidget3.getHeight());
                            }
                            int iMax7 = Math.max(this.mMinWidth, iMax5);
                            int iMax8 = Math.max(this.mMinHeight, iMax6);
                            if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getWidth() >= iMax7) {
                                z2 = false;
                            } else {
                                setWidth(iMax7);
                                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                z2 = USE_SNAPSHOT;
                                z = USE_SNAPSHOT;
                            }
                            if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getHeight() < iMax8) {
                                setHeight(iMax8);
                                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                z2 = USE_SNAPSHOT;
                                z = USE_SNAPSHOT;
                            }
                        }
                        iMax = Math.max(this.mMinWidth, getWidth());
                        if (iMax > getWidth()) {
                            setWidth(iMax);
                            this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                            z2 = USE_SNAPSHOT;
                            z = USE_SNAPSHOT;
                        }
                        iMax2 = Math.max(this.mMinHeight, getHeight());
                        if (iMax2 > getHeight()) {
                            setHeight(iMax2);
                            this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                            z2 = USE_SNAPSHOT;
                            z = USE_SNAPSHOT;
                        }
                        if (z) {
                            z6 = z2;
                            z5 = z;
                        } else {
                            if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || iMax3 <= 0 || getWidth() <= iMax3) {
                                r7 = 1;
                            } else {
                                r7 = 1;
                                this.mWidthMeasuredTooSmall = USE_SNAPSHOT;
                                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                                setWidth(iMax3);
                                z2 = USE_SNAPSHOT;
                                z = USE_SNAPSHOT;
                            }
                            if (this.mListDimensionBehaviors[r7] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || iMax4 <= 0 || getHeight() <= iMax4) {
                                z6 = z2;
                                z5 = z;
                            } else {
                                this.mHeightMeasuredTooSmall = r7;
                                this.mListDimensionBehaviors[r7] = ConstraintWidget.DimensionBehaviour.FIXED;
                                setHeight(iMax4);
                                z5 = USE_SNAPSHOT;
                                z6 = USE_SNAPSHOT;
                            }
                        }
                        i8 = i9;
                        size = size;
                    }
                    c = 2;
                    if (z3) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    iMax = Math.max(this.mMinWidth, getWidth());
                    if (iMax > getWidth()) {
                        setWidth(iMax);
                        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                        z2 = USE_SNAPSHOT;
                        z = USE_SNAPSHOT;
                    }
                    iMax2 = Math.max(this.mMinHeight, getHeight());
                    if (iMax2 > getHeight()) {
                        setHeight(iMax2);
                        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                        z2 = USE_SNAPSHOT;
                        z = USE_SNAPSHOT;
                    }
                    if (z) {
                        z6 = z2;
                        z5 = z;
                    } else {
                        if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            r7 = 1;
                        } else {
                            r7 = 1;
                        }
                        if (this.mListDimensionBehaviors[r7] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            z6 = z2;
                            z5 = z;
                        } else {
                            z6 = z2;
                            z5 = z;
                        }
                    }
                    i8 = i9;
                    size = size;
                }
                i = size;
                this.mWidgetGroups.get(i6).updateUnresolvedWidgets();
                z4 = z5;
            }
            i6++;
            size = i;
            i5 = 32;
        }
        this.mChildren = arrayList;
        if (this.mParent != null) {
            int iMax9 = Math.max(this.mMinWidth, getWidth());
            int iMax10 = Math.max(this.mMinHeight, getHeight());
            this.mSnapshot.applyTo(this);
            setWidth(iMax9 + this.mPaddingLeft + this.mPaddingRight);
            setHeight(iMax10 + this.mPaddingTop + this.mPaddingBottom);
        } else {
            this.f15mX = i3;
            this.f16mY = i4;
        }
        if (z4) {
            this.mListDimensionBehaviors[0] = dimensionBehaviour2;
            this.mListDimensionBehaviors[1] = dimensionBehaviour;
        }
        resetSolverVariables(this.mSystem.getCache());
        if (this == getRootConstraintContainer()) {
            updateDrawPosition();
        }
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.mOptimizationLevel);
    }

    public void solveGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.resolve(null, 0.0f);
        resolutionNode2.resolve(null, 0.0f);
    }

    public void resetGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.invalidateAnchors();
        resolutionNode2.invalidateAnchors();
        resolutionNode.resolve(null, 0.0f);
        resolutionNode2.resolve(null, 0.0f);
    }

    public void optimizeForDimensions(int i, int i2) {
        if (this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.mResolutionWidth != null) {
            this.mResolutionWidth.resolve(i);
        }
        if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || this.mResolutionHeight == null) {
            return;
        }
        this.mResolutionHeight.resolve(i2);
    }

    public void optimizeReset() {
        int size = this.mChildren.size();
        resetResolutionNodes();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).resetResolutionNodes();
        }
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.mOptimizationLevel);
        }
        solveGraph();
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        return this.mWidgetGroups;
    }
}
