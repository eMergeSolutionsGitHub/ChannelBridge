package emerge.lk.channelbridge.Entity;

/**
 * Created by Himanshu on 1/5/2017.
 */

public class CustomersEntity {
//
String itineraryCustomersID,itineraryCustomersName,itineraryCustomersCity,itineraryCustomersImageName;

    public String getItineraryCustomersID() {
        return itineraryCustomersID;
    }

    public void setItineraryCustomersID(String itineraryCustomersID) {
        this.itineraryCustomersID = itineraryCustomersID;
    }

    public String getItineraryCustomersName() {
        return itineraryCustomersName;
    }

    public void setItineraryCustomersName(String itineraryCustomersName) {
        this.itineraryCustomersName = itineraryCustomersName;
    }

    public String getItineraryCustomersCity() {
        return itineraryCustomersCity;
    }

    public void setItineraryCustomersCity(String itineraryCustomersCity) {
        this.itineraryCustomersCity = itineraryCustomersCity;
    }

    public String getItineraryCustomersImageName() {
        return itineraryCustomersImageName;
    }

    public void setItineraryCustomersImageName(String itineraryCustomersImageName) {
        this.itineraryCustomersImageName = itineraryCustomersImageName;
    }

    public CustomersEntity(String itineraryCustomersID, String itineraryCustomersName, String itineraryCustomersCity, String itineraryCustomersImageName) {
        this.itineraryCustomersID = itineraryCustomersID;
        this.itineraryCustomersName = itineraryCustomersName;
        this.itineraryCustomersCity = itineraryCustomersCity;
        this.itineraryCustomersImageName = itineraryCustomersImageName;
    }
}
