package Array;

/**
 * @Number: #134. Gas Station
 * @Descpription: There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * @Author: Created by xucheng.
 */
public class GasStation {
    /**
     * Theory: 如果一个数组的总和非负，那么一定可以找到一个起始位置，从他开始绕数组一圈，累加和一直都是非负的
     * 判断是否存在这样的解: sum of gas - sum of cost >= 0 则存在解
     * 求开始位置：
     * 1. 假如从位置i开始，i+1，i+2...，一路开过来一路油箱都没有空。说明什么？说明从i到i+1，i+2，...肯定是正积累。
     * 2. 现在突然发现开往位置j时油箱空了。这说明什么？说明从位置i开始没法走完全程。那么，我们要从位置i+1开始重新尝试吗？不需要！
     *    为什么？因为前面已经知道，位置i肯定是正积累，那么，如果从位置i+1开始走更加没法走完全程了，因为没有位置i的正积累了。
     *    同理，也不用从i+2，i+3，...开始尝试。所以我们可以放心地从位置j+1开始尝试。
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 开始位置
        int start = 0;
        // 当前剩余油
        int left = 0;
        // 没走完的路的负积累
        int debt = 0;

        for (int i = 0; i < gas.length; i++) {
            left += gas[i] - cost[i];
            if (left < 0) {
                debt += left;
                start = i + 1;
                left = 0;
            }
        }
        // 正积累 + 负积累 相当于 sum of gas - sum of cost
        return left + debt >= 0? start: -1;
    }
}
