package BB;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Number: The number of questions
 * @Descpription:
 * Works well when addTrade is called frequently but printTopKVolume is called seldom
 *
 * If printTopKVolume is called frequently then I can maintain a order in addTrade
 * I create a doubly linked list with its nodes storing stockName and volume,
 * with support of a hashmap storing stockName as key and node as value. T
 * hen every time when add/update a trade, I remove the old trade node
 * and update its volume and search for a right position to insert it in the doubly linked list
 * time -> O(n) for searching
 * In this case, time for printTopKVolume -> O(k) for iterating list and return first k trades (at most k)
 * @Author: Created by xucheng.
 */
public class StockSystem {
    Map<String, Integer> map;

    public StockSystem(){
        map = new HashMap<>();
    }

    // time: O(1)
    // space: O(1)
    public void addTrade(String stockName, int volume) {
        map.put(stockName, map.getOrDefault(stockName, 0) + volume);
    }

    /**
     * If use a list to store stocks and sort, time -> O(n log n)
     * If use a priorityQueue to store stocks and keep k largest stocks in it, time -> O(n log k)
     * @param k
     * @throws Exception
     */
    public void printTopKVolume(int k) throws Exception {
        if(k <= 0) throw new IllegalArgumentException("Invalid Input k !");

        // If there is a tie what to do? Stock name with lower alphabetic order comes first
        PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) ->
                map.get(t1) == map.get(t2) ? t1.compareTo(t2): map.get(t1).compareTo(map.get(t2))
        );

        for(String key: map.keySet()) {
            pq.offer(key);
            if(pq.size() > k)
                pq.poll();
        }

        if(pq.isEmpty()) throw new Exception("No Trade Available At This Time!");

        // if no.of trades < k, return all
        while(!pq.isEmpty()) {
            String stock = pq.poll();
            System.out.println(stock + " " + map.get(stock));
        }
    }

    public static void main(String[] args) throws Exception {
        StockSystem s = new StockSystem();
        s.addTrade("A", 1);
        s.addTrade("B",3);
        s.printTopKVolume(2);
        System.out.println("       ");
        s.addTrade("A",5);
        s.addTrade("B",17);
        s.addTrade("C",20);
        s.addTrade("D",5);
        s.printTopKVolume(3);
    }
}
