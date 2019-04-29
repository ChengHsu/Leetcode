package InterviewPrep.WePay;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class ValidTriangle {
    public boolean isValid(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a)
            return false;
        else
            return true;
    }
}
