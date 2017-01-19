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

import emerge.lk.channelbridge.Entity.ItineraryLastInvoiceEntity;
import emerge.lk.channelbridge.R;


/**
 * Created by Himanshu on 01/05/2017.
 */
public class ItineraryLastInvoicesAdapter extends RecyclerView.Adapter<ItineraryLastInvoicesAdapter.MyViewHolder> implements View.OnClickListener {

    Context mContext;
    ArrayList<ItineraryLastInvoiceEntity> itineraryLastInvoiceEntities;

    public ItineraryLastInvoicesAdapter(Context mContext, ArrayList<ItineraryLastInvoiceEntity> itineraryLastInvoiceEntities) {
        this.mContext = mContext;
        this.itineraryLastInvoiceEntities = itineraryLastInvoiceEntities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itinerary_lastinvoices, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.txtViewlistitinerarylastinvoiceno.setText(itineraryLastInvoiceEntities.get(position).getItineraryLastInvoiceNum());
        holder.txtViewlistitinerarylastinvoicevalue.setText(itineraryLastInvoiceEntities.get(position).getItineraryLastInvoiceValue());
        holder.txtViewlistitinerarylastinvoiceduedate.setText(itineraryLastInvoiceEntities.get(position).getItineraryLastInvoiceDueDate());    }

    @Override
    public int getItemCount() {
        return itineraryLastInvoiceEntities.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtView_list_itinerary_lastinvoiceno) TextView txtViewlistitinerarylastinvoiceno;
        @BindView(R.id.txtView_list_itinerary_lastinvoicevalue) TextView txtViewlistitinerarylastinvoicevalue;
        @BindView(R.id.txtView_list_itinerary_lastinvoiceduedate) TextView txtViewlistitinerarylastinvoiceduedate;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
