package InterviewPrep;


import LinkedList.ListNode;
import Tree.TreeLinkNode;
import Tree.TreeNode;

import java.util.*;

/**
 * @Number:
 * @Descpription:
 * @Author: Created by xucheng.
 */
public class MicrosoftSuzhou {
    /**
     * 青蛙跳台阶:
     * 一只青蛙可以一次跳一级台阶，也可以一次跳两级台阶，如果青蛙要跳上n级台阶，共有多少钟跳法？
     * DP
     * fibonacci: f(n) = f(n-1) + f(n-2)
     * time: O(n)
     * space: O(1)
     *
     * @param n
     * @return
     */
    public int frogJump(int n) {
        int[] dp = new int[]{1, 1, 0};
        if (n < 2)
            return 1;
        for (int i = 2; i <= n; i++) {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }


    /**
     * 变态青蛙跳台阶:
     * 青蛙可以一次跳1,2,...,n级台阶，共有多少钟跳法？
     * Recursion: f(n) = f(n-1) + f(n-2) +... + f(n-n)
     * f(n-1) = f(0) + f(1) + f(2) + ... + f(n-2)
     * f(n) = f(0) + f(1) + f(2) + ... + f(n-2) + f(n-1) = 2 * f(n-1)
     * => f(n) = 1, if n = 0 or n = 1
     * = 2*f(n-1), else
     * time: O()
     * space: O()
     *
     * @param n
     * @return
     */
    public int AdvancedFrogJump(int n) {
//        if (n == 0 || n == 1)
//            return 1;
//        else
//            return 2 * AdvancedFrogJump(n - 1);
        if (n < 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        }
        return dp[n];
    }


    /**
     * LC#41. First Missing Positive
     * Given an unsorted integer array, find the smallest missing positive integer.
     * 第一次遍历: 交换数组元素，使数组中第i位存放数值(i+1)
     * 第二次遍历：寻找第一个不符合要求的元素返回其下标+1
     * time: O(n)
     * space: O(1)
     *
     * @param A
     * @return
     */
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] >= 1 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                swap(A, i, A[i] - 1);
            } else i++;
        }
        i = 0;
        while (i < A.length && A[i] == i + 1) {
            i++;
        }
        return i + 1;

    }

    private void swap(int[] A, int idx1, int idx2) {
        int tmp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = tmp;
    }


    /**
     * LC#136. Single Number
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     * Bit Operation
     * 异或：相同的数异或得0，只剩出现次数位1的数
     * time: O(n)
     * space: O(1)
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }


    /**
     * LC#1. Two Sum
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * time: O(n)
     * space: O(n)
     *
     * @param nums
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            else
                map.put(target - nums[i], i);
        }
        return new int[]{};
    }

    /**
     * LC#167. Two Sum II - Input array is sorted
     * Given an array of integers that is already sorted in ascending order,
     * find two numbers such that they add up to a specific target number.
     * time: O(logn)
     * space:O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumII(int[] nums, int target) {
        int low = 0;
        int high = 0;
        while (low <= high) {
            if (nums[low] + nums[high] == target)
                return new int[]{low + 1, high + 1};
            else if (nums[low] + nums[high] < target)
                low++;
            else
                high--;
        }
        return new int[]{};
    }


    /**
     * 剑指offer：二叉树的下一个结点
     * 如果当前节点有右子节点，则下一个节点是右子树的最左子节点
     * 如果当前节点没有右子节点，
     * 1. 节点为其父节点的左子节点，那么其父节点就是它的下一个节点；
     * 2. 节点为其父节点的右子节点，需要沿其父指针一直向上遍历，一直找到某个节点是其父节点的左子节点为止，那么这个节点的父节点即是需要寻找的下一个节点。
     * time: O(h)
     * space: O(1)
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode nextNode(TreeLinkNode pNode) {
        if (pNode == null)
            return null;

        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        } else {
            while (pNode.next != null) {
                if (pNode == pNode.next.left)
                    return pNode.next;
                pNode = pNode.next;
            }
        }
        return null;
    }

    /**
     * 求1-1000000内的质数个数
     * LC#204. Count Primes
     * Count the number of prime numbers less than a non-negative number, n.
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i])
                continue;
            count++;
            for (int j = 2 * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        return count;

    }


    /**
     * LC#543. Diameter of Binary Tree
     * Given a binary tree, you need to compute the length of the diameter of the tree.
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     * time: O(n)
     * space: O(n)
     *
     * @param root
     * @return
     */
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        getDepth(root);
        return max - 1;
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        max = Math.max(max, leftDepth + rightDepth + 1);
        return 1 + Math.max(leftDepth, rightDepth);
    }


    /**
     * LC#86. Partition List
     * time: O(n)
     * space: O(1)
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        Scanner scanner = new Scanner(System.in);

        ListNode beforeHead = new ListNode(0);
        ListNode beforeCurr = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode afterCurr = afterHead;

        while (head != null) {
            if (head.val < x) {
                beforeCurr.next = head;
                beforeCurr = beforeCurr.next;
            } else {
                afterCurr.next = head;
                afterCurr = afterCurr.next;
            }
            head = head.next;
        }
        beforeCurr.next = afterHead.next;
        afterCurr.next = null;
        return beforeHead.next;
    }


    /**
     * LC#141. Linked List Cycle
     * time: O(n)
     * space: O(1)
     *
     * @param head
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * LC#142. Linked List Cycle II
     * time: O(n)
     * space: O(1)
     *
     * @param head
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                hasCycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (hasCycle) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }


    /**
     * LC#21. Merge Two Sorted Lists
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     * time: O(len(l1)+len(l2))
     * space: O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_iterative(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }

    /**
     * LC#21. Merge Two Sorted Lists
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     * time: O(len(l1)+len(l2))
     * space: O(len(l1)+len(l2))
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists_recursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_recursive(l1, l2.next);
            return l2;
        }
    }

    /**
     * LC#9. Palindrome Number
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     * time: O(log10 N)
     * space: O(1)
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        if (x >= 0 && x <= 9)
            return true;

        int revertedNum = 0;
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNum || x == revertedNum / 10;
    }

    /**
     * LC#8. String to Integer (atoi)
     * Implement atoi which converts a string to an integer.
     * 1. leading whitespaces
     * 2. sign
     * 3. 1st seq can only contain digits
     * 4. If only contain whitespace or just empty, return 0
     * 5. Use long to avoid overflow
     * time: O(len(1st Seq))
     * space: O(1)
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0)
            return 0;
        int sign = 1;
        int start = 0;
        char firstChar = str.charAt(0);
        if (!Character.isDigit(firstChar) && firstChar != '-' && firstChar != '+')
            return 0;
        if (firstChar == '-' || firstChar == '+') {
            sign = (firstChar == '-') ? -1 : 1;
            start = 1;
        }
        String[] seq = str.split(" ");
        long res = 0;
        for (int i = start; i < seq[0].length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch))
                // cannot return 0 directly. special case: 3.14 should return 3
                break;
            res = res * 10 + ch - '0';
            if (res > Integer.MAX_VALUE)
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }


    /**
     * LC#19. Remove Nth Node From End of List
     * One pass with 2 pointers
     * time: O(n)
     * space: O(1)
     * fast starts from head, slow starts from dummy
     * n = 2
     * d - 1 - 2 - 3 - 4 - 5 - null
     * s           f
     *
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // edge case
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (n-- > 0)
            fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * LC#104. Maximum Depth of Binary Tree
     * Given a binary tree, find its maximum depth.
     * time: O(n)
     * space: worst case: O(n)
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


    /**
     * LC#110. Balanced Binary Tree
     * Given a binary tree, determine if it is height-balanced.
     * time: O(n)
     * space: worst case: O(n)
     *
     * @param root
     * @return
     */
    boolean isBalance;

    public boolean isBalanced(TreeNode root) {
        isBalance = false;
        getDepthOfTree(root);
        return isBalance;
    }

    private int getDepthOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepthOfTree(root.left);
        int right = getDepthOfTree(root.right);
        if (Math.abs(left - right) > 1)
            isBalance = false;
        return Math.max(left, right) + 1;
    }


    /**
     * LC#270. Closest Binary Search Tree Value
     * tail recursion: compare diff(root.val,target) and diff(prev_root.val,target)
     * time: O(lgn)
     * space: O(1) tail recursion?
     *
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, root.val);
    }

    public int helper(TreeNode root, double target, int val) {
        if (root == null)
            return val;
        val = (Math.abs(root.val - target) < Math.abs(val - target)) ? root.val : val;
        if (root.val < target)
            return helper(root.right, target, val);
        else
            return helper(root.left, target, val);

    }


    /**
     * LC#169. Majority Element
     * Given an array of size n, find the majority element.
     * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * You may assume that the array is non-empty and the majority element always exist in the array.
     * idea: Moore Voting Algorithm
     * time: O(n)
     * space: O(1)
     * 2 2 1 1 1 2 2
     * e
     * c: 2
     *
     * @param nums
     * @return
     */
