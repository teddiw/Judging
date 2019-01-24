import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/* This is a helper class. The method called 'make' takes: 
 * the number of rows of the CSV file (numPeople)
 * the number of columns of the CSV file (numAnswers)
 * the file name.suffix (f)
 * 
 * 'make' returns a 2-D array of strings. Each row of this array contains information about a certain student. */
public class ArrayFromCSV {
		
	public static String[][] make(int numPeople, int numAnswers, String f) {
		File file = new File(f);
		String[][] list = new String[numPeople][numAnswers];
		try {
			Scanner inputStream = new Scanner(file);
			int counter = 0;
			while(inputStream.hasNextLine() && counter < numPeople) {
				String line = inputStream.next();
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter(",");
				for(int i=0; i<numAnswers; i++) {
					list[counter][i] = lineScanner.next();
					//System.out.println(list[counter][i]);
				}
				lineScanner.close();
				counter++;
				//System.out.println("***");
			}
			inputStream.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
}
