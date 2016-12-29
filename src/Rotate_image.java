/**
 * 48Ã‚
 * You are given an n x n 2D matrix representing an image.
  Rotate the image by 90 degrees (clockwise).
 * Created by zhaoshiqiang on 2016/12/29.
 */
public class Rotate_image {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1){
            return;
        }

        for(int i=0;i<n/2;i++)  {
            for(int j=i;j<n-1-i;j++) {
                int val = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = val;
            }
        }
    }
}