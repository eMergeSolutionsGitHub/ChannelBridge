package emerge.lk.channelbridge.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.lk.channelbridge.Entity.ProductsEntity;
import emerge.lk.channelbridge.R;


/**
 * Created by Himanshu on 01/05/2017.
 */
public class InvoiceProductsCategoryAdapter extends RecyclerView.Adapter<InvoiceProductsCategoryAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<ProductsEntity> invoiceProductsEntity;



    public InvoiceProductsCategoryAdapter(Context mContext, ArrayList<ProductsEntity> invoiceProductsEntity) {
        this.mContext = mContext;
        this.invoiceProductsEntity = invoiceProductsEntity;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_productcategory_tagview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textViewCategory.setText(invoiceProductsEntity.get(position).getProductCatagory());

    }

    @Override
    public int getItemCount() {
        return invoiceProductsEntity.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.txtView_taginvoice_productcategory)
        TextView textViewCategory;
        @BindView(R.id.relLayout_listproductcategorytag_main)
        RelativeLayout relLayout_main;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    relLayout_main.setBackground(mContext.getResources().getDrawable(R.drawable.rounded_corner_productcategorytagselect));

                }
            });
        }
    }

}
