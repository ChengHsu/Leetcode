package InterviewPrep.WePay;

import java.util.Calendar;

/**
 * @Number: 计算某一年的第十个月的第二个星期二是第几号
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class CalendarCalculate {
    public int getDate(int year) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 9);
        calendar.set(Calendar.WEEK_OF_MONTH, 1);
        calendar.set(Calendar.DAY_OF_WEEK, 3);
        System.out.println(calendar.getTime());
        int date = calendar.get(Calendar.DAY_OF_MONTH);

        // this month starts from Tuesday or a day before Tuesday
        if (date <= 3 ) {
            calendar.set(Calendar.WEEK_OF_MONTH, 2);
        }
        // this month starts from a day behind Tuesday
        else
            {
            calendar.add(Calendar.MONTH,1);
            calendar.set(Calendar.WEEK_OF_MONTH, 3);
        }
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
