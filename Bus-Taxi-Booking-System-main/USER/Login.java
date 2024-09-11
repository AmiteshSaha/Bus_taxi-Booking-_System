package USER;

public class Login implements user_base{
	@Override
	public String checkLogin(String email,String password) {
		int f=-1;
		String id = "";
		for(int i=0;i<Customer.custs.size();i++) {
			if(Customer.custs.get(i).email.equals(email)&&Customer.custs.get(i).password.equals(password)) {
				f=0;
				id = Customer.custs.get(i).cust_id;
			}	
			else if(Customer.custs.get(i).email.equals(email)&&!(Customer.custs.get(i).password.equals(password))) {
				f=1;
			}
		}
		if(f==0) {
			System.out.println("Welcome");
			return id;
		}
		else if(f==1) {
			System.out.println("Invalid password");
			return "-1";
		}	
		else {
			System.out.println("User doesnt exists. Please sign up!!");
			return "-1";
		}		
			
	}
	@Override
	public String newLogin(String name, String password, String email, long mob_no,char gen) {
		String id ="";
		for(int i=0;i<Customer.custs.size();i++) {
			if(Customer.custs.get(i).email==email) {
				System.out.println("User already exists");
				return "-1";
			}	
		}
			Customer cust=new Customer(name, password, email, mob_no, gen);cust.addCustomer();
			id = cust.cust_id;
		
		
		System.out.println("Sign Up Successful!");
		return id;
	}

	@Override
	public String deleteLogin(String email,String password) {
		for(int i=0;i<Customer.custs.size();i++) {
			if(Customer.custs.get(i).email.equals(email)&&Customer.custs.get(i).password.equals(password))
			{Customer.custs.remove(i);
				return "User deleted Successfully";
			}
		}
		return "invalid user id or password";
	}
}
