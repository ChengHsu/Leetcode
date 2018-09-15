package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Number: #766. Toeplitz Matrix
 * @Descpription: A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * @Author: Created by xucheng.
 */
public class ToeplitzMatrix {
    // One feature that makes 2 coordinates (r1,c1) and (r2,c2) belong to the same diagonal is r1-c1==r2-c2
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer,Integer> values = new HashMap<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (!values.containsKey(r-c))
                    values.put(r-c,matrix[r][c]);
                else if (values.get(r-c) != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
