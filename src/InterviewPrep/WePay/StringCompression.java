package InterviewPrep.WePay;

/**
 * @Number: 443. String Compression
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class StringCompression {
    /**
     * time :O(n)
     * space: O(n)
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            int end = i;
            while (end < chars.length && chars[end] == chars[i])
                end ++;

            // only one character no duplicate
            if (end == i + 1){
                chars[start++] = chars[i];
            }
            else {
                chars[start++] = chars[i];
                // String.valueOf: # of duplicates
                char[] count = String.valueOf(end - i).toCharArray();
                for (int l = 0; l < count.length; l++)
                    chars[start++] = count[l];
            }

            i = end - 1;
        }
        return start;
    }
}
