package j2w.team.view.widget.viewpager.auto;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @创建人 sky
 * @创建时间 15/7/27 上午10:34
 * @类描述 ViewPager 指示适配器
 */
public class J2WInfiniteStatePagerAdapter extends PagerAdapter {

	FragmentManager							manager;

	List<String>							fragments	= new ArrayList<>();

	public J2WInfiniteCirclePageIndicator	autoScrollViewPager;

	int										placeholder;						// 默认图片

	IInfiniteStatePagerAdapter				iInfiniteStatePagerAdapter;

	public interface IInfiniteStatePagerAdapter {

		void onImageItemClick(int position);

		void loadImg(ImageView view, String url);
	}

	public void setiInfiniteStatePagerAdapter(IInfiniteStatePagerAdapter iInfiniteStatePagerAdapter) {
		this.iInfiniteStatePagerAdapter = iInfiniteStatePagerAdapter;
	}

	public J2WInfiniteStatePagerAdapter(J2WInfiniteCirclePageIndicator autoScrollViewPager, FragmentManager fm) {
		manager = fm;
		this.autoScrollViewPager = autoScrollViewPager;
	}

	public FragmentManager getManager() {
		return manager;
	}

	@Override public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object); // 移出viewpager两边之外的page布局
	}

	public void addData(String url) {
		fragments.add(url);
	}

	public void setData(List<String> fragments) {
		this.fragments = fragments;
	}

	public void addData(List<String> fragments) {
		for (String url : fragments) {
			addData(url);
		}
	}

	public void clearData() {
		fragments.clear();
	}

	@Override public int getCount() {
		return fragments.size();
	}

	@Override public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override public Object instantiateItem(ViewGroup container, final int position) {
		final ImageView view = new ImageView(container.getContext());
		view.setScaleType(ImageView.ScaleType.CENTER);
		view.setId(position);
		//加载图片
		if (iInfiniteStatePagerAdapter != null) {
			iInfiniteStatePagerAdapter.loadImg(view, fragments.get(position));
		}

		view.setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(View v) {
				if (iInfiniteStatePagerAdapter != null) {
					iInfiniteStatePagerAdapter.onImageItemClick(position);
				}
			}
		});
		container.addView(view);
		return view;
	}

	private int	currentPageIndex	= 0;

	public void onPageSelected(int position) {
		currentPageIndex = position;
	}
}
