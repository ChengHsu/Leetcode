package Array;

import java.util.*;

/**
 * @Number: #56. Merge Intervals
 * @Descpription: Given a collection of intervals, merge all overlapping intervals.
 * @Author: Created by xucheng.
 */
public class MergeIntervals {
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

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return (o1.start - o2.start == 0) ? o1.end - o1.end : o1.start - o2.start;
        }
    }

    /**
     * time: O(n log n)
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0)
            return ans;
        // sort the interval in ascending order
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> queue = new LinkedList<>();

        for (Interval interval : intervals) {
            if (queue.isEmpty() || queue.getLast().end < interval.start)
                queue.offer(interval);
            else
                // case : [1,4] [2,3] can't just make o1.end = o2.end
                queue.getLast().end = Math.max(queue.getLast().end, interval.end);
        }
        return queue;
    }
}
