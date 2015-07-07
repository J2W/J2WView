package j2w.team.view.widget.materialWidget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import j2w.team.view.widget.materialWidget.style.IMaterial;
import j2w.team.view.widget.materialWidget.style.MaterialStyle;

/**
 * create by wangtao 2015.03.26
 * 自定义ImageView，带点击波纹效果
 */
public class LImageView extends ImageView implements IMaterial {
	private MaterialStyle mMaterialStyle;

	public LImageView(Context context) {
		this(context, null);
	}

	@SuppressLint("NewApi")
	public LImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mMaterialStyle = new MaterialStyle(this, attrs);
	}

	public void perfirmSuperClick() {
		super.performClick();
	}

	public void setColor(int fullColor) {
		mMaterialStyle.setColor(fullColor);
	}

	public void setType(int widgetType) {
		mMaterialStyle.setType(widgetType);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (!isEnabled()) {
			super.onDraw(canvas);
			return;
		}
		mMaterialStyle.doDraw(canvas);
		super.onDraw(canvas);
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean performClick() {
		if (mMaterialStyle != null) {
			mMaterialStyle.performClick();
		} else {
			return super.performClick();
		}
		return true;
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (mMaterialStyle != null)
			mMaterialStyle.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		super.onWindowFocusChanged(hasWindowFocus);
		if (mMaterialStyle != null)
			mMaterialStyle.onWindowFocusChanged(hasWindowFocus);
	}

	@Override
	protected void onVisibilityChanged(View changedView, int visibility) {
		super.onVisibilityChanged(changedView, visibility);
		if (mMaterialStyle != null)
			mMaterialStyle.onVisibilityChanged(changedView, visibility);
	}

	/**
	 * set click event delay to animation end
	 * 
	 * @param
	 */
	public void setDelayClick(boolean delayClick) {
		mMaterialStyle.setDelayClick(delayClick);
	}

	@Override
	public void setBackgroundResource(int resId) {
		setBackground(this.getResources().getDrawable(resId));
	}

	@Override
	public void setBackground(Drawable background) {
		if (mMaterialStyle != null)
			mMaterialStyle.setBackground(background);
	}

	@Override
	public void setBackgroundColor(int color) {
		if (mMaterialStyle != null)
			mMaterialStyle.setBackgroundColor(color);
	}

	@Override
	@Deprecated
	public void setBackgroundDrawable(Drawable background) {
		// super.setBackgroundDrawable(background);
		this.setBackground(background);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (mMaterialStyle != null) {
			if (mMaterialStyle.needBackgroundMeasure()) {
				int[] size = mMaterialStyle.getMeasureSize(widthMeasureSpec,
						heightMeasureSpec);
				setMeasuredDimension(size[0], size[1]);
			} else {
				super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			}
		} else {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}

	}

	public int mImageResId;

	@Override
	public void setImageResource(int resId) {
		super.setImageResource(resId);
		mImageResId = resId;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		if (!isEnabled())
			return false;
		return super.dispatchTouchEvent(event);
	}

}
