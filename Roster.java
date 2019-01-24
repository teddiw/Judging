import java.util.ArrayList;
/*
 * An instance of this class contains the team information for the season. The field "students" 
 * is an ArrayList of Student objects. The constructor takes in the output of ArrayFromCSV.make(),
 * assuming that the spreadsheet for the CSV was formatted as the following:
 * id | first_name | last_name | times_competed | times_judged | email | phone_number | sbling1_id | sibling2_id | sibling3_id | sibling4_id | judge1_first_name | judge1_last_name | judge1_email | judge1_phone_number | tournaments_attended
 *
 * The implementation in the Client class ought to have a new Roster created each time the algorithm is run.
 */
public class Roster{
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Competitor> competitors = new ArrayList<Competitor>();
	String tournaments_attended = "";
	
	public Roster(String[][] csv_student_array, String[][] csv_competitor_array) {
		for(int i = 0; i < csv_student_array.length; i++) {
			int id = Integer.parseInt(csv_student_array[i][0]);
			String first_name = csv_student_array[i][1];
			String last_name = csv_student_array[i][2];
			int times_competed = Integer.parseInt(csv_student_array[i][3]);
			int times_judged = Integer.parseInt(csv_student_array[i][4]);
			String email = csv_student_array[i][5];
			String phone_number = csv_student_array[i][6];
			int sibling1_id = Integer.parseInt(csv_student_array[i][7]);
			int sibling2_id = Integer.parseInt(csv_student_array[i][8]);
			int sibling3_id = Integer.parseInt(csv_student_array[i][9]);
			int sibling4_id = Integer.parseInt(csv_student_array[i][10]);
			String judge1_first_name = csv_student_array[i][11];
			String judge1_last_name = csv_student_array[i][12];
			String judge1_email = csv_student_array[i][13];
			String judge1_phone_number = csv_student_array[i][14];
			String tournaments_attended = csv_student_array[i][15];
			students.add(new Student(id, first_name, last_name, times_competed, times_judged, email, phone_number, sibling1_id, sibling2_id, sibling3_id, sibling4_id, judge1_first_name, judge1_last_name, judge1_email, judge1_phone_number, tournaments_attended));
		}
		
		for(int i = 0; i < csv_competitor_array.length; i++) {
			int id = Integer.parseInt(csv_competitor_array[i][0]);
			competitors.add(new Competitor(id));
		}
	}
	
	public void add_tournament(String name) {
		tournaments_attended += ", " + name;
	}
	
	public ArrayList<Student> get_competing_students(){
		ArrayList<Student> competing_students = new ArrayList<Student>();
		for(int i=0; i<competitors.size(); i++) {
			for(int j=0; j<students.size(); j++) {
				if(competitors.get(i).get_id() == students.get(j).get_id()) {
					competing_students.add(students.get(j));
				}
			}
		}
		return competing_students;
	}
	
	//create another method to return arraylist of ids who did not appear in roster
	
}