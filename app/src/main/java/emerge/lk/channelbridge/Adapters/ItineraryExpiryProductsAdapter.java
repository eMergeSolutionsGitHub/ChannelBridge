package emerge.lk.channelbridge.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.lk.channelbridge.Entity.ItineraryCreditInvoicesEntity;
import emerge.lk.channelbridge.Entity.ItineraryExpiryProductsEntity;
import emerge.lk.channelbridge.R;


/**
 * Created by Himanshu on 01/05/2017.
 */
public class ItineraryExpiryProductsAdapter extends RecyclerView.Adapter<ItineraryExpiryProductsAdapter.MyViewHolder> implements View.OnClickListener {

    Context mContext;
    ArrayList<ItineraryExpiryProductsEntity> itineraryExpiryProductsEntities;

    public ItineraryExpiryProductsAdapter(Context mContext, ArrayList<ItineraryExpiryProductsEntity> itineraryExpiryProductsEntities) {
        this.mContext = mContext;
        this.itineraryExpiryProductsEntities = itineraryExpiryProductsEntities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itinerary_expiryproducts, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.textViewInvoiceNum.setText(itineraryExpiryProductsEntities.get(position).getItineraryExpiryInvoicesNum());
        holder.textViewInvoiceDate.setText(itineraryExpiryProductsEntities.get(position).getItineraryExpiryInvoicesDate());
        holder.textViewProduct.setText(itineraryExpiryProductsEntities.get(position).getItineraryExpiryProduct());
        holder.textViewBatch.setText(itineraryExpiryProductsEntities.get(position).getItineraryExpiryBatch());
        holder.textViewExpDate.setText(itineraryExpiryProductsEntities.get(position).getItineraryExpiryDate());

    }

    @Override
    public int getItemCount() {
        return itineraryExpiryProductsEntities.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtView_list_itinerary_expiryproducts_invoiceno)
        TextView textViewInvoiceNum;
        @BindView(R.id.txtView_list_itinerary_expiryproducts_invoicedate)
        TextView textViewInvoiceDate;
        @BindView(R.id.txtView_list_itinerary_expiryproducts_product)
        TextView textViewProduct;
        @BindView(R.id.txtView_list_itinerary_expiryproducts_batchno)
        TextView textViewBatch;
        @BindView(R.id.txtView_itinerary_expiryproducts_expdate)
        TextView textViewExpDate;


        public MyViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
