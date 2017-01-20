package emerge.lk.channelbridge.Layout;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.Adapters.CustomerPagerAdapter;
import emerge.lk.channelbridge.Fragments.CustomerCreateFragment;
import emerge.lk.channelbridge.Fragments.CustomerSearchFragment;
import emerge.lk.channelbridge.Fragments.CustomerUpdateFragment;
import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.Service.NavigationDrawer;

public class Customer extends AppCompatActivity {
    NavigationDrawer navigationDrawer;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.customer_add,
            R.drawable.customer_search,
            R.drawable.customer_update
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_create);
        ButterKnife.bind(this);

        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.drowNavigationDrawer();
        navigationDrawer.setDrawerItem();

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();


}
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        CustomerPagerAdapter adapter = new CustomerPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new CustomerCreateFragment(), "New Customer");
        adapter.addFrag(new CustomerSearchFragment(), "Search Customer");
        adapter.addFrag(new CustomerUpdateFragment(), "Update Customer");
        viewPager.setAdapter(adapter);
    }


    @OnClick(R.id.relLayout_channelbridge_menu)
    public void logIn() {
        navigationDrawer.openNavigationDrawer();
    }
}
