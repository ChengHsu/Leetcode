package Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Number: #621. Task Scheduler
 * @Descpription: Given a char array representing tasks CPU need to do.
 * It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 * @Author: Created by xucheng.
 */
public class TaskScheduler {

    /**
     * Greedy : always process the task which has largest amount left
     * time: O(1). queue and map size will not exceed O(26).
     * @param tasks
     * @param n
     * @return
     */
//    public int leastInterval(char[] tasks, int n) {
//        // if cool down interval = 0, no idle interval
//        if (n == 0)
//            return tasks.length;
//
//        // record each type of task and its amount
//        Map<Character, Integer> count = new HashMap<>();
//        for (char task : tasks)
//            count.put(task, count.getOrDefault(task, 0) + 1);
//
//        // put all amounts into queue and always maintain the max one so far as the first one
//        PriorityQueue<Integer> queue = new PriorityQueue<>((t1, t2) -> t2 - t1);
//        for (char c : count.keySet())
//            queue.offer(count.get(c));
//
//        // process the tasks from the front of the queue
//        Map<Integer, Integer> coolDown = new HashMap<>();
//        int currInterval = 0;
//        while (!queue.isEmpty() || !coolDown.isEmpty()) {
//            // if after n intervals, this task's cooling down period expired, remove it from coolDown map and add it to the queue
//            if (coolDown.containsKey(currInterval - n - 1))
//                queue.offer(coolDown.remove(currInterval - n - 1));
//
//            if (!queue.isEmpty()) {
//                int front = queue.poll() - 1;
//                // if still has this type of task left then put it into cooldown map after reduce its amount by 1
//                if (front != 0)
//                    coolDown.put(currInterval, front);
//            }
//            currInterval++;
//        }
//        return currInterval;
//    }

    /**
     * calculating the idle slots
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}
