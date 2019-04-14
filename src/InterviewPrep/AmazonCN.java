package InterviewPrep;

import LinkedList.ListNode;

import java.util.*;


/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class AmazonCN {

    /**
     * 83. Remove Duplicates from Sorted List
     * One pointer
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates_OnePt(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }

    public ListNode deleteDuplicates_TwoPt(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            while (fast != null && fast.val == slow.val)
                fast = fast.next;

            slow.next = fast;
            if (fast != null) {
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }

    /**
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        // head could be deleted in case : 1->1->1->3->5
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            // find the end of current duplicate sequence
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            // distinct node, didn't enter the above loop, update the prev node
            if (prev.next == curr)
                prev = prev.next;
                // duplicate, Make the prev of start node of the duplicate sequence point to the next node of the end of the duplicate sequence
            else
                prev.next = curr.next;
            // move forward curr pointer to the start of the rest nodes
            curr = curr.next;
        }
        return dummy.next;
    }


    /**
     * 26. Remove Duplicates from Sorted Array
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }


    /**
     * time: O(2 log n)
     * space: O(1)
     * 34. Find First and Last Position of Element in Sorted Array
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = new int[]{-1, -1};
        if (nums == null || nums.length == 0)
            return targetRange;
        targetRange[0] = searchLeft(nums, target);
        targetRange[1] = searchRight(nums, target);
        return targetRange;
    }

    int searchLeft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    int searchRight(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }


//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//        ListNode tail = getTail(head);
//        quickSort(head, tail);
//        return head;
//    }
//
//
//    public void quickSort(ListNode head, ListNode tail) {
//        if (head == null || tail == null || head == tail)
//            return;
//
//        ListNode first = head;
//        ListNode second = head.next;
//        int pivot = head.val;
//
//        while (second != tail.next && second != null) {
//            if (second.val < pivot) {
//                first = first.next;
//                if (first != second) {
//                   swap(first, second);
//                }
//            }
//            second = second.next;
//        }
//
//        if (head != first)
//           swap(head, first);
//
//        quickSort(head, first);
//        quickSort(first.next, tail);
//    }
//
//    public void swap(ListNode node1, ListNode node2) {
//       int temp = node1.val;
//       node1.val = node2.val;
//       node2.val = temp;
//    }
//
//    public ListNode getTail(ListNode head) {
//        ListNode tail = head;
//        while (tail != null && tail.next != null)
//            tail = tail.next;
//        return tail;
//    }


    public void quickSort(ListNode head, ListNode tail) {
        if (head == null || tail == null || head == tail)
            return;

        ListNode pivot = head;
        ListNode curr = head.next;
        ListNode start = new ListNode(0);
        ListNode mid = new ListNode(0);
        ListNode midCurr = mid;

        while (curr != null && curr != tail.next) {
            if (curr.val < pivot.val) {
                start.next = curr;
                start = start.next;
            } else {
                midCurr.next = curr;
                midCurr = midCurr.next;
            }
            curr = curr.next;
        }
        start.next = pivot;
        pivot.next = mid;
    }


    /**
     * Permutations
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        List<Integer> currPer = new ArrayList<>();
        for (int num : nums)
            currPer.add(num);
        backtrack(res, nums, currPer, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> currPer, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(currPer));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            Collections.swap(currPer, i, start);
            backtrack(res, nums, currPer, start + 1);
            Collections.swap(currPer, i, start);
        }
    }


    public List<Integer> topKEle(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return list;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        while (!pq.isEmpty()) {
            list.add(pq.poll().getKey());
        }

        return list;
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * Merge sort
         * Time: O(n log n)
         * Space: O(1)
         *
         * @param head
         * @return
         */
//     public ListNode sortList(ListNode head) {
//         if (head == null || head.next == null)
//             return head;

//         // 1. cut the list to 2 halves
//         // prev is the tail of 1st half
//         // slow is the head of 2nd half
//         ListNode prev = null;
//         ListNode slow = head;
//         ListNode fast = head;
//         while (fast != null && fast.next != null) {
//             prev = slow;
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         prev.next = null;

//         // 2. sort each half
//         ListNode l1 = sortList(head);
//         ListNode l2 = sortList(slow);

//         // 3. merge l1 and l2
//         return merge(l1, l2);
//     }

//     private ListNode merge(ListNode l1, ListNode l2) {
//         ListNode dummy = new ListNode(0);
//         ListNode curr = dummy;
//         // always point to the smaller one
//         while (l1 != null && l2 != null) {
//             if (l1.val < l2.val) {
//                 curr.next = l1;
//                 l1 = l1.next;
//             } else {
//                 curr.next = l2;
//                 l2 = l2.next;
//             }
//             curr = curr.next;
//         }
//         // point to the rest of the longer list
//         if (l1 != null)
//             curr.next = l1;
//         if (l2 != null)
//             curr.next = l2;

//         return dummy.next;
//     }
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode tail = head;
            while (tail != null && tail.next != null)
                tail = tail.next;
            quickSort(head, tail);
            return head;
        }


        public void quickSort(ListNode begin, ListNode end) {

            //判断为空，判断是不是只有一个节点
            if (begin == null || end == null || begin == end)
                return;
            //从第一个节点和第一个节点的后面一个几点
            ListNode first = begin;
            ListNode second = begin.next;

            int nMidValue = begin.val;
            //结束条件，second到最后了
            while (second != end.next && second != null) {
                if (second.val < nMidValue) {
                    first = first.next;
                    //判断一下，避免后面的数比第一个数小，不用换的局面
                    if (first != second) {
                        int temp = first.val;
                        first.val = second.val;
                        second.val = temp;
                    }
                }
                second = second.next;
            }
            //判断，有些情况是不用换的，提升性能
            if (begin != first) {
                int temp = begin.val;
                begin.val = first.val;
                first.val = temp;
            }
            //前部分递归
            quickSort(begin, first);
            //后部分递归
            quickSort(first.next, end);
        }

    }


    class MergeSort {
        private int[] nums;
        private int[] newNums;

        public MergeSort(int[] nums) {
            this.nums = nums;
            newNums = new int[nums.length];
        }

        public void doMergeSort(int left, int right) {
            if (left <= right) {
                int mid = (right - left) / 2 + left;
                doMergeSort(left, mid - 1);
                doMergeSort(mid + 1, right);
                mergeHalves(left, mid, right);
            }
        }

        public void mergeHalves(int left, int mid, int right) {
            for (int i = 0; i < nums.length; i++)
                newNums[i] = nums[i];

            int i = left;
            int j = mid + 1;
            int currIdx = left;
            while (i <= mid && j <= right) {
                if (newNums[i] < newNums[j])
                    nums[currIdx++] = newNums[i];
                else
                    nums[currIdx++] = newNums[j];
            }

            while (i <= mid)
                nums[currIdx++] = newNums[i++];

            while (j <= right)
                nums[currIdx++] = newNums[j++];
        }
    }


    class QuickSort {
        private int[] nums;

        public void quickSort(int[] nums) {
            this.nums = nums;
            doQuickSort(0, nums.length - 1);
        }

        public void doQuickSort(int left, int right) {
            if (left >= right)
                return;

            int mid = (right - left) / 2 + left;
            int pivotIdx = partition(left, right, mid);
            doQuickSort(left, pivotIdx - 1);
            doQuickSort(pivotIdx, right);
        }

        public int partition(int left, int right, int pivotIdx) {
            int pivot = nums[pivotIdx];
            while (left <= right) {
                while (nums[left] < pivot)
                    left++;
                while (nums[right] > pivot)
                    right--;
                if (left <= right) {
                    swap(left, right);
                    left++;
                    right--;
                }
            }
            return left;
        }

        public void swap(int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    class QuickSelect {
        int[] nums;

        public int findKth(int[] nums, int k) {
            if (nums == null || nums.length == 0 || nums.length < k)
                return -1;

            this.nums = nums;
            return quickSelect(0, nums.length - 1, nums.length - k);
        }

        public int quickSelect(int left, int right, int small) {
            if (left >= right)
                return nums[left];

            int mid = (right - left) / 2 + left;
            int pivotIndex = partition(left, right, mid);
            if (pivotIndex == small)
                return nums[pivotIndex];
            else if (pivotIndex < small)
                return quickSelect(left, pivotIndex - 1, small);
            else
                return quickSelect(pivotIndex + 1, right, small);

        }

        public int partition(int left, int right, int pivotIndex) {
            int pivot = nums[pivotIndex];
            swap(pivotIndex, right);

            int currIdx = left;
            for (int i = left; i < right; i++) {
                if (nums[i] < pivot) {
                    swap(i, currIdx);
                    currIdx++;
                }
            }
            swap(currIdx, right);
            return currIdx;
        }

        public void swap(int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


}
