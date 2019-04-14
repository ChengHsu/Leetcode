package InterviewPrep.MSSuzhou;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class exponentialN {
    public int calculateN_recursive(int n) {
        if (n < 0)
            return -1;
        if(n == 0)
            return 1;
        return n * calculateN_recursive(n - 1);
    }

    public int calculateN_iterative(int n) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 1;
        int res = 1;

        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }



    public static void main(String[] args) {
        exponentialN exponentialN = new exponentialN();
        System.out.println(exponentialN.calculateN_iterative(5));
    }
}
