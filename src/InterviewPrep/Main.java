package InterviewPrep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // 0abcdefgh1abcdefgh
    // 1abcdefgh0abcdefgh
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String n = sc.nextLine();
//        int num = Integer.parseInt(n);
//        String str = sc.nextLine();
//        int idx = 0;
//        StringBuilder res = new StringBuilder();
//        int cnt = 0;
//        while (idx < str.length() - 9) {
//            char c = str.charAt(idx);
//            String s = str.substring(idx+1, idx + 9);
//            StringBuilder tmp = new StringBuilder(s);
//            if(c == '0'){
//                tmp = tmp.reverse();
//            }
//            res.append(tmp).append(" ");
//            idx += 9;
//            cnt++;
//            if (cnt >= num)
//                break;
//        }
//        if (cnt + 1 <= num){
//            char c = str.charAt(idx);
//            String lastStr = str.substring(idx+1);
//            StringBuilder lastStrSb = new StringBuilder(lastStr);
//            if(c == '0'){
//                lastStrSb = lastStrSb.reverse();
//            }
//            res.append(lastStrSb);
//        }
//        System.out.println(res.toString());
//    }

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String n = sc.nextLine();
//        int num = Integer.parseInt(n);
//        System.out.println(num);
//        List<int[]> cords = new ArrayList<>();
//        boolean[][] graph = new boolean[40][50];
//        for(int i = 0; i < num; i++){
//            String str = sc.nextLine();
//            String[] strArr = str.split(" ");
//            int x = Integer.parseInt(strArr[0]);
//            int y = Integer.parseInt(strArr[1]);
//            int[] c = new int[2];
//            c[0] = x;
//            c[1] = y;
//            cords.add(c);
//        }
//        int cnt = 0;
//        for (int i = 0; i < cords.size(); i++){
//            int x = cords.get(i)[0];
//            int y = cords.get(i)[1];
//            if(graph[x][y] == false){
//                for (int j = 0; j < 50;j ++)
//                    graph[x][j] = true;
//                for (int j = 0; j < 40; j++)
//                    graph[j][y] = true;
//                int tx = x;
//                int ty = y;
//                while (tx > 0 && ty > 0) {
//                    graph[tx - 1][ty - 1] = true;
//                }
//                tx = x;
//                ty = y;
//                while (tx < 40 && ty < 50) {
//                    graph[tx + 1][ty + 1] = true;
//                }
//                cnt++;
//            }
//        }
//        System.out.println(cnt);
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String n = sc.nextLine();
//        int num = Integer.parseInt(n);
//        List<int[]> cords = new ArrayList<>();
//        boolean[][] graph = new boolean[40][50];
//        for (int i = 0; i < num; i++) {
//            String[] str = sc.nextLine().split(" ");
//            int x = Integer.parseInt(str[0]);
//            int y = Integer.parseInt(str[1]);
//            int[] c = new int[2];
//            c[0] = x;
//            c[1] = y;
//            cords.add(c);
//        }
//
//        int cnt = 0;
//        for (int i = 0; i < cords.size(); i++){
//            int x = cords.get(i)[0];
//            int y = cords.get(i)[1];
//            if(graph[x][y] == false){
//                for (int j = 0; j < 50;j ++)
//                    graph[x][j] = true;
//                for (int j = 0; j < 40; j++)
//                    graph[j][y] = true;
//                int tx = x;
//                int ty = y;
//                while (tx > 0 && ty > 0) {
//                    graph[tx--][ty--] = true;
//                }
//                tx = x;
//                ty = y;
//                while (tx < 39 && ty < 49) {
//                    graph[tx++][ty++] = true;
//                }
//                cnt++;
//            }
//        }
//        System.out.println(cnt);
//    }

    public static void main(String[] args) {
       MicrosoftSuzhou_SDE_Intern m = new MicrosoftSuzhou_SDE_Intern();
//       int[] nums = new int[]{3,4,7,2,-3,1,4,2};
//        int[] nums = new int[]{7};
//        System.out.println(m.maxSubarraySumWithK(nums, 7));

//        System.out.println(m.putBall(3, 4));

    }
}

