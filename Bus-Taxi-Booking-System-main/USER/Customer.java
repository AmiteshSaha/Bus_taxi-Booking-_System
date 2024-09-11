package USER;
import java.util.*;

public class Customer extends userX{
	
	public static ArrayList<Customer> custs=new ArrayList<Customer>();
	
	public Customer(String name, String password, String email, long mob_no,char M){
		this.name=name;
		this.email=email;
		this.password=password;
		this.mob_no=mob_no;
		this.cust_id=name+"/"+Integer.toString((int)(mob_no%1000));
		this.gender=M;
	}
	public void addCustomer() {
		custs.add(this);
	}
	public ArrayList<Customer> getCustomers(){
		return custs;
	}
	public static Customer getCustomer(String custId)
	{
		for(int i=0;i<custs.size();i++)
		{
			if(custs.get(i).cust_id==custId)
				return custs.get(i);
		}
		return null;
	}
	public static void removeBus(Customer cust,int vnumber)
	{
		for(int i=0;i<cust.buses.size();i++)
		{
			if(cust.buses.get(i).vehicleNumber==vnumber)
			{
				cust.buses.remove(cust.buses.get(i));
				System.out.println("Booking removed");
				return;
			}
		}
		System.out.println("Booking not found");
	}
	public static void removeTaxi(Customer cust,int vnumber)
	{
		for(int i=0;i<cust.taxis.size();i++)
		{
			if(cust.taxis.get(i).vehicleNumber==vnumber)
			{
				cust.taxis.remove(cust.taxis.get(i));
				System.out.println("Booking removed");
				return;
			}
		}
		System.out.println("Booking not found");
	}
}
