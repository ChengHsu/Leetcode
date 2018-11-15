package String;

/**
 * @Number: #709. To Lower Case
 * @Descpription: Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * @Author: Created by xucheng.
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()) {
            // ASCII A: 65  Z: 90
            char tmp = c >= 'A' && c <= 'Z'? (char)(c + 32): c;
            sb.append(tmp);
        }
        return sb.toString();
    }
}
