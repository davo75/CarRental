/*
 The CarRental class acts a test class by creating vehicle objects, renting 
 vehicles, adding journeys, services and fuel purchases.
 
 @author David Pyle 041110777
 @version 1.0
 @since 11/4/2016
  
 Methods:
    + static void main(String[] args)

Classes this class requires    
    java.util.Date;

 */
package carrental;

import java.util.Date;

public class CarRental {

    /**
     * Main method is responsible for creating vehicle objects and calling
     * various methods for the purpose of testing the application.
     *
     * @param args none
     */
    public static void main(String[] args) {

        /* TEST 1 
         * Create a vehicle, show it's inital state then add two journeys and 
         * two fuel purchases and show it's state again
         *
         * Vehicle state after test should be:
         * Number of Services = 0, should have done 2.
         * Km Travelled = 250km
         * Fuel Economy = 60L/100km
         * Average Fuel Cost = $1.52
         * No revenue as no rentals were requested
         */
 
        System.out.println("***TEST 1***\n");

        //create a new vehicle
        Vehicle excel = new Vehicle("Hyundai", "Excel", 2014);
        //print the initial state of the vehicle
        System.out.println(excel.print());
        
        //add a journey of 150km
        Journey journey0 = new Journey(150);
        //journey0.setNumKmForJourney(150);
        excel.addJourney(journey0);

        //add a fuel purchase of 100L @ 123.78	
        FuelPurchase fp01 = new FuelPurchase(100, 123.78);
        excel.addFuelPurchase(fp01);
        //add a fuel purchase of 50L @ 103.78	
        FuelPurchase fp02 = new FuelPurchase(50, 103.78);
        excel.addFuelPurchase(fp02);

        //add a journey of 100km
        Journey journey01 = new Journey(100);
        //journey01.setNumKmForJourney(100);
        excel.addJourney(journey01);

        //print the state of the vehicle
        System.out.println(excel.print());

        System.out.println("***END OF TEST 1***\n");

        /* END OF TEST 1 */
        
        
        /* TEST 2 
         * Create a new vehicle, show initial state, request km rental of 250km,
         * add two journeys totalling 270km, pay for the rental, show vehicle state.
         *
         * Vehicle state after test should be:
         * Number of Services = 0
         * Km Travelled = 270km
         * Fuel Economy = 0
         * Average Fuel Cost = 0
         * Revenue for the rental = $270
         * Total revenue for the vehicle = $270
         */
        System.out.println("***TEST 2***\n");

        //add a new vehicle
        Vehicle corolla = new Vehicle("Toyota", "Corolla", 2014);
        //print out details - should be no recorded travel or fuel purchases
        System.out.println("***New Vehicle created in initial state***");
        System.out.println(corolla.print());

        //request Km rental of 250km
        System.out.println("***Attempt a km rental of 250km***");
        //attempt a km rental of 250km - should be ok 
        corolla.kmRental(250);

        //add a journey of 150km
        System.out.println("***Adding Journey of 150km***");
        //add 2 journeys - one for 150km and another for 100km       
        Journey journey1 = new Journey(150);
        //journey1.setNumKmForJourney(150);
        corolla.addJourney(journey1);

        //add a journey of 120km
        System.out.println("***Adding Journey of 120km***");
        Journey journey2 = new Journey(120);
        //journey2.setNumKmForJourney(120);
        corolla.addJourney(journey2);

        //pay for the rental
        System.out.println("***Paying for the rental***");
        corolla.payRental();

        //show the vehicle state
        System.out.println("***State of vehicle after rental***");
        System.out.println(corolla.print());

        System.out.println("***END OF TEST 2***\n");

        /* END OF TEST 2 */
        
        /* TEST 3 
         * Using the same vehicle from Test 2 request km rental of 300km.
         *
         * An error message should be displayed stating the vehicle is due for 
         * a service so can't be rented
         */
        System.out.println("***TEST 3***\n");

        System.out.println("***Attempting a rental of 300km***");
        //vehicle is now due for a service so another rental attempt will fail        
        corolla.kmRental(300);

        System.out.println("***END OF TEST 3***\n");

        /* END OF TEST 3 */
        
        /* TEST 4 
         * Using the same vehicle from Test 3 perform a service and attempt km
         * rental of 300km again, add two journeys totalling 95km, add two fuel
         * purchases, pay for the rental, show state of vehicle.
         *
         * Vehicle state after test should be:
         * Number of Services = 1
         * Km since last service = 95
         * Km Travelled = 365
         * Fuel Economy = 68.5L/100km
         * Average Fuel Cost = $0.82
         * Revenue for the rental = $95.00
         * Total revenue for the vehicle = $365.00
         */
        System.out.println("***TEST 4***\n");

        //perform a service
        corolla.addService(new Service("Basic", new Date(), corolla.getTotalKmTravelled()));

        //attempt rental again
        System.out.println("***Attempting the rental of 300km again now the vehicle has been serviced***");
        corolla.kmRental(300);

        //add a journey of 50km        
        System.out.println("***Adding Journey of 50km***");
        Journey journey3 = new Journey(50);
        //journey3.setNumKmForJourney(50);
        corolla.addJourney(journey3);

        //add a fuel purchase of 100L @ 123.78
        System.out.println("***Adding fuel purchase of 100L @ 123.78***");
        FuelPurchase fp1 = new FuelPurchase(100, 123.78);
        corolla.addFuelPurchase(fp1);

        //add a journey of 45km  
        System.out.println("***Adding Journey of 45km***");
        Journey journey4 = new Journey(45);
        //journey4.setNumKmForJourney(45);
        corolla.addJourney(journey4);

        //add a fuel purchase of 150L @ 80.00
        System.out.println("***Adding fuel purchase of 150L @ 80.00***");
        FuelPurchase fp2 = new FuelPurchase(150, 80);
        corolla.addFuelPurchase(fp2);

        //pay for the rental
        corolla.payRental();
        System.out.println("***Rental returned. Only 95km were driven not the expectd 300km. Total revenue will only be $95 and vehicle can be rented again as km driven didnt exceed 100km***");
        //display state of vehicle
        System.out.println(corolla.print());

        System.out.println("***END OF TEST 4***\n");

        /* END OF TEST 4 */
        
        /* TEST 5 
         * Using the same vehicle from Test 4 attempt Day rental for 3 days and 
         * 600km, add two journeys (i.e 2 days) totalling 600km, pay for the 
         * rental, show state of vehicle.
         *
         * A discount message will be displayed because the rental was only for
         * 2 days and not for 3 days.
         *
         * Vehicle state after test should be:
         * Number of Services = 1
         * Km since last service = 695
         * Km Travelled = 995km
         * Fuel Economy = 25.9L/100km
         * Average Fuel Cost = $0.82
         * Revenue for the rental = $200
         * Total revenue for the vehicle = $565.00
         */
        System.out.println("***TEST 5***\n");

        //attempt Day rental for 3 days and 600km
        System.out.println("***Attempt Day Rental of same vehicle for 3 days");
        corolla.dayRental(600, 3);

        //add a journey of 200km
        System.out.println("***Adding Journey of 200km***");
        Journey journey5 = new Journey(200);
        //journey5.setNumKmForJourney(200);
        corolla.addJourney(journey5);

        //add a journey of 400km
        System.out.println("***Adding Journey of 400km***");
        Journey journey6 = new Journey(400);
        //journey6.setNumKmForJourney(400);
        corolla.addJourney(journey6);

        //pay for the rental
        System.out.println("***Paying for the rental***");
        corolla.payRental();
        //display vehicle state
        System.out.println(corolla.print());

        System.out.println("***END OF TEST 5***\n");

        /* END OF TEST 5 */
        
        /* TEST 6
         * Using the same vehicle from Test 5 attempt Day rental for 2 days and 
         * 200km.
         *
         * An error message should be displayed stating the vehicle is due for 
         * a service so can't be rented
         */
        System.out.println("***TEST 6***\n");

        System.out.println("***Attempting another day rental - vehicle needs a service so should fail***");
        corolla.dayRental(300, 2);

        System.out.println("***END OF TEST 6***\n");

        /* END OF TEST 6 */
 
        /* TEST 7 
         * Using the same vehicle from Test 6 perform a service, attempt day rental
         * of 2 days and 300km again, add 3 journeys totalling 500km, add 2 fuel
         * purchases, pay for the rental and display vehicle state.
         *
         * A extra charge message will be displayed because the rental was for
         * 3 days (3 journeys) and not for the initial 2 days.
         *
         * Vehicle state after test should be:
         * Number of Services = 2
         * Km since last service = 500
         * Km Travelled = 1465
         * Fuel Economy = 29.4L/100km
         * Average Fuel Cost = $1.06
         * Revenue for the rental = $300
         * Total revenue for the vehicle = $865.00
         */
        System.out.println("***TEST 7***\n");

        //do a service
        corolla.addService(new Service("Basic", new Date(), corolla.getTotalKmTravelled()));
        System.out.println("***Attempting the rental again now the vehicle has been serviced***");
        corolla.dayRental(300, 2);

        //add a journey of 100km (1 day)
        System.out.println("***Adding Journey of 100km***");
        Journey journey7 = new Journey(100);
        //journey7.setNumKmForJourney(100);
        corolla.addJourney(journey7);

        //add a journey of 200km (2 days)
        System.out.println("***Adding Journey of 100km***");
        Journey journey8 = new Journey(200);
        //journey8.setNumKmForJourney(200);
        corolla.addJourney(journey8);

        //add a journey of 200km (3 days)
        System.out.println("***Adding Journey of 200km***");
        Journey journey9 = new Journey(200);
        //journey9.setNumKmForJourney(200);
        corolla.addJourney(journey9);
        
        //add a fuel purchase of 100L @ 139.60
        System.out.println("***Adding fuel purchase of 100L @ 139.60***");
        FuelPurchase fp3 = new FuelPurchase(100, 139.60);
        corolla.addFuelPurchase(fp3);
        
        //add a fuel purchase of 80L @ 110.56
        System.out.println("***Adding fuel purchase of 80L @ 110.56***");
        FuelPurchase fp4 = new FuelPurchase(80, 110.56);
        corolla.addFuelPurchase(fp4);

        //pay for the rental
        System.out.println("***Paying for the rental***");
        corolla.payRental();

        //display vehicle state
        System.out.println(corolla.print());

        System.out.println("***END OF TEST 7***\n");

        /* END OF TEST 7 */
       
           
        /* TEST 8 
         * Create a copy of the Toyota Corollo 2014 vehicle using the copy constructor.
         *
         * Vehicle state after test should be:
         * Number of Services = 2
         * Km since last service = 500
         * Km Travelled = 1465
         * Fuel Economy = 29.4L/100km
         * Average Fuel Cost = $1.06
         * Revenue for the rental = $300
         * Total revenue for the vehicle = $865.00
         */
        
        System.out.println("***TEST 8***\n");
        
        System.out.println("***Making a copy of the Corollo vehicle***");
	//make a copy of the corolla vehicle
	Vehicle corollaCopy = new Vehicle(corolla);	
	System.out.println(corollaCopy.print());
        
        System.out.println("***END OF TEST 8***\n");

    }

}
