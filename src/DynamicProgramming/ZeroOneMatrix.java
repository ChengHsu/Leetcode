package DynamicProgramming;

/**
 * @Number: 542. 01 Matrix
 * @Descpription: Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * @Author: Created by xucheng.
 */
public class ZeroOneMatrix {
    /**
     for each 0, we skip since the nearest 0 is itself
     for each 1, we take the min distance from its 4 neighbours + 1
     we do 2 passes to fill the 4 neighbours around each non-zero cell
     time : O(m * n)
     extra space: O(1)
     */
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return matrix;

        final int MaxRange = matrix.length * matrix[0].length;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != 0) {
                    int up = (i > 0) ? matrix[i-1][j] : MaxRange;
                    int left = (j > 0)? matrix[i][j-1] : MaxRange;
                    matrix[i][j] = Math.min(up, left) + 1;
                }
            }
        }

        for(int i = matrix.length - 1; i >= 0; i--) {
            for(int j = matrix[0].length - 1; j >= 0; j--) {
                if(matrix[i][j] != 0) {
                    int bottom = (i < matrix.length - 1)? matrix[i+1][j] : MaxRange;
                    int right = (j < matrix[0].length - 1)? matrix[i][j+1] : MaxRange;
                    matrix[i][j] = Math.min(matrix[i][j],Math.min(bottom, right) + 1);
                }
            }
        }

        return matrix;
    }
}
