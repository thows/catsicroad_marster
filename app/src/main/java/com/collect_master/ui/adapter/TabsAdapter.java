package com.collect_master.ui.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.widget.RelativeLayout;

import com.collect_master.R;
import com.collect_master.app.weight.AdvancedPagerSlidingTabStrip;
import com.collect_master.app.weight.Margins;
import com.collect_master.ui.fragment.AttrFragment;
import com.collect_master.ui.fragment.HomeFragment;
import com.collect_master.ui.fragment.LayerFragment;
import com.collect_master.ui.fragment.SetFragment;

/**
 * @author Litao-pc on 2016/10/27.
 *         ~
 */

public class TabsAdapter extends FragmentStatePagerAdapter implements
        AdvancedPagerSlidingTabStrip.IconTabProvider,
        AdvancedPagerSlidingTabStrip.LayoutProvider,
        AdvancedPagerSlidingTabStrip.TipsProvider {
    private Context mContext;
    private int mSize;
    private static final int VIEW_FIRST = 0;
    private static final int VIEW_SECOND = 1;
    private static final int VIEW_THIRD = 2;
    private static final int VIEW_FOURTH = 3;
    private static final int VIEW_SIZE = 4;
    public SparseArray<Fragment> fragments = new SparseArray<>();
    private String[] titles = {"首页", "地图", "属性", "设置"};

    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);
        if (fragments != null) {
            fragments.clear();
            fragments.put(0, new LayerFragment());
            fragments.put(1, new HomeFragment());
            fragments.put(2, new AttrFragment());
            fragments.put(3, new SetFragment());
        }
        this.mContext = c;
        mSize = c.getResources().getDimensionPixelSize(R.dimen.weibo_tab_size);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position >= 0 && position < VIEW_SIZE) {
            return titles[position];
        }
        return null;
    }


    @Override
    public float getPageWeight(int position) {
        if (position >= 0 && position < VIEW_SIZE) {
            switch (position) {
                case VIEW_FIRST:
                    return 0.92f;
                case VIEW_SECOND:
                    return 1.0f;
                case VIEW_THIRD:
                    return 1.0f;
                case VIEW_FOURTH:
                    return 0.92f;
                default:
                    break;
            }
        }
        return 1.0f;
    }

    @Override
    public int[] getPageRule(int position) {
        if (position >= 0 && position < VIEW_SIZE) {
            switch (position) {
                case VIEW_FIRST:
                    return new int[]{
                            RelativeLayout.ALIGN_PARENT_LEFT};
                case VIEW_SECOND:
                    return new int[]{
                            RelativeLayout.ALIGN_PARENT_LEFT};
                case VIEW_THIRD:
                    return new int[]{
                            RelativeLayout.ALIGN_PARENT_RIGHT};
                case VIEW_FOURTH:
                    return new int[]{
                            RelativeLayout.ALIGN_PARENT_RIGHT};
                default:
                   break;
            }
        }


        return new int[0];
    }

    @Override
    public Margins getPageMargins(int position) {
        if (position >= 0 && position < VIEW_SIZE) {
            switch (position) {
                case VIEW_FIRST:
                    return new Margins(mContext.getResources().getDimensionPixelSize(R.dimen.home_bar_icon_margins), 0, 0, 0);
                case VIEW_SECOND:
                    return null;
                case VIEW_THIRD:
                    return null;
                case VIEW_FOURTH:
                    return new Margins(0, 0, mContext.getResources().getDimensionPixelSize(R.dimen.home_bar_icon_margins), 0);
                default:
                    break;
            }
        }
        return null;
    }

    @Override
    public Integer getPageIcon(int index) {
        if (index >= 0 && index < VIEW_SIZE) {
            switch (index) {
                case VIEW_FIRST:


                    return android.R.drawable.ic_menu_mapmode;
                case VIEW_SECOND:
                    return android.R.drawable.ic_menu_manage;
                case VIEW_THIRD:
                    return android.R.drawable.ic_menu_compass;
                case VIEW_FOURTH:
                    return android.R.drawable.ic_menu_directions;
                default:
                    break;
            }
        }
        return 0;
    }

    @Override
    public Integer getPageSelectIcon(int index) {
        if (index >= 0 && index < VIEW_SIZE) {
            switch (index) {
                case VIEW_FIRST:
                    return android.R.drawable.ic_menu_mapmode;
                case VIEW_SECOND:
                    return android.R.drawable.ic_menu_manage;
                case VIEW_THIRD:
                    return android.R.drawable.ic_menu_compass;
                case VIEW_FOURTH:
                    return android.R.drawable.ic_menu_directions;
                default:
                    break;
            }
        }
        return 0;
    }

    @Override
    public Rect getPageIconBounds(int position) {
        return new Rect(0, 0, mSize, mSize);
    }

    @Override
    public int[] getTipsRule(int position) {
        if (position >= 0 && position < VIEW_SIZE) {
            switch (position) {
                case VIEW_FIRST:
                    return new int[]{
                            RelativeLayout.ALIGN_PARENT_LEFT};
                case VIEW_SECOND:
                    return new int[]{
                            RelativeLayout.ALIGN_PARENT_LEFT};
                case VIEW_THIRD:
                    return new int[]{
                            RelativeLayout.ALIGN_PARENT_RIGHT};
                case VIEW_FOURTH:
                    return new int[]{
                            RelativeLayout.ALIGN_PARENT_RIGHT};
                default:
                    break;
            }
        }
        return new int[0];
    }

    @Override
    public Margins getTipsMargins(int position) {
        if (position >= 0 && position < VIEW_SIZE) {
            switch (position) {
                case VIEW_FIRST:
                    return new Margins(4 * mContext.getResources().getDimensionPixelSize(R.dimen.psts_dot_m_right), 0, 0, 0);
                default:
                    break;
            }
        }
        return null;
    }

    @Override
    public Drawable getTipsDrawable(int position) {
        return null;
    }

}
