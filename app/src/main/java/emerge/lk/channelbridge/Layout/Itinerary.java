package emerge.lk.channelbridge.Layout;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.Adapters.ItineraryCustomersAdapter;
import emerge.lk.channelbridge.Dialog.CustomerDialog;
import emerge.lk.channelbridge.Entity.ItineraryCustomersEntity;
import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.Service.NavigationDrawer;

/**
 * Created by Himanshu on 12/27/2016.
 */

public class Itinerary extends AppCompatActivity {
    NavigationDrawer navigationDrawer;
    @BindView(R.id.txtView_channelbridge_title) TextView menuBarTitle;
    @BindView(R.id.recycview_itinerary_customer) RecyclerView recyclerViewItineraryCustomer;


    ItineraryCustomersAdapter itineraryCustomersAdapter;
    ArrayList<ItineraryCustomersEntity> itineraryCustomersEntities = new ArrayList<ItineraryCustomersEntity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_itinerary);
        ButterKnife.bind(this);

        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.drowNavigationDrawer();
        navigationDrawer.setDrawerItem();


        setDayItinerary();


        menuBarTitle.setText(R.string.string_itinerary_titlebar_title);

    }
    @OnClick(R.id.relLayout_channelbridge_menu)
    public void titleBarMenuClick() {
        navigationDrawer.openNavigationDrawer();
    }

    public void setDayItinerary(){


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerViewItineraryCustomer.setLayoutManager(mLayoutManager);
        recyclerViewItineraryCustomer.setItemAnimator(new DefaultItemAnimator());

        itineraryCustomersAdapter = new ItineraryCustomersAdapter(this,itineraryCustomersEntities);
        itineraryCustomersEntities.add(new ItineraryCustomersEntity("001","Asiri Surgical","Colombo 5","15753.jpg"));
        itineraryCustomersEntities.add(new ItineraryCustomersEntity("001","Nawaloka Hospital","Colombo 02","14526.jpg"));
        itineraryCustomersEntities.add(new ItineraryCustomersEntity("001","Hemas Hospital","Wattala","18788.jpg"));
        itineraryCustomersEntities.add(new ItineraryCustomersEntity("001","Lanka Hospital","Colombo 5","25455.jpg"));

        recyclerViewItineraryCustomer.setAdapter(itineraryCustomersAdapter);


    }

    public void setupDialogFragment(int position ,ArrayList<ItineraryCustomersEntity> itineraryCustomersEntities){

        FragmentManager fm = getFragmentManager();
        CustomerDialog customerDialog = new CustomerDialog (position, itineraryCustomersEntities);
        customerDialog.show(fm, "Sample Fragment");
    }

}
