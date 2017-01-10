package emerge.lk.channelbridge.Layout;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.Adapters.ItineraryCreditInvoiceAdapter;
import emerge.lk.channelbridge.Adapters.ItineraryCustomersAdapter;
import emerge.lk.channelbridge.Entity.ItineraryCreditInvoicesEntity;
import emerge.lk.channelbridge.Entity.ItineraryCustomersEntity;
import emerge.lk.channelbridge.Font.TextViewFontAwesome;
import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.Service.NavigationDrawer;

/**
 * Created by Himanshu on 12/27/2016.
 */

public class Itinerary extends Activity {
    NavigationDrawer navigationDrawer;
    @BindView(R.id.txtView_channelbridge_title) TextView menuBarTitle;
    @BindView(R.id.recycview_itinerary_creditinvoice) RecyclerView recyclerViewCreditinvoice;
    @BindView(R.id.recycview_itinerary_customer) RecyclerView recyclerViewCustomers;

    @BindView(R.id.expandablelayout_itinerary_creditinvoice) ExpandableLayout expandablelayoutCreditinvoice;
    @BindView(R.id.ftxtView_itinerary_creditinvoice_arrow) TextViewFontAwesome fontAwesometxtviewCreditinvoiceArrow ;


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
        menuBarTitle.setText(R.string.string_itinerary_titlebar_title);

        setDayItinerary();
        setCreditInvoice();


    }
    @OnClick(R.id.relLayout_channelbridge_menu)
    public void titleBarMenuClick() {
        navigationDrawer.openNavigationDrawer();
    }

    @OnClick(R.id.relLayout_itinerary_creditinvoice)
    public void creditinvoiceLayoutClick() {
        if(expandablelayoutCreditinvoice.isExpanded()){
            expandablelayoutCreditinvoice.collapse();
            fontAwesometxtviewCreditinvoiceArrow.setText(R.string.icon_itinerary_angledoubledown);
        }else {
            expandablelayoutCreditinvoice.expand();
            fontAwesometxtviewCreditinvoiceArrow.setText(R.string.icon_itinerary_angledoubleup);
        }
    }


    public void setDayItinerary(){

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerViewCustomers.setLayoutManager(mLayoutManager);
        recyclerViewCustomers.setItemAnimator(new DefaultItemAnimator());
        itineraryCustomersAdapter = new ItineraryCustomersAdapter(this,itineraryCustomersEntities);
        itineraryCustomersEntities.add(new ItineraryCustomersEntity("001","Asiri Surgical","Colombo 5","15753.jpg"));
        itineraryCustomersEntities.add(new ItineraryCustomersEntity("001","Nawaloka Hospital","Colombo 02","14526.jpg"));
        itineraryCustomersEntities.add(new ItineraryCustomersEntity("001","Hemas Hospital","Wattala","18788.jpg"));
        itineraryCustomersEntities.add(new ItineraryCustomersEntity("001","Lanka Hospital","Colombo 5","25455.jpg"));
        recyclerViewCustomers.setAdapter(itineraryCustomersAdapter);
        
    }

    public void setCreditInvoice(){

        ItineraryCreditInvoiceAdapter itineraryCreditInvoiceAdapter;
        ArrayList<ItineraryCreditInvoicesEntity> itineraryCreditInvoicesEntities = new ArrayList<ItineraryCreditInvoicesEntity>();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerViewCreditinvoice.setLayoutManager(mLayoutManager);
        recyclerViewCreditinvoice.setItemAnimator(new DefaultItemAnimator());

        itineraryCreditInvoiceAdapter = new ItineraryCreditInvoiceAdapter(this,itineraryCreditInvoicesEntities);

        itineraryCreditInvoicesEntities.add(new ItineraryCreditInvoicesEntity("101011","2017-01-04","256330.00","256330.00"));
        itineraryCreditInvoicesEntities.add(new ItineraryCreditInvoicesEntity("106021","2016-05-20","551522.50","551522.50"));
        itineraryCreditInvoicesEntities.add(new ItineraryCreditInvoicesEntity("103016","2016-03-06","36544.00","36544.00"));
        itineraryCreditInvoicesEntities.add(new ItineraryCreditInvoicesEntity("101022","2016-08-12","24555555.00","24555555.00"));

        recyclerViewCreditinvoice.setAdapter(itineraryCreditInvoiceAdapter);


    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(Itinerary.this, Dashboard.class);
        Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
        finish();
        startActivity(i, bndlanimation);
    }

}
