package vehicle;

import java.util.Random;

public class Taxi extends Vehicle{
	int capacity;
	String companyName;
	int speed;
	String driverName;
	String driverContact;
	rideStatus cabStatus;
	String[] customers;
	int[] numOfCustomers;
	static final int maxTime=300;
	long[] ETAs;
	int numberOfBookings;
	public String source;
	public String destination;
	
	public Taxi(int cap, String compName, int speed, String driverName, String driverContact, int vNum){
		capacity = cap;
		companyName = compName;
		this.speed = speed;
		this.driverName = driverName;
		this.driverContact = driverContact;
		ETAs = new long[10];
		numberOfBookings = 0;
		this.vehicleNumber =  vNum;
		customers=new String[10];
		numOfCustomers=new int[10];
		cabStatus=rideStatus.AVAILABLE;
	}
	
	private Route setRoute(String source, String destination, long time) {
		Route route = new Route(source, destination, time);
		return route;
	}
	
	public rideStatus isTaxiAvailable() {
		return cabStatus;
	}
	
	@Override
	public boolean bookVehicle(String customId, String source, String destination, long time, int cap) {
		Route route = setRoute(source, destination, time);
		if(route.ETA - route.startTime > maxTime) {
			return false;
		}
		else 
		{
			if(isTaxiAvailable()==rideStatus.AVAILABLE){
					ETAs[numberOfBookings] = route.ETA;
					numOfCustomers[numberOfBookings] = cap;
					customers[numberOfBookings] = customId;
					numberOfBookings++;
					this.source=source;
					this.destination=destination;
					cabStatus=rideStatus.BOOKED;
					return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean cancelBooking(String customId) {
		int ind = getCustomerId(customers, customId);
		if(ind != -1) {
			for(int i = ind; i < numberOfBookings; i++) {
				ETAs[i] = ETAs[i+1];
				numOfCustomers[i] = numOfCustomers[i+1];
				customers[i] = customers[i+1];
			}
			ETAs[numberOfBookings-1] = 0;
			numOfCustomers[numberOfBookings-1] = 0;
			customers[numberOfBookings-1] = null;
			numberOfBookings--;
			cabStatus=rideStatus.AVAILABLE;
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
	
	public int getCap()
	{
		return this.capacity;
	}
	
	
}
