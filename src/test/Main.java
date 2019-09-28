package test;

import Tree.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * @Author: Created by xucheng.
 */

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
       TreeNode root = new TreeNode(4);
//       root.left = new TreeNode(2);
//       root.right = new TreeNode(6);
//       root.left.left = new TreeNode(1);
//       root.left.right = new TreeNode(3);
//       root.right.left = new TreeNode(5);
//       root.right.right = new TreeNode(7);
        main.bstToMaxHeap(root);
    }


    List<Integer> vals = new ArrayList<>();
    int idx = 0;
    public TreeNode bstToMaxHeap(TreeNode root) {
        if(root == null)
            return null;
        inorder(root);
        root = preorder(root);
        System.out.println(root.val);
        return root;
    }

    private void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        vals.add(root.val);
        inorder(root.right);
    }

    private TreeNode preorder(TreeNode root) {
        if(root == null) return null;

        preorder(root.left);
        preorder(root.right);
        root.val = vals.get(idx++);
        return root;
    }


    public int findCloset(int[] arr, int target) {
        if(arr == null || arr.length == 0)
            return -1;

        int left = 0;
        int right = arr.length - 1;
        int mid = -1;
        while(left <= right) {
            mid = (right - left) / 2 + left;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target) {
                if(mid < arr.length - 1 && arr[mid + 1] > target) {
                    if(target - arr[mid] <= arr[mid + 1] - target)
                        return mid;
                    else
                        return mid + 1;
                }
                left = mid + 1;
            } else {
                if(mid > 0 && arr[mid - 1] < target) {
                    if(target - arr[mid - 1] <= arr[mid] - target)
                        return mid - 1;
                    else
                        return mid;
                }
                right = mid - 1;
            }
        }
        return mid;
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return new ArrayList<>();
        }

        /**
         * @param result: result list to store final return list
         * @param graph: adjacency list of key - store all neighbors of each word (neighbor means all words in dictionary
         *             that only has one character difference with key)
         * @param distance: distance between beginWord and current key word, used for tracing path when we do DFS
         * @param dict: word dictionary, efficient for searching purpose
         * */
        List<List<String>> result = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        if(dict.contains(beginWord)) dict.remove(beginWord);
        if(!dict.contains(endWord)) return result;
        // if(dict.contains(endWord)) dict.remove(endWord);
        bfs(beginWord, endWord, dict, graph, distance);
        dfs(result, graph, distance, endWord, beginWord, new ArrayList<>(Arrays.asList(beginWord)));
        return result;
    }

    // step 1
    public void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Set<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            boolean reachEnd = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();

                char[] curWordArr = curWord.toCharArray();
                for (int j = 0; j < curWordArr.length; j++) {
                    char ch = curWordArr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if(ch == c) continue;
                        curWordArr[j] = c;
                        String newWord = new String(curWordArr);
                        if (dict.contains(newWord)) {
                            graph.putIfAbsent(curWord, new HashSet<>());
                            graph.get(curWord).add(newWord);
                        }
                    }
                    curWordArr[j] = ch;
                }

                // traverse all neighbors of current word, update distance map and queue for next ladder (level)
                for (String neighbor : graph.get(curWord)) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(curWord) + 1);
                        if (neighbor.equals(endWord)) {
                            reachEnd = true;
                        }
                        else {
                            queue.offer(neighbor);
                        }
                    }
                }
                if (reachEnd) {
                    break;
                }
            }
        }
    }

    // step 2
    public void dfs(List<List<String>> result, Map<String, Set<String>> graph, Map<String, Integer> distance,String endWord, String curWord, List<String> tempList) {
        if (curWord.equals(endWord)) {
            result.add(new ArrayList<>(tempList));
        }
        else {
            for (String nextWord : graph.get(curWord)) {
                // only if next node is on the minimum path to the endWord can we traverse it
                if (distance.get(nextWord) == distance.get(curWord) + 1) {
                    tempList.add(nextWord);
                    dfs(result, graph, distance, endWord, nextWord, tempList);
                    tempList.remove(tempList.size() - 1);
                }
            }

        }

    }



    public int[][] submatrixSum(int[][] matrix) {
        int[][] res = new int[2][2];
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return res;

        int m = matrix.length;
        int n = matrix[0].length;
        // pre-compute: sum[i,j] is the sum of submatrix [[0,0], [i,j]]
        int[][] sum = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
            }
        }

        for(int l = 0; l < m; l++) {
            for(int h = l + 1; h <= m; h++) {
                Map<Integer, Integer> map = new HashMap<>();
                for(int j = 0; j <= n; j++) {
                    int diff = sum[h][j] - sum[l][j];
                    if(map.containsKey(diff)) {
                        int k = map.get(diff);
                        res[0][0] = l;
                        res[0][1] = k;
                        res[1][0] = h - 1;
                        res[1][1] = j - 1;
                    }
                    else
                        map.put(diff, j);
                }
            }
        }
        return res;
    }

    public List<Integer> findPeakII(int[][] A) {
        List<Integer> res = new ArrayList<>();
        if(A == null || A.length == 0 || A[0] == null || A[0].length == 0) return res;
        // Elements in first and last row can not become peaks, so starts from 2nd and 2nd last row
        int low = 1;
        int high = A.length - 2;
        // still need to find a peak when there is only one row, so low <= high
        while(low <= high) {
            int mid = (high - low) / 2 + low;
            // find a candidate col in a row
            int col = findCandidateInRow(A, mid);
            // heads to the part with bigger element
            if(A[mid][col] < A[mid + 1][col])
                low = mid + 1;
            else if(A[mid][col] < A[mid - 1][col])
                high = mid - 1;
                // Neither A[mid-1][col] nor A[mid+1][col] is bigger than A[mid][col] => peak element found
            else {
                res.add(mid);
                res.add(col);
                break;  }
        }
        return res;
    }

    private int findCandidateInRow(int[][] A, int row) {
        int left = 0;
        int right = A[0].length - 1;
        while(left < right) {
            int mid = (right - left) / 2 + left;
            if(A[row][mid] < A[row][mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int backPackIV(int[] nums, int target) {
                int[][] dp = new int[nums.length + 1][target + 1];
                dp[0][0] = 1;

                for(int i = 0; i < nums.length; i++) {
                    for(int j = 0; j <= target; j++) {
                        int k = 0;
                        while(k * nums[i] <= j) {
                            dp[i + 1][j] += dp[i][j - nums[i] * k];
                            k++;
                        }
                    }
        }
        return dp[nums.length][target];
    }

    public int backPackII(int[] nums, int[] v, int target) {
        int items = nums.length;
        int[][] dp = new int[items + 1][target + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= items; i++) {
            System.out.println(i);
            for(int j = 1; j <= target; j++) {
                if(nums[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - nums[i - 1]] + v[i - 1]);
            }
        }
        return dp[items][target];
    }


    /**
     * dp[i][s] true if first i items fulls a backpack of size s
     * dp[0][1...m] = f
     * dp[i][0] = t
     * dp[i][s] = dp[i-1] if nums[j] > s
     * dp[i][s] = dp[i-1] if nums[j] <= s && dp[i-1][s - nums[j]]
     * @param nums
     * @param volume
     * @return
     */
    public int backPack(int[] nums, int volume) {
        if(nums == null || nums.length == 0) return 0;
        int items = nums.length;
//        int[][] dp = new int[items + 1][volume + 1];
//        dp[0][0] = 0;
//        for(int i = 0; i < items; i++) {
//            for(int j = 0; j < volume + 1; j++) {
//                if(j >= nums[i])
//                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j - nums[i]] + nums[i]);
//                else
//                    dp[i + 1][j] = dp[i][j];
//            }
//        }
//        return dp[items][volume];
        int[] dp = new int[volume + 1];
        for(int i = 0; i < items; i++) {
            for(int j = volume; j > 0; j--) {
                if(j >= nums[i])
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[volume];
    }




    /**
     * sign
     *
     * @param num
     * @return
     */
    public String intToString(int num) {
        StringBuilder sb = new StringBuilder();
        int sign = 1;
        if (num < 0) {
            sign = -1;
            num = -num;
        }

        while (num != 0) {
            sb.insert(0, (char) (num % 10 + '0'));
            num /= 10;
        }

        if (sign == -1)
            sb.insert(0, "-");
        return sb.toString();
    }

    public int StringToInt(String s) {

        s = s.trim();
        if (s == null || s.length() == 0)
            throw new IllegalArgumentException("Input can not be empty or all spaces");

        int sign = 1;
        int start = 0;
        long res = 0;
        char firstChar = s.charAt(0);

        if (!Character.isDigit(firstChar) && firstChar != '+' && firstChar != '-')
            throw new NumberFormatException("Invalid digit");
        if (firstChar == '-' || firstChar == '+') {
            sign = (firstChar == '-') ? -1 : 1;
            start = 1;
        }

        String[] seq = s.split(" ");
        for (int i = start; i < seq[0].length(); i++) {
            char ch = seq[0].charAt(i);
            res = res * 10 + ch - '0';
            if (res > Integer.MAX_VALUE)
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int) res * sign;
    }

    public int digitsCount(int d, int low, int high) {
        int totalTimes = 0;
        for (int i = low; i <= high; i++) {
            totalTimes += count(i, d);
        }

        return totalTimes;
    }

    public int count(int num, int d) {
        int occurrence = 0;
        String numAsAString = String.valueOf(num);
        for (char c : numAsAString.toCharArray()) {
            if ((c - '0') == d)
                occurrence++;
        }
        return occurrence;
    }

    /**
     * Elements 7.2 base conversion
     *
     * @param numAsString
     * @param b1
     * @param b2
     * @return
     */
    public static String convertBase(String numAsString, int b1, int b2) {
        boolean isNegative = numAsString.startsWith("-");
        int numAsInt = 0;

        // base b1 convert to base 10
        for (int i = (isNegative ? 1 : 0); i < numAsString.length(); i++) {
            char ch = numAsString.charAt(i);
            numAsInt *= b1;
            numAsInt += Character.isDigit(ch) ? ch - '0' : ch - 'A' + 10;
        }

        System.out.println("base 10:" + numAsInt);

        // base 10 convert to base b2
        return (isNegative ? "-" : "") + (numAsInt == 0 ? "0" : constructFromBase(numAsInt, b2));
    }

    private static String constructFromBase(int numAsInt, int base) {
        if (numAsInt == 0)
            return "";
        else
            // if numAsInt%base >= 10, use characters to present digit,
            // Otherwise '0'+ digit
            return constructFromBase(numAsInt / base, base)
                    + (char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10 : '0' + numAsInt % base);
    }

    /**
     * 1.使用两个栈，countStack存子串的重复次数，resStack存中间结果 2.读取完一个数字，把数量入countStack栈
     * 3.读取到[时，把n[前面的结果计算出来并入resStack栈
     * 4.读取到]时，取出最近一次n[res]前面的中间计算结果，也就是resStack的栈顶，再append
     * n次res，n为countStack的栈顶，res为最近一次[]中间的子串 5.其他情况，将字符追加到res末尾
     * <p>
     * 比如: 3[a]2[b3[d]c] 下面是读完各字符时的情况： 读完: 3 [ a ] 2 [ b 3 [ d ] c ] countStack: (3)
     * (3) (3) () (2) (2) (2) (2 3) (2 3) (2 3) (2) (2) () resStack: () ("") ("") ()
     * () (aaa) (aaa) (aaa) (aaa b) (aaa b) (aaa) (aaa) () res: "" "" a aaa aaa "" b
     * b "" d bddd bdddc aaabdddcbdddc
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> segmentStack = new Stack<>();

        int idx = 0;
        while (idx < s.length()) {
            char ch = s.charAt(idx);
            if (Character.isDigit(ch)) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (ch == '[') {
                segmentStack.push(res);
                res = "";
            } else if (ch == ']') {
                StringBuilder sb = new StringBuilder();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    sb.append(res);
                }
                res = sb.toString();
            } else {
                res += ch;
            }
            idx++;
        }
        return res;
    }

    // a b a c
    // a a c
    // d d d d c
    public int replaceAndRemove(int size, char[] s) {
        int idx = 0;
        int numOfA = 0;

        for (int i = 0; i < size; i++) {
            if (s[i] != 'b')
                s[idx++] = s[i];
            if (s[i] == 'a')
                numOfA++;
        }

        int curSize = idx;
        int finalSize = curSize + numOfA;
        int curIdx = idx - 1;
        int writeIdx = finalSize - 1;
        while (curIdx >= 0) {
            if (s[curIdx] == 'a') {
                s[writeIdx--] = 'd';
                s[writeIdx--] = 'd';
            } else {
                s[writeIdx--] = s[curIdx];
            }
            curIdx--;
        }

        return finalSize;
    }

    public String reverseWords(String s) {

        if (s == null || s.length() == 0)
            return "";
        s = s.trim();
        String[] words = s.split(" ");
        int start = 0;
        int end = words.length - 1;
        while (start < end) {
            String tmp = words[start];
            words[start++] = words[end];
            words[end--] = tmp;
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

        }
        return String.join(" ", words);
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int sIdx = 0;
        int pIdx = 0;
        int starIdx = -1;
        int sTmpIdx = -1;

        while (sIdx < sLen) {
            // If the pattern character = string character
            // or pattern character = '?'
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                ++sIdx;
                ++pIdx;
            } else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                // Check the situation
                // when '*' matches no characters
                starIdx = pIdx;
                sTmpIdx = sIdx;
                pIdx++;
            }
            // If pattern character != string character
            // or pattern is used up
            // and there was no '*' character in pattern
            else if (starIdx == -1) {
                return false;
            }
            // If pattern character != string character
            // or pattern is used up
            // and there was '*' character in pattern before
            else {
                // Backtrack: check the situation
                // when '*' matches one more character
                pIdx = starIdx + 1;
                sIdx = sTmpIdx + 1;
                sTmpIdx = sIdx;
            }
        }

        // The remaining characters in the pattern should all be '*' characters
        for (int i = pIdx; i < pLen; i++)
            if (p.charAt(i) != '*')
                return false;
        return true;
    }
}
