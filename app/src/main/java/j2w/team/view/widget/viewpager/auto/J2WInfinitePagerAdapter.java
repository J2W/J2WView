package j2w.team.view.widget.viewpager.auto;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * @创建人 sky
 * @创建时间 15/7/27 上午10:34
 * @类描述 ViewPager 指示适配器
 */
public class J2WInfinitePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

	private static final String			TAG						= "InfinitePagerAdapter";

	private static final boolean		DEBUG					= true;

	private static final float			PAGE_WIDTH_SINGLE_ITEM	= 1.0f;

	private J2WInfiniteStatePagerAdapter	adapter;

	private boolean						infinitePagesEnabled	= true;

	private float						pageWidth				= PAGE_WIDTH_SINGLE_ITEM;

	public J2WInfinitePagerAdapter(J2WInfiniteStatePagerAdapter adapter) {
		this.adapter = adapter;
		adapter.autoScrollViewPager.setOnPageChangeListener(this);
	}

	@Override public int getCount() {
		if (infinitePagesEnabled) {
			return Integer.MAX_VALUE;
		} else {
			return adapter.getCount();
		}
	}

	@Override public float getPageWidth(int position) {
		return pageWidth;
	}

	public int getRealCount() {
		return adapter.getCount();
	}

	@Override public Object instantiateItem(ViewGroup container, int position) {
		int virtualPosition = getVirtualPosition(position);
		Log.i("instantiateItem", "" + virtualPosition + ":" + position);
		return adapter.instantiateItem(container, virtualPosition);
	}

	@Override public void destroyItem(ViewGroup container, int position, Object object) {
		int virtualPosition = getVirtualPosition(position);
		Log.i("destroyItem", "" + virtualPosition + ":" + position);

		adapter.destroyItem(container, virtualPosition, object);
	}

	@Override public void finishUpdate(ViewGroup container) {
		adapter.finishUpdate(container);
	}

	@Override public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	public int getVirtualPosition(int position) {
		return infinitePagesEnabled ? position % getRealCount() : position;
	}

	public void enableInfinitePages(boolean enable) {
		infinitePagesEnabled = enable;
	}

	@Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override public void onPageSelected(int position) {

		adapter.onPageSelected(getVirtualPosition(position));
	}

	@Override public void onPageScrollStateChanged(int state) {

	}
}
