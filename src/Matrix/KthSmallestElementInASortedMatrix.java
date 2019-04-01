package Matrix;

/**
 * @Number: #378. Kth Smallest Element in a Sorted Matrix
 * @Descpription: Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * @Author: Created by xucheng.
 */
public class KthSmallestElementInASortedMatrix {
    /**
     * naive: put all elements into one array and sort
     * return (k-1)th element
     * time: O(n^2)
     * space: O(n)
     *
     * @param matrix
     * @param k
     * @return
     */
//    public int kthSmallest(int[][] matrix, int k) {
//        if (matrix.length == 0 || matrix[0].length == 0)
//            return 0;
//
//        int rowLen = matrix.length;
//        int colLen = matrix[0].length;
//        int[] values = new int[rowLen * colLen];
//        int idx = 0;
//        for (int i =0; i < rowLen; i++) {
//            for (int j = 0 ; j < colLen; j++) {
//                values[idx++] = matrix[i][j];
//            }
//        }
//        Arrays.sort(values);
//        return values[k-1];
//    }


    /**
     * binary search
     * time: O(n * log M), where M is max in matrix
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[rowLen - 1][colLen - 1];

        while (low < high) {
            int mid = (high - low) / 2 + low;
            int count = 0;
            int j = colLen - 1;
            // find number of elements <= mid
            for (int i = 0; i < rowLen; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += j + 1;
            }
            // if number < k, go to the right part
            if (count < k) low = mid + 1;
            else
                high = mid;
        }
        return low;
    }


}
