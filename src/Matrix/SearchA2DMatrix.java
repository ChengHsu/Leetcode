package Matrix;

/**
 * @Number: #74. Search a 2D Matrix
 * @Descpription: Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * #240. Search a 2D Matrix II
 * change: Integers in each column are sorted in ascending from top to bottom.
 * @Author: Created by xucheng.
 */
public class SearchA2DMatrix {

    /**
     * 74:
     * TLE solution - 2 binary searches
     * 1. binary serach on first column to find the row that contains the target
     * 2. binary search on that row to find the target
     * time: O(2 log n)
     * @param matrix
     * @param target
     * @return
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        // edge case
//        if (matrix.length == 0 || matrix[0].length == 0)
//            return false;
//
//        int rowLen = matrix.length;
//        int colLen = matrix[0].length;
//        // 1. 1st binary search
//        int lo = 0;
//        int hi = rowLen - 1;
//        while (lo < hi) {
//            int mid = (hi - lo) / 2 + lo;
//            if (matrix[mid][0] == target)
//                return true;
//            else if (matrix[mid][0] < target)
//                hi = mid;
//            else
//                lo = mid + 1;
//        }
//        // /2. 2nd binary search
//        int low = 0;
//        int high = colLen - 1;
//        while (low <= high) {
//            int mid = (high - low) / 2 + low;
//            if (matrix[lo][mid] == target)
//                return true;
//            if (matrix[lo][mid] < target)
//                high = mid;
//            else low = mid + 1;
//        }
//        return false;
//    }


    /**
     * 74:
     * One binary search: treat the matrix as a sorted list
     * n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
     * an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
     * time: O(log n)
     *
     * @param matrix
     * @param target
     * @return
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        //edge case
//        if (matrix.length == 0 || matrix[0].length == 0)
//            return false;
//
//        int rowLen = matrix.length;
//        int colLen = matrix[0].length;
//
//        int low = 0;
//        int high = rowLen * colLen - 1;
//        while (low <= high) {
//            int mid = (high - low) / 2 + low;
//            if (matrix[mid / colLen][mid % colLen] == target)
//                return true;
//            else if (matrix[mid / colLen][mid % colLen] < target)
//                low = mid + 1;
//            else
//                high = mid - 1;
//        }
//        return false;
//    }


    /**
     * 240:
     * 左下角的数往上所有数递减，往右所有数递增，和target相比较，如果target大，就往右搜，如果target小，就往上搜
     * time: O（m+n. We can rule out one row or one column each time,
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //edge case
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rowLen - 1][colLen - 1])
            return false;

        int x = rowLen - 1;
        int y = 0;
        // general case
        while (true) {
            if (matrix[x][y] > target)
                x--;
            else if (matrix[x][y] < target)
                y++;
            else
                return true;
            if (x < 0 || y >= colLen)
                break;
        }
        return false;
    }


}
