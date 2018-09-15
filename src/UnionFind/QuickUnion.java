package UnionFind;

import java.io.File;
import java.util.Scanner;

/**
 * @Descpription: Tree structure. Only change the value of root when union.
 * Trees can get tall. Find too expensive. Need to do Find to do Union.
 * @Author: Created by xucheng.
 */
public class QuickUnion {

    // 每个元素所属的连通分量
    private int[] id;

    // 初始化，N个连通分量，每个元素的连通分量是它自己
    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N ;i++)
            id[i] = i;
    }

    /**
     * 查找x所属的根节点
     * @param x
     * @return
     */
    public int root(int x) {
        while (x != id[x]) x = id[x];
        return x;
    }


    /**
     * 连接p和q，将p所在的连通分量改为q的
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pId = root(p);
        int qId = root(q);
        id[p] = qId;
    }

    /**
     * 判断p和q是否连接
     * @return
     */
    public boolean connected(int p, int q) {
        return (root(p) == root(q));
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("/Users/xucheng/Desktop/input8.txt"));
        int N=input.nextInt();
        QuickUnion qu = new QuickUnion(N);
        while (input.hasNext()) {
            int p = input.nextInt();
            int q = input.nextInt();
            if (qu.connected(p,q)) continue;
            qu.union(p,q);
            System.out.println(p + " - " + q);
        }
    }

}
