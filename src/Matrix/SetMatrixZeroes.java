package Matrix;

/**
 * @Number: #73. Set Matrix Zeroes
 * @Descpription: Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * @Author: Created by xucheng.
 */
public class SetMatrixZeroes {
    /**
     * brute force
     * time: O((m * n) * (m + n))
     * space: O(1)
     * note:
     * can not modify elements that have same row number or col number with the current 0 element directly to 0
     * can not modify 0 elements that have same row number or col number with the current 0 element directly to -1000000
     *
     * @param matrix
     */
//    public void setZeroes(int[][] matrix) {
//        // edge case
//        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
//            return;
//
//        int rowLen = matrix.length;
//        int colLen = matrix[0].length;
//
//        for (int row = 0; row < rowLen; row++) {
//            for (int col = 0; col < colLen; col++) {
//                if (matrix[row][col] == 0) {
//                    for (int i = 0; i < rowLen; i++)
//                        if (matrix[i][col] != 0)
//                            matrix[i][col] = -1000000;
//                    for (int i = 0; i < colLen; i++)
//                        if (matrix[row][i] != 0)
//                            matrix[row][i] = -1000000;
//                }
//            }
//        }
//
//        for (int row = 0; row < rowLen; row++) {
//            for (int col = 0; col < colLen; col++) {
//                if (matrix[row][col] == -1000000)
//                    matrix[row][col] = 0;
//            }
//        }
//        return;
//    }


    public void setZeroes(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }


}
