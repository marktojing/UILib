package com.csnt.titlestatusbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.csnt.titlestatusbar.statusBar.StatusBarHeightView;
import com.csnt.titlestatusbar.viewUtils.RippleUtil;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;

/**
 * Created by sunrain
 * Created Date 2020/6/3 4:47 PM
 */
public class HeadTitleBar extends RelativeLayout implements DefaultTheme {

    private RelativeLayout layout_root;
    private TextView showTitle;
    private View showLeftContent;
    private View showRightContent;
    private ImageView leftImage;
    private ImageView rightImage;
    private TextView leftText;
    private TextView rightText;
    private TextView centerText;
    private StatusBarHeightView statusBarHeightView;
    private LinearLayout linearLayout;
    String element;
    private Context context;

    private int showViews;

    public HeadTitleBar(Context context) {
        super(context);
        this.context=context;
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HeadTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView(context);
        initAttrs(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HeadTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initView(context);
        initAttrs(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar);
        String title = mTypedArray.getString(R.styleable.HeaderBar_title_text);
        int textColor = mTypedArray.getColor(R.styleable.HeaderBar_title_text_clolor, Color.WHITE);
        //设置展示内容
        showViews = mTypedArray.getInt(R.styleable.HeaderBar_show_views, 0x1A);

        ViewGroup.LayoutParams layoutParams1 = linearLayout.getLayoutParams();
        layoutParams1.width=mTypedArray.getLayoutDimension(R.styleable.HeaderBar_android_layout_width, -1);
        layoutParams1.height=mTypedArray.getLayoutDimension(R.styleable.HeaderBar_android_layout_height, -2)+960;

        linearLayout.setLayoutParams(layoutParams1);
//        linearLayout.setElevation(MaterialDesignStyle.z_dialog_24);
//        layout_root.setElevation(MaterialDesignStyle.z_dialog_24);
        mTypedArray.recycle();
        showView(showViews);
        if(showTitle!=null){
            showTitle.setText(title);
        }


    }
    /**
     *@Author sunrain
     *@Time 2020/6/4 4:22 PM
     *逻辑，如果title只有一个，则这个就是标题，如果有两个则根据中》左》右这种优先级来设定
     * 图标和title最多有三个，最少有一个title（1，3）icon(0,2)
     * 文字的优先级大于图标的
     */
    @SuppressLint("DefaultLocale")
    private void showView(int showView) {
        Long data = Long.valueOf(Integer.toBinaryString(showView));
        element = String.format("%05d", data);
        for (int i = 0; i < element.length(); i++) {

                switch (i){
                    case 0:
                        if(setSelfVisibility(i,centerText)){
                            showTitle=centerText;
                        }
                        break;
                    case 1:
                        if(setSelfVisibility(i,leftImage)){
                            showLeftContent=leftImage;
                        };
                        break;
                    case 2:
                        if(setSelfVisibility(i,leftText)){
                            leftImage.setVisibility(GONE);
                            showLeftContent=leftText;
                            if(showTitle==null){
                                showTitle=leftText;
                            }
                        }
                        break;
                    case 3:
                        if(setSelfVisibility(i,rightImage)){
                            showRightContent=rightImage;
                        };
                        break;
                    case 4:
                        if(setSelfVisibility(i,rightText)){
                            rightImage.setVisibility(GONE);
                            showRightContent=rightText;
                            if(showTitle==null){
                                showTitle=rightText;
                            }
                        }
                        break;
                }

//            setSelfVisibility(i,title,textColor);
        }
    }

    /**
     * 设置是否隐藏
     * @param i  6位二进制数，每一位表示一个属性，1为显示0为隐藏
     */
    private boolean setSelfVisibility(int i,View view){
        if(element.substring(i,i+1).equals("1")){
            view.setVisibility(VISIBLE);
            return true;
        }else{
            view.setVisibility(GONE);
            return false;
        }
    }


    private void initView(final Context context) {
         LayoutInflater.from(context).inflate(R.layout.view_header, this, true);
       rightImage= (ImageView) findViewById(R.id.header_right_img);
       leftImage= (ImageView) findViewById(R.id.header_left_img);
       rightText= (TextView) findViewById(R.id.header_right_text);
        leftText=(TextView) findViewById(R.id.header_left_text);
        centerText=(TextView) findViewById(R.id.header_center_text);
        layout_root = (RelativeLayout) findViewById(R.id.header_root_layout);
        statusBarHeightView = (StatusBarHeightView) findViewById(R.id.status_bar);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
    }

    public void setLeftListener(OnClickListener onClickListener) {
        if(showLeftContent!=null)showLeftContent.setOnClickListener(onClickListener);
    }
    public void setRightListener(OnClickListener onClickListener) {
        if(showRightContent!=null)showRightContent.setOnClickListener(onClickListener);
    }
    public void hideLeftContent(){
        if(showLeftContent!=null)showLeftContent.setVisibility(INVISIBLE);
    }
    public void setTitle(String title){
        if(showTitle!=null){
            showTitle.setText(title);
        }else{
            showTitle=centerText;
            showTitle.setText(title);
        }
    }
    public void setTitle(@StringRes int title){
        if(showTitle!=null){
            showTitle.setText(title);
        }else{
            showTitle=centerText;
            showTitle.setText(title);
        }
    }
    public void setLeftImage(@Nullable Drawable drawable){
        leftImage.setImageDrawable(drawable);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setLeftImageBackMode(int type){
        RippleUtil.getRipperDrawable(leftImage,type);
    }
    public void setLeftImage(@DrawableRes int resId){
        leftImage.setImageResource(resId);
    }
    public void setLeftImage(Bitmap bitmap){
        leftImage.setImageBitmap(bitmap);
    }
    public void setRightImage(@Nullable Drawable drawable){
        rightImage.setImageDrawable(drawable);
    }
    public void setRightImage(@DrawableRes int resId){
        rightImage.setImageResource(resId);
    }
    public void setRightImage(Bitmap bitmap){
        rightImage.setImageBitmap(bitmap);
    }
    public void setBackgroundColor(@ColorInt int color){
        linearLayout.setBackgroundColor(color);
    }
    public void setBackgroundDrawable(@Nullable Drawable drawable){
        layout_root.setClickable(true);
        layout_root.setBackground(drawable);
    }
    public void setBackgroundResource(@DrawableRes int resId){
        layout_root.setBackgroundResource(resId);
    }
    public void setTitleSize( float textSize){
        showTitle.setTextSize(textSize);
    }
    public void setTextSize( float textSize){
        if(showRightContent!=null&&showRightContent instanceof TextView){
             ((TextView) showRightContent).setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
        }
        if(showLeftContent!=null&&showLeftContent instanceof TextView){
            ((TextView) showLeftContent).setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
        }
    }
    public void setLeftText(String leftText){
        if(showLeftContent!=null&&showLeftContent instanceof TextView){
            ((TextView) showLeftContent).setText(leftText);
        }
    }
    public void setLeftText(@StringRes int leftText){
        if(showLeftContent!=null&&showLeftContent instanceof TextView){
            ((TextView) showLeftContent).setText(leftText);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setLeftTextBackMode(){
        if(showLeftContent!=null&&showLeftContent instanceof TextView){
            showLeftContent.setPadding(dip2px(8),dip2px(5),dip2px(8),dip2px(5));
            RippleUtil.getRipperDrawable(((TextView) showLeftContent), RippleUtil.NOBACK_RECTANGLE);
        }
    }
    public void setLeftTextColor(@ColorInt int leftTextColor){
        if(showLeftContent!=null&&showLeftContent instanceof TextView){
            ((TextView) showLeftContent).setTextColor(leftTextColor);
        }
    }
    public void setRightText(String rightText){
        if(showRightContent!=null&&showRightContent instanceof TextView){
            ((TextView) showRightContent).setText(rightText);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setRightTextBackMode(){
        if(showRightContent!=null&&showRightContent instanceof TextView){
            showRightContent.setPadding(dip2px(8),dip2px(5),dip2px(8),dip2px(5));
            RippleUtil.getRipperDrawable(((TextView) showRightContent), RippleUtil.NOBACK_RECTANGLE);
        }
    }
    @SuppressLint("ResourceType")
    public void addRightImage(@DrawableRes int drawable){
        if(showRightContent==null){
            rightImage.setVisibility(VISIBLE);
            if(drawable>0){
                rightImage.setImageResource(drawable);
            }
            showRightContent=rightImage;
        }
    }
    public void setRightText(@StringRes int rightText){
        if(showRightContent!=null&&showRightContent instanceof TextView){
            ((TextView) showRightContent).setText(rightText);
        }
    }
    public void setRightTextColor(@ColorInt int rightTextColor){
        if(showRightContent!=null&&showRightContent instanceof TextView){
            ((TextView) showRightContent).setTextColor(rightTextColor);
        }
    }
    public void setLeftImageSize(int w,int h){
        ViewGroup.LayoutParams layoutParams = leftImage.getLayoutParams();
        layoutParams.width=dip2px(w);
        layoutParams.height=dip2px(h);
        leftImage.setLayoutParams(layoutParams);
    }
    public void setRightImageSize(int w,int h){
        ViewGroup.LayoutParams layoutParams = rightImage.getLayoutParams();
        layoutParams.width=dip2px(w);
        layoutParams.height=dip2px(h);
        rightImage.setLayoutParams(layoutParams);
    }
    public void setRightImagePadding(int padding){
        rightImage.setPadding(dip2px(padding),dip2px(padding),dip2px(padding),dip2px(padding));
    }
    public void setLeftImagePadding(int padding){
        leftImage.setPadding(dip2px(padding),dip2px(padding),dip2px(padding),dip2px(padding));
    }
    public void setRightImageBackgroundColor(@ColorInt int resId){
        GradientDrawable background = (GradientDrawable) rightImage.getBackground();
        background.setColor(resId);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setRightImageBackGroundMode(int type){
        RippleUtil.getRipperDrawable(rightImage,type);
    }

      @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setDefaultTheme(){
        setRightImageSize(MaterialDesignStyle.size_minTouchArea,MaterialDesignStyle.size_minTouchArea);
        setRightImagePadding(MaterialDesignStyle.gap_card_content_min);
        setRightImageBackGroundMode(RippleUtil.NOBACK_ROUND);
        setLeftImageSize(MaterialDesignStyle.size_minTouchArea,MaterialDesignStyle.size_minTouchArea);
        setLeftImagePadding(MaterialDesignStyle.gap_card_content_min);
        setLeftImageBackMode(RippleUtil.NOBACK_ROUND);
        setTitleSize(MaterialDesignStyle.text_title_big);
        setLeftText("返回");
        setLeftTextBackMode();
        setRightText("提交");
        setTitle("QuickApp");
        setTextSize(MaterialDesignStyle.text_appBar);
        setRightTextBackMode();
        setBackgroundColor(MaterialDesignStyle.color_theme_blue);
        VectorDrawable drawable = (VectorDrawable) leftImage.getDrawable();
        VectorDrawable drawable1 = (VectorDrawable) rightImage.getDrawable();
        drawable.setTint(MaterialDesignStyle.color_white);
        drawable1.setTint(MaterialDesignStyle.color_white);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setDefaultSmallTheme(float apha){
        setRightImageSize((int)(MaterialDesignStyle.size_minTouchArea*apha),(int)(MaterialDesignStyle.size_minTouchArea*apha));
        setRightImagePadding((int)(MaterialDesignStyle.gap_card_content_min*apha));
        setRightImageBackGroundMode(RippleUtil.NOBACK_ROUND);
        setLeftImageSize((int)(MaterialDesignStyle.size_minTouchArea*apha),(int)(MaterialDesignStyle.size_minTouchArea*apha));
        setLeftImagePadding((int)(MaterialDesignStyle.gap_card_content_min*apha));
        setLeftImageBackMode(RippleUtil.NOBACK_ROUND);
        setTitleSize(MaterialDesignStyle.text_title_big*apha);
        setLeftText("返回");
        setLeftTextBackMode();
        setRightText("提交");
        setTitle("QuickApp");
        setTextSize(MaterialDesignStyle.text_appBar*apha);
        setRightTextBackMode();
        setBackgroundColor(MaterialDesignStyle.color_theme_blue);
        VectorDrawable drawable = (VectorDrawable) leftImage.getDrawable();
        VectorDrawable drawable1 = (VectorDrawable) rightImage.getDrawable();
        drawable.setTint(MaterialDesignStyle.color_white);
        drawable1.setTint(MaterialDesignStyle.color_white);


    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}