import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* This is a helper class. The method called 'write' takes: 
 * an arraylist of string arrays of what is to be written into the CSV file (list)
 * the desired name of the CSV file, include the suffix (fileName)
 * a string of the labels for each column separated by commas (fileHeader)
 * 
 * 'write' creates a CSV file and places it into the file directory. 
 * Each row of this file contains information about a certain student. */

public class CsvWriter {
	
	private static String COMMA_DELIMITER = ",";
	private static String NEW_LINE_SEPARATOR = "\n";
	
	//public String FILE_HEADER = "Code, Name1, Name2, Period, Sports?, State?";
	public static void write(ArrayList<String[]> list, String fileName, String fileHeader) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.append(fileHeader.toString());
			fileWriter.append(NEW_LINE_SEPARATOR);
			for(int i=0; i<list.size(); i++) {
				fileWriter.append(String.valueOf(list.get(i)[0]));
				for(int j=1; j<list.get(i).length; j++) {
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(list.get(i)[j]));
				}
				fileWriter.append(NEW_LINE_SEPARATOR);
			} 
		} catch (Exception e) {
				System.out.println("Error in writeCSV");
				e.printStackTrace();
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
				} catch(IOException e) {
					System.out.println("Erro while flushing/closing fileWriter");
					e.printStackTrace();
				}
			}
		}
	
	public static ArrayList<String[]> format_students(ArrayList<Student> students, int student_info_num){
		ArrayList<String[]> formatted_students = new ArrayList<String[]>();
		for(int i=0; i<students.size(); i++) {
			String[] current_list = new String[student_info_num];
			current_list[0] = Integer.toString(students.get(i).get_id());
			current_list[1] = students.get(i).get_first_name();
			current_list[2] = students.get(i).get_last_name();
			current_list[3] = Integer.toString(students.get(i).get_times_competed());
			current_list[4] = Integer.toString(students.get(i).get_times_judged());
			current_list[5] = students.get(i).get_email();
			current_list[6] = students.get(i).get_phone_number();
			current_list[7] = Integer.toString(students.get(i).get_sibling1_id());
			current_list[8] = Integer.toString(students.get(i).get_sibling2_id());
			current_list[9] = Integer.toString(students.get(i).get_sibling3_id());
			current_list[10] = Integer.toString(students.get(i).get_sibling4_id());
			current_list[11] = students.get(i).get_judge1().get_first_name();
			current_list[12] = students.get(i).get_judge1().get_last_name();
			current_list[13] = students.get(i).get_judge1().get_email();
			current_list[14] = students.get(i).get_judge1().get_phone_number();
			current_list[15] = students.get(i).get_tournaments_attended();
			
			formatted_students.add(current_list);
		}
		return formatted_students;
	}
}



