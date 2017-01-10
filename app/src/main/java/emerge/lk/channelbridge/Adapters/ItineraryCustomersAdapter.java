package emerge.lk.channelbridge.Adapters;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.annotations.Nullable;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.lk.channelbridge.Dialog.CustomerDialog;
import emerge.lk.channelbridge.Entity.ItineraryCustomersEntity;
import emerge.lk.channelbridge.Layout.Itinerary;
import emerge.lk.channelbridge.R;


/**
 * Created by Himanshu on 01/05/2017.
 */
public class ItineraryCustomersAdapter extends RecyclerView.Adapter<ItineraryCustomersAdapter.MyViewHolder> implements View.OnClickListener {

    Context mContext;
    ArrayList<ItineraryCustomersEntity> itineraryCustomersEntities;
    CustomerDialog customerDialog;
    FragmentManager fragmentManager;

    public ItineraryCustomersAdapter(Context mContext, ArrayList<ItineraryCustomersEntity> itineraryCustomersEntities) {
        this.mContext = mContext;
        this.itineraryCustomersEntities = itineraryCustomersEntities;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itinerary_customer, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final String cutomerImagePath = "file:///android_asset/image/" + itineraryCustomersEntities.get(position).getItineraryCustomersImageName();

        holder.textViewCustomerName.setText(itineraryCustomersEntities.get(position).getItineraryCustomersName());
        holder.textViewCustomerCity.setText(itineraryCustomersEntities.get(position).getItineraryCustomersCity());
        Picasso.with(mContext).load(cutomerImagePath).into(holder.imageViewCustomerImage);

        holder.linLayout_itinerary_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                if(mContext instanceof Itinerary){
                    ((Itinerary)mContext).setupDialogFragment(position, itineraryCustomersEntities);
                }

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return itineraryCustomersEntities.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgView_itinerary_customer)
        ImageView imageViewCustomerImage;
        @BindView(R.id.textView_itinerary_customername)
        TextView textViewCustomerName;
        @BindView(R.id.textView_itinerary_customercity)
        TextView textViewCustomerCity;
        @BindView(R.id.linLayout_itinerary_item)
        LinearLayout linLayout_itinerary_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
