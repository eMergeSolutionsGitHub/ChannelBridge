package emerge.lk.channelbridge.Dialog;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.lk.channelbridge.Entity.ItineraryCustomersEntity;
import emerge.lk.channelbridge.R;

/**
 * Created by Chamal on 1/10/2017.
 */

public class CustomerDialog extends DialogFragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    @BindView(R.id.fa_dialogbox_close)
    TextView tvCloseDialog;
    @BindView(R.id.dialogbox_customer_name)
    TextView customerName;
    @BindView(R.id.dialogbox_customer_area)
    TextView customerArea;


    @BindView(R.id.imgView_dialogbox_customer)
    ImageView customerImage;


    int position;
    int dialogWidth = 1200;
    int dialogHeight = 780;

    private SliderLayout mDemoSlider;




    public CustomerDialog() {
    }


    ArrayList<ItineraryCustomersEntity> itineraryCustomersEntities;

    @SuppressLint("ValidFragment")
    public CustomerDialog(int position, ArrayList<ItineraryCustomersEntity> itineraryCustomersEntities) {
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

        tvCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        customerName.setText(itineraryCustomersEntities.get(position).getItineraryCustomersName());
        customerArea.setText(itineraryCustomersEntities.get(position).getItineraryCustomersCity());
        Picasso.with(view.getContext()).load("file:///android_asset/image/" + itineraryCustomersEntities.get(position).getItineraryCustomersImageName()).into(customerImage);


        mDemoSlider = (SliderLayout)view.findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("image 01",R.drawable.a);
        file_maps.put("image 02",R.drawable.b);
        file_maps.put("image 03",R.drawable.c);
        file_maps.put("image 04", R.drawable.d);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(view.getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(null);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Fade);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(null);


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
}
