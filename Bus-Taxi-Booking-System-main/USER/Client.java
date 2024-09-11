package USER;
import java.util.*;

class Client extends Login{
	
	public String login() {
		Scanner in=new Scanner(System.in);
		int choice=0;
		System.out.println("Enter Choice: 1-> Sign In,  2->Sign Up,  3->Delete Account");
		choice=in.nextInt();
		if(choice==1) {
			String email,password;
			System.out.println("Enter email: ");
			email=in.next();
			System.out.println("Enter password: ");
			password=in.next();
			String S=checkLogin(email, password);
			if(!(S.equals("-1")))
				return S;
			else
				return "-1";
		}
		else if(choice==2) {
			String email,password,name;
			long mobno;char gen;
			System.out.println("Enter name:");
			name=in.next();
			System.out.println("Enter email:");
			email=in.next();
			System.out.println("Enter Password:");
			password=in.next();
			System.out.println("Enter Mobile number");
			mobno=in.nextLong();
			System.out.println("Enter gender");
			gen=in.next().charAt(0);
			String S=newLogin(name, password, email, mobno,gen);
			if(!S.equals("-1"))
				return S;
			else
				return "-1";
		
		}
		else if(choice ==3) {
			String email,password;
			System.out.println("Enter email: ");
			email=in.next();
			System.out.println("Enter passwrod: ");
			password=in.next();
			String S=deleteLogin(email,password);
			System.out.println(S);
			return S;
		}
		return "-1";
	}
}
