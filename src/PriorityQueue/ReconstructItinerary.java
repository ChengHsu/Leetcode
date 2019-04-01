package PriorityQueue;

import java.util.*;

/**
 * @Number: #332. Reconstruct Itinerary
 * @Descpription: Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * @Author: Created by xucheng.
 */
public class ReconstructItinerary {
    /**
     * DFS
     * @param tickets
     * @return
     */
//    public List<String> findItinerary(String[][] tickets) {
//        List<String> res = new ArrayList<>();
//        if (tickets == null|| tickets.length == 0)
//            return res;
//
//        int totalLen = tickets.length + 1;
//
//        Map<String, List<String>> map = new HashMap<>();
//        for (String[] ticket: tickets) {
//            if (!map.containsKey(ticket[0]))
//                map.put(ticket[0], new ArrayList<>());
//            map.get(ticket[0]).add(ticket[1]);
//        }
//
//        // keep destinations in lexical order
//        for (List<String> list: map.values())
//            Collections.sort(list);
//
//        String start = "JFK";
//        res.add(start);
//
//        if (findItinerary(start, res, map,totalLen))
//            return res;
//        else
//            return null;
//
//    }
//
//    private boolean findItinerary(String start, List<String> path, Map<String, List<String>> map, int totalLen) {
//        if (path.size() == totalLen)
//            return true;
////      no available destination from current start
//        if (!map.containsKey(start))
//            return false;
//
//        List<String> destinations = map.get(start);
//        for (int i =0 ; i < destinations.size(); i++) {
//            String dest = destinations.get(i);
//            destinations.remove(i);
//            path.add(dest);
//            // try to find next dest from current dest
//            if (findItinerary(dest, path, map, totalLen))
//                return true;
//            // backtrack
//            path.remove(path.size() - 1);
//            destinations.add(i,dest);
//        }
//        return false;
//    }


    /**
     * Eulerian path: In graph theory, an Eulerian trail is a trail in a finite graph which visits every edge exactly once
     * => 每个票用一次并且全部用掉
     * Hierholzer algorithm
     * path = []
     * DFS(u):
     *  while (u存在未被访问的边e(u,v)):
     *      mark e(u,v)为visited
     *      DFS(v)
     *  path.pushLeft(u)
     *
     *  time: create graph: O(n + n log n), Hierholzer: O(n)
     *      O(n + n log n + n)
     *  space: O(n)
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary(String[][] tickets) {
        // use Priority Queue to keep lexical order
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        // create graph
        for (String[] ticket: tickets) {
            if (!map.containsKey(ticket[0]))
                map.put(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }

        String start = "JFK";
        dfs(start, res, map);
        return res;
    }

    private void dfs(String start, LinkedList<String> res, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> destinations = map.get(start);

        //  while (u存在未被访问的边e(u,v)), 弹出Priority Queue, 并以此点为起点dfs找下一个dest
        while (destinations != null && !destinations.isEmpty())
            dfs(destinations.poll(), res, map);

        // 从该点出发没有未被访问的点了，加入list最前面
        res.addFirst(start);
    }

}
