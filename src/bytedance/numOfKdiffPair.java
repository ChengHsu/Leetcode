package bytedance;

import java.util.*;

/**
 * @Number: The number of questions
 * @Descpription: 在n个元素的数组中，找到差值为k的数字对去重后的个数
 * @Author: Created by xucheng.
 */
public class numOfKdiffPair {

    public static void main(String[] args) {
        int[] num = new int[]{1,1,5,5,3,3};
        System.out.println(countNum_2(num, 2));

    }

    /**
     * time: O(nlogn)
     * space: O(1)
     *
     * @param num
     * @param k
     * @return
     */
    public static int countNum_1(int[] num, int k) {
        int cnt = 0;
        Arrays.sort(num);
        int i = 0, j = 0;
        int count = 0;
        while (i < num.length && j < num.length) {
            if (num[j] - num[i] < k) {
                j++;
            } else if (num[j] - num[i] == k) {
                count++;
                int tmpI = num[i];
                int tmpJ = num[j];
               while (i < num.length && j < num.length && (tmpI == num[i] || tmpJ == num[j])){
                   if(tmpI == num[i])
                       i++;
                   if (tmpJ == num[j])
                       j++;
               }
            } else {
                i++;
            }
        }
        return count;
    }


    /**
     * time: O(n)
     * space: O(n)
     * @param num
     * @param k
     * @return
     */
    public static int countNum_2(int[] num, int k){
       HashSet<Integer> set = new HashSet<>();
        for (int n: num){
            set.add(n);
        }

        int count= 0;

        for(int i = 0; i < num.length; i++){
            if(set.contains(num[i] + k)){
                count++;
                set.remove(num[i] + k);
            }
        }
        return count;
    }
}
