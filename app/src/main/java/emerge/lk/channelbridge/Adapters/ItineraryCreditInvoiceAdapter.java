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
import emerge.lk.channelbridge.Entity.InvoiceEntity;
import emerge.lk.channelbridge.R;


/**
 * Created by Himanshu on 01/05/2017.
 */
public class ItineraryCreditInvoiceAdapter extends RecyclerView.Adapter<ItineraryCreditInvoiceAdapter.MyViewHolder> implements View.OnClickListener {

    Context mContext;
    ArrayList<InvoiceEntity> itineraryCreditInvoicesEntities;

    public ItineraryCreditInvoiceAdapter(Context mContext, ArrayList<InvoiceEntity> itineraryCreditInvoicesEntities) {
        this.mContext = mContext;
        this.itineraryCreditInvoicesEntities = itineraryCreditInvoicesEntities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itinerary_creditinvoices, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.textViewInvoiceNum.setText(itineraryCreditInvoicesEntities.get(position).getInvoiceNumber());
        holder.textViewInvoiceDate.setText(itineraryCreditInvoicesEntities.get(position).getInvoiceDate());
        holder.textViewInvoiceTotvalue.setText(itineraryCreditInvoicesEntities.get(position).getInvoiceValue());
        holder.textViewInvoiceBalance.setText(itineraryCreditInvoicesEntities.get(position).getInvoicesBalance());
    }

    @Override
    public int getItemCount() {
        return itineraryCreditInvoicesEntities.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtView_listitinerary_creditinvoice_num)
        TextView textViewInvoiceNum;
        @BindView(R.id.txtView_listitinerary_creditinvoice_date)
        TextView textViewInvoiceDate;
        @BindView(R.id.txtView_listitinerary_creditinvoice_totvalue)
        TextView textViewInvoiceTotvalue;
        @BindView(R.id.txtView_listitinerary_creditinvoice_balance)
        TextView textViewInvoiceBalance;

        public MyViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
