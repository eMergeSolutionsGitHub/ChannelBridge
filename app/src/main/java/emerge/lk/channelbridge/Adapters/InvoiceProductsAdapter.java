package emerge.lk.channelbridge.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.lk.channelbridge.Entity.ProductsEntity;
import emerge.lk.channelbridge.Font.FontTitle;
import emerge.lk.channelbridge.Layout.Invoice;
import emerge.lk.channelbridge.Layout.Itinerary;
import emerge.lk.channelbridge.R;


/**
 * Created by Himanshu on 01/05/2017.
 */
public class InvoiceProductsAdapter extends RecyclerView.Adapter<InvoiceProductsAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<ProductsEntity> invoiceProductsEntity;


    public InvoiceProductsAdapter(Context mContext, ArrayList<ProductsEntity> invoiceProductsEntity) {
        this.mContext = mContext;
        this.invoiceProductsEntity = invoiceProductsEntity;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_invoice_product, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textViewProductcode.setText(invoiceProductsEntity.get(position).getProductCode());
        holder.textViewDescription.setText(invoiceProductsEntity.get(position).getProductDiscription());
        holder.textViewBatch.setText(invoiceProductsEntity.get(position).getProductBatch());
        holder.textViewStock.setText(invoiceProductsEntity.get(position).getProductStock());
        holder.txtViewProductexpdate.setText(invoiceProductsEntity.get(position).getProductExpiryDate());
        holder.textViewRetailPrice.setText(invoiceProductsEntity.get(position).getProductRetailPrice());
        holder.textViewSellingPrice.setText(invoiceProductsEntity.get(position).getProductSellingPrice());

        holder.relLayoutnvoiceProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext instanceof Invoice) {
                    ((Invoice) mContext).openSelectedProductDialog(invoiceProductsEntity.get(position).getProductCode());
                } else {
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return invoiceProductsEntity.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.imgView_list_invoice_customer)
        ImageView imageViewCustomerImage;
        @BindView(R.id.txtView_list_invoice_productcode)
        TextView textViewProductcode;
        @BindView(R.id.txtView_list_invoice_productdescription)
        TextView textViewDescription;
        @BindView(R.id.txtView_list_invoice_productbatch)
        TextView textViewBatch;
        @BindView(R.id.txtView_list_invoice_productstock)
        TextView textViewStock;
        @BindView(R.id.txtView_list_invoice_productretailprice)
        TextView textViewRetailPrice;
        @BindView(R.id.txtView_list_invoice_productsellingprice)
        TextView textViewSellingPrice;
        @BindView(R.id.txtView_list_invoice_productexpdate)
        TextView txtViewProductexpdate;

        @BindView(R.id.relLayout_invoices_products)
        RelativeLayout relLayoutnvoiceProducts;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
