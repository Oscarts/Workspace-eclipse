package planner;

import java.util.ArrayList;
import java.util.Collections;

public class Tour{

    // Holds our tour of cities
    private ArrayList<Integer> tour; 
    // Cache
    private double fitness = 0;
    private double distance = 0;
    private int inviduals=0;
    readData instance;
    
    // Constructs a blank tour
    public Tour(readData instance){
    	this.instance=instance;
    	tour = new ArrayList<Integer>(instance.getNumberCities());
    	for (int i = 0; i < instance.getNumberCities(); i++) {
			tour.add(null);
		}
    	//i think i can be optimized to eliminate generate individual..
    }


    // Creates a random individual
    public void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int cityIndex = 0; cityIndex < instance.getNumberCities(); cityIndex++) {
          setCity(cityIndex, cityIndex);
        }
        // Randomly reorder the tour
        Collections.shuffle(tour);
    }

    // Gets a city from the tour
    public int getCity(int tourPosition) {
        return (Integer) tour.get(tourPosition);
    }
    // gets the tour
    public ArrayList<Integer> getTour() {
		return tour;
	}
    // Sets a city in a certain position within a tour
    public void setCity(int tourPosition, int city) {
        tour.set(tourPosition, city);
        // If the tours been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }
    
    // Gets the tours fitness
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        
        return fitness;
    }
    
    // Gets the total distance of the tour
    public double getDistance(){
    	
        if (distance == 0) {
            double tourDistance = 0;
            // Loop through our tour's cities
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                // Get city we're travelling from
                int fromCity = getCity(cityIndex);
                // City we're travelling to
                int destinationCity;
                // Check we're not on our tour's last city, if we are set our 
                // tour's final destination city to our starting city
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                
                //int from=fromCity.getX();
                //int to=destinationCity.getX();
                // Get the distance between the two cities
//                tourDistance += fromCity.distanceTo(destinationCity);
               // if (cityIndex + 1 < tourSize()) {
                 tourDistance += instance.getDistances(fromCity,destinationCity);					
			//	} else {
	          //      tourDistance += distances[cityIndex][0];
			//	}
            }
            distance = tourDistance;
        }
        return distance;
    }

    // Get number of cities on our tour
    public int tourSize() {
        return tour.size();
    }
    
    // Check if the tour contains a city
    public boolean containsCity(int city){
        return tour.contains(city);
    }
    
    @Override
    public String toString() {
        String geneString = "Tour: ";
        for (int i = 0; i < tourSize(); i++) {
            geneString += instance.names[getCity(i)]+"->";
        }
        return geneString;
    }
//    @Override
//
//     public boolean addAll(int index,Collection c) {
//
//
//     return super.addAll( c);
//
//     }
}