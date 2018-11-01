package String;

/**
 * @Number: #434. Number of Segments in a String
 * @Descpription: Count the number of segments in a string, where a segment is defined to be a contiguous
 * sequence of non-space characters.
 * @Author: Created by xucheng.
 */
public class NumberofSegmentsinaString {
    public int countSegments(String s) {
        String trimmed = s.trim();
        return trimmed.length() == 0? 0: trimmed.split("\\s+").length;
    }
}
