package emerge.lk.channelbridge.Layout;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_customer);
        ButterKnife.bind(this);

        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.drowNavigationDrawer();
        navigationDrawer.setDrawerItem();

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Aaargh.ttf");
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(tf);

                }
            }
        }


    }

    private void setupViewPager(ViewPager viewPager) {
        CustomerPagerAdapter adapter = new CustomerPagerAdapter(getSupportFragmentManager(), getApplicationContext());
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
