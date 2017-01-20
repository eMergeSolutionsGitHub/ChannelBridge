package emerge.lk.channelbridge.Layout;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.app.FragmentManager;
import android.os.Bundle;

import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.Adapters.ItineraryCreditInvoiceAdapter;
import emerge.lk.channelbridge.Adapters.ItineraryCustomersAdapter;
import emerge.lk.channelbridge.Adapters.ItineraryExpiryProductsAdapter;
import emerge.lk.channelbridge.Adapters.ItineraryLastInvoicesAdapter;
import emerge.lk.channelbridge.Adapters.ItineraryLastVisitAdapter;
import emerge.lk.channelbridge.Entity.CustomersEntity;
import emerge.lk.channelbridge.Entity.ProductsEntity;
import emerge.lk.channelbridge.Entity.InvoiceEntity;
import emerge.lk.channelbridge.Entity.LastVisitEntity;
import emerge.lk.channelbridge.Font.TextViewFontAwesome;
import emerge.lk.channelbridge.Dialog.CustomerDialog;
import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.Service.NavigationDrawer;

/**
 * Created by Himanshu on 12/27/2016.
 */

public class Itinerary extends Activity {
    NavigationDrawer navigationDrawer;

    @BindView(R.id.txtView_channelbridge_title) TextView menuBarTitle;
    @BindView(R.id.recycview_itinerary_creditinvoice) RecyclerView recyclerViewCreditInvoice;
    @BindView(R.id.recycview_itinerary_customer) RecyclerView recyclerViewCustomers;
    @BindView(R.id.recycview_itinerary_lastinvoice) RecyclerView recyclerViewLastInvoice;
    @BindView(R.id.recycview_itinerary_lastvisit) RecyclerView recyclerViewLAstVisit;
    @BindView(R.id.recycview_itinerary_expiryproducts) RecyclerView recyclerViewExpiryproducts;
    @BindView(R.id.expandablelayout_itinerary_creditinvoice) ExpandableLayout expandablelayoutCreditinvoice;
    @BindView(R.id.ftxtView_itinerary_creditinvoice_arrow) TextViewFontAwesome fontAwesometxtviewCreditinvoiceArrow ;
    @BindView(R.id.expandablelayout_itinerary_lastinvoice) ExpandableLayout expandablelayoutLastinvoice;
    @BindView(R.id.ftxtView_itinerary_lastinvoices_arrow) TextViewFontAwesome fontAwesometxtviewLasttinvoiceArrow ;
    @BindView(R.id.expandablelayout_itinerary_declineproduct) ExpandableLayout expandablelayoutDeclineproducts;
    @BindView(R.id.ftxtView_itinerary_declineproducts_arrow) TextViewFontAwesome fontAwesometxtviewDeclineproductsArrow ;
    @BindView(R.id.expandablelayout_itinerary_expiryproducts) ExpandableLayout expandablelayoutExpiryproducts;
    @BindView(R.id.ftxtView_itinerary_expiryproducts_arrow) TextViewFontAwesome fontAwesometxtviewExpiryproductsArrow ;
    @BindView(R.id.expandablelayout_itinerary_lastvisit) ExpandableLayout expandablelayoutLastVisit;
    @BindView(R.id.ftxtView_itinerary_lastvisit_arrow) TextViewFontAwesome fontAwesometxtviewLastVisitArrow ;
    @BindView(R.id.chart_itinerary_declineproduct) LineChart chartDeclineproduct ;
    @BindView(R.id.relLayout_itinerary_customer) RelativeLayout layoutCustomer;
    @BindView(R.id.scrollView_customer_details) ScrollView scrollViewCustomerDetails;



