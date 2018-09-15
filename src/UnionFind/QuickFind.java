package UnionFind;

import java.io.File;
import java.util.Scanner;

/**
 * @Descpription: Union too expensive
 * @Author: Created by xucheng.
 */
public class QuickFind {

    // 连通分量数
    private int count;
    // 每个元素所属的连通分量
    private int[] id;

    // 初始化，N个连通分量，每个元素的连通分量是它自己
    public QuickFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N ;i++)
            id[i] = i;
    }

    /**
     * 取得连通分量数
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * 查找x所属的连通分量
     * @param x
     * @return
     */
    public int find(int x) {
        return id[x];
    }

    /**
     * 连接p和q，将p所在的连通分量改为q的
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        for (int i = 0; i < id.length; i++) {
            if (find(i) == pId)
                id[i] = qId;
        }
        count--;
    }

    /**
     * 判断p和q是否连接
     * @return
     */
    public boolean connected(int p, int q) {
        return (find(p) == find(q));
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("/Users/xucheng/Desktop/input8.txt"));
        int N=input.nextInt();
        QuickFind uf = new QuickFind(N);
        while (input.hasNext()) {
            int p = input.nextInt();
            int q = input.nextInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            System.out.println(p + " - " + q);
        }
        System.out.println("Connected Component Numbers: " + uf.getCount());
    }

    }
