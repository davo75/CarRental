/*
 The FuelPurchase class stores details on fuel cost and litres when making a 
 fuel purchase.
 
 @author David Pyle 041110777
 @version 1.0
 @since 11/4/2016
  
 Methods:
    + double getAmountFuelLitres()
    + void setAmountFuelLitres(double amountFuel)
    + double getFuelCost()
    + void setFuelCost(double fuelCost)
 */
package carrental;

public class FuelPurchase {
    
    //number of litres purchased
    private double amountFuelLitres;
    //cost of the fuel
    private double fuelCost;
    
    /**
     * Constructor Sets the amount of fuel and fuel cost for a fuel purchase.
     * 
     * @param amountFuel the number of litres
     * @param fuelCost the cost of the fuel
     */
    public FuelPurchase(double amountFuel, double fuelCost) {
	
	this.amountFuelLitres = amountFuel;
	this.fuelCost = fuelCost;
    }
    
    /**
     * Gets the number of litres for the purchase
     * 
     * @return the number of litres of fuel
     */
    public double getAmountFuelLitres() {
	return amountFuelLitres;
    }

    /**
     * Sets the number of litres fuel for the purchase
     * 
     * @param amountFuel the number of litres purchased
     */
    public void setAmountFuelLitres(double amountFuel) {
	this.amountFuelLitres += amountFuel;
    }

    /**
     * Gets the cost of the fuel purchase
     * 
     * @return the cost of the fuel
     */
    public double getFuelCost() {
	return fuelCost;
    }

    /**
     * Sets the cost of the fuel purchase
     * 
     * @param fuelCost the cost of the fuel
     */
    public void setFuelCost(double fuelCost) {
	this.fuelCost = fuelCost;
    }
    
}
