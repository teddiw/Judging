/*
 * This class contains all of the information about one specific student in the class.  
 */

public class Student{
	private int times_competed;
	private int times_judged;
	private int sibling1_id;
	private int sibling2_id;
	private int sibling3_id;
	private int sibling4_id;
	private int id;
	private Judge judge1;
	private String first_name;
	private String last_name;
	private String tournaments_attended;
	private String email;
	private String phone_number;
	
	public Student(int id, String first_name, String last_name, int times_competed, int times_judged, String email, String phone_number, int sibling1_id, int sibling2_id, int sibling3_id, int sibling4_id, String judge1_first_name, String judge1_last_name, String judge1_email, String judge1_phone_number, String tournaments_attended) {
		this.sibling1_id = sibling1_id;
		this.sibling2_id = sibling2_id;
		this.sibling3_id = sibling3_id;
		this.sibling4_id = sibling4_id;
		this.id = id;
		this.judge1 = new Judge(judge1_first_name, judge1_last_name, judge1_email, judge1_phone_number);
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.times_competed = times_competed;
		this.times_judged = times_judged;
		this.tournaments_attended = tournaments_attended;
	}
	
	public double get_score() {
		if(times_competed == 0) {
			return 0;
		}else {
			return (double) times_judged / times_competed;
		}
	}
	
	public Student find_sibling1(Roster r) {
		for(int i = 0; i < r.students.size(); i++) {
			Student current_student = r.students.get(i);
			if(sibling1_id == current_student.get_id()) {
				return current_student;
			}
		}
		return new Student(0, "", "", 0, 0, "","", 0, 0, 0, 0, "", "", "", "", ""); /*This default student instance is only returned 
		if there is an administrative error. Specifically, the student entered the sibling id incorrectly,
		or the sibling id is incorrectly recorded in the "students" ArrayList from the Roster instance.*/
	}
		
	
	public void increment_times_competed() {
		times_competed++;
	}
	
	public void increment_times_judged() {
		times_judged++;
	}
	
	public int get_times_judged() {
		return times_judged;
	}
	
	public int get_times_competed() {
		return times_competed;
	}
	
	public int get_sibling1_id() {
		return sibling1_id;
	}
	
	public int get_sibling2_id() {
		return sibling2_id;
	}
	
	public int get_sibling3_id() {
		return sibling3_id;
	}
	
	public int get_sibling4_id() {
		return sibling4_id;
	}
	
	public int get_id() {
		return id;
	}
	
	public Judge get_judge1() {
		return judge1;
	}
	
	public String get_first_name() {
		return first_name;
	}
	
	public String get_last_name() {
		return last_name;
	}
	
	public String get_tournaments_attended() {
		return tournaments_attended;
	}
	
	public String get_email() {
		return email;
	}
	
	public String get_phone_number() {
		return phone_number;
	}
	
	public void print_student() {
		System.out.println(id+"; "+last_name+", "+first_name+"; "+email+"; "+phone_number+"; "+times_judged+"; "+times_competed+"; "+tournaments_attended+"; SIBLINGS: "+sibling1_id+", "+sibling2_id+", "+sibling3_id+", "+sibling4_id);
	}
	
	public void add_tournament(String name) {
		tournaments_attended += "_" + name;
	}

}