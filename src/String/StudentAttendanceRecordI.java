package String;

/**
 * @Number: #551. Student Attendance Record I
 * @Descpription: You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * @Author: Created by xucheng.
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A')
                countA++;
            if (s.charAt(i) == 'L') {
                // if current char is the first one or its previous char also is 'L', add count
                if (i == 0 || s.charAt(i-1) == 'L')
                    countL++;
                // Not continuous, the current L becomes the 1st of continuous L substring, set countL to 1
                else countL = 1;
            }
            // Have to judge after count operation to avoid case with "LL" at the last.
            if (countA > 1 || countL > 2)
                return false;
        }
        return true;
    }
}
