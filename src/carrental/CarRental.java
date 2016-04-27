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
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarRental {

    private static final int NUM_VEHICLES_IN_FLEET = 10;
    //create fleet of 10 vehicles
    private static Vehicle[] fleet; 
    private static int vehicleCount=0;   
    
    /**
     * Main method is responsible for creating vehicle objects and calling
     * various methods for the purpose of testing the application.
     *
     * @param args none
     */
    public static void main(String[] args) {

        /* TO DO 
         * Create a main menu to test Vehicle class
         *
        */
        fleet = new Vehicle[NUM_VEHICLES_IN_FLEET];
        //create a new vehicle
        fleet[0] = new Vehicle("Hyundai", "Excel", 2014);
        vehicleCount++;

        showMainMenu();
        
//        /* TEST 1 
//         * Create a vehicle, show it's inital state thenadd two journeys and 
//         * two fuel purchases and show it's state again
//         *
//         * Vehicle state after test should be:
//         * Number of Services = 0
//         * Km Travelled = 250km
//         * Fuel Economy = 60L/100km
//         * Average Fuel Cost = $1.52
//         * No revenue as no rentals were requested
//         */
// 
//        System.out.println("***TEST 1***\n");
//
//        //create a new vehicle
//        Vehicle excel = new Vehicle("Hyundai", "Excel", 2014);
//        //print the initial state of the vehicle
//        System.out.println(excel.print());
//        
//        //add a journey of 150km
//        Journey journey0 = new Journey();
//        journey0.setNumKmForJourney(150);
//        excel.addJourney(journey0);
//
//        //add a fuel purchase of 100L @ 123.78	
//        FuelPurchase fp01 = new FuelPurchase(100, 123.78);
//        excel.addFuelPurchase(fp01);
//        //add a fuel purchase of 50L @ 103.78	
//        FuelPurchase fp02 = new FuelPurchase(50, 103.78);
//        excel.addFuelPurchase(fp02);
//
//        //add a journey of 100km
//        Journey journey01 = new Journey();
//        journey01.setNumKmForJourney(100);
//        excel.addJourney(journey01);
//
//        //print the state of the vehicle
//        System.out.println(excel.print());
//
//        System.out.println("***END OF TEST 1***\n");
//
//        /* END OF TEST 1 */
//        
//        
//        /* TEST 2 
//         * Create a new vehicle, show initial state, request km rental of 250km,
//         * add two journeys totalling 270km, pay for the rental, show vehicle state.
//         *
//         * Vehicle state after test should be:
//         * Number of Services = 0
//         * Km Travelled = 270km
//         * Fuel Economy = 0
//         * Average Fuel Cost = 0
//         * Revenue for the rental = $270
//         * Total revenue for the vehicle = $270
//         */
//        System.out.println("***TEST 2***\n");
//
//        //add a new vehicle
//        Vehicle corolla = new Vehicle("Toyota", "Corolla", 2014);
//        //print out details - should be no recorded travel or fuel purchases
//        System.out.println("***New Vehicle created in initial state***");
//        System.out.println(corolla.print());
//
//        //request Km rental of 250km
//        System.out.println("***Attempt a km rental of 250km***");
//        //attempt a km rental of 250km - should be ok 
//        corolla.kmRental(250);
//
//        //add a journey of 150km
//        System.out.println("***Adding Journey of 150km***");
//        //add 2 journeys - one for 150km and another for 100km       
//        Journey journey1 = new Journey();
//        journey1.setNumKmForJourney(150);
//        corolla.addJourney(journey1);
//
//        //add a journey of 120km
//        System.out.println("***Adding Journey of 120km***");
//        Journey journey2 = new Journey();
//        journey2.setNumKmForJourney(120);
//        corolla.addJourney(journey2);
//
//        //pay for the rental
//        System.out.println("***Paying for the rental***");
//        corolla.payRental();
//
//        //show the vehicle state
//        System.out.println("***State of vehicle after rental***");
//        System.out.println(corolla.print());
//
//        System.out.println("***END OF TEST 2***\n");
//
//        /* END OF TEST 2 */
//        
//        /* TEST 3 
//         * Using the same vehicle from Test 2 request km rental of 300km.
//         *
//         * An error message should be displayed stating the vehicle is due for 
//         * a service so can't be rented
//         */
//        System.out.println("***TEST 3***\n");
//
//        System.out.println("***Attempting a rental of 300km***");
//        //vehicle is now due for a service so another rental attempt will fail        
//        corolla.kmRental(300);
//
//        System.out.println("***END OF TEST 3***\n");
//
//        /* END OF TEST 3 */
//        
//        /* TEST 4 
//         * Using the same vehicle from Test 3 perform a service and attempt km
//         * rental of 300km again, add two journeys totalling 95km, add two fuel
//         * purchases, pay for the rental, show state of vehicle.
//         *
//         * Vehicle state after test should be:
//         * Number of Services = 1
//         * Km since last service = 95
//         * Km Travelled = 365
//         * Fuel Economy = 68.5L/100km
//         * Average Fuel Cost = $0.82
//         * Revenue for the rental = $95.00
//         * Total revenue for the vehicle = $365.00
//         */
//        System.out.println("***TEST 4***\n");
//
//        //perform a service
//        corolla.addService(new Service("Basic", new Date(), corolla.getTotalKmTravelled()));
//
//        //attempt rental again
//        System.out.println("***Attempting the rental of 300km again now the vehicle has been serviced***");
//        corolla.kmRental(300);
//
//        //add a journey of 50km        
//        System.out.println("***Adding Journey of 50km***");
//        Journey journey3 = new Journey();
//        journey3.setNumKmForJourney(50);
//        corolla.addJourney(journey3);
//
//        //add a fuel purchase of 100L @ 123.78
//        System.out.println("***Adding fuel purchase of 100L @ 123.78***");
//        FuelPurchase fp1 = new FuelPurchase(100, 123.78);
//        corolla.addFuelPurchase(fp1);
//
//        //add a journey of 45km  
//        System.out.println("***Adding Journey of 45km***");
//        Journey journey4 = new Journey();
//        journey4.setNumKmForJourney(45);
//        corolla.addJourney(journey4);
//
//        //add a fuel purchase of 150L @ 80.00
//        System.out.println("***Adding fuel purchase of 150L @ 80.00***");
//        FuelPurchase fp2 = new FuelPurchase(150, 80);
//        corolla.addFuelPurchase(fp2);
//
//        //pay for the rental
//        corolla.payRental();
//        System.out.println("***Rental returned. Only 95km were driven not the expectd 300km. Total revenue will only be $95 and vehicle can be rented again as km driven didnt exceed 100km***");
//        //display state of vehicle
//        System.out.println(corolla.print());
//
//        System.out.println("***END OF TEST 4***\n");
//
//        /* END OF TEST 4 */
//        
//        /* TEST 5 
//         * Using the same vehicle from Test 4 attempt Day rental for 3 days and 
//         * 600km, add two journeys (i.e 2 days) totalling 600km, pay for the 
//         * rental, show state of vehicle.
//         *
//         * A discount message will be displayed because the rental was only for
//         * 2 days and not for 3 days.
//         *
//         * Vehicle state after test should be:
//         * Number of Services = 1
//         * Km since last service = 695
//         * Km Travelled = 995km
//         * Fuel Economy = 25.9L/100km
//         * Average Fuel Cost = $0.82
//         * Revenue for the rental = $200
//         * Total revenue for the vehicle = $565.00
//         */
//        System.out.println("***TEST 5***\n");
//
//        //attempt Day rental for 3 days and 600km
//        System.out.println("***Attempt Day Rental of same vehicle for 3 days");
//        corolla.dayRental(600, 3);
//
//        //add a journey of 200km
//        System.out.println("***Adding Journey of 200km***");
//        Journey journey5 = new Journey();
//        journey5.setNumKmForJourney(200);
//        corolla.addJourney(journey5);
//
//        //add a journey of 400km
//        System.out.println("***Adding Journey of 400km***");
//        Journey journey6 = new Journey();
//        journey6.setNumKmForJourney(400);
//        corolla.addJourney(journey6);
//
//        //pay for the rental
//        System.out.println("***Paying for the rental***");
//        corolla.payRental();
//        //display vehicle state
//        System.out.println(corolla.print());
//
//        System.out.println("***END OF TEST 5***\n");
//
//        /* END OF TEST 5 */
//        
//        /* TEST 6
//         * Using the same vehicle from Test 5 attempt Day rental for 2 days and 
//         * 200km.
//         *
//         * An error message should be displayed stating the vehicle is due for 
//         * a service so can't be rented
//         */
//        System.out.println("***TEST 6***\n");
//
//        System.out.println("***Attempting another day rental - vehicle needs a service so should fail***");
//        corolla.dayRental(300, 2);
//
//        System.out.println("***END OF TEST 6***\n");
//
//        /* END OF TEST 6 */
// 
//        /* TEST 7 
//         * Using the same vehicle from Test 6 perform a service, attempt day rental
//         * of 2 days and 300km again, add 3 journeys totalling 500km, add 2 fuel
//         * purchases, pay for the rental and display vehicle state.
//         *
//         * A extra charge message will be displayed because the rental was for
//         * 3 days (3 journeys) and not for the initial 2 days.
//         *
//         * Vehicle state after test should be:
//         * Number of Services = 2
//         * Km since last service = 500
//         * Km Travelled = 1465
//         * Fuel Economy = 29.4L/100km
//         * Average Fuel Cost = $1.06
//         * Revenue for the rental = $300
//         * Total revenue for the vehicle = $865.00
//         */
//        System.out.println("***TEST 7***\n");
//
//        //do a service
//        corolla.addService(new Service("Basic", new Date(), corolla.getTotalKmTravelled()));
//        System.out.println("***Attempting the rental again now the vehicle has been serviced***");
//        corolla.dayRental(300, 2);
//
//        //add a journey of 100km (1 day)
//        System.out.println("***Adding Journey of 100km***");
//        Journey journey7 = new Journey();
//        journey7.setNumKmForJourney(100);
//        corolla.addJourney(journey7);
//
//        //add a journey of 200km (2 days)
//        System.out.println("***Adding Journey of 100km***");
//        Journey journey8 = new Journey();
//        journey8.setNumKmForJourney(200);
//        corolla.addJourney(journey8);
//
//        //add a journey of 200km (3 days)
//        System.out.println("***Adding Journey of 200km***");
//        Journey journey9 = new Journey();
//        journey9.setNumKmForJourney(200);
//        corolla.addJourney(journey9);
//        
//        //add a fuel purchase of 100L @ 139.60
//        System.out.println("***Adding fuel purchase of 100L @ 139.60***");
//        FuelPurchase fp3 = new FuelPurchase(100, 139.60);
//        corolla.addFuelPurchase(fp3);
//        
//        //add a fuel purchase of 80L @ 110.56
//        System.out.println("***Adding fuel purchase of 80L @ 110.56***");
//        FuelPurchase fp4 = new FuelPurchase(80, 110.56);
//        corolla.addFuelPurchase(fp4);
//
//        //pay for the rental
//        System.out.println("***Paying for the rental***");
//        corolla.payRental();
//
//        //display vehicle state
//        System.out.println(corolla.print());
//
//        System.out.println("***END OF TEST 7***\n");
//
//        /* END OF TEST 7 */
//       
//           
//        /* TEST 8 
//         * Create a copy of the Toyota Corollo 2014 vehicle using the copy constructor.
//         *
//         * Vehicle state after test should be:
//         * Number of Services = 2
//         * Km since last service = 500
//         * Km Travelled = 1465
//         * Fuel Economy = 29.4L/100km
//         * Average Fuel Cost = $1.06
//         * Revenue for the rental = $300
//         * Total revenue for the vehicle = $865.00
//         */
//        
//        System.out.println("***TEST 8***\n");
//        
//        System.out.println("***Making a copy of the Corollo vehicle***");
//	//make a copy of the corolla vehicle
//	Vehicle corollaCopy = new Vehicle(corolla);	
//	System.out.println(corollaCopy.print());
//        
//        System.out.println("***END OF TEST 8***\n");

    }
    
    private static void showMainMenu() {
        
        // flag to see if user has decided to exit the main menu
        boolean userExit = false;
        // Scanner object for capturing user input
        Scanner input = new Scanner(System.in);
        
        
        
        // show the main menu until user exits
        while (!userExit) 
        {
            // error handling in case user enters a string
            try 
            {  
                //display any existing vehicles in the fleet
                displayFleet();
                // display main menu
                System.out.println("\nChoose an option: \n");                
                System.out.println("1. Add a vehicle");
                System.out.println("2. Edit vehicle");
                System.out.println("3. Copy vehicle ");
                System.out.println("4. Exit\n");
                
                // get the user's choice
                int choice = input.nextInt();
                input.nextLine(); 
                // handle the menu choice
                switch (choice) 
                {                
                    case 1: 
                        // add a vehicle
                        addVehicle();          
                        break;
                    case 2:
                        //edit a vehicle
                        System.out.print("Enter vehicle number to edit: "); 
                        int vehicleNum = input.nextInt();
                        showSubMenu(vehicleNum);
                        break;
                    case 3:
                        System.out.print("Enter vehicle number to copy: "); 
                        int vehicleNumCopy = input.nextInt();
                        fleet[vehicleCount] = new Vehicle(fleet[vehicleNumCopy-1]);
                        vehicleCount++;
                        break;
                    case 4:
                        //set flag in order to exit the loop
                        userExit = true;
                        //System.out.println("Exiting...Bye!");
                        break;
                    default:
                        // display error message in case no option entered
                        System.out.println("Invalid option.\n");
                        break;
                }
            }
            //handle exception in case invalid input
            catch (InputMismatchException inputMismatchException) 
            {                
                // ignore any input so user can select again from the menu
                input.nextLine();
                //display error message
                System.out.println("Invalid input. Numbers only please");
            }
        }        
    }

    private static void addVehicle() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter vehicle manufacturer: ");                        
        String manufacturer = input.nextLine();
                        
        System.out.print("Enter vehicle model: ");
        String model = input.nextLine();
                         
        System.out.print("Enter vehicle year of manufacturer: ");
        int yearBuilt = input.nextInt();
                        
        fleet[vehicleCount] = new Vehicle(manufacturer, model, yearBuilt);                        
        System.out.println("New vehicle created\n"); 
        vehicleCount++;
    }
    
    private static void showSubMenu(int vehicleNum) {
        
        // flag to see if user has decided to exit the main menu
        boolean backToMain = false;
        // Scanner object for capturing user input
        Scanner input = new Scanner(System.in);
        
        while (!backToMain) 
        {
            // error handling in case user enters a string
            try 
            {  
                // display sub menu
                System.out.println("\nVehicle sub menu\n");
                System.out.println("Choose an option: \n");
                System.out.println("1. Request Day Rental");
                System.out.println("2. Request Kilometre Rental");
                System.out.println("3. Add a journey");
                System.out.println("4. Perform a service");
                System.out.println("5. Add a fuel purchase");
                System.out.println("6. Display vehicle details");
                System.out.println("7. Pay for rental");
                System.out.println("8. Back to main menu\n");
                
                // get the user's choice
                int choice = input.nextInt();
                input.nextLine(); 
                // handle the menu choice
                switch (choice) 
                {   
                    case 1: 
                        System.out.println("Enter number of rental days: ");
                        int days = input.nextInt();
                        System.out.println("Enter number of kilometres: ");
                        double dayKms = input.nextDouble();
                        fleet[vehicleNum-1].dayRental(dayKms, days);
                        break;
                    case 2: 
                        System.out.println("Enter number of kilometres: ");
                        double kms = input.nextDouble();
                        fleet[vehicleNum-1].kmRental(kms);
                        break;
                    case 3: 
                        System.out.println("Enter number of kilometres for journey: ");
                        double jKms = input.nextDouble();
                        fleet[vehicleNum-1].addJourney(new Journey(jKms));
                        break;
                    case 4: 
                        fleet[vehicleNum-1].addService(new Service("Basic", new Date(), fleet[vehicleNum-1].getTotalKmTravelled()));
                        break;
                    case 5: 
                        System.out.println("Enter amount of fuel: ");
                        double fuel = input.nextDouble();
                        System.out.println("Enter cost of fuel: ");
                        double cost = input.nextDouble();
                        fleet[vehicleNum-1].addFuelPurchase(new FuelPurchase(fuel, cost));
                        break;                    
                    case 6: 
                        fleet[vehicleNum-1].print();
                        break;
                    case 7: 
                        fleet[vehicleNum-1].payRental();
                        break;
                    case 8: 
                        backToMain = true;
                        showMainMenu();
                        break;
                }
            }
            //handle exception in case invalid input
            catch (InputMismatchException inputMismatchException) 
            {                
                // ignore any input so user can select again from the menu
                input.nextLine();
                //display error message
                System.out.println("Invalid input. Numbers only please");
            }
        }
    }
    
    private static void displayFleet() {
        
        System.out.println(String.format("%25s", "VEHICLE FLEET"));
        System.out.println(String.format("%-10s", "Vehicle") + String.format("%-16s", "Manufacturer") + String.format("%-10s","Model") + String.format("%-5s", "Year"));
        //System.out.print(String.format("%-10s", "Number") + String.format("%10s", "Manufacturer") + String.format("%10s", "Model") + String.format("%10s", "Year Built\n"));
        for (int vehicle=0; vehicle<fleet.length; vehicle++) {
            if (fleet[vehicle] != null) {
            System.out.println(String.format("%-10s", (vehicle+1)) + String.format("%-16s", fleet[vehicle].getManufacturer()) + String.format("%-10s",fleet[vehicle].getModel()) + String.format("%-5s", fleet[vehicle].getYearBuilt()));
            }
        }        
    }
}
