package Array;

/**
 * @Number: #661.Image Smoother
 * @Descpription: Given a 2D integer matrix M representing the gray scale of an image,
 * you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 * @Author: Created by xucheng.
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if (M == null) return null;
        int row = M.length;
        int col = M[0].length;

        int[][] res = new int[row][col];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                int sum = 0, num = 0;
                for (int x : new int[]{-1, 0, 1}) {
                    for (int y : new int[]{-1, 0, 1}) {
                        if (isValid(i + x, j + y, row, col)) {
                            sum += M[i + x][j + y];
                            num ++;
                        }
                    }
                }
                res[i][j] = sum / num;
            }
        }
        return res;
    }
    private boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
