package USER;
import java.util.*;
import vehicle.Bus;
import vehicle.Taxi;
public class bookings{
	static void newBus(Customer cust,Bus bus)
	{
		cust.buses.add(bus);
	}
	static void newTaxi(Customer cust,Taxi taxi)
	{
		cust.taxis.add(taxi);
	}
	static int ifbuses(Customer cust)
	{
		return cust.buses.size();
	}
	static int iftaxis(Customer cust)
	{
		return cust.taxis.size();
	}	
}
