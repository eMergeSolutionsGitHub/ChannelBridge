package emerge.lk.channelbridge.Dialog;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;


import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.lk.channelbridge.Entity.CustomersEntity;

import emerge.lk.channelbridge.R;

/**
 * Created by Chamal on 1/10/2017.
 */

public class CustomerDetailsDialog extends DialogFragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    @BindView(R.id.txtView_customer_detailDialog_customer_name)
    TextView customerName;
    @BindView(R.id.txtView_customer_detailDialog_customer_area)
    TextView customerArea;

    @BindView(R.id.txtView_customer_detailDialog_address)
    TextView customerAddress;
    @BindView(R.id.txtView_customer_detailDialog_phone)
    TextView customerPhone;
    @BindView(R.id.txtView_customer_detailDialog_email)
    TextView customerEmail;
    @BindView(R.id.txtView_customer_detailDialog_web)
    TextView customerWeb;
    @BindView(R.id.txtView_customer_detailDialog_fax)
    TextView customerFax;
    @BindView(R.id.txtView_customer_detailDialog_area)
    TextView customerArea2;
    @BindView(R.id.txtView_customer_detailDialog_town)
    TextView customerTown;
    @BindView(R.id.txtView_customer_detailDialog_district)
    TextView customerDistrict;
    @BindView(R.id.txtView_customer_detailDialog_latitude)
    TextView customerLatitude;
    @BindView(R.id.txtView_customer_detailDialog_longitude)
    TextView customerLongitude;
    @BindView(R.id.txtView_customer_detailDialog_own_name)
    TextView customerName2;
    @BindView(R.id.txtView_customer_detailDialog_own_no)
    TextView customerNo;
    @BindView(R.id.txtView_customer_detailDialog_brNo)
    TextView customerBrNo;
    @BindView(R.id.txtView_customer_detailDialog_regNo)
    TextView customerRegNo;


    @BindView(R.id.imgView_customer_detailDialog_customer)
    ImageView customerImage;

    int position;
    int dialogWidth = 1300;
    int dialogHeight = 780;

    HashMap<String, String> file_maps;

    private SliderLayout mDemoSlider;

    public CustomerDetailsDialog() {
    }


    ArrayList<CustomersEntity> itineraryCustomersEntities;

    @SuppressLint("ValidFragment")
    public CustomerDetailsDialog(int position, ArrayList<CustomersEntity> itineraryCustomersEntities) {
        this.position = position;
        this.itineraryCustomersEntities = itineraryCustomersEntities;
    }

    //Test
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        final View view = inflater.inflate(R.layout.dialogbox_customer_details, container, false);
        ButterKnife.bind(this, view);

        customerName.setText(itineraryCustomersEntities.get(position).getItineraryCustomersName());
        customerArea.setText(itineraryCustomersEntities.get(position).getItineraryCustomersCity());

        Glide.with(view.getContext()).load("file:///android_asset/image/" + itineraryCustomersEntities.get(position).getItineraryCustomersImageName()).into(customerImage);
        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider_customer_detailDialog);

        file_maps = getHashMap(itineraryCustomersEntities.get(position).getItineraryCustomersName());
        setUpSlider(file_maps, view.getContext());


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Window window = getDialog().getWindow();
        window.setLayout(dialogWidth, dialogHeight);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        //Uri path = Uri.parse("android.resource://emerge.lk.channelbridge/drawable/" + file_maps.get(slider.getBundle().get("extra")));
        Uri path = Uri.parse("file:///android_asset/image/" + file_maps.get(slider.getBundle().get("extra")));

        Glide.with(getActivity()).load(path).into(customerImage);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setUpSlider(HashMap<String, String> map, Context context) {

        for (String name : map.keySet()) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(context);
            // initialize a SliderLayout
            defaultSliderView
                    .image("file:///android_asset/image/"+map.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            defaultSliderView.bundle(new Bundle());
            defaultSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(defaultSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(null);

    }

    public HashMap<String, String> getHashMap(String name) {
        HashMap<String, String> retHashmap = null;
        switch (name) {
            case "Asiri Surgical":
                retHashmap = new HashMap<>();
                retHashmap.put("image1", "asiri1.jpg");
                retHashmap.put("image2", "asiri2.jpg");
                retHashmap.put("image3", "asiri3.jpg");
                break;

            case "Hemas Hospital":
                retHashmap = new HashMap<>();
                retHashmap.put("image1", "hemas1.jpg");
                retHashmap.put("image2", "hemas2.jpg");
                retHashmap.put("image3", "hemas3.jpg");
                break;

            case "Lanka Hospital":
                retHashmap = new HashMap<>();
                retHashmap.put("image1", "lanka1.jpg");
                retHashmap.put("image2", "lanka2.jpg");
                retHashmap.put("image3", "lanka3.jpg");
                break;

            case "Nawaloka Hospital":
                retHashmap = new HashMap<>();
                retHashmap.put("image1", "nawa1.jpg");
                retHashmap.put("image2", "nawa2.jpg");
                retHashmap.put("image3", "nawa3.jpg");
                break;

            case "Ninewells Hospital":
                retHashmap = new HashMap<>();
                retHashmap.put("image1", "ninwls1.jpg");
                retHashmap.put("image2", "ninwls2.jpg");
                retHashmap.put("image3", "ninwls3.jpg");
                break;

            default:
                retHashmap = new HashMap<>();
                retHashmap.put("image1", "154.jpg");
                retHashmap.put("image2", "14526.jpg");
                retHashmap.put("image3", "15753.jpg");
        }

        return retHashmap;
    }
}
