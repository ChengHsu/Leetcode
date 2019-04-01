package Stack;

import java.util.*;

/**
 * @Number: #71. Simplify Path
 * @Descpription: Given an absolute path for a file (Unix-style), simplify it.
 * Or in other words, convert it to the canonical path.
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level.
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names.
 * The last directory name (if it exists) must not end with a trailing /.
 * Also, the canonical path must be the shortest string representing the absolute path.
 * an example of the difference between an absolute path and a canonical path:
 * absolute path:  C:\abc\..\abc\file.txt
 * canonical path: C:\abc\file.txt
 * @Author: Created by xucheng.
 */
public class SimplifyPath {
    /**
     * Stack:
     * push每个非"."".."的dir,遇到..则pop出上一个dir
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String dir: path.split("/")) {
            if (!stack.empty() && dir.equals(".."))
                stack.pop();
            else if (!dir.equals(".") && !dir.equals("") && !dir.equals(".."))
                stack.push(dir);
        }
        List<String> list = new ArrayList(stack);
        return "/"+String.join("/", list);
    }
}
