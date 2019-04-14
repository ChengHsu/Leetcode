package InterviewPrep.MSSuzhou;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Cluster {

    private class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
//            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public List<List<Point>> findCluster(Point[] points, int k) {

        List<List<Point>> clusters = new ArrayList<>();
        Set<Point> visited = new HashSet<>();

        if (points == null || points.length == 0)
            return clusters;

//        for (Point point : points) {
//            clusters.add(dfs(points, new ArrayList<>(), visited, point));
//        }
//
//        return clusters;

        HashMap<Point, Set<Point>> map = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            if (!map.containsKey(points[i]))
                map.put(points[i], new HashSet<>());
            Set<Point> neighbors = map.get(points[i]);
            for (int j = 0; j < points.length; j++) {
                if(getDistance(points[i], points[j]) < k)
                    neighbors.add(points[j]);
            }
            map.put(points[i],neighbors);
        }

        dfs(points, map, )
    }

    public double getDistance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    public List<Point> dfs(Point[] points,  List<Point> currCluster, Set<Point> visited, Point point) {

        visited.add(point);
        for (Point p : points) {
            if (p.equals(point))
                continue;
            if (!visited.contains(p) && getDistance(p, point) < 1) {
                currCluster.add(p);
                dfs(points, currCluster, visited, p);
            }
        }

        return currCluster;
    }
}
