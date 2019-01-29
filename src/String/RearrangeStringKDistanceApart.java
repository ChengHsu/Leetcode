package String;

/**
 * @Number: 358. Rearrange String k Distance Apart
 * @Descpription: Given a non-empty string s and an integer k,
 * rearrange the string such that the same characters are at least distance k from each other.
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 * @Author: Created by xucheng.
 */
public class RearrangeStringKDistanceApart {
    /**
     * Greedy
     * One count array to store the remaining count of every character. Another array to keep track of the most left position that one character can appear.
     We will iterated through these two array to find the best candidate for every position.
     * @param str
     * @param k
     * @return
     */
    public String rearrangeString(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for(int i=0;i<length;i++){
            count[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int index = 0;index<length;index++){
            int candidatePos = findValidMax(count, valid, index);
            if( candidatePos == -1) return "";
            count[candidatePos]--;
            valid[candidatePos] = index+k;
            sb.append((char)('a'+candidatePos));
            System.out.println("sb: "+ sb);
        }
        return sb.toString();
    }

    private int findValidMax(int[] count, int[] valid, int index){
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        for(int i=0;i<count.length;i++){
            if(count[i]>0 && count[i]>max && index>=valid[i]){
                max = count[i];
                candidatePos = i;
            }
        }
        return candidatePos;
    }
}