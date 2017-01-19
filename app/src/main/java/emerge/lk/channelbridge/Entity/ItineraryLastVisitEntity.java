package emerge.lk.channelbridge.Entity;

/**
 * Created by Himanshu on 1/5/2017.
 */

public class ItineraryLastVisitEntity {

    String itineraryLastVisitCustomerNumber, itineraryLastVisitInvoicesDate;
    int itineraryLastVisitOnRoute;

    public ItineraryLastVisitEntity(String itineraryLastVisitCustomerNumber, String itineraryLastVisitInvoicesDate, int itineraryLastVisitOnRoute) {
        this.itineraryLastVisitCustomerNumber = itineraryLastVisitCustomerNumber;
        this.itineraryLastVisitInvoicesDate = itineraryLastVisitInvoicesDate;
        this.itineraryLastVisitOnRoute = itineraryLastVisitOnRoute;
    }

    public String getItineraryLastVisitCustomerNumber() {
        return itineraryLastVisitCustomerNumber;
    }

    public void setItineraryLastVisitCustomerNumber(String itineraryLastVisitCustomerNumber) {
        this.itineraryLastVisitCustomerNumber = itineraryLastVisitCustomerNumber;
    }

    public String getItineraryLastVisitInvoicesDate() {
        return itineraryLastVisitInvoicesDate;
    }

    public void setItineraryLastVisitInvoicesDate(String itineraryLastVisitInvoicesDate) {
        this.itineraryLastVisitInvoicesDate = itineraryLastVisitInvoicesDate;
    }

    public int getItineraryLastVisitOnRoute() {
        return itineraryLastVisitOnRoute;
    }

    public void setItineraryLastVisitOnRoute(int itineraryLastVisitOnRoute) {
        this.itineraryLastVisitOnRoute = itineraryLastVisitOnRoute;
    }
}
