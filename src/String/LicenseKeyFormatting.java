package String;

/**
 * @Number: #482. License Key Formatting
 * @Descpription: You are given a license key represented as a string S which consists only alphanumeric character and dashes.
 * The string is separated into N+1 groups by N dashes.
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character.
 * Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 * The length of string S will not exceed 12,000, and K is a positive integer.
 * String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
 * String S is non-empty.
 * @Author: Created by xucheng.
 */
public class LicenseKeyFormatting {
//    public String licenseKeyFormatting(String S, int K) {
//        S = S.toUpperCase();
//        StringBuilder processed = new StringBuilder();
//        for (char ch : S.toCharArray())
//            if (ch != '-')
//                processed.append(ch);
//        // for special case like : "---"
//        if (processed.length() == 0)
//            return "";
//
//        StringBuilder formatted = new StringBuilder();
//        int i = (processed.length() % K != 0) ? processed.length() % K : K;
//        formatted.append(processed.substring(0, i));
//        // not only one group
//        if (i != processed.length()) {
//            // add '-' to the end of first group
//            formatted.append('-');
//            for (; i < processed.length() - K; i += K) {
//                formatted.append(processed.substring(i, i + K));
//                formatted.append('-');
//            }
//            // no '-' at the end of last group
//            formatted.append(processed.substring(i));
//        }
//        return formatted.toString();
//    }

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        String s = S.toUpperCase();

        for (int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if (ch != '-'){
                if (cnt == K){
                    sb.append('-');
                    cnt = 0;
                    sb.append(ch);
                }
                else sb.append(ch);
                cnt++;
            }
        }
        return sb.reverse().toString();
    }
}
