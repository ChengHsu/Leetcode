package InterviewPrep.WePay;



/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class ValidNumber {
    /**
     * Ignore the leading and trailing white spaces
     * Ensure that the all the characters in the belongs to {+,-,.,e,[0-9]}
     * Ensure that no '.' comes after 'e'
     * Ensure that no duplicate '.' and 'e'
     * 'e' should be followed by '+' '-' or a digit
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null)
            return false;

        // trims the spaces
        s = s.trim();

        if (s.length() == 0)
            return false;

        // if string is of length 1 and the only character is not a digit
//        if (s.length() == 1 && !Character.isDigit(s.charAt(0)))
//            return false;

        int signCount = 0;
        boolean hasE = false;
        boolean hasNum = false;
        boolean hasPoint = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // invalid character
            if (!isValidChar(c)) return false;

            // digit is always fine
            if (c >= '0' && c <= '9') hasNum = true;

            // e or E
            if (c == 'e' || c == 'E') {
                // e cannot appear twice and digits must be in front of it
                if (hasE || !hasNum) return false;
                // e cannot be the last one
                if (i == s.length() - 1) return false;

                hasE = true;
            }

            // decimal
            if (c == '.') {
                // . cannot appear twice and it cannot appear after an 'e'
                if (hasPoint || hasE) return false;
                // if . is the last one, digits must be in front of it, e.g. "7."
                if (i == s.length() - 1 && !hasNum) return false;

                hasPoint = true;
            }

            // signs
            if (c == '+' || c == '-') {
                // no more than 2 signs
                if (signCount == 2) return false;
                // sign cannot be the last one
                if (i == s.length() - 1) return false;
                // sign can appear in the middle only when e appears in front
                if (i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') return false;

                signCount++;
            }
        }

        return true;
    }

    private boolean isValidChar(char c) {
        return (c >= '0' && c <= '9') || c == '.' || c == '+' || c == '-' || c == 'e' || c == 'E';
    }
}





