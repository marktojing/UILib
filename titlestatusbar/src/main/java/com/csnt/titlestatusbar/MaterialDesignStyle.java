package com.csnt.titlestatusbar;

import android.graphics.Color;

import com.csnt.titlestatusbar.viewUtils.ColorUtil;


/**
 * Created by sunrain
 * Created Date 2020/6/2 9:28 AM
 * 原质化设计  谷歌2014年推出的新的设计模式
 */
public class MaterialDesignStyle {
    /**
     * z轴设置
     */
    public static final int z_card_1=1;//卡片的高度1～8
    public static final int z_card_2=2;//卡片的高度1～8
    public static final int z_card_3=3;//卡片的高度1～8
    public static final int z_card_4=4;//卡片的高度1～8
    public static final int z_card_5=5;//卡片的高度1～8
    public static final int z_card_6=6;//卡片的高度1～8
    public static final int z_card_7=7;//卡片的高度1～8
    public static final int z_card_8=8;//卡片的高度1～8
    public static final int z_switch_1=1;//开关z高度
    public static final int z_button_2=2;//按钮的z高2～8
    public static final int z_button_3=3;//按钮的z高2～8
    public static final int z_button_4=4;//按钮的z高2～8
    public static final int z_button_5=5;//按钮的z高2～8
    public static final int z_button_6=6;//按钮的z高2～8
    public static final int z_button_7=7;//按钮的z高2～8
    public static final int z_button_8=8;//按钮的z高2～8
    public static final int z_topBar_4=4;//顶部应用栏z高4
    public static final int z_bottomBar_8=8;//底部应用栏z高8
    public static final int z_refreshTip_3=3;//底部应用栏z高4
    public static final int z_menu_8=8;//菜单z高8
    public static final int z_bottom_6=6;//底部z高6
    public static final int z_fab_6=6;//悬浮球FABz高6~12
    public static final int z_fab_7=7;//悬浮球FABz高6
    public static final int z_fab_8=8;//悬浮球FABz高6
    public static final int z_fab_9=9;//悬浮球FABz高6
    public static final int z_fab_10=10;//悬浮球FABz高6
    public static final int z_fab_11=11;//悬浮球FABz高6
    public static final int z_fab_12=12;//悬浮球FABz高6
    public static final int z_slideNavigation_16=16;//抽屉式导航
    public static final int z_dialog_24=24;//对话框

    /**
     * 颜色
     */
    public static final int color_black= Color.parseColor("#000000");//黑色字体
    public static final int color_white= Color.parseColor("#FFFFFF");//白色字体
    public static int color_split_line_b= ColorUtil.setAlpha(12,color_black);//分割线颜色
    public static int color_tipOrStop_b= ColorUtil.setAlpha(26,color_black);//提示或禁用
    public static int color_text_light_b= ColorUtil.setAlpha(54,color_black);//减淡文字
    public static int color_text_normal_b= ColorUtil.setAlpha(87,color_black);//普通文字
    public static int color_split_line_w= ColorUtil.setAlpha(12,color_white);
    public static int color_tipOrStop_w= ColorUtil.setAlpha(26,color_white);
    public static int color_text_light_w= ColorUtil.setAlpha(54,color_white);
    public static int color_text_normal_w= ColorUtil.setAlpha(87,color_white);

    public static final int color_theme_blue=Color.parseColor("#346DFF");//500主色湛蓝
    public static final int color_theme_blue_dark=Color.parseColor("#1C55E7");//700主色湛蓝_深色
    public static final int color_theme_blue_light=Color.parseColor("#AAC1FF");//100主色湛蓝_浅色
    public static final int color_theme_pink=Color.parseColor("#FF4E87");//200辅色粉红
    public static final int color_theme_pink_dark=Color.parseColor("#FF256B");//400辅色粉红_深色
    public static final int color_theme_pink_light=Color.parseColor("#FFACC6");//100辅色粉红_浅色
    /**
     * 文字大小
     */
    public static final int text_tip = 12;//12sp 小字提示
    public static final int text_main_button = 14;//正文/button
    public static final int text_title_small = 16;//小标题
    public static final int text_appBar = 20;//appBar
    public static final int text_title_big = 24;//appBar
    /**
     * 控件尺寸
     */
    public static final int size_minTouchArea = 48;//文字sp其他dp
    public static final int size_minIcon = 32;//文字sp其他dp
    public static final int size_suspensionButton_40 = 40;//悬浮按钮尺寸40dp
    public static final int size_suspensionButton_56 = 56;//悬浮按钮尺寸56dp
    public static final int height_statusBar = 24;//状态栏高度
    public static final int height_minAppbar = 56;//appBar最小高度
    public static final int height_bottomNavigationBar = 48;//底部导航栏高度
    public static final int wight_base = 56;//可变控件的基数（对话框、菜单等宽度都可以用56的整数倍设计）
    public static final int base = 8;//栅格系统的最小单位是8dp，一切距离、尺寸都应该是8dp的整数倍
    /**
     * 控件间隙
     */
    public static final int gap_card_card = 8;//卡片间距
    public static final int gap_splitLine = 8;//分割线上下留白
    public static final int gap_slideBar_right = 56;//分割线上下留白
    public static final int gap_command = 16;//大多数元素的留白距离
    public static final int gap_leftLineOrRightLine = 16;//屏幕左右对齐基线
    public static final int gap_text_left_haveIcon = 72;//屏幕左右对齐基线，有图标的情况下
    public static final int gap_text_left_noIcon = 24;//屏幕左右对齐基线，无图标的情况下
    public static final int gap_card_content_min = 8;//可点击区域边界到文字/icon的距离

}
