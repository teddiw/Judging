import java.util.ArrayList;
/*
 * This is a helper class. The  method 'lowest_scores' takes: 
 * an ArrayList of Student objects (competing_students)
 * the number of judges needed (num_judges) 
 * 
 * 'lowest_scores' returns an ArrayList of Student objects containing the num_judges quantity of 
 * Student objects with the lowest times_judged:times_competed score.
 */
public class Select{
	public static ArrayList<Student> lowest_scores(ArrayList<Student> competing_students, int num_judges){
		ArrayList<Student> competitors_for_judging = new ArrayList<Student>();
		for(int i=0; i<num_judges; i++) {
			int lowest_index = 0;
			double lowest_value = competing_students.get(0).get_score();
			for(int j=0; j<competing_students.size(); j++) {
				if(lowest_value > competing_students.get(j).get_score()) {
					lowest_value = competing_students.get(j).get_score();
					lowest_index = j;
				}
			}
			competitors_for_judging.add(competing_students.remove(lowest_index));
		}
		return competitors_for_judging;
	}	
}