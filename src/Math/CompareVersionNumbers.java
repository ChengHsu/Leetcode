package Math;

/**
 * @Number: 165. Compare Version Numbers
 * @Descpription: Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * You may assume the default revision number for each level of a version number to be 0.
 * For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number.
 * Its third and fourth level revision number are both 0.
 * Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
 * Version strings do not start or end with dots, and they will not be two consecutive dots.
 * @Author: Created by xucheng.
 */
public class CompareVersionNumbers {
    /**
     * Split String by dot, the regex should be "\\."
     * Use Integer.parseInt() to convert String to Int and eliminate leading 0s.
     * Use compareTo to get the comparison result
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] arrV1 = version1.split("\\.");
        String[] arrV2 = version2.split("\\.");
        int len = Math.max(arrV1.length, arrV2.length);

        for (int i = 0; i < len; i++) {
            Integer v1 = i < arrV1.length? Integer.parseInt(arrV1[i]): 0;
            Integer v2 = i < arrV2.length? Integer.parseInt(arrV2[i]): 0;
            int res = v1.compareTo(v2);
            // res == 0 , continue comparison the next pair of strings
            if (res != 0)
                return res;
        }
        return 0;
    }
}
