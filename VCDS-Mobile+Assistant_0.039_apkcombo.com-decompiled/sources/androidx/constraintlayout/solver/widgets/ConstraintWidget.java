package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    protected static final int ANCHOR_BASELINE = 4;
    protected static final int ANCHOR_BOTTOM = 3;
    protected static final int ANCHOR_LEFT = 0;
    protected static final int ANCHOR_RIGHT = 1;
    protected static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    ConstraintWidgetGroup mBelongingGroup;
    ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    protected float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    private int mDrawHeight;
    private int mDrawWidth;
    private int mDrawX;
    private int mDrawY;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    boolean mIsHeightWrapContent;
    boolean mIsWidthWrapContent;
    ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    protected ConstraintAnchor[] mListAnchors;
    protected DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    int mMatchConstraintDefaultHeight;
    int mMatchConstraintDefaultWidth;
    int mMatchConstraintMaxHeight;
    int mMatchConstraintMaxWidth;
    int mMatchConstraintMinHeight;
    int mMatchConstraintMinWidth;
    float mMatchConstraintPercentHeight;
    float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    boolean mOptimizerMeasured;
    ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    ResolutionDimension mResolutionHeight;
    ResolutionDimension mResolutionWidth;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    int[] mResolvedMatchConstraintDefault;
    ConstraintAnchor mRight;
    boolean mRightHasCentered;
    ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    float[] mWeight;
    int mWidth;
    private int mWrapHeight;
    private int mWrapWidth;

    /* JADX INFO: renamed from: mX */
    protected int f15mX;

    /* JADX INFO: renamed from: mY */
    protected int f16mY;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
    }

    public void resolve() {
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f15mX = 0;
        this.f16mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        ResolutionDimension resolutionDimension = this.mResolutionWidth;
        if (resolutionDimension != null) {
            resolutionDimension.reset();
        }
        ResolutionDimension resolutionDimension2 = this.mResolutionHeight;
        if (resolutionDimension2 != null) {
            resolutionDimension2.reset();
        }
        this.mBelongingGroup = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
    }

    public void resetResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().reset();
        }
    }

    public void updateResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().update();
        }
    }

    public void analyze(int i) {
        Optimizer.analyze(i, this);
    }

    public boolean isFullyResolved() {
        return this.mLeft.getResolutionNode().state == 1 && this.mRight.getResolutionNode().state == 1 && this.mTop.getResolutionNode().state == 1 && this.mBottom.getResolutionNode().state == 1;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.mResolutionWidth == null) {
            this.mResolutionWidth = new ResolutionDimension();
        }
        return this.mResolutionWidth;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.mResolutionHeight == null) {
            this.mResolutionHeight = new ResolutionDimension();
        }
        return this.mResolutionHeight;
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f15mX = 0;
        this.f16mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.f15mX = i;
        this.f16mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
        forceUpdateDrawPosition();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isRootContainer() {
        if (!(this instanceof ConstraintWidgetContainer)) {
            return false;
        }
        ConstraintWidget constraintWidget = this.mParent;
        return constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer);
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        while (parent != null) {
            if (parent instanceof ConstraintWidgetContainer) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        ConstraintWidget parent = getParent();
        if (parent == constraintWidget) {
            return true;
        }
        if (parent == constraintWidget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public WidgetContainer getRootWidgetContainer() {
        ConstraintWidget parent = this;
        while (parent.getParent() != null) {
            parent = parent.getParent();
        }
        if (parent instanceof WidgetContainer) {
            return (WidgetContainer) parent;
        }
        return null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        solverVariableCreateObjectVariable.setName(str + ".left");
        solverVariableCreateObjectVariable2.setName(str + ".top");
        solverVariableCreateObjectVariable3.setName(str + ".right");
        solverVariableCreateObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline).setName(str + ".baseline");
        }
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f15mX);
        sb.append(", ");
        sb.append(this.f16mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(") wrap: (");
        sb.append(this.mWrapWidth);
        sb.append(" x ");
        sb.append(this.mWrapHeight);
        sb.append(")");
        return sb.toString();
    }

    int getInternalDrawX() {
        return this.mDrawX;
    }

    int getInternalDrawY() {
        return this.mDrawY;
    }

    public int getInternalDrawRight() {
        return this.mDrawX + this.mDrawWidth;
    }

    public int getInternalDrawBottom() {
        return this.mDrawY + this.mDrawHeight;
    }

    public int getX() {
        return this.f15mX;
    }

    public int getY() {
        return this.f16mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int i = this.mWidth;
        int iMax = 0;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            iMax = Math.max(this.mMatchConstraintMinWidth, i);
        } else {
            int i2 = this.mMatchConstraintMinWidth;
            if (i2 > 0) {
                this.mWidth = i2;
                iMax = i2;
            }
        }
        int i3 = this.mMatchConstraintMaxWidth;
        return (i3 <= 0 || i3 >= iMax) ? iMax : i3;
    }

    public int getOptimizerWrapHeight() {
        int iMax = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                iMax = Math.max(this.mMatchConstraintMinHeight, iMax);
            } else {
                iMax = this.mMatchConstraintMinHeight;
                if (iMax > 0) {
                    this.mHeight = iMax;
                } else {
                    iMax = 0;
                }
            }
            int i = this.mMatchConstraintMaxHeight;
            if (i > 0 && i < iMax) {
                return i;
            }
        }
        return iMax;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getDrawX() {
        return this.mDrawX + this.mOffsetX;
    }

    public int getDrawY() {
        return this.mDrawY + this.mOffsetY;
    }

    public int getDrawWidth() {
        return this.mDrawWidth;
    }

    public int getDrawHeight() {
        return this.mDrawHeight;
    }

    public int getDrawBottom() {
        return getDrawY() + this.mDrawHeight;
    }

    public int getDrawRight() {
        return getDrawX() + this.mDrawWidth;
    }

    protected int getRootX() {
        return this.f15mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.f16mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.mBaselineDistance > 0;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int i) {
        this.f15mX = i;
    }

    public void setY(int i) {
        this.f16mY = i;
    }

    public void setOrigin(int i, int i2) {
        this.f15mX = i;
        this.f16mY = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = C01221.f17x4c44d048[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.mGoneMargin = i;
            return;
        }
        if (i2 == 2) {
            this.mTop.mGoneMargin = i;
        } else if (i2 == 3) {
            this.mRight.mGoneMargin = i;
        } else {
            if (i2 != 4) {
                return;
            }
            this.mBottom.mGoneMargin = i;
        }
    }

    public void updateDrawPosition() {
        int i = this.f15mX;
        int i2 = this.f16mY;
        int i3 = this.mWidth + i;
        int i4 = this.mHeight + i2;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public void forceUpdateDrawPosition() {
        int i = this.f15mX;
        int i2 = this.f16mY;
        int i3 = this.mWidth + i;
        int i4 = this.mHeight + i2;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public void setDrawOrigin(int i, int i2) {
        int i3 = i - this.mOffsetX;
        this.mDrawX = i3;
        int i4 = i2 - this.mOffsetY;
        this.mDrawY = i4;
        this.f15mX = i3;
        this.f16mY = i4;
    }

    public void setDrawX(int i) {
        int i2 = i - this.mOffsetX;
        this.mDrawX = i2;
        this.f15mX = i2;
    }

    public void setDrawY(int i) {
        int i2 = i - this.mOffsetY;
        this.mDrawY = i2;
        this.f16mY = i2;
    }

    public void setDrawWidth(int i) {
        this.mDrawWidth = i;
    }

    public void setDrawHeight(int i) {
        this.mDrawHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f >= 1.0f || i != 0) {
            return;
        }
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f >= 1.0f || i != 0) {
            return;
        }
        this.mMatchConstraintDefaultHeight = 2;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0087 A[PHI: r0
      0x0087: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:39:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0087 -> B:41:0x0088). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String str) {
        float fAbs;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i2 = 0;
        int i3 = -1;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (!strSubstring.equalsIgnoreCase("W")) {
                i2 = strSubstring.equalsIgnoreCase("H") ? 1 : -1;
            }
            i3 = i2;
            i2 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        try {
            if (iIndexOf2 >= 0 && iIndexOf2 < length - 1) {
                String strSubstring2 = str.substring(i2, iIndexOf2);
                String strSubstring3 = str.substring(iIndexOf2 + 1);
                if (strSubstring2.length() <= 0 || strSubstring3.length() <= 0) {
                    fAbs = 0.0f;
                } else {
                    float f = Float.parseFloat(strSubstring2);
                    float f2 = Float.parseFloat(strSubstring3);
                    if (f <= 0.0f || f2 <= 0.0f) {
                        fAbs = 0.0f;
                    } else if (i3 == 1) {
                        fAbs = Math.abs(f2 / f);
                    } else {
                        fAbs = Math.abs(f / f2);
                    }
                }
            } else {
                String strSubstring4 = str.substring(i2);
                if (strSubstring4.length() > 0) {
                    fAbs = Float.parseFloat(strSubstring4);
                } else {
                    fAbs = 0.0f;
                }
            }
        } catch (NumberFormatException unused) {
        }
        i = (fAbs > i ? 1 : (fAbs == i ? 0 : -1));
        if (i > 0) {
            this.mDimensionRatio = fAbs;
            this.mDimensionRatioSide = i3;
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setWrapWidth(int i) {
        this.mWrapWidth = i;
    }

    public void setWrapHeight(int i) {
        this.mWrapHeight = i;
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mMinWidth;
        if (i < i3) {
            this.mWidth = i3;
        }
        this.mHeight = i2;
        int i4 = this.mMinHeight;
        if (i2 < i4) {
            this.mHeight = i4;
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.f15mX = i;
        this.f16mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i7 < (i6 = this.mWidth)) {
            i7 = i6;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i8 < (i5 = this.mHeight)) {
            i8 = i5;
        }
        this.mWidth = i7;
        this.mHeight = i8;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            this.mHeight = i9;
        }
        int i10 = this.mMinWidth;
        if (i7 < i10) {
            this.mWidth = i10;
        }
        this.mOptimizerMeasured = true;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
        this.mOptimizerMeasured = true;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.f15mX = i;
        int i3 = i2 - i;
        this.mWidth = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setVerticalDimension(int i, int i2) {
        this.f16mY = i;
        int i3 = i2 - i;
        this.mHeight = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, i2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, ConstraintAnchor.Strength strength, int i2) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i, strength, i2);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        connect(type, constraintWidget, type2, i, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength) {
        connect(type, constraintWidget, type2, i, strength, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength, int i2) {
        boolean z;
        int i3;
        int i4 = 0;
        if (type == ConstraintAnchor.Type.CENTER) {
            if (type2 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0, strength, i2);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.RIGHT, 0, strength, i2);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    i3 = i2;
                    connect(ConstraintAnchor.Type.TOP, constraintWidget, ConstraintAnchor.Type.TOP, 0, strength, i3);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, ConstraintAnchor.Type.BOTTOM, 0, strength, i3);
                } else {
                    i3 = i2;
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0, i3);
                    return;
                } else if (z) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, i3);
                    return;
                } else {
                    if (z2) {
                        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, i3);
                        return;
                    }
                    return;
                }
            }
            if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0, strength, i2);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0, strength, i2);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i2);
                return;
            } else {
                if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                    connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0, strength, i2);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0, strength, i2);
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i2);
                    return;
                }
                return;
            }
        }
        if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0, i2);
            anchor7.connect(anchor6, 0, i2);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0, i2);
            return;
        }
        if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0, i2);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0, i2);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0, i2);
            return;
        }
        if (type == ConstraintAnchor.Type.CENTER_X && type2 == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0, i2);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0, i2);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0, i2);
            return;
        }
        if (type == ConstraintAnchor.Type.CENTER_Y && type2 == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0, i2);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, i2);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0, i2);
            return;
        }
        ConstraintAnchor anchor9 = getAnchor(type);
        ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            if (type == ConstraintAnchor.Type.BASELINE) {
                ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
            } else {
                if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.BASELINE);
                    if (anchor13 != null) {
                        anchor13.reset();
                    }
                    ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor14.getTarget() != anchor10) {
                        anchor14.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                    if (anchor15.isConnected()) {
                        opposite.reset();
                        anchor15.reset();
                    }
                } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor16.getTarget() != anchor10) {
                        anchor16.reset();
                    }
                    ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    if (anchor17.isConnected()) {
                        opposite2.reset();
                        anchor17.reset();
                    }
                }
                i4 = i;
            }
            anchor9.connect(anchor10, i4, strength, i2);
            anchor10.getOwner().connectedTo(anchor9.getOwner());
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (this instanceof ConstraintWidgetContainer) {
            return;
        }
        if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (getWidth() == getWrapWidth()) {
                setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            } else if (getWidth() > getMinWidth()) {
                setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
            }
        }
        if (getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (getHeight() == getWrapHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            } else if (getHeight() > getMinHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            }
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == anchor5) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor6) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                anchor.reset();
                anchor2.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor7) {
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
            if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor5.reset();
            }
        } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
            anchor5.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).reset();
        }
    }

    public void resetAnchors(int i) {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor = this.mAnchors.get(i2);
            if (i == constraintAnchor.getConnectionCreator()) {
                if (constraintAnchor.isVerticalAnchor()) {
                    setVerticalBiasPercent(DEFAULT_BIAS);
                } else {
                    setHorizontalBiasPercent(DEFAULT_BIAS);
                }
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                constraintAnchor.reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (C01221.f17x4c44d048[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        if (this.mListAnchors[i2].mTarget == null) {
            return false;
        }
        ConstraintAnchor constraintAnchor = this.mListAnchors[i2].mTarget.mTarget;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        if (constraintAnchor == constraintAnchorArr[i2]) {
            return false;
        }
        int i3 = i2 + 1;
        return constraintAnchorArr[i3].mTarget != null && this.mListAnchors[i3].mTarget.mTarget == this.mListAnchors[i3];
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:104:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:107:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:110:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:113:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:116:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:117:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:119:0x0225  */
    /* JADX WARN: Code duplicated, block: B:122:0x0236  */
    /* JADX WARN: Code duplicated, block: B:123:0x0239  */
    /* JADX WARN: Code duplicated, block: B:125:0x0242  */
    /* JADX WARN: Code duplicated, block: B:128:0x0248  */
    /* JADX WARN: Code duplicated, block: B:130:0x024b  */
    /* JADX WARN: Code duplicated, block: B:135:0x0254  */
    /* JADX WARN: Code duplicated, block: B:138:0x0259  */
    /* JADX WARN: Code duplicated, block: B:140:0x0263  */
    /* JADX WARN: Code duplicated, block: B:141:0x026d  */
    /* JADX WARN: Code duplicated, block: B:143:0x027f  */
    /* JADX WARN: Code duplicated, block: B:144:0x028e  */
    /* JADX WARN: Code duplicated, block: B:147:0x0294  */
    /* JADX WARN: Code duplicated, block: B:148:0x029c  */
    /* JADX WARN: Code duplicated, block: B:151:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:154:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:156:0x02df  */
    /* JADX WARN: Code duplicated, block: B:157:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:158:0x0301  */
    /* JADX WARN: Code duplicated, block: B:161:0x030b  */
    /* JADX WARN: Code duplicated, block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0197  */
    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        SolverVariable solverVariable;
        int i;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        boolean z9;
        boolean z10;
        boolean z11;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget;
        SolverVariable solverVariableCreateObjectVariable;
        SolverVariable solverVariable5;
        LinearSystem linearSystem2;
        SolverVariable solverVariable6;
        int i2;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariableCreateObjectVariable2;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariableCreateObjectVariable3;
        int i3;
        boolean zIsInHorizontalChain;
        boolean zIsInVerticalChain;
        LinearSystem linearSystem3 = linearSystem;
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem3.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem3.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable6 = linearSystem3.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable7 = linearSystem3.createObjectVariable(this.mBottom);
        SolverVariable solverVariableCreateObjectVariable8 = linearSystem3.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget4 = this.mParent;
        if (constraintWidget4 != null) {
            z = constraintWidget4 != null && constraintWidget4.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            ConstraintWidget constraintWidget5 = this.mParent;
            z2 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                zIsInHorizontalChain = true;
            } else {
                zIsInHorizontalChain = isInHorizontalChain();
            }
            if (isChainHead(1)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                zIsInVerticalChain = true;
            } else {
                zIsInVerticalChain = isInVerticalChain();
            }
            if (z && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable5, 0, 1);
            }
            if (z2 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable7, 0, 1);
            }
            z3 = zIsInHorizontalChain;
            z4 = zIsInVerticalChain;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        int i4 = this.mWidth;
        int i5 = this.mMinWidth;
        if (i4 < i5) {
            i4 = i5;
        }
        int i6 = this.mHeight;
        int i7 = this.mMinHeight;
        if (i6 < i7) {
            i6 = i7;
        }
        boolean z12 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z13 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
        float f = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f;
        int i8 = this.mMatchConstraintDefaultWidth;
        int i9 = this.mMatchConstraintDefaultHeight;
        if (f > 0.0f && this.mVisibility != 8) {
            solverVariable = solverVariableCreateObjectVariable7;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i8 == 0) {
                i8 = 3;
            }
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i9 == 0) {
                i9 = 3;
            }
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i8 == 3 && i9 == 3) {
                setupDimensionRatio(z, z2, z12, z13);
            } else {
                if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i8 == 3) {
                    this.mResolvedDimensionRatioSide = 0;
                    i4 = (int) (this.mResolvedDimensionRatio * this.mHeight);
                    if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        i = i9;
                        i8 = 4;
                    }
                    int[] iArr = this.mResolvedMatchConstraintDefault;
                    iArr[0] = i8;
                    iArr[1] = i;
                    if (z5) {
                    }
                    if (this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    z8 = !this.mCenter.isConnected();
                    if (this.mHorizontalResolution != 2) {
                        constraintWidget2 = this.mParent;
                        if (constraintWidget2 != null) {
                            solverVariableCreateObjectVariable2 = linearSystem3.createObjectVariable(constraintWidget2.mRight);
                        } else {
                            solverVariableCreateObjectVariable2 = null;
                        }
                        constraintWidget3 = this.mParent;
                        if (constraintWidget3 != null) {
                            solverVariableCreateObjectVariable3 = linearSystem3.createObjectVariable(constraintWidget3.mLeft);
                        } else {
                            solverVariableCreateObjectVariable3 = null;
                        }
                        z9 = z8;
                        solverVariable2 = solverVariableCreateObjectVariable6;
                        solverVariable3 = solverVariableCreateObjectVariable8;
                        linearSystem3 = linearSystem;
                        applyConstraints(linearSystem3, z, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, this.mListDimensionBehaviors[0], z7, this.mLeft, this.mRight, this.f15mX, i4, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z6, z3, i8, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
                    } else {
                        solverVariable2 = solverVariableCreateObjectVariable6;
                        solverVariable3 = solverVariableCreateObjectVariable8;
                        z9 = z8;
                    }
                    if (this.mVerticalResolution == 2) {
                        return;
                    }
                    if (this.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT) {
                        z10 = false;
                    } else {
                        z10 = false;
                    }
                    if (z5) {
                        z11 = false;
                    } else {
                        z11 = false;
                    }
                    if (this.mBaselineDistance <= 0) {
                        solverVariable4 = solverVariable2;
                    } else if (this.mBaseline.getResolutionNode().state == 1) {
                        this.mBaseline.getResolutionNode().addResolvedValue(linearSystem3);
                        solverVariable4 = solverVariable2;
                    } else {
                        solverVariable4 = solverVariable2;
                        solverVariable6 = solverVariable3;
                        linearSystem3.addEquality(solverVariable6, solverVariable4, getBaselineDistance(), 6);
                        if (this.mBaseline.mTarget != null) {
                            linearSystem3.addEquality(solverVariable6, linearSystem3.createObjectVariable(this.mBaseline.mTarget), 0, 6);
                            z9 = false;
                        }
                    }
                    constraintWidget = this.mParent;
                    if (constraintWidget != null) {
                        solverVariableCreateObjectVariable = linearSystem3.createObjectVariable(constraintWidget.mBottom);
                    } else {
                        solverVariableCreateObjectVariable = null;
                    }
                    ConstraintWidget constraintWidget6 = this.mParent;
                    solverVariable5 = solverVariable4;
                    applyConstraints(linearSystem3, z2, constraintWidget6 != null ? linearSystem3.createObjectVariable(constraintWidget6.mTop) : null, solverVariableCreateObjectVariable, this.mListDimensionBehaviors[1], z10, this.mTop, this.mBottom, this.f16mY, i6, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z11, z4, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z9);
                    if (!z5) {
                        linearSystem2 = linearSystem;
                    } else if (this.mResolvedDimensionRatioSide == 1) {
                        linearSystem.addRatio(solverVariable, solverVariable5, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable4, this.mResolvedDimensionRatio, 6);
                        linearSystem2 = linearSystem;
                    } else {
                        linearSystem.addRatio(r20, solverVariableCreateObjectVariable4, solverVariable, solverVariable5, this.mResolvedDimensionRatio, 6);
                        linearSystem2 = linearSystem;
                    }
                    if (this.mCenter.isConnected()) {
                        linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                    }
                }
                if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i9 == 3) {
                    this.mResolvedDimensionRatioSide = 1;
                    if (this.mDimensionRatioSide == -1) {
                        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    }
                    i6 = (int) (this.mResolvedDimensionRatio * this.mWidth);
                    if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        i6 = i6;
                        z5 = false;
                        i = 4;
                    }
                }
                int[] iArr2 = this.mResolvedMatchConstraintDefault;
                iArr2[0] = i8;
                iArr2[1] = i;
                z6 = !z5 && ((i3 = this.mResolvedDimensionRatioSide) == 0 || i3 == -1);
                if (this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT || !(this instanceof ConstraintWidgetContainer)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                z8 = !this.mCenter.isConnected();
                if (this.mHorizontalResolution != 2) {
                    constraintWidget2 = this.mParent;
                    if (constraintWidget2 != null) {
                        solverVariableCreateObjectVariable2 = linearSystem3.createObjectVariable(constraintWidget2.mRight);
                    } else {
                        solverVariableCreateObjectVariable2 = null;
                    }
                    constraintWidget3 = this.mParent;
                    if (constraintWidget3 != null) {
                        solverVariableCreateObjectVariable3 = linearSystem3.createObjectVariable(constraintWidget3.mLeft);
                    } else {
                        solverVariableCreateObjectVariable3 = null;
                    }
                    z9 = z8;
                    solverVariable2 = solverVariableCreateObjectVariable6;
                    solverVariable3 = solverVariableCreateObjectVariable8;
                    linearSystem3 = linearSystem;
                    applyConstraints(linearSystem3, z, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, this.mListDimensionBehaviors[0], z7, this.mLeft, this.mRight, this.f15mX, i4, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z6, z3, i8, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
                } else {
                    solverVariable2 = solverVariableCreateObjectVariable6;
                    solverVariable3 = solverVariableCreateObjectVariable8;
                    z9 = z8;
                }
                if (this.mVerticalResolution == 2) {
                    return;
                }
                if (this.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT || !(this instanceof ConstraintWidgetContainer)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z5 || !((i2 = this.mResolvedDimensionRatioSide) == 1 || i2 == -1)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (this.mBaselineDistance <= 0) {
                    solverVariable4 = solverVariable2;
                } else if (this.mBaseline.getResolutionNode().state == 1) {
                    this.mBaseline.getResolutionNode().addResolvedValue(linearSystem3);
                    solverVariable4 = solverVariable2;
                } else {
                    solverVariable4 = solverVariable2;
                    solverVariable6 = solverVariable3;
                    linearSystem3.addEquality(solverVariable6, solverVariable4, getBaselineDistance(), 6);
                    if (this.mBaseline.mTarget != null) {
                        linearSystem3.addEquality(solverVariable6, linearSystem3.createObjectVariable(this.mBaseline.mTarget), 0, 6);
                        z9 = false;
                    }
                }
                constraintWidget = this.mParent;
                if (constraintWidget != null) {
                    solverVariableCreateObjectVariable = linearSystem3.createObjectVariable(constraintWidget.mBottom);
                } else {
                    solverVariableCreateObjectVariable = null;
                }
                ConstraintWidget constraintWidget7 = this.mParent;
                solverVariable5 = solverVariable4;
                applyConstraints(linearSystem3, z2, constraintWidget7 != null ? linearSystem3.createObjectVariable(constraintWidget7.mTop) : null, solverVariableCreateObjectVariable, this.mListDimensionBehaviors[1], z10, this.mTop, this.mBottom, this.f16mY, i6, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z11, z4, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z9);
                if (!z5) {
                    linearSystem2 = linearSystem;
                } else if (this.mResolvedDimensionRatioSide == 1) {
                    linearSystem.addRatio(solverVariable, solverVariable5, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable4, this.mResolvedDimensionRatio, 6);
                    linearSystem2 = linearSystem;
                } else {
                    linearSystem.addRatio(r20, solverVariableCreateObjectVariable4, solverVariable, solverVariable5, this.mResolvedDimensionRatio, 6);
                    linearSystem2 = linearSystem;
                }
                if (this.mCenter.isConnected()) {
                    linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                }
            }
            i = i9;
            i6 = i6;
            z5 = true;
            int[] iArr3 = this.mResolvedMatchConstraintDefault;
            iArr3[0] = i8;
            iArr3[1] = i;
            if (z5) {
            }
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT) {
                z7 = false;
            } else {
                z7 = false;
            }
            z8 = !this.mCenter.isConnected();
            if (this.mHorizontalResolution != 2) {
                constraintWidget2 = this.mParent;
                if (constraintWidget2 != null) {
                    solverVariableCreateObjectVariable2 = linearSystem3.createObjectVariable(constraintWidget2.mRight);
                } else {
                    solverVariableCreateObjectVariable2 = null;
                }
                constraintWidget3 = this.mParent;
                if (constraintWidget3 != null) {
                    solverVariableCreateObjectVariable3 = linearSystem3.createObjectVariable(constraintWidget3.mLeft);
                } else {
                    solverVariableCreateObjectVariable3 = null;
                }
                z9 = z8;
                solverVariable2 = solverVariableCreateObjectVariable6;
                solverVariable3 = solverVariableCreateObjectVariable8;
                linearSystem3 = linearSystem;
                applyConstraints(linearSystem3, z, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, this.mListDimensionBehaviors[0], z7, this.mLeft, this.mRight, this.f15mX, i4, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z6, z3, i8, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
            } else {
                solverVariable2 = solverVariableCreateObjectVariable6;
                solverVariable3 = solverVariableCreateObjectVariable8;
                z9 = z8;
            }
            if (this.mVerticalResolution == 2) {
                return;
            }
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT) {
                z10 = false;
            } else {
                z10 = false;
            }
            if (z5) {
                z11 = false;
            } else {
                z11 = false;
            }
            if (this.mBaselineDistance <= 0) {
                solverVariable4 = solverVariable2;
            } else if (this.mBaseline.getResolutionNode().state == 1) {
                this.mBaseline.getResolutionNode().addResolvedValue(linearSystem3);
                solverVariable4 = solverVariable2;
            } else {
                solverVariable4 = solverVariable2;
                solverVariable6 = solverVariable3;
                linearSystem3.addEquality(solverVariable6, solverVariable4, getBaselineDistance(), 6);
                if (this.mBaseline.mTarget != null) {
                    linearSystem3.addEquality(solverVariable6, linearSystem3.createObjectVariable(this.mBaseline.mTarget), 0, 6);
                    z9 = false;
                }
            }
            constraintWidget = this.mParent;
            if (constraintWidget != null) {
                solverVariableCreateObjectVariable = linearSystem3.createObjectVariable(constraintWidget.mBottom);
            } else {
                solverVariableCreateObjectVariable = null;
            }
            ConstraintWidget constraintWidget8 = this.mParent;
            solverVariable5 = solverVariable4;
            applyConstraints(linearSystem3, z2, constraintWidget8 != null ? linearSystem3.createObjectVariable(constraintWidget8.mTop) : null, solverVariableCreateObjectVariable, this.mListDimensionBehaviors[1], z10, this.mTop, this.mBottom, this.f16mY, i6, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z11, z4, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z9);
            if (!z5) {
                linearSystem2 = linearSystem;
            } else if (this.mResolvedDimensionRatioSide == 1) {
                linearSystem.addRatio(solverVariable, solverVariable5, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable4, this.mResolvedDimensionRatio, 6);
                linearSystem2 = linearSystem;
            } else {
                linearSystem.addRatio(r20, solverVariableCreateObjectVariable4, solverVariable, solverVariable5, this.mResolvedDimensionRatio, 6);
                linearSystem2 = linearSystem;
            }
            if (this.mCenter.isConnected()) {
                linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
            }
        }
        solverVariable = solverVariableCreateObjectVariable7;
        i = i9;
        z5 = false;
        int[] iArr4 = this.mResolvedMatchConstraintDefault;
        iArr4[0] = i8;
        iArr4[1] = i;
        if (z5) {
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT) {
            z7 = false;
        } else {
            z7 = false;
        }
        z8 = !this.mCenter.isConnected();
        if (this.mHorizontalResolution != 2) {
            constraintWidget2 = this.mParent;
            if (constraintWidget2 != null) {
                solverVariableCreateObjectVariable2 = linearSystem3.createObjectVariable(constraintWidget2.mRight);
            } else {
                solverVariableCreateObjectVariable2 = null;
            }
            constraintWidget3 = this.mParent;
            if (constraintWidget3 != null) {
                solverVariableCreateObjectVariable3 = linearSystem3.createObjectVariable(constraintWidget3.mLeft);
            } else {
                solverVariableCreateObjectVariable3 = null;
            }
            z9 = z8;
            solverVariable2 = solverVariableCreateObjectVariable6;
            solverVariable3 = solverVariableCreateObjectVariable8;
            linearSystem3 = linearSystem;
            applyConstraints(linearSystem3, z, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, this.mListDimensionBehaviors[0], z7, this.mLeft, this.mRight, this.f15mX, i4, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z6, z3, i8, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
        } else {
            solverVariable2 = solverVariableCreateObjectVariable6;
            solverVariable3 = solverVariableCreateObjectVariable8;
            z9 = z8;
        }
        if (this.mVerticalResolution == 2) {
            return;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT) {
            z10 = false;
        } else {
            z10 = false;
        }
        if (z5) {
            z11 = false;
        } else {
            z11 = false;
        }
        if (this.mBaselineDistance <= 0) {
            solverVariable4 = solverVariable2;
        } else if (this.mBaseline.getResolutionNode().state == 1) {
            this.mBaseline.getResolutionNode().addResolvedValue(linearSystem3);
            solverVariable4 = solverVariable2;
        } else {
            solverVariable4 = solverVariable2;
            solverVariable6 = solverVariable3;
            linearSystem3.addEquality(solverVariable6, solverVariable4, getBaselineDistance(), 6);
            if (this.mBaseline.mTarget != null) {
                linearSystem3.addEquality(solverVariable6, linearSystem3.createObjectVariable(this.mBaseline.mTarget), 0, 6);
                z9 = false;
            }
        }
        constraintWidget = this.mParent;
        if (constraintWidget != null) {
            solverVariableCreateObjectVariable = linearSystem3.createObjectVariable(constraintWidget.mBottom);
        } else {
            solverVariableCreateObjectVariable = null;
        }
        ConstraintWidget constraintWidget9 = this.mParent;
        solverVariable5 = solverVariable4;
        applyConstraints(linearSystem3, z2, constraintWidget9 != null ? linearSystem3.createObjectVariable(constraintWidget9.mTop) : null, solverVariableCreateObjectVariable, this.mListDimensionBehaviors[1], z10, this.mTop, this.mBottom, this.f16mY, i6, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z11, z4, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z9);
        if (!z5) {
            linearSystem2 = linearSystem;
        } else if (this.mResolvedDimensionRatioSide == 1) {
            linearSystem.addRatio(solverVariable, solverVariable5, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable4, this.mResolvedDimensionRatio, 6);
            linearSystem2 = linearSystem;
        } else {
            linearSystem.addRatio(r20, solverVariableCreateObjectVariable4, solverVariable, solverVariable5, this.mResolvedDimensionRatio, 6);
            linearSystem2 = linearSystem;
        }
        if (this.mCenter.isConnected()) {
            linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
        }
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z && !z2) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z && z2) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (i == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1 && z && z2) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:157:0x0271  */
    /* JADX WARN: Code duplicated, block: B:164:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:168:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:170:0x02b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:171:0x02b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:174:0x02c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:175:0x02c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:179:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:182:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:190:? A[RETURN, SYNTHETIC] */
    private void applyConstraints(LinearSystem linearSystem, boolean z, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        long j;
        int iMin;
        int i8;
        int i9;
        SolverVariable solverVariableCreateObjectVariable;
        SolverVariable solverVariableCreateObjectVariable2;
        char c;
        int i10;
        int i11;
        boolean z6;
        boolean z7;
        int i12;
        boolean z8;
        boolean z9;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        boolean z10;
        int i13;
        int i14;
        int i15;
        boolean z11;
        int i16;
        boolean z12;
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable solverVariableCreateObjectVariable6 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (linearSystem.graphOptimizer) {
            j = 1;
            if (constraintAnchor.getResolutionNode().state == 1 && constraintAnchor2.getResolutionNode().state == 1) {
                if (LinearSystem.getMetrics() != null) {
                    LinearSystem.getMetrics().resolvedWidgets++;
                }
                constraintAnchor.getResolutionNode().addResolvedValue(linearSystem);
                constraintAnchor2.getResolutionNode().addResolvedValue(linearSystem);
                if (z4 || !z) {
                    return;
                }
                linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable4, 0, 6);
                return;
            }
        } else {
            j = 1;
        }
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets += j;
        }
        boolean zIsConnected = constraintAnchor.isConnected();
        boolean zIsConnected2 = constraintAnchor2.isConnected();
        boolean zIsConnected3 = this.mCenter.isConnected();
        int i17 = zIsConnected2 ? (zIsConnected ? 1 : 0) + 1 : zIsConnected ? 1 : 0;
        if (zIsConnected3) {
            i17++;
        }
        int i18 = z3 ? 3 : i5;
        int i19 = C01221.f18xdde91696[dimensionBehaviour.ordinal()];
        boolean z13 = (i19 == 1 || i19 == 2 || i19 == 3 || i19 != 4 || i18 == 4) ? false : true;
        if (this.mVisibility == 8) {
            iMin = 0;
            z13 = false;
        } else {
            iMin = i2;
        }
        if (z5) {
            if (!zIsConnected && !zIsConnected2 && !zIsConnected3) {
                linearSystem.addEquality(solverVariableCreateObjectVariable3, i);
            } else if (zIsConnected && !zIsConnected2) {
                i8 = 6;
                linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 6);
            }
            i8 = 6;
        } else {
            i8 = 6;
        }
        if (z13) {
            i9 = i6;
            if (i9 == -2) {
                i9 = iMin;
            }
            int i20 = i7 == -2 ? iMin : i7;
            if (i9 > 0) {
                linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i9, 6);
                iMin = Math.max(iMin, i9);
            }
            if (i20 > 0) {
                linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i20, 6);
                iMin = Math.min(iMin, i20);
            }
            if (i18 != 1) {
                if (i18 == 2) {
                    if (constraintAnchor.getType() == ConstraintAnchor.Type.TOP || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                        solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                        solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                    } else {
                        solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                        solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                    }
                    c = 2;
                    i10 = iMin;
                    linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, f2));
                    i11 = i20;
                    z6 = false;
                }
                if (z6 || i17 == c || z3) {
                    z13 = z6;
                } else {
                    int iMax = Math.max(i9, i10);
                    if (i11 > 0) {
                        iMax = Math.min(i11, iMax);
                    }
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMax, 6);
                    z13 = false;
                }
            } else if (z) {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 6);
            } else if (z4) {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 4);
            } else {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 1);
            }
            i11 = i20;
            z6 = z13;
            c = 2;
            i10 = iMin;
            if (z6) {
                z13 = z6;
            } else {
                z13 = z6;
            }
        } else {
            if (z2) {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 3);
                if (i3 > 0) {
                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i3, 6);
                }
                if (i4 < Integer.MAX_VALUE) {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i4, 6);
                }
            } else {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, i8);
            }
            i9 = i6;
            i11 = i7;
            i18 = i18;
            i17 = i17;
            c = 2;
        }
        if (!z5 || z4) {
            if (i17 >= c || !z) {
                return;
            }
            linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 6);
            linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable4, 0, 6);
            return;
        }
        int i21 = 5;
        if (zIsConnected || zIsConnected2 || zIsConnected3) {
            if (!zIsConnected || zIsConnected2) {
                if (zIsConnected || !zIsConnected2) {
                    if (zIsConnected && zIsConnected2) {
                        if (z13) {
                            if (z && i3 == 0) {
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 6);
                            }
                            if (i18 == 0) {
                                if (i11 > 0 || i9 > 0) {
                                    i16 = 4;
                                    z12 = true;
                                } else {
                                    i16 = 6;
                                    z12 = false;
                                }
                                linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), i16);
                                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, -constraintAnchor2.getMargin(), i16);
                                boolean z14 = i11 > 0 || i9 > 0;
                                z9 = z12;
                                i12 = 5;
                                z7 = true;
                                z8 = z14;
                            } else {
                                z7 = true;
                                if (i18 == 1) {
                                    i12 = 6;
                                    z8 = true;
                                    z9 = true;
                                } else if (i18 == 3) {
                                    int i22 = (z3 || this.mResolvedDimensionRatioSide == -1 || i11 > 0) ? 4 : 6;
                                    linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), i22);
                                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, -constraintAnchor2.getMargin(), i22);
                                    i12 = 5;
                                    z8 = true;
                                    z9 = true;
                                } else {
                                    i12 = 5;
                                    z8 = false;
                                }
                            }
                            if (z8) {
                                solverVariable3 = solverVariableCreateObjectVariable5;
                                int i23 = i12;
                                solverVariable4 = solverVariableCreateObjectVariable6;
                                linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariable3, constraintAnchor.getMargin(), f, solverVariable4, solverVariableCreateObjectVariable4, constraintAnchor2.getMargin(), i23);
                                constraintAnchor3 = constraintAnchor;
                                z11 = constraintAnchor3.mTarget.mOwner instanceof Barrier;
                                constraintAnchor4 = constraintAnchor2;
                                boolean z15 = constraintAnchor4.mTarget.mOwner instanceof Barrier;
                                if (z11 || z15) {
                                    if (z11 && z15) {
                                        z10 = z;
                                        i21 = 6;
                                    }
                                    i13 = 5;
                                } else {
                                    z7 = z;
                                    i13 = 6;
                                    z10 = true;
                                }
                                if (z9) {
                                    i21 = 6;
                                    i13 = 6;
                                }
                                if ((z13 && z7) || z9) {
                                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable3, constraintAnchor3.getMargin(), i21);
                                }
                                if ((z13 && z10) || z9) {
                                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariable4, -constraintAnchor4.getMargin(), i13);
                                }
                                i14 = 0;
                                i15 = 6;
                                if (z) {
                                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 6);
                                }
                            } else {
                                constraintAnchor3 = constraintAnchor;
                                constraintAnchor4 = constraintAnchor2;
                                solverVariable3 = solverVariableCreateObjectVariable5;
                                solverVariable4 = solverVariableCreateObjectVariable6;
                            }
                            z10 = z;
                            z7 = z10;
                            i13 = 5;
                            if (z9) {
                                i21 = 6;
                                i13 = 6;
                            }
                            if (z13) {
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable3, constraintAnchor3.getMargin(), i21);
                            } else {
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable3, constraintAnchor3.getMargin(), i21);
                            }
                            if (z13) {
                                linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariable4, -constraintAnchor4.getMargin(), i13);
                            } else {
                                linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariable4, -constraintAnchor4.getMargin(), i13);
                            }
                            i14 = 0;
                            i15 = 6;
                            if (z) {
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 6);
                            }
                        } else {
                            z7 = true;
                            i12 = 5;
                            z8 = true;
                        }
                        z9 = false;
                        if (z8) {
                            solverVariable3 = solverVariableCreateObjectVariable5;
                            int i24 = i12;
                            solverVariable4 = solverVariableCreateObjectVariable6;
                            linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariable3, constraintAnchor.getMargin(), f, solverVariable4, solverVariableCreateObjectVariable4, constraintAnchor2.getMargin(), i24);
                            constraintAnchor3 = constraintAnchor;
                            z11 = constraintAnchor3.mTarget.mOwner instanceof Barrier;
                            constraintAnchor4 = constraintAnchor2;
                            boolean z16 = constraintAnchor4.mTarget.mOwner instanceof Barrier;
                            if (z11) {
                            }
                            if (z11) {
                            }
                            i13 = 5;
                            if (z9) {
                                i21 = 6;
                                i13 = 6;
                            }
                            if (z13) {
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable3, constraintAnchor3.getMargin(), i21);
                            } else {
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable3, constraintAnchor3.getMargin(), i21);
                            }
                            if (z13) {
                                linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariable4, -constraintAnchor4.getMargin(), i13);
                            } else {
                                linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariable4, -constraintAnchor4.getMargin(), i13);
                            }
                            i14 = 0;
                            i15 = 6;
                            if (z) {
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 6);
                            }
                        } else {
                            constraintAnchor3 = constraintAnchor;
                            constraintAnchor4 = constraintAnchor2;
                            solverVariable3 = solverVariableCreateObjectVariable5;
                            solverVariable4 = solverVariableCreateObjectVariable6;
                        }
                        z10 = z;
                        z7 = z10;
                        i13 = 5;
                        if (z9) {
                            i21 = 6;
                            i13 = 6;
                        }
                        if (z13) {
                            linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable3, constraintAnchor3.getMargin(), i21);
                        } else {
                            linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable3, constraintAnchor3.getMargin(), i21);
                        }
                        if (z13) {
                            linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariable4, -constraintAnchor4.getMargin(), i13);
                        } else {
                            linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariable4, -constraintAnchor4.getMargin(), i13);
                        }
                        i14 = 0;
                        i15 = 6;
                        if (z) {
                            linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 6);
                        }
                    }
                    if (z) {
                        linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable4, i14, i15);
                    }
                }
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, -constraintAnchor2.getMargin(), 6);
                if (z) {
                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 5);
                }
            } else if (z) {
                linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable4, 0, 5);
            }
        } else if (z) {
            linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable4, 0, 5);
        }
        i14 = 0;
        i15 = 6;
        if (z) {
            linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable4, i14, i15);
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1 */
    static /* synthetic */ class C01221 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type */
        static final /* synthetic */ int[] f17x4c44d048;

        /* JADX INFO: renamed from: $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour */
        static final /* synthetic */ int[] f18xdde91696;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            f18xdde91696 = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18xdde91696[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18xdde91696[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18xdde91696[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            f17x4c44d048 = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17x4c44d048[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17x4c44d048[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17x4c44d048[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17x4c44d048[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17x4c44d048[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17x4c44d048[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17x4c44d048[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17x4c44d048[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }
}
