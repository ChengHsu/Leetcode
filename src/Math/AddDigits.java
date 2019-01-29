package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: 258. Add Digits
 * @Descpription: Given a non-negative integer num,
 * repeatedly add all its digits until the result has only one digit.
 * @Author: Created by xucheng.
 */
public class AddDigits {
    /**
     * naive
     * 分离digits并求和，为一位数则退出；否则继续repeat
     * @param num
     * @return
     */
//    public int addDigits(int num) {
//        int res = num;
//        while (res >= 10) {
//            List<Integer> list = helper(res);
//            res = 0;
//            for (int i = 0; i < list.size(); i++)
//                res += list.get(i);
//        }
//        return res;
//    }
//
//    private List<Integer> helper(int res) {
//        List<Integer> list = new ArrayList<>();
//        while (res != 0) {
//            list.add(res % 10);
//            res /= 10;
//        }
//        return list;
//    }

    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }

}
