package emerge.lk.channelbridge.Entity;

/**
 * Created by Himanshu on 1/5/2017.
 */

public class ItineraryExpiryProductsEntity {

String itineraryExpiryInvoicesNum,itineraryExpiryInvoicesDate,itineraryExpiryProduct,itineraryExpiryBatch,itineraryExpiryDate;


    public ItineraryExpiryProductsEntity(String itineraryExpiryInvoicesNum, String itineraryExpiryInvoicesDate, String itineraryExpiryProduct, String itineraryExpiryBatch, String itineraryExpiryDate) {
        this.itineraryExpiryInvoicesNum = itineraryExpiryInvoicesNum;
        this.itineraryExpiryInvoicesDate = itineraryExpiryInvoicesDate;
        this.itineraryExpiryProduct = itineraryExpiryProduct;
        this.itineraryExpiryBatch = itineraryExpiryBatch;
        this.itineraryExpiryDate = itineraryExpiryDate;
    }

    public String getItineraryExpiryInvoicesNum() {
        return itineraryExpiryInvoicesNum;
    }

    public void setItineraryExpiryInvoicesNum(String itineraryExpiryInvoicesNum) {
        this.itineraryExpiryInvoicesNum = itineraryExpiryInvoicesNum;
    }

    public String getItineraryExpiryInvoicesDate() {
        return itineraryExpiryInvoicesDate;
    }

    public void setItineraryExpiryInvoicesDate(String itineraryExpiryInvoicesDate) {
        this.itineraryExpiryInvoicesDate = itineraryExpiryInvoicesDate;
    }

    public String getItineraryExpiryProduct() {
        return itineraryExpiryProduct;
    }

    public void setItineraryExpiryProduct(String itineraryExpiryProduct) {
        this.itineraryExpiryProduct = itineraryExpiryProduct;
    }

    public String getItineraryExpiryBatch() {
        return itineraryExpiryBatch;
    }

    public void setItineraryExpiryBatch(String itineraryExpiryBatch) {
        this.itineraryExpiryBatch = itineraryExpiryBatch;
    }

    public String getItineraryExpiryDate() {
        return itineraryExpiryDate;
    }

    public void setItineraryExpiryDate(String itineraryExpiryDate) {
        this.itineraryExpiryDate = itineraryExpiryDate;
    }
}
