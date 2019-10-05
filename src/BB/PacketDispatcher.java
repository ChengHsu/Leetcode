package BB;

import java.util.HashMap;

/**
 * @Number: The number of questions
 * @Descpription:
 * 假设有一个server会按任意顺序一直收到“(词，序号)”格式的包，每次收到一个包，要按顺序print出这些词，设计这个server class。
 * 序号从1开始，但你可能会先收到序号为3的包，这种情况就得先存起来，等1号包来。
 * @Author: Created by xucheng.
 */
public class PacketDispatcher {
    HashMap<Integer, String> map;
    int expectedNum;
    public PacketDispatcher() {
        map = new HashMap<>();
        expectedNum = 1;
    }

    public void receivePacket(int number, String word) {
        if(expectedNum > number)
            throw new IllegalArgumentException("Invalid number or Duplicate Packet Number!");
        else if(expectedNum == number) {
            System.out.println("Packet #" + number + " received");
            expectedNum++;
        }
        else if(expectedNum < number) {
            if (map.containsKey(number))
                throw new IllegalArgumentException("Duplicate Packet Number!");
            else
                map.put(number, word);
        }

        while(map.containsKey(expectedNum)) {
            System.out.println("Packet #" + map.get(expectedNum) + " received");
            map.remove(expectedNum);
            expectedNum++;
        }
    }

    public static void main(String[] args) {
        PacketDispatcher p = new PacketDispatcher();
        p.receivePacket(3, "3");
        p.receivePacket(1, "1");
        p.receivePacket(4, "4");
        p.receivePacket(2, "2");
        p.receivePacket(7, "7");
        p.receivePacket(9, "9");
        p.receivePacket(8, "8");
        p.receivePacket(6, "6");
        p.receivePacket(5, "5");
    }
}
