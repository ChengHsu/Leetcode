package Random;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class ReservoirSampling {
    /**
     * Question: 在一个给定长度的数组中随机等概率抽取一个数据很容易，但如果面对的是长度未知的海量数据流呢
     * Answer:
     * 1. 先选取数据流中的前k个元素，保存在集合A中；
     * 2. 从第j（k + 1 <= j <= n）个元素开始，每次先以概率p = k/j选择是否让第j个元素留下。若j被选中，则从A中随机选择一个元素并用该元素j替换它；否则直接淘汰该元素；
     * 3. 重复步骤2直到结束，最后集合A中剩下的就是保证随机抽取的k个元素。
     */
}
