package com.csnt.titlestatusbar.viewUtils;
import android.view.View;

/**
 * Created by sunrain
 * Created Date 2020/6/19 4:49 PM
 */
public class ViewUtil {
    /**
     * 获取view的宽度
     */
    public static int getViewWidth(View view) {
        int width = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(width, height);
        return view.getMeasuredWidth(); // 获取宽度
    }


    /**
     * 获取view的宽度
     *
     */
    public static int getViewHeight(View view) {
        int width = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(width, height);
        return view.getMeasuredHeight(); // 获取宽度
    }
}
