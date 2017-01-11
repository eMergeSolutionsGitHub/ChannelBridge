package emerge.lk.channelbridge.Dialog;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.lk.channelbridge.Entity.ItineraryCustomersEntity;
import emerge.lk.channelbridge.R;

/**
 * Created by Chamal on 1/10/2017.
 */

public class CustomerDialog extends DialogFragment {

    @BindView(R.id.imgView_dialogbox_close)
    ImageView ivCloseDialog;
    @BindView(R.id.dialogbox_customer_name)
    TextView customerName;
    @BindView(R.id.dialogbox_customer_area)
    TextView customerArea;
    @BindView(R.id.imgView_dialogbox_customer)
    ImageView customerImage;

    int position;
    int dialogWidth = 1200;
    int dialogHeight = 600;

    ArrayList<ItineraryCustomersEntity> itineraryCustomersEntities;

    @SuppressLint("ValidFragment")
    public CustomerDialog(int position , ArrayList<ItineraryCustomersEntity> itineraryCustomersEntities){
        this.position = position;
        this.itineraryCustomersEntities = itineraryCustomersEntities;
    }

    //Test
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialogbox_customer_details, container, false);
        ButterKnife.bind(this, view);

        ivCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getDialog().dismiss();
            }
        });

        customerName.setText(itineraryCustomersEntities.get(position).getItineraryCustomersName());
        customerArea.setText(itineraryCustomersEntities.get(position).getItineraryCustomersCity());
        Picasso.with(view.getContext()).load("file:///android_asset/image/" + itineraryCustomersEntities.get(position).getItineraryCustomersImageName()).into(customerImage);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Window window = getDialog().getWindow();
        window.setLayout(dialogWidth, dialogHeight);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}
