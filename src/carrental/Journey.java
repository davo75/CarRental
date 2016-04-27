/*
 The Journey class stores the number of kilometers travelled.
 
 @author David Pyle 041110777
 @version 1.0
 @since 11/4/2016
  
 Methods:
    + double getNumKmForJourney()
    + void setNumKmForJourney(double numKmForJourney)
 */
package carrental;

public class Journey {

    //number of kilometers for a single journey
    private double numKmForJourney;

    /**
     * Constructor Sets the default number of kilometers for a journey to zero.
     */
    public Journey() {
        
        this.numKmForJourney = 0;
    }

    /**
     * Constructor Sets the number of kilometers for a journey.
     */
    public Journey(double numKmForJourney) {
        
        this.numKmForJourney = numKmForJourney;
    } 
    
    /**
     * Gets the number of kilometers for the journey
     *
     * @return the number of kilometers for the journey
     */
    public double getNumKmForJourney() {
        
        return numKmForJourney;
    }

    /**
     * Sets the number of kilometers for the journey
     *
     * @param numKmForJourney the number of kilometers for the journey
     */
    public void setNumKmForJourney(double numKmForJourney) {
        
        this.numKmForJourney = numKmForJourney;
    }

}
