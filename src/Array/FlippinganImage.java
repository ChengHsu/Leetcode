package Array;

/**
 * @Number: 832. Flipping an Image
 * @Descpription: Given a binary matrix A, we want to flip the image horizontally, then invert it,
 * and return the resulting image. To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * For example, inverting [0, 1, 1] results in [1, 0, 0].
 * @Author: Created by xucheng.
 */
public class FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
//        Flip: Judge if the length is odd or even, then swap the numbers of two sides.
        for (int i = 0; i < A.length; i++) {
            int start = 0;
            int end = A[0].length - 1;
            for (int j = 0; j < A[0].length / 2; j++) {
                int tmp = A[i][start];
                A[i][start] = A[i][end];
                A[i][end] = tmp;
                start++;
                end--;
            }
        }

//      invert
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) A[i][j] = 1;
                else if (A[i][j] == 1) A[i][j] = 0;
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.println(A[i][j]);
            }
        }
        return A;
    }
}
