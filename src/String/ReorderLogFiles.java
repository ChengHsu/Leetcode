package String;

import java.util.*;

/**
 * @Number: #937. Reorder Log Files
 * @Descpription: You have an array of logs.  Each log is a space delimited string of words.
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 * @Author: Created by xucheng.
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        // 按字典顺序比较两个字符串 compareTo
        // 1. letter log before digit log
        // 2. The digit-logs should be put in their original order.
        // 3. letter log ordered lexicographically ignoring identifier
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (String log: logs) {
            if (isLetterLog(log)) {
                letterLogs.add(log);
            }
            else digitLogs.add(log);
        }
        // Comparator
        Collections.sort(letterLogs,(a,b)->{
            String identifier1 = a.substring(0,a.indexOf(" "));
            String content1 = a.substring(a.indexOf(" "));
            String identifier2 = b.substring(0,b.indexOf(" "));
            String content2 = b.substring(b.indexOf(" "));
            int compare = content1.compareTo(content2);
            if (compare != 0)
                return compare;
            return identifier1.compareTo(identifier2);
        });

        String[] res = new String[logs.length];
        int idx = 0;
        for (String log: letterLogs)
            res[idx++] = log;
        for (String log: digitLogs)
            res[idx++] = log;
        return res;
    }

    private boolean isLetterLog(String log) {
        char c = log.charAt(log.indexOf(" ")+1);
        if (c >= 'a' && c <= 'z')
            return true;
        else return false;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("ba", "aa");
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("ff", "ff");
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("ee", "ee");
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("bb", "ee");
        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("gg", "gg");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        Collections.sort(list,(s1, s2) ->
            s1.entrySet().toString().compareTo(s2.entrySet().toString())
        );
        System.out.println(list);


    }

}
