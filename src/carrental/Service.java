/*
 The Service class stores the service details for a vehicle.
 
 @author David Pyle 041110777
 @version 1.0
 @since 11/4/2016
  
 Methods:
    + String getServiceType()
    + void setServiceType(String serviceType)
    + Date getServiceDate()
    + void setServiceDate(Date serviceDate)
    + int getKmAtTimeOfService()
 */
package carrental;

import java.util.Date;

/**
 *
 * @author 041110777
 */
public class Service {

    //the type of service e.g. Basic, Major
    private String serviceType;
    //the date the service was performed
    private Date serviceDate;
    //the number of kilometers recorded at the time of the service
    private int kmAtTimeOfService;

    /**
     * Constructor 
     *
     * @param serviceType the type of service
     * @param serviceDate the date of the service
     * @param kmAtTimeOfService the number of km for the vehicle at the time of
     * the service
     */
    public Service(String serviceType, Date serviceDate, int kmAtTimeOfService) {
        
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.kmAtTimeOfService = kmAtTimeOfService;
    }

    /**
     * Gets the type of service
     *
     * @return the type of service e.g. Basic, Major
     */
    public String getServiceType() {
        
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        
        this.serviceType = serviceType;
    }

    /**
     * Gets the date of service
     *
     * @return the date the service was performed
     */
    public Date getServiceDate() {
        
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        
        this.serviceDate = serviceDate;
    }

    /**
     * Gets the number of km at the time of the service
     *
     * @return the number of kilometers the service was performed at
     */
    public int getKmAtTimeOfService() {
        
        return kmAtTimeOfService;
    }

}
