package vehicle;
import USER.Customer;

public class Bus extends Vehicle{
	int capacity;          // the Capacity of the bus or the number of total seats the bus has;
	int availableSeats;    // the number of available seats;
	public String source;		   // The point from which the bus starts its journey.	
	public String destination;	   // The point where the bus ends its journey
	int time;              // The time at which the bus starts its journey from its source. Measured in hours past 00:00;
	String[] customers;	   // Maintains a list of customers by their Ids ;
	int numberOfCustomers; // The number of customers who have currently booked the bus;
	String companyName;    // Name of the company of the bus;
	int distance;	// total distance of the route;
	
	public Bus(int cap, String source, String dest, int time, int vnumber, String name, int distance){
		this.vehicleNumber = vnumber;
		capacity = cap;
		availableSeats = cap;
		this.source = source;
		destination = dest;
		this.time = time;
		customers = new String[cap];
		numberOfCustomers = 0;
		companyName = name;
		this.distance = distance;
	}
	
	@Override
	public boolean bookVehicle(String customId, String source, String destination, long time, int cap) {
		if(availableSeats > 0) {
			customers[numberOfCustomers] =  customId;
			numberOfCustomers++;
			availableSeats--;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean cancelBooking(String customId) {
		int ind = getCustomerId(customers, customId);
		if(ind != -1) {
			for(int i = ind; i < customers.length-1; i++) {
				customers[i] = customers[i+1];
			}
			customers[capacity-1] = null;
			numberOfCustomers--;
			availableSeats++;
			return true;
		}
		return false;
	}
	
	private int getCustomerId(String[] customs, String customId) {
		for(int i = 0; i < customs.length; i++) {
			if(customs[i] == customId) {
				return i;
			}
		}
		return -1;
	}
	
	public String[] getCustomers() {
		return customers;
	}
	
	public void finishTrip() {
		for(int i = 0; i < customers.length; i++) {
			customers[i] = null;
		}
		availableSeats = capacity;
		numberOfCustomers = 0;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getCap()
	{
		return this.availableSeats;
	}
	
//	public boolean addMultipleCustomers(String source, String dest, int time, String... customs) {
//		for(int i = 0; i < customs.length; i++) {
//			if(!bookVehicle(customs[i], source, dest, time, 1)) {
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean cancelMultipleCustomers(String... customs) {
//		for(int i = 0; i < customs.length; i++) {
//			if(!cancelBooking(customs[i])) {
//				return false;
//			}
//		}
//		return true;
//	}
	
}
