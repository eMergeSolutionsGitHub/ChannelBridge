package emerge.lk.channelbridge.Layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.Service.NavigationDrawer;

/**
 * Created by Himanshu on 12/27/2016.
 */

public class Itinerary extends Activity {
    NavigationDrawer navigationDrawer;
    @BindView(R.id.txtView_channelbridge_title) TextView menuBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_itinerary);
        ButterKnife.bind(this);



        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.drowNavigationDrawer();
        navigationDrawer.setDrawerItem();

        menuBarTitle.setText(R.string.string_itinerary_titlebar_title);

    }
    @OnClick(R.id.relLayout_channelbridge_menu)
    public void titleBarMenuClick() {
        navigationDrawer.openNavigationDrawer();
    }
}
