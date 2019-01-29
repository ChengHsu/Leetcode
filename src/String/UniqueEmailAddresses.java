package String;

import java.util.HashSet;
import java.util.Set;


/**
 * @Number: #929. Unique Email Addresses
 * @Descpription: Every email consists of a local name and a domain name, separated by the @ sign.
    For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
    Besides lowercase letters, these emails may contain '.'s or '+'s.
    If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be
    forwarded to the same address without dots in the local name.
    For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
    (Note that this rule does not apply for domain names.)
    If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
    This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
    (Again, this rule does not apply for domain names.)
    It is possible to use both of these rules at the same time.
    Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 * @Author: Created by xucheng.
 */
public class UniqueEmailAddresses {
    // naive
    // step 1: Process strings: for each local part of a given string, delete '.' in it and delete the substring between '+' and '@'
    // step 2: Store each string into a HashSet and return the size of HashSet.
//    public int numUniqueEmails(String[] emails) {
//        HashSet<String> strings = new HashSet<>();
//        for (int i = 0; i < emails.length; i++) {
//            StringBuilder sb = new StringBuilder(emails[i]);
//            boolean isLocal = true;
//            boolean hasPlus = false;
//            int start = 0, end = 0;
//            // walk through every char in a string
//            for (int j = 0; j < sb.length(); j ++) {
//                if (sb.charAt(j) == '@') {
//                    isLocal = false;
//                    end = j;
//                }
//                if (isLocal) {
//                    if (sb.charAt(j) == '.') {
//                        sb.deleteCharAt(j);
//                    }
//                    if (sb.charAt(j) == '+' && !hasPlus) {
//                        hasPlus = true;
//                        start = j;
//                        sb.deleteCharAt(j);
//                    }
//                }
//            }
//            if (start != 0 && end != 0)
//                sb.delete(start,end);
//            strings.add(sb.toString());
//            System.out.println(sb);
//        }
//        return strings.size();
//    }

    /**
     * Split every email into 2 parts: local and domain
     * Just take the sub string before "+"
     * Replace all "." with ""
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email: emails) {
            int split = email.indexOf('@');
            String local = email.substring(0,split);
            String domain = email.substring(split);
            if (local.contains("+")) {
                local = local.substring(0,local.indexOf('+'));
            }
            System.out.println("bef: "+local);
            local = local.replace(".","");
            System.out.println(local+domain);
            set.add(local + domain);
        }
        return set.size();
    }
}
