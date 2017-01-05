package emerge.lk.channelbridge.Layout;

import android.app.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.Service.NavigationDrawer;


/**
 * Created by Himanshu on 12/27/2016.
 */


public class Dashboard extends Activity implements DatePickerDialog.OnDateSetListener {

    NavigationDrawer navigationDrawer;
    @BindView(R.id.bar_chart) BarChart barChart;
    @BindView(R.id.bar_chart_h) HorizontalBarChart bar_chart_h;
    @BindView(R.id.pie_chart1) PieChart pie_chart1;
    @BindView(R.id.pie_chart2) PieChart pie_chart2;
    @BindView(R.id.pie_chart3) PieChart pie_chart3;
    @BindView(R.id.pie_chart4) PieChart pie_chart4;



    TextView textView_channelbridge_date;

    //Test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dashboard);
        ButterKnife.bind(this);

        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.drowNavigationDrawer();
        navigationDrawer.setDrawerItem();
        textView_channelbridge_date = (TextView) findViewById(R.id.textView_channelbridge_date);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        textView_channelbridge_date.setText("Appointment Date: " + dateFormat.format(date));


        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));

        ArrayList<Entry> entries2 = new ArrayList<>();
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
        dataset.setColors(new int[] { android.R.color.holo_red_dark, android.R.color.holo_blue_bright, android.R.color.holo_green_dark, android.R.color.holo_blue_dark }, Dashboard.this);
        BarData data = new BarData(labels, dataset);

        barChart.setData(data);
        barChart.animateXY(2000, 2000);
        barChart.invalidate();

        bar_chart_h.setData(data);
        bar_chart_h.animateXY(1000, 1000);
        bar_chart_h.invalidate();

        PieDataSet pieDataSet = new PieDataSet(entries2, "Monthly sales");
        PieData pieData = new PieData(labels, pieDataSet);

        pie_chart1.setData(pieData);
        pie_chart2.setData(pieData);
        pie_chart3.setData(pieData);
        pie_chart4.setData(pieData);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        textView_channelbridge_date.setText("Appointment Date: "+year+"/"+(monthOfYear+1)+"/"+dayOfMonth+" - "+yearEnd+"/"+(monthOfYearEnd+1)+"/"+dayOfMonthEnd);
    }



    @OnClick(R.id.relLayout_channelbridge_menu)
    public void logIn() {
        navigationDrawer.openNavigationDrawer();
    }

    @OnClick(R.id.relLayout_channelbridge_date)
    public void openDatepicker() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                Dashboard.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }


}


