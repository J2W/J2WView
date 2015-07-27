package j2w.team.view.widget.viewpager.icon;

/**
 * @创建人 sky
 * @创建时间 15/7/27 上午10:34
 * @类描述 ViewPager 指示器 切换样式接口
 */
public interface IconPagerAdapter {

	/**
	 * 切换图片
	 * 
	 * @param index
	 *            下标
	 * @return
	 */
	int getIconResId(int index);

	/**
	 * 数量
	 * 
	 * @return
	 */
	int getCount();

	/**
	 * 默认图标
	 * 
	 * @return
	 */
	int getIconResIdDefault();

	/**
	 * ImageView 布局
	 * 
	 * @return
	 */
	int getIconLayout();
}
