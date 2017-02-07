package emerge.lk.channelbridge.Layout;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaofeng.flowlayoutmanager.FlowLayoutManager;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.Adapters.InvoiceProductsAdapter;
import emerge.lk.channelbridge.Adapters.InvoiceProductsCategoryAdapter;
import emerge.lk.channelbridge.Adapters.InvoiceShoppingCartAdapter;
import emerge.lk.channelbridge.Dialog.InvoiceProductDialog;
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
    @BindView(R.id.expandablelayout_invoice_productcategory)
    ExpandableLayout expandablelayoutProductCategory;
    @BindView(R.id.expandablelayout_invoice_productserach)
    ExpandableLayout expandablelayoutProductSerach;

    @BindView(R.id.recycview_invoice_product)
    RecyclerView recycviewInvoiceProduct;
    @BindView(R.id.recycview_invoice_productcategory)
    RecyclerView recycviewInvoiceProductCategory;
    @BindView(R.id.recycview_invoice_shoppingcart)
    RecyclerView recycviewInvoiceProductShoppingCart;




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
            if(expandablelayoutProductCategory.isExpanded()){
                expandablelayoutProductCategory.setDuration(200);
                expandablelayoutProductCategory.collapse();
            }if(expandablelayoutProductSerach.isExpanded()){
                expandablelayoutProductSerach.setDuration(400);
                expandablelayoutProductSerach.collapse();
            }else {}
            showShoppingCrat();
            expandablelayoutShoppingcartProduct.setDuration(1000);
            expandablelayoutShoppingcartProduct.expand();

        }
    }
    @OnClick(R.id.relLayout_invoice_productcategory)
    public void productCategoryClick() {
        if (expandablelayoutProductCategory.isExpanded()) {
            expandablelayoutProductCategory.collapse();
        } else {
            setProductsCategory();
            if(expandablelayoutShoppingcartProduct.isExpanded()){
                expandablelayoutShoppingcartProduct.setDuration(200);
                expandablelayoutShoppingcartProduct.collapse();
            }if(expandablelayoutProductSerach.isExpanded()){
                expandablelayoutProductSerach.setDuration(400);
                expandablelayoutProductSerach.collapse();
            }else {}
            expandablelayoutProductCategory.setDuration(1000);
            expandablelayoutProductCategory.expand();
        }
    }

    @OnClick(R.id.relLayout_invoice_productserach)
    public void productSerachClick() {
        if (expandablelayoutProductSerach.isExpanded()) {
            expandablelayoutProductSerach.collapse();
        } else {
            setProductsCategory();
            if(expandablelayoutShoppingcartProduct.isExpanded()){
                expandablelayoutShoppingcartProduct.setDuration(200);
                expandablelayoutShoppingcartProduct.collapse();
            }if(expandablelayoutProductCategory.isExpanded()){
                expandablelayoutProductCategory.setDuration(400);
                expandablelayoutProductCategory.collapse();
            }else {}
            expandablelayoutProductSerach.setDuration(1000);
            expandablelayoutProductSerach.expand();

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

    public void setProductsCategory() {

        InvoiceProductsCategoryAdapter invoiceProductsCategoryAdapter;
        ArrayList<ProductsEntity> invoiceProductsEntities = new ArrayList<ProductsEntity>();

        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        flowLayoutManager.setAutoMeasureEnabled(true);
        recycviewInvoiceProductCategory.setLayoutManager(flowLayoutManager);


        invoiceProductsCategoryAdapter = new InvoiceProductsCategoryAdapter(this,invoiceProductsEntities);

        invoiceProductsEntities.add(new ProductsEntity("COROLENE"));
        invoiceProductsEntities.add(new ProductsEntity("CARDIOXYL"));
        invoiceProductsEntities.add(new ProductsEntity("MONOTIME"));
        invoiceProductsEntities.add(new ProductsEntity("ADVANTIME"));
        invoiceProductsEntities.add(new ProductsEntity("HOE Pharmaceuticals"));
        invoiceProductsEntities.add(new ProductsEntity("ADON"));
        invoiceProductsEntities.add(new ProductsEntity("ANNE FRENCH"));
        invoiceProductsEntities.add(new ProductsEntity("SAROME"));
        invoiceProductsEntities.add(new ProductsEntity("EVER YOUTH"));
        invoiceProductsEntities.add(new ProductsEntity("HOLLYWOOD STYLE"));
        recycviewInvoiceProductCategory.setAdapter(invoiceProductsCategoryAdapter);
    }

    public void openSelectedProductDialog(String productCode){
        FragmentManager fm = getFragmentManager();
        InvoiceProductDialog invoiceProductDialog = new InvoiceProductDialog();
        invoiceProductDialog.show(fm, "Dialog Fragment");

    }

    public void showShoppingCrat(){

        InvoiceShoppingCartAdapter invoiceShoppingCartAdapter;
        ArrayList<ProductsEntity> shoppingCartEntity = new ArrayList<ProductsEntity>();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recycviewInvoiceProductShoppingCart.setLayoutManager(mLayoutManager);
        recycviewInvoiceProductShoppingCart.setItemAnimator(new DefaultItemAnimator());

        invoiceShoppingCartAdapter = new InvoiceShoppingCartAdapter(this,shoppingCartEntity);

        shoppingCartEntity.add(new ProductsEntity("18R35A","18R35A",10,50,50,0,0.0));
        shoppingCartEntity.add(new ProductsEntity("18R35A","18R35A",10,50,50,0,0.0));
        shoppingCartEntity.add(new ProductsEntity("18R35A","318R35A",10,50,50,0,0.0));
        shoppingCartEntity.add(new ProductsEntity("18R35A","18R35A",10,50,50,0,0.0));
        recycviewInvoiceProductShoppingCart.setAdapter(invoiceShoppingCartAdapter);
    }

}
