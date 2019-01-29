package Array; /**
 * @Descpription: #118. & #119
 * #118: Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * #119: Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * @Author: Created by xucheng.
 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    //  #118 v1
    public List<List<Integer>> generate_v1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // numRow = 0
        if (numRows == 0)
            return triangle;

        // first row
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(rowNum - 1);

            // first row element
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }

            // last row element
            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }


//    #118 v2
    public List<List<Integer>> generate_v2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
//          row不是被清空的，每次开始新的循环row中都保留着上一行的数
            row.add(0, 1);
            System.out.println("new");
            System.out.println(row);
            for(int j = 1; j < row.size()-1 ; j++){
                row.set(j,row.get(j)+row.get(j+1));
            }
            triangle.add(new ArrayList<>(row));
        }
        return triangle;
    }

    //    #119
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
//        row index < 0
        if (rowIndex < 0)
            return row;
        for(int i = 0; i < rowIndex+1; i++) {
            row.add(0,1);
            for(int j = 1; j < row.size()-1; j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
        }
        return row;
    }

    public List<Integer> getRow_v(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        if (rowIndex < 0)
            return row;
        for (int i = 0; i < rowIndex+1; i++) {
            row.add(0,1);
            System.out.println("before:"+row);
            for (int j = 1; j < row.size()-1; j++) {
                int tmp = row.get(j)+row.get(j+1);
                System.out.println("add: "+ tmp);
                row.set(j,row.get(j)+row.get(j+1));
            }
            System.out.println("after:"+row);
        }
        return row;
    }
}
