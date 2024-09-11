package USER;

import java.util.ArrayList;

import vehicle.Bus;
import vehicle.Taxi;

public abstract class userX {
	public String name;
	public String password;
	public String cust_id;
	public String email;
	public long mob_no;
	public char gender;
	public ArrayList<Bus> buses=new ArrayList<Bus>();
	public ArrayList<Taxi> taxis=new ArrayList<Taxi>();
}
