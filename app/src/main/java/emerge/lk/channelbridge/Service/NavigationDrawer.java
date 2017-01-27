package emerge.lk.channelbridge.Service;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import emerge.lk.channelbridge.Adapters.NavigationAdapter;
import emerge.lk.channelbridge.Entity.NavigationEntity;
import emerge.lk.channelbridge.Layout.Customer;
import emerge.lk.channelbridge.Layout.Dashboard;
import emerge.lk.channelbridge.Layout.Itinerary;
import emerge.lk.channelbridge.R;


/**
 * Created by Himanshu on 12/27/2016.
 */

public class NavigationDrawer {
    public Activity activity;
    DrawerLayout dLayout;

    ArrayList<NavigationEntity> navigationItems;
    NavigationAdapter navigationAdapter;
    ListView listView_navigation;

    public NavigationDrawer(Activity activity) {
        this.activity = activity;
        navigationItems = new ArrayList<NavigationEntity>();
        listView_navigation = (ListView) activity.findViewById(R.id.listView_navigation);
        dLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
    }

    public void drowNavigationDrawer() {
        navigationAdapter = new NavigationAdapter(activity, navigationItems);
        navigationItems.add(new NavigationEntity("Dashboard", R.string.icon_navigation_home));
        navigationItems.add(new NavigationEntity("Itinerary", R.string.icon_navigation_itinerary));
        navigationItems.add(new NavigationEntity("Customer", R.string.icon_navigation_customer));
        navigationItems.add(new NavigationEntity("Products", R.string.icon_navigation_product));
        navigationItems.add(new NavigationEntity("Return", R.string.icon_navigation_return));
        navigationItems.add(new NavigationEntity("Sync", R.string.icon_navigation_sync));
        navigationItems.add(new NavigationEntity("Report", R.string.icon_navigation_report));
        navigationItems.add(new NavigationEntity("Collection Note", R.string.icon_navigation_collectionnote));
        navigationItems.add(new NavigationEntity("Print", R.string.icon_navigation_print));
        navigationItems.add(new NavigationEntity("My Account", R.string.icon_navigation_password));
        navigationItems.add(new NavigationEntity("Attendance", R.string.icon_navigation_attendens));
        navigationItems.add(new NavigationEntity("Admin", R.string.icon_navigation_admin));
        navigationItems.add(new NavigationEntity("Backup", R.string.icon_navigation_backup));
        listView_navigation.setAdapter(navigationAdapter);
    }

    public void openNavigationDrawer() {
        dLayout.openDrawer(Gravity.LEFT);
    }

    public void setDrawerItem() {
        listView_navigation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(activity, Dashboard.class);
                    Bundle bndlanimation = ActivityOptions.makeCustomAnimation(activity, R.anim.animation, R.anim.animation2).toBundle();
                    activity.finish();
                    activity.startActivity(i, bndlanimation);

                }
                if (position == 1) {
                    Intent i = new Intent(activity, Itinerary.class);
                    Bundle bndlanimation = ActivityOptions.makeCustomAnimation(activity, R.anim.animation, R.anim.animation2).toBundle();
                    activity.finish();
                    activity.startActivity(i, bndlanimation);
                }
                if (position == 2) {

                    Intent i = new Intent(activity, Customer.class);
                    Bundle bndlanimation = ActivityOptions.makeCustomAnimation(activity, R.anim.animation, R.anim.animation2).toBundle();
                    activity.finish();
                    activity.startActivity(i, bndlanimation);

                }
                if (position == 3) {


                }
                if (position == 4) {


                }
                if (position == 5) {

                }
                if (position == 6) {


                }
                if (position == 7) {


                }
                if (position == 8) {

                }
                if (position == 9) {

                }
                if (position == 10) {

                }


            }
        });
    }

}
