package emerge.lk.channelbridge.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.lk.channelbridge.R;

/**
 * Created by Chamal on 1/19/2017.
 */

public class CustomerCreateFragment extends Fragment {
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
}