//    public int majorityElement(int[] nums) {
//        int count = 0;
//        int elment = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (count == 0) {
//                elment = nums[i];
//                count = 1;
//            } else {
//                if (elment == nums[i])
//                    count++;
//                else
//                    count--;
//            }
//        }
//        return elment;
//    }

    /**
     * LC#229. Majority Element II
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     * idea: Moore Voting Algorithm
     * https://leetcode.com/problems/majority-element-ii/discuss/63520/Boyer-Moore-Majority-Vote-algorithm-and-my-elaboration
     * time: O(n)
     * space: O(1)
     * 2 2 1 1 1 2 2
     * e
     * c: 2
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int candidateA = nums[0];
        int candidateB = nums[0];
        int cntA = 0;
        int cntB = 0;
        for (int num : nums) {
            if (num == candidateA)
                cntA++;
            else if (num == candidateB)
                cntB++;
            else if (cntA == 0) {
                candidateA = num;
                cntA = 1;
            } else if (cntB == 0) {
                candidateB = num;
                cntB = 1;
            } else {
                cntA--;
                cntB--;
            }
        }

        cntA = 0;
        cntB = 0;
        for (int num : nums) {
            if (num == candidateA)
                cntA++;
            if (num == candidateB)
                cntB++;
        }
        if (cntA > nums.length / 3)
            res.add(candidateA);
        if (cntB > nums.length / 3 && candidateB != candidateA)
            res.add(candidateB);

        return res;
    }


    /**
     * LC#215. Kth Largest Element in an Array
     * Find the kth largest element in an unsorted array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * The kth largest element is the (len-k+1) smallest element in the array, we maintain a min-heap
     * of k elements, every time size reaches k, we do poll to get rid of the current smallest one.
     * At the end, k nums remain in the heap are the k larger ones, and the top is the smallest among them, which is
     * the K-th largest.
     * <p>
     * Priority Queue： K个较大的是有序的
     * time: O(Nlogk) add operation cost O(logk) in worst case
     * space: O(k)
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_heap(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.poll();
    }

    /**
     * Quick Select: K个较大的不是有序的
     * time: O(N) in average, O(N^2) in worst
     * space: O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        // edge case
        if (nums == null || nums.length < k)
            return 0;

        this.nums = nums;
        int len = nums.length;
        // K-th largest is the (N-K)-th smallest
        return quick_select(0, len - 1, len - k);
    }

    public int quick_select(int left, int right, int nk_smallest) {
        if (left == right)
            return this.nums[left];
//        Random random = new Random();
//        int pivot_index = left + random.nextInt(right - left);
        int pivot_index = (right - left) / 2 + left;
        pivot_index = partition(left, right, pivot_index);
        if (nk_smallest == pivot_index) {
            return this.nums[nk_smallest];
        } else if (nk_smallest < pivot_index)
            return quick_select(left, pivot_index - 1, nk_smallest);
        else
            return quick_select(pivot_index + 1, right, nk_smallest);
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        // move pivot to end
        swap(pivot_index, right);
        int curr_idx = left;
        // move smaller elemnts to left
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(curr_idx, i);
                curr_idx++;
            }
        }
        // move pivot to its final place
        swap(right, curr_idx);
        return curr_idx;

    }

    public void swap(int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /**
     * LC#121. Best Time to Buy and Sell Stock
     * find current min price and update max profit among elements behind current min price
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length == 0)
            return 0;

        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }

    /**
     * LC#122. Best Time to Buy and Sell Stock II
     * calculate every vally (prices[i] < prices[i+1]) and sum them up
     * time: O(n)
     * space: O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        int max = 0;
        if (prices == null || prices.length == 0)
            return 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                max += prices[i + 1] - prices[i];
        }
        return max;
    }


    /**
     * LC#54. Spiral Matrix
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * time: O(m*n)
     * space: O(1)
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 1st row
            for (int i = colStart; i <= colEnd; i++)
                list.add(matrix[rowStart][i]);

            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++)
                list.add(matrix[i][colEnd]);

            colEnd--;
            // 只有一行
            if (rowStart <= rowEnd)
                for (int i = colEnd; i >= colStart; i--)
                    list.add(matrix[rowEnd][i]);

            rowEnd--;
            // 只有一列
            if (colStart <= colEnd)
                for (int i = rowEnd; i >= rowStart; i--)
                    list.add(matrix[i][colStart]);

            colStart++;
        }
        return list;
    }


    /**
     * LC#59. Spiral Matrix II
     * Given a positive integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
     * time: O(m*n)
     * space: O(1)
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // edge case
        if (n == 0)
            return res;

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++)
                res[rowStart][i] = num++;
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++)
                res[i][colEnd] = num++;
            colEnd--;

            if (rowStart <= rowEnd)
                for (int i = colEnd; i >= colStart; i--)
                    res[rowEnd][i] = num++;
            rowEnd--;

            if (colStart <= colEnd)
                for (int i = rowEnd; i >= rowStart; i--)
                    res[i][colStart] = num++;

            colStart++;
        }
        return res;
    }


    /**
     * LC.#611. Valid Triangle Number
     * 2  3  4  5  6  7  8  9
     * a  ->             b  c
     * if nums[a] + nums[b] > c, then (nums between a and b) + nums[b] > nums[c], count the # and then b--
     * else a++;
     * time: O(n^2)
     * space: O(logn)
     */
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int count = 0;
        for (int c = nums.length - 1; c > 1; c--) {
            int a = 0;
            int b = c - 1;
            while (a < b) {
                if (nums[a] + nums[b] > nums[c]) {
                    count += b - a;
                    b--;
                } else
                    a++;
            }
        }
        return count;
    }


    /**
     * LC.#88. Merge Sorted Array
     * Overwrite nums1 from the end.
     * time:O(m+n)
     * space: O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0)
            return;

        int p1 = m - 1;
        int p2 = n - 1;
        int currIdx = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[currIdx--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        while (p1 >= 0) {
            nums1[currIdx--] = nums1[p1--];
        }
        while (p2 >= 0) {
            nums1[currIdx--] = nums2[p2--];
        }
    }


    /**
     * LC.#155. Min Stack
     * time: O(1) for each method
     * space: O(1)
     */
    class MinStack {
        class Node {
            int val;
            int min;

            Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        Stack<Node> stack = null;

        public MinStack() {
            stack = new Stack<>();
        }

        // compare min with x to update min and store it to the peek node
        public void push(int x) {
            int min = 0;
            if (stack.isEmpty()) min = x;
            else
                min = Math.min(stack.peek().min, x);
            stack.push(new Node(x, min));
        }

        public void pop() {
            if (!stack.isEmpty())
                stack.pop();
        }

        public int top() {
            if (!stack.isEmpty())
                return stack.peek().val;
            else
                return 0;
        }

        public int getMin() {
            if (!stack.isEmpty())
                return stack.peek().min;
            else return 0;
        }
    }


    /**
     * LC#107. Binary Tree Level Order Traversal II
     * time: O()
     * space: O(1)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> currLevel = new LinkedList<>();
        currLevel.add(root);
        while (!currLevel.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!currLevel.isEmpty()) {
                TreeNode tn = currLevel.poll();
                level.add(tn.val);
                // right to left order for each level
                //level.add(0,tn.val);
                if (tn.left != null)
                    nextLevel.add(tn.left);
                if (tn.right != null)
                    nextLevel.add(tn.right);
            }
            currLevel = nextLevel;
            // bottom to top
            res.add(0, level);
        }
        // another way from botom to top
        //Collections.reverse(res);
        return res;
    }


    /**
     * LC#161. One Edit Distance
     * 完全相同的两字符串或两个空串应该return false
     * time: O(min(len(s), len(t)))
     * space: O(1)
     *
     * @param
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
                    return s.substring(i).equals(t.substring(i + 1));
                else // s is longer than t, so the only possibility is deleting one char from s
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
        return Math.abs(s.length() - t.length()) == 1;
    }


    /**
     * LC#179. Largest Number
     * time: O(nlgn)
     * space: O(n)
     *
     * @return
     */
    class LargestNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] numAsStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numAsStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numAsStrs, new LargestNumberComparator());

        // input array: [0,0] -> "00"
        if (numAsStrs[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String numAsStr : numAsStrs)
            sb.append(numAsStr);
        return sb.toString();
    }


    /**
     * LC#143. Reorder List
     * <p>
     * 1. Find the middle
     * 2. Reverse the second half
     * 3. Reorder one by one
     * <p>
     * time: O(n)
     * space: O(1)
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        // edge case
        if (head == null || head.next == null)
            return;
        //  step 1. cut the list to two halves
        //  prev will be the tail of 1st half
        //  slow will be the head of 2nd half
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = head;
        ListNode l2 = slow;
        // 2. reverse the second half
        l2 = reverse(l2);
        // 3. merge two lists
        merge(l1, l2);
    }

    // null - 1 - 2 - 3 - 4 - 5 - null
    //                       prev curr next
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 1   2  null
    // | / |
    // 5   4 - 3
    public void merge(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            curr1.next = curr2;
            // othwise curr2 will points to null cuz next1 == null at this time
            if (next1 == null)
                break;
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }
    }


    /**
     * 72. Edit Distance
     * time: O(l1*l2)
     * space: O(l1*l2)
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1 + 1; i++)
            for (int j = 0; j < l2 + 1; j++)
                dp[i][j] = 0;

        for (int i = 0; i < l1; i++)
            dp[i][0] = i;
        for (int j = 0; j < l2; j++)
            dp[0][j] = j;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int c = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + c, Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[l1][l2];
    }


    /**
     * $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
     * https://leetcode.com/problems/split-bst/discuss/159985/Python-DFS-tm
     * LC#776. Split BST
     *
     * @param root
     * @param V
     * @return
     */
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root != null)
            System.out.println("root.val: " + root.val);
        if (root == null) {
            System.out.println("leaf");
            return new TreeNode[]{null, null};
        } else if (root.val <= V) {
            System.out.println("right");
            TreeNode[] bns = splitBST(root.right, V);
            root.right = bns[0];
            bns[0] = root;
            return bns;
        } else {
            System.out.println("left");
            TreeNode[] bns = splitBST(root.left, V);
            root.left = bns[1];
            bns[1] = root;
            return bns;
        }
    }


    /**
     * 机器人走格子，给定M*N个方格，从左上角到达右下角，每次只能向下或向右走一步，有多少不同的走法
     * Dynamic Programming
     * 如果要走到（m,n），那么我们的上一步只能是（m-1,n）或者（m,n-1），
     * 所以走到（m,n）的所有走法就是走到（m-1,n）的所有走法+走到(m,n-1)的所有走法
     */
    public int numsOfWays(int m, int n) {
        int ways[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            ways[i][0] = 0;
        for (int i = 0; i <= n; i++)
            ways[0][i] = 0;

        ways[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1)
                    continue;
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[m][n];
    }

    /**
     * 最小路径和，给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小
     * Dynamic Programming
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum[][] = new int[m][n];
        sum[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i - 1 < 0)
                    sum[i][j] = sum[i][j - 1] + grid[i][j];
                else if (j - 1 < 0)
                    sum[i][j] = sum[i - 1][j] + grid[i][j];
                else sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        return sum[m - 1][n - 1];
    }


    /**
     * LC#617. Merge Two Binary Trees
     * time: O(n)
     * space: O(n)
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


    /**
     * LC#101. Symmetric Tree
     * time:O(n)
     * space: O(n)
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return true;
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode leftTn = queue.poll();
            TreeNode rightTn = queue.poll();
            // the left and right nodes of leaves r all null
            if (leftTn == null && rightTn == null)
                continue;
            if (leftTn == null || rightTn == null)
                return false;
            if (leftTn.val != rightTn.val)
                return false;
            queue.offer(leftTn.left);
            queue.offer(rightTn.right);
            queue.offer(leftTn.right);
            queue.offer(rightTn.left);
        }
        return true;
    }


    /**
     * LC#34. Find First and Last Position of Element in Sorted Array
     * binary search
     * time: O(lgn)
     * space: O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        if (nums == null || nums.length == 0)
            return targetRange;


        targetRange[0] = findLeft(nums, target);
        targetRange[1] = findRight(nums, target);
        return targetRange;
    }

    public int findLeft(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    public int findRight(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }


    /**
     * 3 Implementations of fibonacci
     *
     * @param n
     * @return
     */
    public int fib_iter(int n) {
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public int fib_recur(int n) {
        if (n <= 1)
            return n;
        return fib_recur(n - 1) + fib_recur(n - 2);
    }

    public int fib_tail_recur(int n, int a, int b) {
        if (n == 0)
            return a;
        if (n == 1)
            return b;
        return fib_tail_recur(n - 1, b, a + b);
    }


    /**
     * 给定一组pair,第一个值为粉丝ID，第二个值为被该粉丝follow的博主ID，给定n为人数，找出粉丝数超过k的所有博主
     * 可以间接follow if (2,3) && (3,4) then (2,4)
     * BFS类似Topological sort
     */
    public List<Integer> moreThanKFans(int[][] pairs, int n, int k) {
        List<Integer> res = new ArrayList<>();
        int[] fans = new int[n + 1];
        int[] inDegree = new int[n + 1];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++)
            graph.put(i, new HashSet<>());

        // build graph
        for (int[] pair : pairs) {
            int fan = pair[0];
            int blogger = pair[1];
            Set<Integer> next = graph.get(fan); // add all the bloggers that the fan follows
            next.add(blogger);
            graph.put(fan, next);
            inDegree[blogger]++;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        // initialize queue
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // if # of fans reaches k, add the current one to answer list
            if (fans[cur] >= k)
                res.add(cur);

            Set<Integer> nexts = graph.get(cur);
            for (int next : nexts) {
                inDegree[next]--;
                // 当前next增加的粉丝数= 粉他粉丝的人(fans[cur]) + 他的粉丝(cur)
                fans[next] += fans[cur] + 1;
                // in-degree == 0 add it to queue
                if (inDegree[next] == 0)
                    queue.offer(next);
            }
        }
        return res;
    }


    /**
     * preorder traversal
     * time: O(n)
     * spae: O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode tn = st.pop();
            res.add(tn.val);
            if (tn.right != null)
                st.push(tn.right);
            if (tn.left != null)
                st.push(tn.left);
        }
        return res;
    }

    /**
     * inorder traversal
     * time: O(n)
     * spae: O(n)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


    /**
     * Lincode#533. Two Sum - Closest to target
     * Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
     * Return the the difference between the sum of the two integers and the target.
     *
     * @param nums
     * @param target
     * @return
     */
    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;
        while (left < right) {
            num1 = nums[left];
            num2 = nums[right];
            if (nums[left] + nums[right] < target) {
                left++;
                minDiff = Math.min(minDiff, target - nums[left] - nums[right]);
            } else {
                right--;
                minDiff = Math.min(minDiff, nums[left] + nums[right] - target);
            }
        }
        System.out.println(num1 + "  " + num2 + "  closet sum :" + Math.abs(target - minDiff));
        return minDiff;
    }


    /**
     * Find the length of largest subarray with 0 sum
     * Given an array of integers, find length of the largest subarray with sum equals to 0.
     * time: O(n)
     * space: O(n)
     *
     * @param arr
     * @return
     */
    public int maxLen(int arr[]) {
        int maxLen = 0;
        int sum = 0;
        // 存current sum和 current index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0)
                maxLen = i + 1;
            // if we've seen this sum before, means the the sum of sub-array beetween two same sums = 0, update the len: i - prev_i
            if (map.containsKey(sum))
                maxLen = Math.max(maxLen, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return maxLen;
    }


    /**
     * Find the max length of largest subarray with k sum
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxSubarraySumWithK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        // cover case 1: arr[i] == k && maxLen == 0
        // case2 : sum == k
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                int prevIdx = map.get(sum - k);
                maxLen = Math.max(maxLen, i + 1 - prevIdx);
            }
            map.put(sum, i + 1);

        }
        return maxLen;
    }


    /**
     * 560. Subarray Sum Equals K
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // stores current cum and occurrences
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                cnt += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }


    /**
     * Put n balls into m buckets
     *
     * @param m
     * @param n
     * @return
     */
    int numOfWays = 0;

    public int putBall(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        dfs(m, n, 0);
        return numOfWays;
    }

    public void dfs(int bucketsLeft, int ballsLeft, int start) {
        if (ballsLeft < 0 || bucketsLeft < 0)
            return;
        if ((ballsLeft == 0 && bucketsLeft != 0) && (ballsLeft != 0 && bucketsLeft < 0))
            return;
        if (ballsLeft == 0 && bucketsLeft == 0)
            numOfWays++;
        for (int i = start; i <= ballsLeft; i++) {
            dfs(bucketsLeft - 1, ballsLeft - i, i);
        }
    }


    /**
     * 题目：把数字翻译成字符串
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成”a”，1翻译成”b”，……，11翻译成”l”，……，25翻译成”z”。一个数字可能有多个翻译。
     * 例如12258有5种不同的翻译，它们分别是”bccfi”、”bwfi”、”bczi”、”mcfi”和”mzi”。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
     * 可以选一个数字或两个连续的数字（10~25）翻译成一个字符。
     * 定义f(i)：从第i位数字开始的不同翻译数目
     * 若第i个数字和第i+1个数字拼接成的数字在10~25范围内，则递归式子为：
     * f(i) = f(i + 1) + f(i + 2)
     * 否则：
     * f(i) = f(i + 1)
     *
     * @param num
     * @return
     */
    public int getTranslationCount(int num) {
        if (num < 0)
            return 0;

        String numStr = String.valueOf(num);

        int[] counts = new int[numStr.length() + 1];

        counts[numStr.length()] = 0;
        counts[numStr.length() - 1] = 1;

        for (int i = numStr.length() - 2; i >= 0; i--) {
            int count = counts[i + 1];
            int firstDigit = numStr.charAt(i) - '0';
            int secondDigit = numStr.charAt(i + 1) - '0';
            int twoDigitNum = firstDigit * 10 + secondDigit;
            if (twoDigitNum >= 10 && twoDigitNum <= 25) {
                if (i < numStr.length() - 2)
                    count += counts[i + 2];
                else
                    count += 1;
            }
            counts[i] = count;
        }
        return counts[0];
    }


    /**
     * LRU
     */

    /**
     * 给定一个邻接矩阵，0代表不相邻，1代表相邻，给定k个颜色，求出每个item应该怎么涂色
     */
    /**
     * Dynamic Programming: 背包
     */

    /**
     * R树
     */

    /**
     *  服务器有一个非常大的字典，每次备份的时候都要所有内容备份一次，如果备份的过程中突然crash了，又要重新写，问我有什么好的解决方案
     */
    /**
     * java inheritance, generics, class vs. interface
     */
    /**
     * Find the minimum absolute sum of two numbers in an array
     */
    /**
     * 凸包问题
     *  https://blog.csdn.net/Bone_ACE/article/details/46239187
     */


}
