package emerge.lk.channelbridge.Dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.lk.channelbridge.R;

/**
 * Created by Himanshu on 2/1/2017.
 */

public class InvoicePrintDialog extends DialogFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View invoiceProductView = inflater.inflate(R.layout.dialog_invoice_print, container, false);
        ButterKnife.bind(this, invoiceProductView);

        return invoiceProductView;
    }



}
