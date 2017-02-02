package emerge.lk.channelbridge.Dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import emerge.lk.channelbridge.R;

/**
 * Created by Himanshu on 2/1/2017.
 */

public class InvoiceProductDialog extends DialogFragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View v = inflater.inflate(R.layout.dialog_invoice_products, container, false);

        return v;
    }

}
