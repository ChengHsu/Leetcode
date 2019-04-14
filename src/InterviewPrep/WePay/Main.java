package InterviewPrep.WePay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
//        ZombieCluster zombieCluster = new ZombieCluster();
//        String[] M = new String[]{"110", "110","001"};
//        System.out.println(zombieCluster.zombieCluster_dfs(M));

//        Braces braces = new Braces();
//        String[] brace = new String[]{"({})[)","()"} ;
//        System.out.println(Arrays.toString(braces.balancedBrace(brace)));

//        CalendarCalculate calendarCalculate = new CalendarCalculate();
//
//        System.out.println(calendarCalculate.getDate(2019));


        Alerter alerter = new Alerter();

        System.out.println(alerter.raiseAlert(new int[]{1,2,100,2,2},3, 1.5));
        System.out.println(alerter.raiseAlert(new int[]{1,2,4,2,2},3, 2));
        System.out.println(alerter.raiseAlert(new int[]{1,2,100,2,2},2, 2.5));

    }
}
