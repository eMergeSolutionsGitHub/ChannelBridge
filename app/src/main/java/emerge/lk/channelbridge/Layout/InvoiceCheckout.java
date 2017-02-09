package emerge.lk.channelbridge.Layout;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.Adapters.CBSpinnerAdapter;
import emerge.lk.channelbridge.Dialog.InvoicePrintDialog;
import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.Service.NavigationDrawer;

/**
 * Created by Himanshu on 2/7/2017.
 */

public class InvoiceCheckout extends Activity {


    NavigationDrawer navigationDrawer;
    @BindView(R.id.txtView_channelbridge_title)
    TextView menuBarTitle;

    @BindView(R.id.spinner_invoicecheckout_creditduration)
    Spinner spinnerCreditduration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_invoice_checkout);
        ButterKnife.bind(this);

        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.drowNavigationDrawer();
        navigationDrawer.setDrawerItem();
        menuBarTitle.setText(R.string.string_invoicecheckout_titlebar_title);

        setCrditduration();

    }
    @OnClick(R.id.relLayout_channelbridge_menu)
    public void titleBarMenuClick() {
        navigationDrawer.openNavigationDrawer();
    }

    @OnClick(R.id.btn_invoicecheckout_next)
    public void buttonNextClick() {
        FragmentManager fm = getFragmentManager();
        InvoicePrintDialog invoicePrintDialog = new InvoicePrintDialog();
        invoicePrintDialog.show(fm, "Dialog Fragment");
    }

    private void setCrditduration(){
        List<String> list = new ArrayList<String>();
        list.add("03");
        list.add("06");
        list.add("12");
        list.add("15");
        CBSpinnerAdapter adapter = new CBSpinnerAdapter(this, android.R.layout.simple_spinner_item, list);
        spinnerCreditduration.setAdapter(adapter);
    }

}
