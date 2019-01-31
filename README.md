# Judging

## Problem:
High school speech and debate tournaments require a team of competitors to bring along a proportional 
number of judges (often parents) that is always less than the number of competitors. To ensure that each 
student/family has a fair judging burden (that is proportional to the number of times the student has 
competed), our team currently requires a student to bring along a judge every single time they compete. 
This is problematic because many of the judges who show up are never called to judge, simply because the 
tournament never required that many judges in the first place. 

## Solution:
This automated judge selection system tracks the number of times a student has competed and the number of 
times the student has brought a judge throughout the tournament season. For each upcoming tournament, 
attending students are ranked by their #timesjudged to #timescompeted ratios and those with the lowest 
ratios are selected to provide a judge for the tournament. This allows exactly the number of judges required 
by the tournament to be sent to the tournament in order to avoid the problem outlined above.

Before every tournament, the Client.java should be run. 
- students_num should be changed to the number of students on the uploaded roster. 
- competitors_num should be changed to the number of students competing. 
- studentsCSVfileName is the filename of the student roster to upload with header format 
  (open students_test - Sheet1.csv to see required format):
  id | first_name | last_name | times_competed | times_judged | email | phone_number | sbling1_id | sibling2_id | sibling3_id   | sibling4_id | judge1_first_name | judge1_last_name | judge1_email | judge1_phone_number | tournaments_attended
- competitorsCSVfileName is the filename of the competitor roster to upload with no header format 
  (open competitors_test - Sheet1.csv to see required format).

Running Client.java will create two new files called "updated_roster.csv" and "students_to_provide_judges.csv"
which will be placed in your directory. These files contain the updated list of students and the list of students 
who are to provide judges for the upcoming tournament.

To see an example of this code: students_test - Sheet1.csv and competitors_test - Sheet1.csv are test files and can be used to run Client.java to obtain the two output files.
