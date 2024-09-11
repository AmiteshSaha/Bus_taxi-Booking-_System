package USER;
import java.util.*;
import vehicle.Bus;
import vehicle.Taxi;
import vehicle.Vehicle;
import vehicle.rideStatus;
import USER.Landing;

public class BUS_TAXI_BOOKING_DEMO {
	
	static Bus[] buses= new Bus[8];
	static Taxi[] taxis= new Taxi[5];
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Bus b1 = new Bus(50, "Mumbai", "Bangalore", 1600, 12345, "Tata", 1200);
		Bus b2 = new Bus(50, "Mumbai", "Bangalore", 1830, 22222, "Tata", 1200);
		Bus b3 = new Bus(50, "Mumbai", "Bangalore", 2300, 33333, "Tata", 1200);
		Bus b4 = new Bus(50, "Delhi", "Bangalore", 0600, 44444, "Tata", 2400);
		Bus b5 =  new Bus(50, "Chennai", "Coimbatore", 0600, 55555, "Tata", 550);
		Bus b6 = new Bus(50, "Jaipur", "Panaji", 0430, 66666, "Tata", 2000);
		Bus b7 = new Bus(50, "Mysore", "Bangalore", 0625, 77777, "Tata", 200);
		Bus b8 = new Bus(50, "Panaji", "Margao", 0630, 88888, "Tata", 50);
		
		buses[0] = b1;
		buses[1] = b2;
		buses[2] = b3;
		buses[3] = b4;
		buses[4] = b5;
		buses[5] = b6;
		buses[6] = b7;
		buses[7] = b8;
		
		Taxi t1 = new Taxi(4,"Tata", 80, "__", "9284734342", 9832);
		Taxi t2 = new Taxi(4,"Hyundai", 80, "__", "9423959433", 3832);
		Taxi t3 = new Taxi(6,"Maruti", 80, "__", "9239498934", 2039);
		Taxi t4 = new Taxi(6,"Honda", 80, "__", "9493492834", 3048);
		Taxi t5 = new Taxi(6,"Toyota", 80, "__", "9543263634", 5493);
		
		taxis[0] = t1;
		taxis[1] = t2;
		taxis[2] = t3;
		taxis[3] = t4;
		taxis[4] = t5;
				
		
		int session;
		System.out.println("Start session? yes->1 No->0 ");
		session=in.nextInt();
		while(session==1)
		{
			Landing obj=new Landing(buses,taxis);
			obj.loginClient();
			while(obj.loginStatus==true)
			{
				Customer cu=Customer.getCustomer(obj.customId);
				
				int vch;
				System.out.println("Choose BUS or TAXI: BUS->1 TAXI->2 ");
				vch=in.nextInt();
				if(vch==1)
				{
					int sz=bookings.ifbuses(cu);
					if(sz>0)
					{
						System.out.println("YOUR BOOKINGS:");
						for(int i=0,k=0;i<sz;i++)
						{
							System.out.println((++k)+") "+cu.buses.get(i).vehicleNumber+" From: "+cu.buses.get(i).source+" to:"+cu.buses.get(i).destination);
						}
					}
					int opch;
					System.out.println("1->Cancel Booking, 2->New Booking");
					opch=in.nextInt();
					if(opch==1)
					{
						if(sz==0)
							System.out.println("You have no bookings.");
						else
						{
							System.out.println("YOUR BOOKINGS:");
							for(int i=0,k=0;i<sz;i++)
							{
								System.out.println((++k)+") "+cu.buses.get(i).vehicleNumber+" From: "+cu.buses.get(i).source+" to:"+cu.buses.get(i).destination);
							}
							System.out.println("Enter bus number to cancel booking");
							int bno=in.nextInt();
							Customer.removeBus(cu,bno);
							obj.cancelBookings(bno);
						}
					}
					else {
					String source,destination;
					System.out.println("Enter Source: ");
					source=in.next();
					System.out.println("Enter Destination: ");
					destination=in.next();
					ArrayList<Bus> ba=obj.searchBuses(source,destination);
					for(int i=0,k=0;i<ba.size();i++)
					{
						if(ba.get(i).getCap()>0)
						System.out.println(""+(++k)+") "+ba.get(i).vehicleNumber+" Start Time: "+ba.get(i).getTime()+" - capacity: "+ba.get(i).getCap());
					}
					int t;
					System.out.println("Enter bus no. to book");
					t=in.nextInt();
					boolean f=obj.bookBus(t, source, destination, 1);
					if(f==true)
					{System.out.println("Bus booked Successfully");
					}
					else
						System.out.println("Booking failed.please try again");
					}
				}
				else if(vch==2)
				{
					int sz=bookings.iftaxis(cu);
					if(sz>0)
					{
						System.out.println("YOUR BOOKINGS:");
						for(int i=0,k=0;i<sz;i++)
						{
							System.out.println((++k)+") "+cu.taxis.get(i).vehicleNumber+" From: "+cu.taxis.get(i).source+" to:"+cu.taxis.get(i).destination);
						}
					}
					int opch;
					System.out.println("1->Cancel Booking, 2->New Booking");
					opch=in.nextInt();
					if(opch==1)
					{
						if(sz==0)
							System.out.println("You have no bookings.");
						else
						{
							System.out.println("YOUR BOOKINGS:");
							for(int i=0,k=0;i<sz;i++)
							{
								System.out.println((++k)+") "+cu.taxis.get(i).vehicleNumber+" From: "+cu.taxis.get(i).source+" to:"+cu.taxis.get(i).destination);
							}
							System.out.println("Enter taxi number to cancel booking");
							int bno=in.nextInt();
							Customer.removeTaxi(cu,bno);
							obj.cancelBookings(bno);
						}
					}
					else 
					{

					ArrayList<Taxi> b=obj.searchTaxis();
					for(int i=0,k=0;i<b.size();i++)
					{
						if(b.get(i).isTaxiAvailable()==rideStatus.AVAILABLE)
						System.out.println(""+(++k)+") "+b.get(i).vehicleNumber+" - capacity: "+b.get(i).getCap());
					}
					int t;
					System.out.println("Enter Taxi no. to book");
					t=in.nextInt();
					String source,destination;
					System.out.println("Enter Source: ");
					source=in.next();
					System.out.println("Enter Destination: ");
					destination=in.next();
					boolean f=obj.bookTaxi(t, source, destination,System.currentTimeMillis()) ;
					if(f==true)
						System.out.println("Taxi booked Successfully");
					else
						System.out.println("Booking failed.please try again");
				}
				}
				else
				{
					System.out.println("Please try again");
				}
				int log;
				System.out.println("Logout? yes->1 no->2");
				log=in.nextInt();
				if(log==1)
				{
					obj.logout();
					break;
				}
				
			}
			int log;
			System.out.println("End Session? yes->1 no->2");
			log=in.nextInt();
			if(log==1)
			{
				break;
			}
			else
				continue;
		}
		
	}
		
}
