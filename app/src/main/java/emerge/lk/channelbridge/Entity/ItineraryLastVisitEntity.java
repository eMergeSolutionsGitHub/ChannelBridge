package emerge.lk.channelbridge.Entity;

/**
 * Created by Himanshu on 1/5/2017.
 */

public class ItineraryLastVisitEntity {

String itineraryCreditInvoicesNum,itineraryCreditInvoicesDate,itineraryCreditInvoicesTotvalue,itineraryCreditInvoicesBalance;


    public ItineraryLastVisitEntity(String itineraryCreditInvoicesNum, String itineraryCreditInvoicesDate, String itineraryCreditInvoicesTotvalue, String itineraryCreditInvoicesBalance) {
        this.itineraryCreditInvoicesNum = itineraryCreditInvoicesNum;
        this.itineraryCreditInvoicesDate = itineraryCreditInvoicesDate;
        this.itineraryCreditInvoicesTotvalue = itineraryCreditInvoicesTotvalue;
        this.itineraryCreditInvoicesBalance = itineraryCreditInvoicesBalance;
    }


    public String getItineraryCreditInvoicesNum() {
        return itineraryCreditInvoicesNum;
    }

    public void setItineraryCreditInvoicesNum(String itineraryCreditInvoicesNum) {
        this.itineraryCreditInvoicesNum = itineraryCreditInvoicesNum;
    }

    public String getItineraryCreditInvoicesDate() {
        return itineraryCreditInvoicesDate;
    }

    public void setItineraryCreditInvoicesDate(String itineraryCreditInvoicesDate) {
        this.itineraryCreditInvoicesDate = itineraryCreditInvoicesDate;
    }

    public String getItineraryCreditInvoicesTotvalue() {
        return itineraryCreditInvoicesTotvalue;
    }

    public void setItineraryCreditInvoicesTotvalue(String itineraryCreditInvoicesTotvalue) {
        this.itineraryCreditInvoicesTotvalue = itineraryCreditInvoicesTotvalue;
    }

    public String getItineraryCreditInvoicesBalance() {
        return itineraryCreditInvoicesBalance;
    }

    public void setItineraryCreditInvoicesBalance(String itineraryCreditInvoicesBalance) {
        this.itineraryCreditInvoicesBalance = itineraryCreditInvoicesBalance;
    }
}
