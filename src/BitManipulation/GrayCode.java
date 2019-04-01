package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #89. Gray Code
 * @Descpription: The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * @Author: Created by xucheng.
 */
public class GrayCode {
    public List<Integer> grayCode(int n){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++){
            res.add(i ^ i >> 1);
        }
        return res;
    }
}
