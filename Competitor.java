/*
 * This class contains all of the information about one specific competitor signed up for the tournament.  
 */
public class Competitor{
	private int id;
	
	public Competitor(int id) {
		this.id = id;
	}
	
	public int get_id() {
		return id;
	}
	
	public void print_competitor() {
		System.out.println(id);
	}
}