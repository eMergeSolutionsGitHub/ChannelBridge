package emerge.lk.channelbridge.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import emerge.lk.channelbridge.Fragments.CustomerCreateFragment;
import emerge.lk.channelbridge.Fragments.CustomerSearchFragment;
import emerge.lk.channelbridge.Fragments.CustomerUpdateFragment;

/**
 * Created by Chamal on 1/19/2017.
 */

public class CustomerPagerAdapter extends FragmentStatePagerAdapter {
    int noOfTabs;

    public CustomerPagerAdapter(FragmentManager fm, int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CustomerCreateFragment tab1 = new CustomerCreateFragment();
                return tab1;
            case 1:
                CustomerSearchFragment tab2 = new CustomerSearchFragment();
                return tab2;
            case 2:
                CustomerUpdateFragment tab3 = new CustomerUpdateFragment();
                return tab3;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Add Customer";

            case 1:
                return "Search Customer";

            default:
                return "Update Customer";            }
    }
}
