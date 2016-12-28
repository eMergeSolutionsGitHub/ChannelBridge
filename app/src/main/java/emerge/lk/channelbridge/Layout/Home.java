package emerge.lk.channelbridge.Layout;

import android.app.Activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;


import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.Service.NavigationDrawer;
import emerge.lk.channelbridge.databinding.LayoutHomeBinding;


/**
 * Created by Himanshu on 12/27/2016.
 */

public class Home extends Activity {
    NavigationDrawer navigationDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);


        LayoutHomeBinding homeBinding = DataBindingUtil.setContentView(this,R.layout.layout_home);
        OnClickMenuHandler handler = new OnClickMenuHandler();
        homeBinding.setHandlermenu(handler);

        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.drowNavigationDrawer();
        navigationDrawer.setDrawerItem();


    }
    public class OnClickMenuHandler {
        public void onUpdateMenuOnClick(View view) {
            navigationDrawer.openNavigationDrawer();
        }
    }
}
