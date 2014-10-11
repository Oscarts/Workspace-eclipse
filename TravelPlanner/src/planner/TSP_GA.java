package planner;

public class TSP_GA {

    public static void main(String[] args) throws Exception {

    	
        readData data=new readData(args[0]);
        //int dim=data.getNumberCities();
        // Initialize population
        Population pop = new Population(50, true, data);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());
        GA Ga=new GA(data);
        // Evolve population for 100 generations
        Population evolvePopulation = Ga.evolvePopulation(pop);
		pop = evolvePopulation;
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}