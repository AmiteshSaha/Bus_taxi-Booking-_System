package vehicle;

public abstract class Vehicle {
	public int vehicleNumber;
		
	public abstract boolean bookVehicle(String customId, String source, String destination, long time, int cap);
	
	public abstract boolean cancelBooking(String customId);
}
