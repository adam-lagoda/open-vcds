package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes.dex */
class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;

    /* JADX INFO: renamed from: mJ */
    private final float f26mJ;
    private final float mJstar;

    /* JADX INFO: renamed from: mM */
    private final float f27mM;

    /* JADX INFO: renamed from: mQ */
    private final float f28mQ;

    /* JADX INFO: renamed from: mS */
    private final float f29mS;

    float getHue() {
        return this.mHue;
    }

    float getChroma() {
        return this.mChroma;
    }

    float getJ() {
        return this.f26mJ;
    }

    float getQ() {
        return this.f28mQ;
    }

    float getM() {
        return this.f27mM;
    }

    float getS() {
        return this.f29mS;
    }

    float getJStar() {
        return this.mJstar;
    }

    float getAStar() {
        return this.mAstar;
    }

    float getBStar() {
        return this.mBstar;
    }

    CamColor(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.mHue = f;
        this.mChroma = f2;
        this.f26mJ = f3;
        this.f28mQ = f4;
        this.f27mM = f5;
        this.f29mS = f6;
        this.mJstar = f7;
        this.mAstar = f8;
        this.mBstar = f9;
    }

    static int toColor(float f, float f2, float f3) {
        return toColor(f, f2, f3, ViewingConditions.DEFAULT);
    }

    static CamColor fromColor(int i) {
        return fromColorInViewingConditions(i, ViewingConditions.DEFAULT);
    }

    static CamColor fromColorInViewingConditions(int i, ViewingConditions viewingConditions) {
        float[] fArrXyzFromInt = CamUtils.xyzFromInt(i);
        float[][] fArr = CamUtils.XYZ_TO_CAM16RGB;
        float f = fArrXyzFromInt[0];
        float[] fArr2 = fArr[0];
        float f2 = fArr2[0] * f;
        float f3 = fArrXyzFromInt[1];
        float f4 = f2 + (fArr2[1] * f3);
        float f5 = fArrXyzFromInt[2];
        float f6 = f4 + (fArr2[2] * f5);
        float[] fArr3 = fArr[1];
        float f7 = (fArr3[0] * f) + (fArr3[1] * f3) + (fArr3[2] * f5);
        float[] fArr4 = fArr[2];
        float f8 = (f * fArr4[0]) + (f3 * fArr4[1]) + (f5 * fArr4[2]);
        float f9 = viewingConditions.getRgbD()[0] * f6;
        float f10 = viewingConditions.getRgbD()[1] * f7;
        float f11 = viewingConditions.getRgbD()[2] * f8;
        double fl = viewingConditions.getFl() * Math.abs(f9);
        Double.isNaN(fl);
        float fPow = (float) Math.pow(fl / 100.0d, 0.42d);
        double fl2 = viewingConditions.getFl() * Math.abs(f10);
        Double.isNaN(fl2);
        float fPow2 = (float) Math.pow(fl2 / 100.0d, 0.42d);
        double fl3 = viewingConditions.getFl() * Math.abs(f11);
        Double.isNaN(fl3);
        float fPow3 = (float) Math.pow(fl3 / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f9) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f10) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f11) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d = fSignum;
        Double.isNaN(d);
        double d2 = fSignum2;
        Double.isNaN(d2);
        double d3 = fSignum3;
        Double.isNaN(d3);
        float f12 = ((float) (((d * 11.0d) + (d2 * (-12.0d))) + d3)) / 11.0f;
        double d4 = fSignum + fSignum2;
        Double.isNaN(d3);
        Double.isNaN(d4);
        float f13 = ((float) (d4 - (d3 * 2.0d))) / 9.0f;
        float f14 = fSignum2 * 20.0f;
        float f15 = (((fSignum * 20.0f) + f14) + (21.0f * fSignum3)) / 20.0f;
        float f16 = (((fSignum * 40.0f) + f14) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f13, f12)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f17 = fAtan2;
        float f18 = (3.1415927f * f17) / 180.0f;
        float fPow4 = ((float) Math.pow((f16 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float c = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        double d5 = ((double) f17) < 20.14d ? 360.0f + f17 : f17;
        Double.isNaN(d5);
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((d5 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((f12 * f12) + (f13 * f13)))) / (f15 + 0.305f), 0.9d));
        double d6 = fPow4;
        Double.isNaN(d6);
        float fSqrt = fPow5 * ((float) Math.sqrt(d6 / 100.0d));
        float flRoot = fSqrt * viewingConditions.getFlRoot();
        float fSqrt2 = ((float) Math.sqrt((fPow5 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f19 = (1.7f * fPow4) / ((0.007f * fPow4) + DE_MAX);
        float fLog = ((float) Math.log((0.0228f * flRoot) + DE_MAX)) * 43.85965f;
        double d7 = f18;
        return new CamColor(f17, fSqrt, fPow4, c, flRoot, fSqrt2, f19, fLog * ((float) Math.cos(d7)), fLog * ((float) Math.sin(d7)));
    }

    private static CamColor fromJch(float f, float f2, float f3) {
        return fromJchInFrame(f, f2, f3, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float f, float f2, float f3, ViewingConditions viewingConditions) {
        float c = 4.0f / viewingConditions.getC();
        double d = f;
        Double.isNaN(d);
        double d2 = d / 100.0d;
        float fSqrt = c * ((float) Math.sqrt(d2)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float flRoot = viewingConditions.getFlRoot() * f2;
        float fSqrt2 = ((float) Math.sqrt(((f2 / ((float) Math.sqrt(d2))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f4 = (1.7f * f) / ((0.007f * f) + DE_MAX);
        double d3 = flRoot;
        Double.isNaN(d3);
        float fLog = ((float) Math.log((d3 * 0.0228d) + 1.0d)) * 43.85965f;
        double d4 = (3.1415927f * f3) / 180.0f;
        return new CamColor(f3, f2, f, fSqrt, flRoot, fSqrt2, f4, ((float) Math.cos(d4)) * fLog, fLog * ((float) Math.sin(d4)));
    }

    float distance(CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((jStar * jStar) + (aStar * aStar) + (bStar * bStar)), 0.63d) * 1.41d);
    }

    int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    int viewed(ViewingConditions viewingConditions) {
        float fSqrt;
        if (getChroma() == 0.0d || getJ() == 0.0d) {
            fSqrt = 0.0f;
        } else {
            float chroma = getChroma();
            double j = getJ();
            Double.isNaN(j);
            fSqrt = chroma / ((float) Math.sqrt(j / 100.0d));
        }
        double d = fSqrt;
        double dPow = Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d);
        Double.isNaN(d);
        float fPow = (float) Math.pow(d / dPow, 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        Double.isNaN(hue);
        float fCos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f;
        float aw = viewingConditions.getAw();
        double j2 = getJ();
        Double.isNaN(j2);
        double c = viewingConditions.getC();
        Double.isNaN(c);
        double d2 = 1.0d / c;
        double z = viewingConditions.getZ();
        Double.isNaN(z);
        float fPow2 = aw * ((float) Math.pow(j2 / 100.0d, d2 / z));
        float nc = fCos * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = fPow2 / viewingConditions.getNbb();
        float fSin = (float) Math.sin(hue);
        float fCos2 = (float) Math.cos(hue);
        float f = (((0.305f + nbb) * 23.0f) * fPow) / (((nc * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f2 = fCos2 * f;
        float f3 = f * fSin;
        float f4 = nbb * 460.0f;
        float f5 = (((451.0f * f2) + f4) + (288.0f * f3)) / 1403.0f;
        float f6 = ((f4 - (891.0f * f2)) - (261.0f * f3)) / 1403.0f;
        float f7 = ((f4 - (f2 * 220.0f)) - (f3 * 6300.0f)) / 1403.0f;
        double dAbs = Math.abs(f5);
        Double.isNaN(dAbs);
        double dAbs2 = Math.abs(f5);
        Double.isNaN(dAbs2);
        float fSignum = Math.signum(f5) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (dAbs * 27.13d) / (400.0d - dAbs2)), 2.380952380952381d));
        double dAbs3 = Math.abs(f6);
        Double.isNaN(dAbs3);
        double dAbs4 = Math.abs(f6);
        Double.isNaN(dAbs4);
        float fSignum2 = Math.signum(f6) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (dAbs3 * 27.13d) / (400.0d - dAbs4)), 2.380952380952381d));
        double dAbs5 = Math.abs(f7);
        Double.isNaN(dAbs5);
        double dAbs6 = Math.abs(f7);
        Double.isNaN(dAbs6);
        float fSignum3 = Math.signum(f7) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (dAbs5 * 27.13d) / (400.0d - dAbs6)), 2.380952380952381d));
        float f8 = fSignum / viewingConditions.getRgbD()[0];
        float f9 = fSignum2 / viewingConditions.getRgbD()[1];
        float f10 = fSignum3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f11 = (fArr2[0] * f8) + (fArr2[1] * f9) + (fArr2[2] * f10);
        float[] fArr3 = fArr[1];
        float f12 = (fArr3[0] * f8) + (fArr3[1] * f9) + (fArr3[2] * f10);
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor(f11, f12, (f8 * fArr4[0]) + (f9 * fArr4[1]) + (f10 * fArr4[2]));
    }

    static int toColor(float f, float f2, float f3, ViewingConditions viewingConditions) {
        if (f2 < 1.0d || Math.round(f3) <= 0.0d || Math.round(f3) >= 100.0d) {
            return CamUtils.intFromLStar(f3);
        }
        float fMin = f < 0.0f ? 0.0f : Math.min(360.0f, f);
        float f4 = f2;
        CamColor camColor = null;
        float f5 = 0.0f;
        boolean z = true;
        while (Math.abs(f5 - f2) >= CHROMA_SEARCH_ENDPOINT) {
            CamColor camColorFindCamByJ = findCamByJ(fMin, f4, f3);
            if (!z) {
                if (camColorFindCamByJ == null) {
                    f2 = f4;
                } else {
                    f5 = f4;
                    camColor = camColorFindCamByJ;
                }
                f4 = ((f2 - f5) / 2.0f) + f5;
            } else {
                if (camColorFindCamByJ != null) {
                    return camColorFindCamByJ.viewed(viewingConditions);
                }
                f4 = ((f2 - f5) / 2.0f) + f5;
                z = false;
            }
        }
        if (camColor == null) {
            return CamUtils.intFromLStar(f3);
        }
        return camColor.viewed(viewingConditions);
    }

    private static CamColor findCamByJ(float f, float f2, float f3) {
        float f4 = 100.0f;
        float f5 = 1000.0f;
        CamColor camColor = null;
        float f6 = 1000.0f;
        float f7 = 0.0f;
        while (Math.abs(f7 - f4) > LIGHTNESS_SEARCH_ENDPOINT) {
            float f8 = ((f4 - f7) / 2.0f) + f7;
            int iViewedInSrgb = fromJch(f8, f2, f).viewedInSrgb();
            float fLStarFromInt = CamUtils.lStarFromInt(iViewedInSrgb);
            float fAbs = Math.abs(f3 - fLStarFromInt);
            if (fAbs < DL_MAX) {
                CamColor camColorFromColor = fromColor(iViewedInSrgb);
                float fDistance = camColorFromColor.distance(fromJch(camColorFromColor.getJ(), camColorFromColor.getChroma(), f));
                if (fDistance <= DE_MAX) {
                    camColor = camColorFromColor;
                    f5 = fAbs;
                    f6 = fDistance;
                }
            }
            if (f5 == 0.0f && f6 == 0.0f) {
                return camColor;
            }
            if (fLStarFromInt < f3) {
                f7 = f8;
            } else {
                f4 = f8;
            }
        }
        return camColor;
    }
}
