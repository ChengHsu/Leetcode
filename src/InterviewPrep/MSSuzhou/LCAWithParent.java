package InterviewPrep.MSSuzhou;

import Tree.TreeNode;

import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class LCAWithParent {

    class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }

    /**
     * time : O(h)
     * space: O(1)
     * @param p
     * @param q
     * @return
     */
    public Node findLCA(Node p, Node q) {
        int pDepth = getDepth(p);
        int qDepth = getDepth(q);

        // make sure p is the deeper one for simplicity
        if (qDepth > pDepth) {
            Node tmp = q;
            q = p;
            p = tmp;
        }

        // Ascends from the deeper one
        int depthDiff = pDepth - qDepth;
        while (depthDiff-- > 0) {
            p = p.parent;
        }

        // ascends both util reach the LCA
        while (p != null) {
            if (p == q)
                return p;
            p = p.parent;
            q = q.parent;
        }
        throw new NoSuchElementException("LCA is not found");
    }

    private int getDepth(Node node) {
        int depth = 0;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    /**
     * time: O(h)
     * space: O(h)
     * @param p
     * @param q
     * @return
     */
    public Node findLCAWithSet(Node p, Node q) {
        HashSet<Node> set = new HashSet<>();

        while (p != null) {
            set.add(p);
            p = p.parent;
        }

        while (q != null) {
            if (set.contains(q))
                return q;
            q = q.parent;
        }
        throw new NoSuchElementException("LCA is not found");
    }
}
