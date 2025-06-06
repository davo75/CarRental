/*
 The Vehicle class stores information about a vehicle's details including fuel 
 statistics, journey details, service details and types of rentals.
 
 @author David Pyle 041110777
 @version 1.0
 @since 11/4/2016
  
 Methods:
    + void kmRental(double numKm)
    + void dayRental(double numKm, int numDays)
    + void addService(Service aService)
    + int getNumberOfServices()
    + double getTotalRevenue()
    + void addJourney(Journey aJourney)
    + void payRental()
    + void addFuelPurchase(FuelPurchase fuel)
    + double getAvgFuelCost()
    + boolean dueForService()
    + int kmSinceLastService()
    + String print()
    + String getManufacturer()
    + void setManufacturer(String manufacturer)
    + String getModel()
    + void setModel(String model)
    + int getYearBuilt()
    + void setYearBuilt(int yearBuilt)
    + int getTotalKmTravelled()
    + double getTotalFuelCost()
    + double getFuelEconomy()

Classes this class requires    
    java.text.DecimalFormat;
    java.util.ArrayList;

 */
package carrental;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Vehicle {

    //vehicle manufacturer
    private String manufacturer;
    //vehicle model
    private String model;
    //vehicle year of manufacturer
    private int yearBuilt;
    
    //total kilometres travelled by the vehicle
    private int totalKmTravelled;
    //total cost of fuel for the vehicle
    private double totalFuelCost;
    //total amount of fuel in litres used by the vehicle
    private double totalFuelLitres;
    //total revenue generated by a vehicle rental
    private double rentalRevenue;
    
    //total revenue generated by vehicle over all rentals
    public double vehicleTotalRevenue;
    
    //number of services performed on the vehicle
    private int numServices;
    //service interval rate (every 100km)
    private static final int SERVICE_DUE_KM = 100;

    //list of journeys for the vehicle
    private ArrayList<Journey> journeys;
    //list of fuel purchases for the vehicle
    private ArrayList<FuelPurchase> fuelPurchases;
    //list of services done on the vehicle
    private ArrayList<Service> services;

    //Per kilometre rental type
    private PerKmRental kmRental;
    //Per day rental type
    private PerDayRental dayRental;

    /**
     * Constructor
     *
     * Initialise vehicle to default state of empty or zero values
     */
    public Vehicle() {
        //initialise manufacturer, model and year built
        this.manufacturer = "";
        this.model = "";
        this.yearBuilt = 0;

        //initialise total km travelled
        this.totalKmTravelled = 0;

        //initialise fuel cost and litres used
        this.totalFuelCost = 0;
        this.totalFuelLitres = 0;

        //initialise rental revenue and total revenue over vehicle's lifetime
        this.rentalRevenue = 0;
        this.vehicleTotalRevenue = 0;

        //initialise number of services
        this.numServices = 0;

        //set up journey, fuel purchase and services lists
        journeys = new ArrayList<>();
        fuelPurchases = new ArrayList<>();
        services = new ArrayList<>();
    }

    /**
     * Constructor
     * 
     * Sets the vehicle manufacturer, model and year built
     *
     * @param manufacturer vehicle manufacturer
     * @param model vehicle model
     * @param yearBuilt vehicle's year of manufacturer
     */
    public Vehicle(String manufacturer, String model, int yearBuilt) {
        //call default constructor
        this();
        //set manfacturer, model and year built
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearBuilt = yearBuilt;
    }

    /**
     * Copy Constructor
     * 
     * Makes a copy of an existing vehicle
     *
     * @param vehicleCopy vehicle to copy
     */
    public Vehicle(Vehicle vehicleCopy) {

        //copy the manufacturer, model and year built
        this.manufacturer = vehicleCopy.manufacturer;
        this.model = vehicleCopy.model;
        this.yearBuilt = vehicleCopy.yearBuilt;

        //copy total kilometres travelled, fuel cost and total litres
        this.totalKmTravelled = vehicleCopy.totalKmTravelled;
        this.totalFuelCost = vehicleCopy.totalFuelCost;
        this.totalFuelLitres = vehicleCopy.totalFuelLitres;

        //copy the number of services
        this.numServices = vehicleCopy.numServices;

        //copy the journey, fuel purchases and services lists. New lists are
        //created so modifications to the copied vehicle don't affect the
        //original object.
        this.journeys = new ArrayList<>(vehicleCopy.journeys);
        this.fuelPurchases = new ArrayList<>(vehicleCopy.fuelPurchases);
        this.services = new ArrayList<>(vehicleCopy.services);
        
        //copy the overall revenue for the vehicle
        this.vehicleTotalRevenue = vehicleCopy.vehicleTotalRevenue;

        //determine rental type
        String rentalType = "";

        //if rental type is a kilometre type then copy the rental and revenue details
        if (vehicleCopy.kmRental != null) {
            rentalType = "KM RENTAL";
            this.kmRental = new PerKmRental(vehicleCopy.kmRental.getNumKm());
            this.kmRental.setActualKmForRental(vehicleCopy.kmRental.getActualKmForRental());
            this.rentalRevenue = this.kmRental.getKmRentalRevenue();
        //else if rental type is a day rental then copy the rental and revenue details
        } else if (vehicleCopy.dayRental != null) {
            rentalType = "DAY RENTAL";
            this.dayRental = new PerDayRental(vehicleCopy.dayRental.getNumKms(),
                                             vehicleCopy.dayRental.getNumDays());
            this.dayRental.setActualDaysRented(vehicleCopy.dayRental.getActualDaysRented());
            this.rentalRevenue = this.dayRental.getDayRentalRevenue();
        }
        System.out.println("\nBelow is a COPY of the " + rentalType + " " + manufacturer + " " + model);
    }

    /**
     * Creates a new Kilometre rental only if the vehicle isn't due for a
     * service.
     *
     * @param numKm the number of kilometres the rental is booked for
     */
    public void kmRental(double numKm) {

        //check if the vehicle is due for a service
        if (dueForService()) {
            System.out.println("Rental vehicle not available. Needs to be serviced\n");
        } else {
            //create the rental
            this.kmRental = new PerKmRental(numKm);
        }
    }

    /**
     * Creates a new Day rental only if the vehicle isn't due for a service.
     *
     * @param numKm the number of kilometres the rental is booked for
     * @param numDays the number of days the rental is booked for
     */
    public void dayRental(double numKm, int numDays) {

        //check if the vehicle is due for a service
        if (dueForService()) {
            System.out.println("Rental vehicle not available. Needs to be serviced\n");
        } else {
            //create the rental
            this.dayRental = new PerDayRental(numKm, numDays);
        }
    }

    /**
     * Adds a new service to the vehicle
     *
     * @param aService the service to add
     */
    public void addService(Service aService) {

        //add the service to the vehicle's service list
        services.add(aService);
        //increment the service counter
        numServices++;
        System.out.println("Vehicle has been serviced!\n");
    }

    /**
     * Gets the number of services performed on the vehicle
     *
     * @return the number of services the vehicle has had
     */
    public int getNumberOfServices() {

        return numServices;
    }

    /**
     * Gets the rental revenue for the vehicle
     *
     * @return the revenue for the rental
     */
    public double getRentalRevenue() {
        return rentalRevenue;
    }

    /**
     * Adds a new journey to the vehicle
     *
     * @param aJourney the journey to add
     */
    public void addJourney(Journey aJourney) {

        //add the journey to the vehicle's journey list
        journeys.add(aJourney);
        //update the total kilometres done by the vehicle
        this.totalKmTravelled += aJourney.getNumKmForJourney();

        //if the rental type is a km rental
        if (kmRental != null) {
            //update the rental's number of km
            kmRental.setActualKmForRental(aJourney.getNumKmForJourney());
            //update the rental's revenue based on the km travelled
            this.rentalRevenue = kmRental.getKmRentalRevenue();
            //else if the rental type is a day rental
        } else if (dayRental != null) {
            //update the days the vehicle has rented for. Note: One journey = one day.
            dayRental.setActualDaysRented(dayRental.getActualDaysRented() + 1);
            //update the rental revenue based on the number of days rented
            this.rentalRevenue = dayRental.getDayRentalRevenue();
        }
    }

    /**
     * Reconciles the rental fees due. 
     * 
     * For km rentals the amount charged is for the actual kilometres travelled,
     * not the number of kilometres set at the time of the booking. For day 
     * rentals the amount charged is for the number of days the vehicle was used
     * for, not the number of days set at the time of the booking.
     */
    public void payRental() {

        //for km rentals
        if (kmRental != null) {
            //update the total revenue for the vehicle
            this.vehicleTotalRevenue += kmRental.getKmRentalRevenue();
            //if the actual km travelled is less than the inital km at the time of booking then display discount message
            if (kmRental.getActualKmForRental() < kmRental.getNumKm()) {
                System.out.println("Discount! The number of kilometres driven was less then original rental kilometres. You will only be charged for " + kmRental.getActualKmForRental() + "km");
            //else the actual km was more than the initial booking amount so display the extra charge message
            } else if (kmRental.getActualKmForRental() > kmRental.getNumKm()) {
                System.out.println("Extra Charge! The number of kilometres driven was more than original rental kilometres. You will be charged for " + kmRental.getActualKmForRental() + "km");
            }
            //reset the rental
            kmRental = null;
            //for day rentals
        } else if (dayRental != null) {
            //update the total revenue for the vehicle
            this.vehicleTotalRevenue += dayRental.getDayRentalRevenue();
            //if the actual days used is less than the inital days set at the time of booking then display discount message
            if (dayRental.getActualDaysRented() < dayRental.getNumDays()) {
                System.out.println("Discount! Days rented was less then original rental days. You will only be charged for " + dayRental.getActualDaysRented() + " day(s)");
                //else the actual number of days was more than the initial number of days at the booking so display the extra charge message
            } else if (dayRental.getActualDaysRented() > dayRental.getNumDays()) {
                System.out.println("Extra Charge! Days rented was more then original rental days. You will be charged for " + dayRental.getActualDaysRented() + " day(s)");
            }
            //reset the rental
            dayRental = null;
        }

    }

    /**
     * Adds a new fuel purchase for the vehicle
     *
     * @param fuel the fuel purchase to add
     */
    public void addFuelPurchase(FuelPurchase fuel) {
        //add the fuel purchase to the vehicle's list of fuel purchases
        fuelPurchases.add(fuel);
        //update the amount of fuel (litres) used
        this.totalFuelLitres += fuel.getAmountFuelLitres();
        //update the total fuel cost
        this.totalFuelCost += fuel.getFuelCost();
    }

    /**
     * Gets the average fuel cost for the vehicle
     *
     * @return the average fuel cost for the vehicle
     */
    public double getAvgFuelCost() {
        //avoid division by zero if no fuel has been purchased yet
        if (totalFuelLitres == 0) {
            return 0;
        }
        //calculate average fuel cost
        return totalFuelCost / totalFuelLitres;
    }

    /**
     * Determines if the vehicle is due for a service
     *
     * @return true if due for a service, false if not
     */
    public boolean dueForService() {

        //service is required once the distance since the last service reaches
        //the service interval
        return kmSinceLastService() >= SERVICE_DUE_KM;
    }

    /**
     * Determines the number of km since the vehicle's last service
     *
     * @return the number km since the last service
     */
    public int kmSinceLastService() {
        //if no services have been done just return the km travelled so far
        if (numServices == 0) {
            return totalKmTravelled;
            //else return the number of km done since the last service
        } else {
            return totalKmTravelled - services.get((numServices - 1)).getKmAtTimeOfService();
        }
    }

    /**
     * Displays the vehicle's current state.
     *
     * @return the vehicle's state
     */
    public String print() {

        //set up the format for decimal values
        DecimalFormat df1 = new DecimalFormat("0.0"); //one decimal place
        DecimalFormat df2 = new DecimalFormat("0.00"); //two decimal places
        //initialise vehicle status
        String vehicleStatus = "";

        //get the vehicle manufacturer, model and year built
        vehicleStatus += "Vehicle: " + this.manufacturer + "\n";
        vehicleStatus += "Model: " + this.model + "\n";
        vehicleStatus += "Year Built: " + this.yearBuilt + "\n";

        //get the number of services message
        if (numServices == 0) {
            vehicleStatus += "No services have been recorded for this vehicle. ";
            if (totalKmTravelled > 0) {
                vehicleStatus += "It should have undergone " + this.totalKmTravelled/SERVICE_DUE_KM  + " service(s).\n";
            } else {
                vehicleStatus += "\n";
            }
       
        } else {
            vehicleStatus += "Number of services: " + this.getNumberOfServices() + "\n";
            vehicleStatus += "Kilometers since last service: " + this.kmSinceLastService() + "\n";
        }

        //get the total km travelled message
        if (totalKmTravelled == 0) {
            vehicleStatus += "No travel has been recorded yet.\n";
        } else {
            vehicleStatus += "Total Kilometres travelled: " + this.totalKmTravelled + "\n";
        }

        //get the fuel stats message
        if (totalFuelCost == 0) {
            vehicleStatus += "No fuel has been purchased yet.\n";
        } else {
            vehicleStatus += "Fuel Economy: " + df1.format(getFuelEconomy()) + " Litres/100km\n";
            vehicleStatus += "Average Fuel Cost: $" + df2.format(getAvgFuelCost()) + " per litre\n";
        }        
        
        //get the vehicle revenue stats message
        vehicleStatus += "Revenue for this rental: $" + df2.format(this.rentalRevenue) + "\n";
        vehicleStatus += "Overall Revenue for this vehicle: $" + df2.format(this.vehicleTotalRevenue) + "\n";
        
        //return the vehicle status
        return vehicleStatus;
    }

    /**
     * Get the vehicle manufacturer
     *
     * @return the vehicle's manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }
    
    /**
     * Set the vehicle manufacturer
     *
     * @param manufacturer the vehicle's manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Get the vehicle model
     *
     * @return the vehicle's model
     */
    public String getModel() {
        return model;
    }

      /**
     * Set the vehicle model
     *
     * @param   model the vehicle's model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Get the vehicle year of manufacturer
     *
     * @return the vehicle's year of manufacturer
     */
    public int getYearBuilt() {
        return yearBuilt;
    }
    
    /**
     * Set the vehicle year of manufacturer
     * 
     * @param yearBuilt the vehicle's year of manufacturer
     */
    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    /**
     * Get the vehicle's total km travelled
     *
     * @return the vehicle's total km travelled
     */
    public int getTotalKmTravelled() {
        return totalKmTravelled;
    }

    /**
     * Get the vehicle's total fuel cost
     *
     * @return the vehicle's total fuel cost
     */
    public double getTotalFuelCost() {
        return totalFuelCost;
    }

    /**
     * Get the vehicle's fuel economy (litres per 100km)
     *
     * @return the vehicle's fuel economy
     */
    public double getFuelEconomy() {
        //avoid division by zero if the vehicle has not travelled yet
        if (totalKmTravelled == 0) {
            return 0;
        }
        //calculate the fuel economy
        return (totalFuelLitres * 100) / totalKmTravelled;
    }

}
