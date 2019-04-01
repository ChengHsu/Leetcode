package Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Number: #252. Meeting Rooms
 * @Descpription: Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), determine if a person could attend all meetings.
 * 253. Meeting Rooms II
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 * @Author: Created by xucheng.
 */
public class MeetingRooms {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * 252
     * time: O(n log n)
     *
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0)
            return true;
        Arrays.sort(intervals, new IntervalComparator());

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start)
                return false;
        }
        return true;
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return (o1.start - o2.start == 0) ? o1.end - o2.end : o1.start - o2.start;
        }
    }


    /**
     * 253
     * https://www.youtube.com/watch?v=jUpuIio_oYo
     * 1. sort all start times and end times
     * 2. iterate every start time, if it's behind current end time, then there is time conflict
     * time: O(n log n)
     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0)
            return 0;

        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < len; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            // As long as there is a start time before the current end time, there is one overlap, so we add a room
            if (start[i] < end[right])
                rooms++;
             else right++;
        }
        return rooms;
    }
}
