package Array;

/**
 * @Number: #566.Reshape the Matrix
 * @Descpription: In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * Given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * @Author: Created by xucheng.
 */
public class ReshapeTheMatrix {
//  2D -> 1D -> 2D
//    public int[][] matrixReshape(int[][] nums, int r, int c) {
//        int prevRows = nums.length;
//        int prevColumns = nums[0].length;
//        int[] tmpNums = new int[prevRows * prevColumns];
//        int[][] curNums = new int[r][c];
//        int count = 0;
//        for (int i = 0; i < prevRows; i++) {
//            for(int j = 0; j < prevColumns; j++) {
//                tmpNums[count++] = nums[i][j];
//            }
//        }
//        count = 0;
//        if((r * c) != prevRows * prevColumns)
//            return nums;
//        else {
//            for (int i = 0; i < r; i++) {
//                for (int j = 0 ; j < c ; j++) {
//                    curNums[i][j] = tmpNums[count++];
//                }
//            }
//            return curNums;
//        }
//    }

//  Judge: if the reshape is impossible, return original one. Otherwise, 2D -> 2D
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int prevRows = nums.length;
        int prevColumns = nums[0].length;
        if (r * c != prevRows * prevColumns) return nums;
        int[][] reshapedNums = new int[r][c];
        int rPos = 0;
        int cPos = 0;

        for (int[] rNum : nums) {
            for (int num : rNum) {
                reshapedNums[rPos][cPos] = num;
                if (cPos < c - 1) cPos++;
                else {
                    rPos++;
                    cPos = 0;
                }
            }
        }
        return reshapedNums;
    }
}
