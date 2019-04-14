package InterviewPrep.MSSuzhou;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class AmicableNumber {
    public int sumOfProperDivisors(int n) {
        if (n <= 1)
            return -1;

        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;

                // to handle perfect square. e.g. avoid adding 8 twice if n = 64
                if (n / i != i) {
                    sum += n / i;
                }
            }
        }

        return sum;
    }


    public int amicablePair(int n1) {
        int n2 = sumOfProperDivisors(n1);

        if (n1 != n2 && sumOfProperDivisors(n2) == n1)
            return n2;
        else
            return -1;
    }

    /* return all amicable numbers that are less than num */
    public List<int[]> findAmicableNum(int num) {
        List<int[]> res = new ArrayList<>();
        HashSet<Integer> allAmicableNums = new HashSet<>();

        for (int i = 0; i < num; i++) {
            int amicableNum = amicablePair(i);
            if (amicableNum != -1) {
                // remove duplicate pairs
                if (!allAmicableNums.contains(i) && !allAmicableNums.contains(amicableNum))
                    res.add(new int[]{i, amicableNum});
                allAmicableNums.add(i);
                allAmicableNums.add(amicableNum);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        AmicableNumber amicableNumber = new AmicableNumber();
        List<int[]> pairs = amicableNumber.findAmicableNum(100000);

        for (int[] pair : pairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}
