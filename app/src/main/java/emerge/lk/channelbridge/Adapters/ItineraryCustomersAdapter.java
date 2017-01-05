package emerge.lk.channelbridge.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import emerge.lk.channelbridge.Entity.ItineraryCustomersEntity;
import emerge.lk.channelbridge.R;


/**
 * Created by Himanshu on 01/05/2017.
 */
public class ItineraryCustomersAdapter extends RecyclerView.Adapter<ItineraryCustomersAdapter.MyViewHolder> implements View.OnClickListener {

    Context mContext;
    ArrayList<ItineraryCustomersEntity> itineraryCustomersEntities;

    boolean status = false;


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

        holder.textViewCustomerName.setText(itineraryCustomersEntities.get(position).getItineraryCustomersName());


    }

    @Override
    public int getItemCount() {
        return itineraryCustomersEntities.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView imageViewCustomerImage;
        TextView textViewCustomerName,textViewCustomerCity;

      /*  @BindView(R.id.imgView_itinerary_customer) ImageView imageViewCustomerImage;
        @BindView(R.id.textView_itinerary_customername) TextView textViewCustomerName;
        @BindView(R.id.textView_itinerary_customercity) TextView textViewCustomerCity;*/


        public MyViewHolder(View itemView) {
            super(itemView);


          //  imageViewCustomerImage = (ImageView) itemView.findViewById(R.id.imgView_itinerary_customer);
           textViewCustomerName = (TextView) itemView.findViewById(R.id.textView_itinerary_customername);
          //  textViewCustomerCity = (TextView) itemView.findViewById(R.id.textView_itinerary_customercity);



        }



    }

}
