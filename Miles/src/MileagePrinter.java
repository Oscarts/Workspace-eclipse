import java.util.Scanner;

public class MileagePrinter {
	
	final double COST_PER_GALLON = 3.95;
	private double tank;
	private double efficiency;
	
	public double getEfficiency() {
		return efficiency;
	}
	public double getTank() {
		return tank;
	}
	public void setEfficiency(double efficiency) {
		if (efficiency<=0) {
			System.out.println("No can go");
		}else {
			this.efficiency = efficiency;
		}
	}
	public void setTank(double tank) {
		this.tank = tank;
	}
	public double distance() {
		return tank*efficiency;
	}
	public double cost() {
		return tank*COST_PER_GALLON;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MileagePrinter mp=new MileagePrinter();
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the number of gallons of gas in the tank");
		double tank=in.nextDouble(); 
		System.out.println("Enter the fuel efficiency");
		double efficiency =in.nextDouble();
		mp.setEfficiency(efficiency);
		mp.setTank(tank);
		//System.out.printf("Cost:%11.2f\n",  COST_PER_GALLON*100/efficiency);
	}

}
//Sample runs for the final version:
//Enter the number of gallons of gas in the tank 5.1
//Enter the fuel efficiency 35.0
//Distance:   178.5
//Cost:       11.29
//Enter the number of gallons of gas in the tank 25
//Enter the fuel efficiency -5
//No can go 
//Sample run for the draft:
//Enter the number of gallons of gas in the tank 4.2
//Enter the fuel efficiency 35
//4.2 35.0 