package BB;

import java.util.HashMap;
import java.util.Map;

/**
 * @Number: The number of questions
 * @Descpription:
 *
 * @Author: Created by xucheng.
 */
public class Marathon {
    class Node {
        int runnerId;
        int cpId; // check point id
        Node prev;
        Node next;
        public Node(int rId, int cId) {
            this.runnerId = rId;
            this.cpId = cId;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    Node[] checkPoints;
    int numCP; // no. of checkpoints
    public Marathon(int num) {
        map = new HashMap<>();
        this.numCP = num;
        checkPoints = new Node[this.numCP];
        for(int i = 0; i < numCP; i++) {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            checkPoints[i] = head;
        }
    }

    public void update(int runnerId, int cpId) {
        if(map.containsKey(runnerId)) {
            Node oldRecord = map.get(runnerId);
            // delete old record from old check point list
            delete(oldRecord);
        }
        Node newRecord  = new Node(runnerId, cpId);
        map.put(runnerId, newRecord);
        // add new record to new check point list
        move(newRecord, cpId);
    }

    private void move(Node n, int cpId) {
        Node next = checkPoints[cpId].next;
        checkPoints[cpId].next = n;
        n.prev = checkPoints[cpId];
        n.next = next;
        next.prev = n;
    }

    private void delete(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.prev = null;
        n.next = null;
    }

    public void printTopK(int k) {
        for(int i = numCP - 1; i >= 0; i --) {
            Node tail = checkPoints[i].next;
            while(tail.runnerId != -1)
                tail = tail.next;
            tail = tail.prev;
            while(tail.runnerId != -1 && k-- > 0) {
                System.out.println(tail.runnerId);
                tail = tail.prev;
            }
            if(k == 0) break;
        }
    }

    public static void main(String[] args) {
        Marathon m = new Marathon(10);
        m.update(1, 1);
        m.update(2,1);
        m.printTopK(2);
        m.update(3, 1);
        m.update(4, 2);
        m.update(3, 2);
        System.out.println("----------------");
        m.printTopK(2);
        m.update(2, 3);
        System.out.println("----------------");
        m.printTopK(1);
        m.update(1, 2);
        System.out.println("----------------");
        m.printTopK(4);
    }
}
