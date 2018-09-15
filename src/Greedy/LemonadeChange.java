package Greedy;

/**
 * @Number: #860. Lemonade Change
 * @Descpription: At a lemonade stand, each lemonade costs $5.
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
 * You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 * Note that you don't have any change in hand at first.
 * Return true if and only if you can provide every customer with correct change.
 * @Author: Created by xucheng.
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int numFive = 0;
        int numTen = 0;
       for (int i = 0 ; i < bills.length; i++) {
           if (bills[i] == 5) {
               numFive += 1;
           }
           else if (bills[i] == 10) {
               if (numFive == 0)
                   return false;
               numTen += 1;
               numFive -= 1;
           }
           else if (bills[i] == 20) {
               if (numFive > 0 && numTen > 0) {
                   numTen--;
                   numFive--;
               }
               else if (numFive >= 3) {
                   numFive = numFive - 3;
               }
               else return false;
           }
       }
       return true;
    }
}
