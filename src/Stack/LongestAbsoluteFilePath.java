package Stack;

import java.util.Stack;

/**
 * @Number: #388. Longest Absolute File Path
 * @Descpription: Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system.
 * If there is no file in the system, return 0.
 * The name of a file contains at least a . and an extension.
 * The name of a directory or sub-directory will not contain a ..
 * Time complexity required: O(n) where n is the size of the input string.
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 * @Author: Created by xucheng.
 */
public class LongestAbsoluteFilePath {
    /**
     * stack: maintain a variable maxLen to record the max length
     * use a stack to store current len and update maxLen
     * time: O(n)
     * @param input
     * @return
     */
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0)
            return 0;

        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // dummy length
        for (String dir : input.split("\n")) {
            int level = dir.lastIndexOf("\t") + 1; // nums of \t
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            System.out.println("peek: " + stack.peek());
            // 前缀的长度 + 当前dir的长度 - \t的个数 + 1 （"\"的长度）
            // 因为拼接时需要去掉所有\t并加上1个\
            int currLen = stack.peek() + dir.length() - level + 1;
            stack.push(currLen);
            System.out.println("curr len: " + currLen);
            // file name, update the max len
            if (dir.contains("."))
                // 如果已经找到file，则多append了一个"\"在最后，长度减去一个"\"长度，然后update Max len
                maxLen = Math.max(maxLen, currLen - 1);
        }
        return maxLen;
    }
}
