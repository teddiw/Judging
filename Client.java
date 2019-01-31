import java.util.ArrayList;
import java.util.Arrays;
/*This is run to produce the results.*/
public class Client{
	public static void main(String[] args) {
		int student_info_num = 16;
		int students_num = 10; //change this to the number of students on the roster
		students_num += 1;
		String studentsCSVfileName = "students_test - Sheet1.csv"; //change this to the roster of students with specified header form: id | first_name | last_name | times_competed | times_judged | email | phone_number | sbling1_id | sibling2_id | sibling3_id | sibling4_id | judge1_first_name | judge1_last_name | judge1_email | judge1_phone_number | tournaments_attended
		String competitorsCSVfileName = "competitors_test - Sheet1.csv"; //change this to the list of student IDs of competing students
		int competitors_num = 9; //change this to the number of students competing
		String[][] students_from_CSV = ArrayFromCSV.make(students_num, student_info_num, studentsCSVfileName); //loaded with an example file
		String[][] competitors_from_CSV = ArrayFromCSV.make(competitors_num, 1, competitorsCSVfileName); //loaded with an example file 
		Roster roster = new Roster(Arrays.copyOfRange(students_from_CSV, 1, students_num), competitors_from_CSV); //make copy to trim off spreadsheet header
		ArrayList<Student> competing_students = roster.get_competing_students();
		//throw some warning if there are competitor IDs that are not found on the roster of students
		ArrayList<Student> competitors_for_judging = Select.lowest_scores(competing_students, 5);
		
		for(int i=0; i<competitors_for_judging.size(); i++) {
			competitors_for_judging.get(i).increment_times_judged();
			competitors_for_judging.get(i).increment_times_competed();
			competitors_for_judging.get(i).add_tournament("JamesLogan");
		}
		
		for(int i=0; i<competing_students.size(); i++) {
			competing_students.get(i).increment_times_competed();
			competing_students.get(i).add_tournament("JamesLogan");
		}
		
		ArrayList<String[]> formatted_students = CsvWriter.format_students(roster.students, student_info_num);
		ArrayList<String[]> formatted_competitors_for_judging = CsvWriter.format_students(competitors_for_judging, student_info_num);
		CsvWriter.write(formatted_students, "updated_roster.csv", "id,first_name,last_name,times_competed,times_judged,email,phone_number,sibling1_id,sibling2_id,sibling3_id,sibling4_id,judge1_first_name,judge1_last_name,judge1_email,judge1_phone_number,tournaments_attended");
		CsvWriter.write(formatted_competitors_for_judging, "students_to_provide_judges.csv", "id,first_name,last_name,times_competed,times_judged,email,phone_number,sibling1_id,sibling2_id,sibling3_id,sibling4_id,judge1_first_name,judge1_last_name,judge1_email,judge1_phone_number,tournaments_attended");
		
		
		
	}
	
	public static void run_tests(){
		//This method is full of commented-out tests to run if needed
		
		/*
		//Code to test if competitor info correctly loaded into Competitor objects in the roster.students ArrayList
		for(int i=0; i<roster.competitors.size(); i++) {
			roster.competitors.get(i).print_competitor();
		}
		*/
		
		/*
		//Code to test if student info correctly loaded into Student objects in the roster.students ArrayList
		for(int i=0; i<roster.students.size(); i++) {
			roster.students.get(i).print_student();
		}
		*/ 
		
		/*
		//Code to test ArrayFromCSV.make
		String[][] entries = ArrayFromCSV.make(11, 2, "csv_test - works.csv");
		int i = 0;
		while(i<11) {
			System.out.println(entries[i][0]+", "+entries[i][1]);
			i++;
		} 
		*/
		
		/* //Code to test CsvWriter.write
		ArrayList<String[]> test_list = new ArrayList<String[]>();
		
		String[] a = {"01", "111"};
		String[] b = {"02", "222"};
		String[] c = {"03", "333"};
		String[] d = {"04", "444"};
		String[] e = {"05", "555"};
		
		test_list.add(a);
		test_list.add(b);
		test_list.add(c);
		test_list.add(d);
		test_list.add(e);
		
		CsvWriter.write(test_list, "works.csv", "Code, ID");
		*/
		
		/*
		// Two tests for ArrayListFromCSV (produce same output)
		ArrayList<String[]> entries2 = ArrayListFromCSV.make(2, "csv_test - works.csv");
		String s = "";
		for(int i=0; i<entries2.size(); i++) {
			for(int j=0; j<entries2.get(0).length; j++) {
				s+=entries2.get(i)[j]+" ";
			}
			s+="\n";
		}
		
		System.out.println(s);
		
		System.out.println("*****");
		System.out.println();
		
		//same result as above
		for(int i=0; i<entries2.size(); i++) {
			for(int j=0; j<2; j++) {
				System.out.print(entries2.get(i)[j]+" ");
			}
			System.out.println();
		}
		
		*/
		
	}
}
