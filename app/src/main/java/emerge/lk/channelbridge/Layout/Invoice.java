package emerge.lk.channelbridge.Layout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.Adapters.InvoiceProductsAdapter;
import emerge.lk.channelbridge.Entity.ProductsEntity;
import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.Service.NavigationDrawer;

/**
 * Created by Himanshu on 1/19/2017.
 */

public class Invoice extends Activity {

    NavigationDrawer navigationDrawer;

    @BindView(R.id.txtView_channelbridge_title)
    TextView menuBarTitle;
    @BindView(R.id.expandablelayout_invoice_shoppingcart_product)
    ExpandableLayout expandablelayoutShoppingcartProduct;
    @BindView(R.id.recycview_invoice_product)
    RecyclerView recycviewInvoiceProduct;

    //test


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_invoice);
        ButterKnife.bind(this);

        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.drowNavigationDrawer();
        navigationDrawer.setDrawerItem();
        menuBarTitle.setText(R.string.string_invoice_titlebar_title);


        setProductsList();
    }

    @OnClick(R.id.relLayout_channelbridge_menu)
    public void titleBarMenuClick() {
        navigationDrawer.openNavigationDrawer();
    }

    @OnClick(R.id.relLayout_invoice_shoppingcart)
    public void shoppingCartProductClick() {
        if (expandablelayoutShoppingcartProduct.isExpanded()) {
            expandablelayoutShoppingcartProduct.collapse();
        } else {
            expandablelayoutShoppingcartProduct.expand();

        }
    }

    public void setProductsList() {

        InvoiceProductsAdapter invoiceProductsAdapter;
        ArrayList<ProductsEntity> invoiceProductsEntities = new ArrayList<ProductsEntity>();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recycviewInvoiceProduct.setLayoutManager(mLayoutManager);
        recycviewInvoiceProduct.setItemAnimator(new DefaultItemAnimator());

        invoiceProductsAdapter = new InvoiceProductsAdapter(this, invoiceProductsEntities);

        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));
        invoiceProductsEntities.add(new ProductsEntity("18R35A", "18R35A", "2017-05-20", "0 USP,250cm", "10000","250.00","260.00"));

        recycviewInvoiceProduct.setAdapter(invoiceProductsAdapter);
    }
}
