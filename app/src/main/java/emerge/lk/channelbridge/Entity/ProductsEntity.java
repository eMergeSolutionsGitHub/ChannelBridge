package emerge.lk.channelbridge.Entity;

/**
 * Created by Himanshu on 1/5/2017.
 */

public class ProductsEntity {

    String productCode, productBatch, productExpiryDate,productDiscription,productStock,productRetailPrice,productSellingPrice;
    String invoicesNumber, invoicesDate;
    String productCatagory;


    public ProductsEntity(String productCode, String productBatch, String productExpiryDate, String productDiscription, String productStock, String productRetailPrice, String productSellingPrice) {
        this.productCode = productCode;
        this.productBatch = productBatch;
        this.productExpiryDate = productExpiryDate;
        this.productDiscription = productDiscription;
        this.productStock = productStock;
        this.productRetailPrice = productRetailPrice;
        this.productSellingPrice = productSellingPrice;
    }

    public ProductsEntity(String invoicesNumber, String invoicesDate, String productCode, String productBatch, String productExpiryDate) {
        this.invoicesNumber = invoicesNumber;
        this.invoicesDate = invoicesDate;
        this.productCode = productCode;
        this.productBatch = productBatch;
        this.productExpiryDate = productExpiryDate;
    }

    public ProductsEntity(String productCatagory) {
        this.productCatagory = productCatagory;
    }

    public String getProductDiscription() {
        return productDiscription;
    }

    public void setProductDiscription(String productDiscription) {
        this.productDiscription = productDiscription;
    }

    public String getProductStock() {
        return productStock;
    }

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }

    public String getProductRetailPrice() {
        return productRetailPrice;
    }

    public void setProductRetailPrice(String productRetailPrice) {
        this.productRetailPrice = productRetailPrice;
    }

    public String getProductSellingPrice() {
        return productSellingPrice;
    }

    public void setProductSellingPrice(String productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    public String getInvoicesNumber() {
        return invoicesNumber;
    }

    public void setInvoicesNumber(String invoicesNumber) {
        this.invoicesNumber = invoicesNumber;
    }

    public String getInvoicesDate() {
        return invoicesDate;
    }

    public void setInvoicesDate(String invoicesDate) {
        this.invoicesDate = invoicesDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductBatch() {
        return productBatch;
    }

    public void setProductBatch(String productBatch) {
        this.productBatch = productBatch;
    }

    public String getProductExpiryDate() {
        return productExpiryDate;
    }

    public void setProductExpiryDate(String productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    public String getProductCatagory() {
        return productCatagory;
    }

    public void setProductCatagory(String productCatagory) {
        this.productCatagory = productCatagory;
    }
}