    ItineraryCustomersAdapter itineraryCustomersAdapter;
    ArrayList<CustomersEntity> itineraryCustomersEntities = new ArrayList<CustomersEntity>();

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

    }

    @OnClick(R.id.relLayout_channelbridge_menu)
    public void titleBarMenuClick() {
        navigationDrawer.openNavigationDrawer();
    }

    @OnClick(R.id.relLayout_itinerary_creditinvoice)
    public void creditInvoiceLayoutClick() {
        if(expandablelayoutCreditinvoice.isExpanded()){
            expandablelayoutCreditinvoice.collapse();
            fontAwesometxtviewCreditinvoiceArrow.setText(R.string.icon_itinerary_angledoubledown);
        }else {
            expandablelayoutCreditinvoice.expand();
            fontAwesometxtviewCreditinvoiceArrow.setText(R.string.icon_itinerary_angledoubleup);
            setCreditInvoice();
        }
    }

    @OnClick(R.id.relLayout_itinerary_lastinvoice)
    public void lastInvoiceLayoutClick() {
        if(expandablelayoutLastinvoice.isExpanded()){
            expandablelayoutLastinvoice.collapse();
            fontAwesometxtviewLasttinvoiceArrow.setText(R.string.icon_itinerary_angledoubledown);
        }else {
            expandablelayoutLastinvoice.expand();
            fontAwesometxtviewLasttinvoiceArrow.setText(R.string.icon_itinerary_angledoubleup);
            setLastInvoice();
        }
    }

    @OnClick(R.id.relLayout_itinerary_declineproduct)
    public void lastDeclineProductClick() {

        if(expandablelayoutDeclineproducts.isExpanded()){
            expandablelayoutDeclineproducts.collapse();
            fontAwesometxtviewDeclineproductsArrow.setText(R.string.icon_itinerary_angledoubledown);
        }else {
            expandablelayoutDeclineproducts.expand();
            fontAwesometxtviewDeclineproductsArrow.setText(R.string.icon_itinerary_angledoubleup);
            setDeclineproduct();
            setScrollviewDowun();
        }
    }
    @OnClick(R.id.relLayout_itinerary_expiryproducts)
    public void expiryProductsClick() {
        if(expandablelayoutExpiryproducts.isExpanded()){
            expandablelayoutExpiryproducts.collapse();
            fontAwesometxtviewExpiryproductsArrow.setText(R.string.icon_itinerary_angledoubledown);
        }else {
            expandablelayoutExpiryproducts.expand();
            fontAwesometxtviewExpiryproductsArrow.setText(R.string.icon_itinerary_angledoubleup);
            setExpiryProducts();
            setScrollviewDowun();
        }
    }

    @OnClick(R.id.relLayout_itinerary_lastvisit)
    public void LastVisitClick() {
        if(expandablelayoutLastVisit.isExpanded()){
            expandablelayoutLastVisit.collapse();
            fontAwesometxtviewLastVisitArrow.setText(R.string.icon_itinerary_angledoubledown);
        }else {
            expandablelayoutLastVisit.expand();
            fontAwesometxtviewLastVisitArrow.setText(R.string.icon_itinerary_angledoubleup);
            setCustomerLastVisit();
            setScrollviewDowun();
        }
    }


    public void setDayItinerary(){
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);

        recyclerViewCustomers.setLayoutManager(mLayoutManager);
        recyclerViewCustomers.setItemAnimator(new DefaultItemAnimator());

        itineraryCustomersAdapter = new ItineraryCustomersAdapter(this,itineraryCustomersEntities);
        itineraryCustomersEntities.add(new CustomersEntity("001","Asiri Surgical","Colombo 5","15753.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Nawaloka Hospital","Colombo 02","14526.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Hemas Hospital","Wattala","18788.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Lanka Hospital","Colombo 5","25455.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Ninewells Hospital","Colombo 5","154.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Asiri Surgical","Colombo 5","15753.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Nawaloka Hospital","Colombo 02","14526.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Hemas Hospital","Wattala","18788.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Lanka Hospital","Colombo 5","25455.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Ninewells Hospital","Colombo 5","154.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Asiri Surgical","Colombo 5","15753.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Nawaloka Hospital","Colombo 02","14526.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Hemas Hospital","Wattala","18788.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Lanka Hospital","Colombo 5","25455.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Ninewells Hospital","Colombo 5","154.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Asiri Surgical","Colombo 5","15753.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Nawaloka Hospital","Colombo 02","14526.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Hemas Hospital","Wattala","18788.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Lanka Hospital","Colombo 5","25455.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Ninewells Hospital","Colombo 5","154.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Asiri Surgical","Colombo 5","15753.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Nawaloka Hospital","Colombo 02","14526.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Hemas Hospital","Wattala","18788.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Lanka Hospital","Colombo 5","25455.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Ninewells Hospital","Colombo 5","154.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Asiri Surgical","Colombo 5","15753.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Nawaloka Hospital","Colombo 02","14526.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Hemas Hospital","Wattala","18788.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Lanka Hospital","Colombo 5","25455.jpg"));
        itineraryCustomersEntities.add(new CustomersEntity("001","Ninewells Hospital","Colombo 5","154.jpg"));
        recyclerViewCustomers.setAdapter(itineraryCustomersAdapter);

    }

    public void setCreditInvoice(){

        ItineraryCreditInvoiceAdapter itineraryCreditInvoiceAdapter;
        ArrayList<InvoiceEntity> itineraryCreditInvoicesEntities = new ArrayList<InvoiceEntity>();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerViewCreditInvoice.setLayoutManager(mLayoutManager);
        recyclerViewCreditInvoice.setItemAnimator(new DefaultItemAnimator());
        itineraryCreditInvoiceAdapter = new ItineraryCreditInvoiceAdapter(this,itineraryCreditInvoicesEntities);
        itineraryCreditInvoicesEntities.add(new InvoiceEntity("101011","2017-01-04","256330.00","256330.00"));
        itineraryCreditInvoicesEntities.add(new InvoiceEntity("106021","2016-05-20","551522.50","551522.50"));
        itineraryCreditInvoicesEntities.add(new InvoiceEntity("103016","2016-03-06","36544.00","36544.00"));
        itineraryCreditInvoicesEntities.add(new InvoiceEntity("101022","2016-08-12","24555555.00","24555555.00"));
        recyclerViewCreditInvoice.setAdapter(itineraryCreditInvoiceAdapter);

    }

    public void setLastInvoice(){
        ItineraryLastInvoicesAdapter itineraryLastInvoicesAdapter;
        ArrayList<InvoiceEntity> itineraryLastInvoiceEntities = new ArrayList<InvoiceEntity>();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerViewLastInvoice.setLayoutManager(mLayoutManager);
        recyclerViewLastInvoice.setItemAnimator(new DefaultItemAnimator());

        itineraryLastInvoicesAdapter = new ItineraryLastInvoicesAdapter(this,itineraryLastInvoiceEntities);

        itineraryLastInvoiceEntities.add(new InvoiceEntity("101011","256330.00","2017-01-04"));
        itineraryLastInvoiceEntities.add(new InvoiceEntity("106021","551522.50","2016-05-20"));
        itineraryLastInvoiceEntities.add(new InvoiceEntity("103016","36544.00","2016-03-06"));
        itineraryLastInvoiceEntities.add(new InvoiceEntity("101022","24555555.00","2016-08-12"));
        recyclerViewLastInvoice.setAdapter(itineraryLastInvoicesAdapter);
    }

    public void setDeclineproduct(){
        chartDeclineproduct.setTouchEnabled(true);
        chartDeclineproduct.setDragEnabled(true);
        chartDeclineproduct.setScaleEnabled(true);
        chartDeclineproduct.setPinchZoom(true);
        LimitLine llXAxis = new LimitLine(10f, "Index 10");



        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        llXAxis.setTextSize(50f);

        YAxis leftAxis = chartDeclineproduct.getAxisLeft();
        leftAxis.removeAllLimitLines();

        leftAxis.setAxisMaxValue(220f);
        leftAxis.setAxisMinValue(-50f);

        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawLimitLinesBehindData(true);
        chartDeclineproduct.getAxisRight().setEnabled(false);

        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("HOBE02");
        xVals.add("EU05");
        xVals.add("B25705");
        xVals.add("C10495");
        xVals.add("F05130");
        xVals.add("G30640");
        xVals.add("HOAS56");
        xVals.add("DC70810-26");
        xVals.add("B95205");
        xVals.add("91S70A");
        xVals.add("73S30P");
        xVals.add("73S30M");
        xVals.add("32300M20");
        xVals.add("20S20D");
        xVals.add("20S05B");

        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i < 15; i++) {
            float mult = (100 + 1);
            float val = (float) (Math.random() * mult) + 3;// + (float)
            yVals.add(new Entry(val, i));
        }


        LineDataSet set1 = new LineDataSet(yVals, "");

        set1.enableDashedLine(10f, 5f, 0f);
        set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(15f);
        set1.setDrawFilled(true);
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1);
        LineData data = new LineData(xVals, dataSets);
        chartDeclineproduct.setData(data);

        chartDeclineproduct.animateX(2500, Easing.EasingOption.EaseInOutQuart);
        Legend l = chartDeclineproduct.getLegend();
        l.setForm(Legend.LegendForm.LINE);



    }

    public void setExpiryProducts(){

        ItineraryExpiryProductsAdapter itineraryExpiryProductsAdapter;
        ArrayList<ProductsEntity> itineraryExpiryProductsEntities = new ArrayList<ProductsEntity>();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerViewExpiryproducts.setLayoutManager(mLayoutManager);
        recyclerViewExpiryproducts.setItemAnimator(new DefaultItemAnimator());

        itineraryExpiryProductsAdapter = new ItineraryExpiryProductsAdapter(this,itineraryExpiryProductsEntities);

        itineraryExpiryProductsEntities.add(new ProductsEntity("101011","2017-01-04","HOBE02","HOBE02","2017-05-04"));
        itineraryExpiryProductsEntities.add(new ProductsEntity("106021","2016-05-20","EU05","EU05","2017-01-04"));
        itineraryExpiryProductsEntities.add(new ProductsEntity("103016","2016-03-06","B25705","B25705","2017-01-04"));
        itineraryExpiryProductsEntities.add(new ProductsEntity("101022","2016-08-12","G30640","G30640","2017-01-04"));

        recyclerViewExpiryproducts.setAdapter(itineraryExpiryProductsAdapter);

    }

    public void setCustomerLastVisit(){

        ItineraryLastVisitAdapter itineraryLastVisitAdapter;
        ArrayList<LastVisitEntity> itineraryLastVisitEntities = new ArrayList<LastVisitEntity>();


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerViewLAstVisit.setLayoutManager(mLayoutManager);
        recyclerViewLAstVisit.setItemAnimator(new DefaultItemAnimator());

        itineraryLastVisitAdapter = new ItineraryLastVisitAdapter(this,itineraryLastVisitEntities);
        itineraryLastVisitEntities.add(new LastVisitEntity("101011","2017-01-04",0));
        itineraryLastVisitEntities.add(new LastVisitEntity("101011","2017-01-04",1));
        itineraryLastVisitEntities.add(new LastVisitEntity("101011","2017-01-04",1));
        itineraryLastVisitEntities.add(new LastVisitEntity("101011","2017-01-04",0));
        itineraryLastVisitEntities.add(new LastVisitEntity("101011","2017-01-04",1));

        recyclerViewLAstVisit.setAdapter(itineraryLastVisitAdapter);

    }


    public void setupDialogFragment(int position ,ArrayList<CustomersEntity> itineraryCustomersEntities){
        FragmentManager fm = getFragmentManager();
        CustomerDialog customerDialog = new CustomerDialog (position, itineraryCustomersEntities);
        customerDialog.show(fm, "Sample Fragment");
    }

    public void navigateToInvoices(String customerID){

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("sharedPrefCustomerIDForInvoices", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("ItineraryCustomersID",customerID);
        editor.commit();

        Intent i = new Intent(Itinerary.this,Invoice.class);
        Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
        finish();
        startActivity(i, bndlanimation);

    }

    public void setScrollviewDowun(){new Handler().postDelayed(new Runnable() {
            public void run() {
                scrollViewCustomerDetails.fullScroll(ScrollView.FOCUS_DOWN);
            }
        }, 300);
    }



}
