package Greedy;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
//        int[] g = {1,2,3};
//        int[] s = {1,1};
//        AssignCookies assignCookies = new AssignCookies();
//        System.out.println(assignCookies.findContentChildren(g,s));

        int[] bills = {5,5,10,10,20};
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(bills));
    }
}
