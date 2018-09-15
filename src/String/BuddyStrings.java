package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Number: #859. Buddy Strings
 * @Descpription: Given two strings A and B of lowercase letters,
 * return true if and only if we can swap two letters in A so that the result equals B.
 * @Author: Created by xucheng.
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        // A和B长度必须相等
        // 如果A equals B, 若有重复字符则相当于交换重复字符后==B
        // 如果A not equals B, 遍历并记录不同的点的index, 若index数为2且A[i] == B[j]且B[i] == A[j],则可==B

        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (char c : A.toCharArray()) {
                set.add(c);
            }
            return set.size() < A.length();
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                list.add(i);
            }
        }
        return (list.size() == 2 && A.charAt(list.get(0)) == B.charAt(list.get(1)) && A.charAt(list.get(1)) == B.charAt(list.get(0)));
    }
}
