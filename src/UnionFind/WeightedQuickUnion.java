package UnionFind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Descpription:
 * https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
 * Modify quick-union to avoid tall trees.
 * Keep track of size of each component.
 * Balance by linking small tree below large one.
 * @Author: Created by xucheng.
 */
public class WeightedQuickUnion {

    private int[] parent;   // parent[i] = parent of i
    private int[] size;     // size[i] = number of sites in subtree rooted at i
    private int count;      // number of components

    public WeightedQuickUnion(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // initialize the parent of each node to itself
            size[i] = 1;
        }
    }

    /**
     * Returns the number of components.
     */
    public int count() {
        return count;
    }

    /**
     * Returns the component identifier for the component containing site {@code p}.
     * @param  p the integer representing one object
     * @return the component identifier for the component containing site {@code p}
     */
    public int find(int p) {
        while (p != parent[p]) {
            // path compression: set parent of p to its grandparent.
            // eventually every examined node on the way of finding root of p will be connected to the root of p
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    /**
     * Returns true if the the two sites are in the same component.
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    /**
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        // connected already
        if (rootP == rootQ) return;

        // link smaller tree below larger tree
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and n-1) from standard input,
     * where each integer represents some object;
     * if the sites are in different components, merge the two components
     * and print the pair to standard output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("/Users/xucheng/Desktop/input8.txt"));
        int n = input.nextInt();
        WeightedQuickUnion uf = new WeightedQuickUnion(n);
        while (input.hasNext()) {
            int p = input.nextInt();
            int q = input.nextInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " components");
    }
}
