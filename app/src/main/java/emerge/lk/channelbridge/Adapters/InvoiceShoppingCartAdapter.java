package emerge.lk.channelbridge.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.lk.channelbridge.Entity.ProductsEntity;
import emerge.lk.channelbridge.Font.FontTitle;
import emerge.lk.channelbridge.R;


/**
 * Created by Himanshu on 01/05/2017.
 */
public class InvoiceShoppingCartAdapter extends RecyclerView.Adapter<InvoiceShoppingCartAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<ProductsEntity> invoiceProductsEntity;


    public InvoiceShoppingCartAdapter(Context mContext, ArrayList<ProductsEntity> invoiceProductsEntity) {
        this.mContext = mContext;
        this.invoiceProductsEntity = invoiceProductsEntity;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_invoice_shoppingcart, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.txtViewProductcode.setText(invoiceProductsEntity.get(position).getProductCode());
        holder.txtViewProductbatch.setText(invoiceProductsEntity.get(position).getProductBatch());
        holder.txtViewShelfqty.setText(String.valueOf(invoiceProductsEntity.get(position).getProductShelfQty()));
        holder.txtViewRequestqty.setText(String.valueOf(invoiceProductsEntity.get(position).getProductRequestQty()));
        holder.txtViewOrderqty.setText(String.valueOf(invoiceProductsEntity.get(position).getProductOrderQty()));
        holder.txtViewFreeqty.setText(String.valueOf(invoiceProductsEntity.get(position).getProductFreeQty()));
        holder.txtViewDiscountqty.setText(String.valueOf(invoiceProductsEntity.get(position).getProductDiscount()));
    }

    @Override
    public int getItemCount() {
        return invoiceProductsEntity.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgView_list_invoiceshoppingcart_product)
        CircularImageView imgViewProduct;
        @BindView(R.id.txtView_list_invoiceshoppingcart_productcode)
        TextView txtViewProductcode;
        @BindView(R.id.txtView_list_invoiceshoppingcart_productbatch)
        TextView txtViewProductbatch;
        @BindView(R.id.txtView_list_invoiceshoppingcart_shelfqty)
        TextView txtViewShelfqty;
        @BindView(R.id.txtView_list_invoiceshoppingcart_requestqty)
        TextView txtViewRequestqty;
        @BindView(R.id.txtView_list_invoiceshoppingcart_orderqty)
        TextView txtViewOrderqty;
        @BindView(R.id.txtView_list_invoiceshoppingcart_freeqty)
        TextView txtViewFreeqty;
        @BindView(R.id.txtView_list_invoiceshoppingcart_discountqty)
        TextView txtViewDiscountqty;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
