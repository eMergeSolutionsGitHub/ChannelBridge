package emerge.lk.channelbridge.Entity;

/**
 * Created by Himanshu on 1/5/2017.
 */

public class ItineraryLastInvoiceEntity {

    String itineraryLastInvoiceNum, itineraryLastInvoiceValue, itineraryLastInvoiceDueDate;

    public ItineraryLastInvoiceEntity(String itineraryLastInvoiceNum, String itineraryLastInvoiceValue, String itineraryLastInvoiceDueDate) {
        this.itineraryLastInvoiceNum = itineraryLastInvoiceNum;
        this.itineraryLastInvoiceValue = itineraryLastInvoiceValue;
        this.itineraryLastInvoiceDueDate = itineraryLastInvoiceDueDate;
    }

    public String getItineraryLastInvoiceNum() {
        return itineraryLastInvoiceNum;
    }

    public void setItineraryLastInvoiceNum(String itineraryLastInvoiceNum) {
        this.itineraryLastInvoiceNum = itineraryLastInvoiceNum;
    }

    public String getItineraryLastInvoiceValue() {
        return itineraryLastInvoiceValue;
    }

    public void setItineraryLastInvoiceValue(String itineraryLastInvoiceValue) {
        this.itineraryLastInvoiceValue = itineraryLastInvoiceValue;
    }

    public String getItineraryLastInvoiceDueDate() {
        return itineraryLastInvoiceDueDate;
    }

    public void setItineraryLastInvoiceDueDate(String itineraryLastInvoiceDueDate) {
        this.itineraryLastInvoiceDueDate = itineraryLastInvoiceDueDate;
    }
}
