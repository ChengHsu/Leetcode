package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: # 412. Fizz Buzz
 * @Descpription: Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 * @Author: Created by xucheng.
 */
public class FizzBuzz {
    /**
     * naive
     * time: O(n)
     * space: O(1)
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1)
            return res;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                res.add("FizzBuzz");
            else if (i % 3 == 0)
                res.add("Fizz");
            else if (i % 5 == 0)
                res.add("Buzz");
            else res.add(String.valueOf(i));
        }
        return res;
    }
}
