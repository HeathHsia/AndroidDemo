package layoutview.heath.com.layoutview;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import java.util.jar.Attributes;

public class CustomButton extends AppCompatButton {

    /** 自定义View 是在Activity中new创建的 自动调用
     * 自定义View 构造函数
     * @param context Activity 上下文
     */
    public CustomButton (Context context) {
        super(context);
    }

    /** 自定义View 是在XML中创建的 自动调用
     * 自定义View 构造函数
     * @param context Activity 上下文
     * @param attrs 自定义属性是从AttributeSet 传过来的
     */
    public CustomButton (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 自定义View 构造函数 不会自动调用 一般在第二个函数中主动调用，有style属性的时候调用
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CustomButton (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     *  View Width Height Measure
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    /**
     * View Layout布局
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * View 绘制过程
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
