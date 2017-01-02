package emerge.lk.channelbridge.Layout;

import android.app.Activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;


import java.util.ArrayList;

import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.Service.NavigationDrawer;



/**
 * Created by Himanshu on 12/27/2016.
 */


public class Home extends Activity {
    NavigationDrawer navigationDrawer;
    BarChart chart1;
    BubbleChart chart2;
    HorizontalBarChart bar_chart_h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dashboard);


        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.drowNavigationDrawer();
        navigationDrawer.setDrawerItem();


        chart1 = (BarChart) findViewById(R.id.bar_chart1);
        chart2 = (BubbleChart) findViewById(R.id.bar_chart2);
        bar_chart_h = (HorizontalBarChart)findViewById(R.id.bar_chart_h);



        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));

        ArrayList<BubbleEntry> entries2 = new ArrayList<>();
        entries2.add(new BubbleEntry(1, 3f, 5));
        entries2.add(new BubbleEntry(2, 13f, 5));
        entries2.add(new BubbleEntry(3, 32f, 5));
        entries2.add(new BubbleEntry(4, 10f, 5));
        entries2.add(new BubbleEntry(5, 5f, 5));




        ArrayList<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        BarDataSet dataset = new BarDataSet(entries, "Num sales");
        dataset.setColors(new int[] { android.R.color.holo_red_dark, android.R.color.holo_blue_bright, android.R.color.holo_green_dark, android.R.color.holo_blue_dark }, Home.this);
        BarData data = new BarData(labels, dataset);

        BubbleDataSet dataSet2 = new BubbleDataSet(entries2, "Num sales");
        BubbleData data2 = new BubbleData(labels, dataSet2);

        chart1.setData(data);
        chart1.animateXY(2000, 2000);
        chart1.invalidate();

        chart2.setData(data2);
        chart2.animateXY(3000, 3000);
        chart2.invalidate();

        bar_chart_h.setData(data);
        bar_chart_h.animateXY(1000, 1000);
        bar_chart_h.invalidate();



    }

}


