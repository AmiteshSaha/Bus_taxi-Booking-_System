package USER;

public interface user_base{
	
	public String checkLogin(String email,String password);
	
	public String deleteLogin(String email,String password);
	
	public String newLogin(String name, String password, String email, long mob_no,char gen);
}
