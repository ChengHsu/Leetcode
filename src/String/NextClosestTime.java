package String;

import java.util.HashSet;

/**
 * @Number: #681. Next Closest Time
 * @Descpription: Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 * @Author: Created by xucheng.
 */
public class NextClosestTime {
    /**
     * Simulation
     *
     * @param time
     * @return
     */
//    public String nextClosestTime(String time) {
//        HashSet<Integer> set = new HashSet<>();
//        String[] timeArr = time.split(":");
//
//        int hour = Integer.parseInt(timeArr[0]);
//        int minute = Integer.parseInt(timeArr[1]);
//
//        int minNum = 10;
//        for (int i = 0; i < 2; i++) {
//            set.add(timeArr[i].charAt(0) - '0');
//            set.add(timeArr[i].charAt(1) - '0');
//            minNum = Math.min(minNum, Math.min(timeArr[i].charAt(0) - '0', timeArr[i].charAt(1) - '0'));
//        }
//
//        for (int min = minute + 1; min < 60; min++) {
//            if (set.contains(hour / 10) && set.contains(hour % 10) && set.contains(min / 10) && set.contains(min % 10)) {
//                return String.format("%02d:%02d",hour, min);
//            }
//        }
//
//        for (int hr = hour + 1; hr < 24; hr++) {
//            for (int min = 0; min < 60; min++) {
//                if (set.contains(hr / 10) && set.contains(hr % 10) && set.contains(min / 10) && set.contains(min % 10)) {
//                    return String.format("%02d:%02d",hr, min);
//                }
//            }
//        }
//        String tmp = String.valueOf(minNum);
//        return tmp + tmp + ":" + tmp + tmp;
//    }



    class Solution {
        public String nextClosestTime(String time) {
            HashSet<Integer> set = new HashSet<>();
            String[] timeArr = time.split(":");

            int hour = Integer.parseInt(timeArr[0]);
            int minute = Integer.parseInt(timeArr[1]);

            int minNum = 10;
            for (int i = 0; i < 2; i++) {
                set.add(timeArr[i].charAt(0) - '0');
                set.add(timeArr[i].charAt(1) - '0');
                minNum = Math.min(minNum, Math.min(timeArr[i].charAt(0) - '0', timeArr[i].charAt(1) - '0'));
            }

            for (int min = minute + 1; min < 60; min++) {
                if (set.contains(hour / 10) && set.contains(hour % 10) && set.contains(min / 10) && set.contains(min % 10)) {
                    String resHr = String.valueOf(hour);
                    String resMin = String.valueOf(min);
                    if (hour < 10)
                        resHr = "0" + String.valueOf(hour);
                    if (min < 10)
                        resMin = "0" + String.valueOf(min);
                    return resHr + ":" + resMin;
                }
            }

            for (int hr = hour + 1; hr < 24; hr++) {
                for (int min = 0; min < 60; min++) {
                    if (set.contains(hr / 10) && set.contains(hr % 10) && set.contains(min / 10) && set.contains(min % 10)) {
                        String resHr = String.valueOf(hr);
                        String resMin = String.valueOf(min);
                        if (hour < 10)
                            resHr = "0" + String.valueOf(hr);
                        if (min < 10)
                            resMin = "0" + String.valueOf(min);
                        return resHr + ":" + resMin;
                    }
                }
            }
            String tmp = String.valueOf(minNum);
            return tmp + tmp + ":" + tmp + tmp;
        }
    }

}
