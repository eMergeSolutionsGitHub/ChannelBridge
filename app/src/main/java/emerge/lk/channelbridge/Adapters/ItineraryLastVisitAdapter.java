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
import emerge.lk.channelbridge.Entity.LastVisitEntity;
import emerge.lk.channelbridge.Font.TextViewFontAwesome;
import emerge.lk.channelbridge.R;


/**
 * Created by Himanshu on 01/05/2017.
 */
public class ItineraryLastVisitAdapter extends RecyclerView.Adapter<ItineraryLastVisitAdapter.MyViewHolder> implements View.OnClickListener {

    Context mContext;
    ArrayList<LastVisitEntity> itineraryLastVisitEntities;

    public ItineraryLastVisitAdapter(Context mContext, ArrayList<LastVisitEntity> itineraryLastVisitEntities) {
        this.mContext = mContext;
        this.itineraryLastVisitEntities = itineraryLastVisitEntities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itinerary_lastvisite, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.txtViewlistitinerarylastvisitdate.setText(itineraryLastVisitEntities.get(position).getItineraryLastVisitInvoicesDate());
        if(itineraryLastVisitEntities.get(position).getItineraryLastVisitOnRoute()==1){
            holder.txtViewlistitinerarylastvisitonroute.setText(R.string.icon_navigation_itinerary);
            holder.txtViewlistitinerarylastvisitonroute.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        }else {
            holder.txtViewlistitinerarylastvisitoutofroute.setText(R.string.icon_navigation_itinerary);
            holder.txtViewlistitinerarylastvisitoutofroute.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        }


      //  holder.txtViewlistitinerarylastinvoiceno.setText(itineraryLastInvoiceEntities.get(position).getInvoiceNumber());
      //  holder.txtViewlistitinerarylastinvoicevalue.setText(itineraryLastInvoiceEntities.get(position).getInvoiceValue());
     //   holder.txtViewlistitinerarylastinvoiceduedate.setText(itineraryLastInvoiceEntities.get(position).getInvoiceDueDate());
    }

    @Override
    public int getItemCount() {
        return itineraryLastVisitEntities.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {




        @BindView(R.id.txtView_list_itinerary_lastvisit_Date) TextView txtViewlistitinerarylastvisitdate;
        @BindView(R.id.ftxtView_list_itinerary_lastvisit_onroute)
        TextViewFontAwesome txtViewlistitinerarylastvisitonroute;
        @BindView(R.id.ftxtView_list_itinerary_lastvisit_outofroute) TextViewFontAwesome txtViewlistitinerarylastvisitoutofroute;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
