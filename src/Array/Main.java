package Array;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String[] str = new String[]{"ABC","BCA"};
        System.out.println(main.maxSum(2,str));
    }

    public int maxSum(int n, String[] str){
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> firstVals = new HashSet<>();


        for (int i = 0 ; i < str.length; i++){
            int len = str[i].length();
            firstVals.add(str[i].charAt(0));
            int cnt = 1;
            for (int j = len - 1; j >= 0; j--){
                char c = str[i].charAt(j);
                map.put(c, map.getOrDefault(c, 0) + cnt);
                cnt *= 10;
            }
        }


        ArrayList<Map.Entry<Character,Integer>> list  = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        if (list.size() == 10){
            for (int i = 9; i >=0; i--){
                if (!firstVals.contains(list.get(i).getKey())){
                    list.remove(i);
                    break;
                }
            }
        }

        int weight = 9;
        int idx = 0;
        int res = 0;
        while (idx < list.size()){
            res += list.get(idx).getValue() * weight;
            idx++;
            weight--;
        }
        return res;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0)
            return ans;

        backtrack(ans, "",0 , 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String curr, int left, int right, int n) {
        if (curr.length() == n * 2) {
            ans.add(curr);
            return;
        }

        if (left < n)
            backtrack(ans, curr + "(",left + 1, right, n);
        if (right < left)
            backtrack(ans,curr + ")", left, right + 1, n);

    }



}


