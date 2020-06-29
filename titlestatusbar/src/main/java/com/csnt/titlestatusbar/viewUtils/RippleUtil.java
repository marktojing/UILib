package com.csnt.titlestatusbar.viewUtils;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

/**
 * Created by sunrain
 * Created Date 2020/6/7 11:44 PM
 * 设置代码涟漪效果
 */
public class RippleUtil {
    public static final int NONE=0;
    public static final int ROUND=10;
    public static final int RECTANGLE=20;
    public static final int NOBACK_RECTANGLE=21;
    public static final int NOBACK_ROUND=11;
    /**
    *@Author sunrain
    *@Time 2020/6/7 11:45 PM
    *
    */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static RippleDrawable setRipperDrawable(int radius, @ColorInt int backgroundColor, @ColorInt int pressedColor, int mode){
        int[][] stateList = new int[][]{
                new int[]{android.R.attr.state_pressed},
                new int[]{android.R.attr.state_focused},
                new int[]{android.R.attr.state_activated},
                new int[]{}
        };
        //深蓝
        int normalColor = Color.parseColor("#303F9F");
        //玫瑰红
        int[] stateColorList = new int[]{
                pressedColor,
                pressedColor,
                pressedColor,
                normalColor
        };
        ColorStateList colorStateList = new ColorStateList(stateList, stateColorList);
        float[] outRadius = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
        RoundRectShape roundRectShape = new RoundRectShape(outRadius, null, null);
        ShapeDrawable maskDrawable = new ShapeDrawable();
        maskDrawable.setShape(roundRectShape);
//        maskDrawable.getPaint().setColor(Color.parseColor("#000000"));
        maskDrawable.getPaint().setColor(Color.parseColor("#f7c653"));
        maskDrawable.getPaint().setStyle(Paint.Style.FILL);
        ShapeDrawable contentDrawable = new ShapeDrawable();
        contentDrawable.setShape(roundRectShape);
//        contentDrawable.getPaint().setColor(Color.parseColor("#f7c653"));
        contentDrawable.getPaint().setColor(backgroundColor);
        contentDrawable.getPaint().setStyle(Paint.Style.FILL);

        //contentDrawable实际是默认初始化时展示的；maskDrawable 控制了rippleDrawable的范围
        switch (mode){
            case NOBACK_ROUND:
            case NOBACK_RECTANGLE:
                return new RippleDrawable(colorStateList, null, maskDrawable);
            default:
                break;
        }
        return new RippleDrawable(colorStateList, contentDrawable, maskDrawable);
    }
    /**
     *@Author sunrain
     *@Time 2020/6/7 11:45 PM
     *
     */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void getRipperDrawable(View v, int type){
        v.setClickable(true);
        switch (type){
            case ROUND:
                v.setBackground(setRipperDrawable( v.getLayoutParams().width/2,Color.parseColor("#FFFFFF"),Color.parseColor("#FF4081"),type));
                break;
            case NOBACK_ROUND:
                v.setBackground(setRipperDrawable( v.getLayoutParams().width/2,Color.parseColor("#00FFFFFF"),Color.parseColor("#FF4081"),type));
                break;
            case RECTANGLE:
                v.setBackground(setRipperDrawable(20,Color.parseColor("#FFFFFF"),Color.parseColor("#FF4081"),type));
                break;
            case NOBACK_RECTANGLE:
                v.setBackground(setRipperDrawable(20,Color.parseColor("#00FFFFFF"),Color.parseColor("#FF4081"),type));
                break;
            case NONE:
            default:
                v.setBackground(setRipperDrawable(0,Color.parseColor("#FFFFFF"),Color.parseColor("#FF4081"),type));
                break;
        }


    }
}
