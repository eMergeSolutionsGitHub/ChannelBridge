package emerge.lk.channelbridge.Layout;

import android.app.Activity;
import android.graphics.Color;
import android.app.FragmentManager;
import android.os.Bundle;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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
import emerge.lk.channelbridge.Adapters.ItineraryLastInvoicesAdapter;
import emerge.lk.channelbridge.Entity.ItineraryCreditInvoicesEntity;
import emerge.lk.channelbridge.Entity.ItineraryCustomersEntity;
import emerge.lk.channelbridge.Entity.ItineraryLastInvoiceEntity;
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

    @BindView(R.id.expandablelayout_itinerary_creditinvoice) ExpandableLayout expandablelayoutCreditinvoice;
    @BindView(R.id.ftxtView_itinerary_creditinvoice_arrow) TextViewFontAwesome fontAwesometxtviewCreditinvoiceArrow ;


    @BindView(R.id.expandablelayout_itinerary_lastinvoice) ExpandableLayout expandablelayoutLastinvoice;
    @BindView(R.id.ftxtView_itinerary_lastinvoices_arrow) TextViewFontAwesome fontAwesometxtviewLasttinvoiceArrow ;

    @BindView(R.id.expandablelayout_itinerary_declineproduct) ExpandableLayout expandablelayoutDeclineproducts;
    @BindView(R.id.ftxtView_itinerary_declineproducts_arrow) TextViewFontAwesome fontAwesometxtviewDeclineproductsArrow ;



    @BindView(R.id.chart_itinerary_declineproduct) LineChart chartDeclineproduct ;


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

        setCreditInvoice();
        setLastInvoice();


        menuBarTitle.setText(R.string.string_itinerary_titlebar_title);

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
        recyclerViewCreditInvoice.setLayoutManager(mLayoutManager);
        recyclerViewCreditInvoice.setItemAnimator(new DefaultItemAnimator());

        itineraryCreditInvoiceAdapter = new ItineraryCreditInvoiceAdapter(this,itineraryCreditInvoicesEntities);

        itineraryCreditInvoicesEntities.add(new ItineraryCreditInvoicesEntity("101011","2017-01-04","256330.00","256330.00"));
        itineraryCreditInvoicesEntities.add(new ItineraryCreditInvoicesEntity("106021","2016-05-20","551522.50","551522.50"));
        itineraryCreditInvoicesEntities.add(new ItineraryCreditInvoicesEntity("103016","2016-03-06","36544.00","36544.00"));
        itineraryCreditInvoicesEntities.add(new ItineraryCreditInvoicesEntity("101022","2016-08-12","24555555.00","24555555.00"));

        recyclerViewCreditInvoice.setAdapter(itineraryCreditInvoiceAdapter);


    }

    public void setLastInvoice(){
        ItineraryLastInvoicesAdapter itineraryLastInvoicesAdapter;
        ArrayList<ItineraryLastInvoiceEntity> itineraryLastInvoiceEntities = new ArrayList<ItineraryLastInvoiceEntity>();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerViewLastInvoice.setLayoutManager(mLayoutManager);
        recyclerViewLastInvoice.setItemAnimator(new DefaultItemAnimator());

        itineraryLastInvoicesAdapter = new ItineraryLastInvoicesAdapter(this,itineraryLastInvoiceEntities);

        itineraryLastInvoiceEntities.add(new ItineraryLastInvoiceEntity("101011","256330.00","2017-01-04"));
        itineraryLastInvoiceEntities.add(new ItineraryLastInvoiceEntity("106021","551522.50","2016-05-20"));
        itineraryLastInvoiceEntities.add(new ItineraryLastInvoiceEntity("103016","36544.00","2016-03-06"));
        itineraryLastInvoiceEntities.add(new ItineraryLastInvoiceEntity("101022","24555555.00","2016-08-12"));
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

    public void setupDialogFragment(int position ,ArrayList<ItineraryCustomersEntity> itineraryCustomersEntities){

        FragmentManager fm = getFragmentManager();
        CustomerDialog customerDialog = new CustomerDialog (position, itineraryCustomersEntities);
        customerDialog.show(fm, "Sample Fragment");
    }

}
