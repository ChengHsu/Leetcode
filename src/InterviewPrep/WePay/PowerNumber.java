package InterviewPrep.WePay;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * 4 (2^2)
 * 8 (2^3)
 * 9 (3^2)
 * 16(2^4,4^2)
 * 25(5^2)
 * 27(3^3)
 * 32(2^5)
 * 36(6^2)
 * 49(7^2)
 * 64(2^6,8^2)
 * 81(3^4,9^2)
 * 100(10^2)
 *
 * @Author: Created by xucheng.
 */
public class PowerNumber {
    public int getPowerNumber(int index) {
        if (index < 0)
            return Integer.MIN_VALUE;
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        int tempIndex = index;

        for (int base = 2; base <= index + 3; base++) {
            long number = base;
            for (int j = 2; j <= 20; j++) {
                number *= base;
                if (tempIndex < 3)
                    tempIndex = 3;
                if (number > (tempIndex + 1) * (tempIndex + 1))
                    break;
                if (set.contains(number))
                    continue;
                queue.offer(number);
                set.add(number);
            }
        }

        for (int i = 0; i < index; i++) {
            queue.poll();
        }
        assert queue.peek() != null;
        return queue.peek().intValue();
    }
}
