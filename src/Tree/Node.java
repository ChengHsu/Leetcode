package Tree;

import java.util.List;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Node {
        public int val;
        public List<Tree.Node> children;

        public Node() {
        }

        public Node(int _val, List<Tree.Node> _children) {
            val = _val;
            children = _children;
        }
}
