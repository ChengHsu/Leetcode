package String;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main( String[] args) {
        String a = "acccccb";
        String b = "bccccca";
//        AddBinary addBinary = new AddBinary();
//        addBinary.addBinary(a , b);
//        BuddyStrings buddyStrings = new BuddyStrings();
//        System.out.println(buddyStrings.buddyStrings(a,b));
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        DetectCapital detectCapital = new DetectCapital();
//        System.out.println(detectCapital.detectCapitalUse(""));
//        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
//        countBinarySubstrings.countBinarySubstrings("10101");
//        FirstUniqueCharacterinaString firstUniqueCharacterinaString = new FirstUniqueCharacterinaString();
//        System.out.println(firstUniqueCharacterinaString.firstUniqChar("loveleetcode"));
//        CountAndSay countAndSay = new CountAndSay();
//        String str = countAndSay.countAndSay(4);
//        System.out.println("res: "+str);
//        String S = "bbGPuClvxA XYbNe";
//        GoatLatin goatLatin = new GoatLatin();
//        System.out.println(goatLatin.toGoatLatin(S));
//        String s = "b   a   a";
//        LengthofLastWord lengthofLastWord = new LengthofLastWord();
//        System.out.println(lengthofLastWord.lengthOfLastWord(s));
//        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
//        String[] arr = {"flower","flow","flight"};
//        System.out.println(longestCommonPrefix.longestCommonPrefix(arr));
//        NumberofSegmentsinaString numberofSegmentsinaString = new NumberofSegmentsinaString();
//        System.out.println(numberofSegmentsinaString.countSegments("foo bar"));
        KMP k = new KMP();
        System.out.println(k.ViolentMatch("BBC ABCDAB ABCDABCDABDE","ABCDABD"));
    }
}
