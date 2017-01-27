package emerge.lk.channelbridge.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import java.util.ArrayList;
import java.util.List;

import emerge.lk.channelbridge.Fragments.CustomerCreateFragment;
import emerge.lk.channelbridge.Fragments.CustomerSearchFragment;
import emerge.lk.channelbridge.Fragments.CustomerUpdateFragment;
import emerge.lk.channelbridge.R;

/**
 * Created by Chamal on 1/19/2017.
 */

public class CustomerPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    Context context;

    private int[] tabIcons = {
            R.drawable.customer_add,
            R.drawable.customer_search,
            R.drawable.customer_update
    };

    public CustomerPagerAdapter(FragmentManager manager, Context context) {
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        Drawable image = context.getResources().getDrawable(tabIcons[position]);
        image.setBounds(0, 0, 40, 40);
        // Replace blank spaces with image icon
        SpannableString sb = new SpannableString("   " + mFragmentTitleList.get(position));
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;

    }
}
