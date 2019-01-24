/*
 * This class contains all of the information for a judge. 
 */

public class Judge{
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	
	public Judge(String first_name, String last_name, String email, String phone_number) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
	}
	
	public String get_first_name() {
		return first_name;
	}
	
	public String get_last_name() {
		return last_name;
	}
	
	public String get_email() {
		return email;
	}
	
	public String get_phone_number() {
		return phone_number;
	}
}