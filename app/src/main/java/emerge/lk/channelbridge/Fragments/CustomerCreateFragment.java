package emerge.lk.channelbridge.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.Layout.CustomerPhotoGallery;
import emerge.lk.channelbridge.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Chamal on 1/19/2017.
 */

public class CustomerCreateFragment extends Fragment {


    @BindView(R.id.lnlImages_customerCreateFragment)
    LinearLayout lnrImages;

    private ArrayList<String> imagesPathList;
    private Bitmap yourbitmap;
    private Bitmap resized;
    private final int PICK_IMAGE_MULTIPLE =1;

    @BindView(R.id.edtTxt_customerCreateFragment_address)
    TextView customerAddress;
    @BindView(R.id.edtTxt_customerCreateFragment_phone)
    TextView customerPhone;
    @BindView(R.id.editText_customerCreateFragment_email)
    TextView customerEmail;
    @BindView(R.id.edtTxt_customerCreateFragment_web)
    TextView customerWeb;
    @BindView(R.id.edtTxt_customerCreateFragment_fax)
    TextView customerFax;
    @BindView(R.id.edtTxt_customerCreateFragment_area)
    TextView customerArea;
    @BindView(R.id.edtTxt_customerCreateFragment_town)
    TextView customerTown;
    @BindView(R.id.edtTxt_customerCreateFragment_district)
    TextView customerDistrict;
    @BindView(R.id.edtTxt_customerCreateFragment_latitude)
    TextView customerLatitude;
    @BindView(R.id.edtTxt_customerCreateFragment_longitude)
    TextView customerLongitude;
    @BindView(R.id.edtTxt_customerCreateFragment_own_name)
    TextView customerOwnName;
    @BindView(R.id.edtTxt_customerCreateFragment_own_no)
    TextView customerOwnNO;
    @BindView(R.id.edtTxt_customerCreateFragment_brNo)
    TextView customerBrNo;
    @BindView(R.id.edtTxt_customerCreateFragment_regNo)
    TextView customerRegNo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_create, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if(requestCode == PICK_IMAGE_MULTIPLE){
                imagesPathList = new ArrayList<String>();
                String[] imagesPath = data.getStringExtra("data").split("\\|");
                try{
                    lnrImages.removeAllViews();
                }catch (Throwable e){
                    e.printStackTrace();
                }
                for (int i=0;i<imagesPath.length;i++){
                    imagesPathList.add(imagesPath[i]);
                    yourbitmap = BitmapFactory.decodeFile(imagesPath[i]);
                    ImageView imageView = new ImageView(getContext());
                    View view = new View(getContext());
                    view.setMinimumWidth(16);
                    imageView.setImageBitmap(yourbitmap);
                    imageView.setAdjustViewBounds(true);
                    lnrImages.addView(imageView);
                    lnrImages.addView(view);
                }
            }
        }

    }

    @OnClick(R.id.btn_customerCreateFragment_select)
    public void selectImages() {
        Intent intent = new Intent(getActivity(), CustomerPhotoGallery.class);
        startActivityForResult(intent,PICK_IMAGE_MULTIPLE);
    }
}
