
public class Ballon {
	//Implement a class Balloon that models a spherical balloon that is being filled with air.  
	//The constructor constructs an empty balloon (That is, the volume is 0).

	//Supply these methods: 
//		void addAir(double amount) adds the given amount of air
//		double getVolume() gets the current volume
//		double getSurfaceArea() gets the current surface area
//		double getRadius() gets the current radius
	Double volume;
	public Ballon(){
		volume=0.0;
	}
	public Double getVolume() {
		return volume;
	}
	public Double getRadious() {
		return Math.pow(((3.0/4)*volume/Math.PI), (1/3.0));
	}
	public Double getSurfaceArea() {
		return 3*volume/getRadious();
	}
	public void addAir(Double amount){
		volume=volume+amount;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ballon b=new Ballon();
		b.addAir(10.0);
	}

}
