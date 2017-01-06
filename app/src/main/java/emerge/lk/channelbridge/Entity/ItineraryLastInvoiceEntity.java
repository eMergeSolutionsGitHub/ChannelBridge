package emerge.lk.channelbridge.Entity;

/**
 * Created by Himanshu on 1/5/2017.
 */

public class ItineraryLastInvoiceEntity {

    String itineraryLastInvoiceID, itineraryLastInvoiceValue, itineraryLastInvoiceDueDate;

    public ItineraryLastInvoiceEntity(String itineraryLastInvoiceID, String itineraryLastInvoiceValue, String itineraryLastInvoiceDueDate) {
        this.itineraryLastInvoiceID = itineraryLastInvoiceID;
        this.itineraryLastInvoiceValue = itineraryLastInvoiceValue;
        this.itineraryLastInvoiceDueDate = itineraryLastInvoiceDueDate;
    }

    public String getItineraryLastInvoiceID() {
        return itineraryLastInvoiceID;
    }

    public void setItineraryLastInvoiceID(String itineraryLastInvoiceID) {
        this.itineraryLastInvoiceID = itineraryLastInvoiceID;
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
