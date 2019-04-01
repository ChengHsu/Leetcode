package PriorityQueue;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {12,6,9,8,5,7};
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int num: nums) {
            pq.add(num);
            // 按升序排列，最后留下3个最大的
            if (pq.size() > 3)
                pq.poll();
        }

        while (!pq.isEmpty())
            System.out.println(pq.poll());
//
//        Iterator iterator = pq.iterator();
//
//        while (iterator.hasNext())
//            System.out.println(iterator.next());


    }
}
