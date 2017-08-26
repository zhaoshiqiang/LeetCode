package other;

/**第74题
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

     Integers in each row are sorted from left to right.
     The first integer of each row is greater than the last integer of the previous row.
     For example,

     Consider the following matrix:

     [
         [1,   3,  5,  7],
         [10, 11, 16, 20],
         [23, 30, 34, 50]
     ]
     Given target = 3, return true.
 * Created by zhaoshiqiang on 2017/2/23.
 */
public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int i=m-1;
        int j=0;
        //从坐下角开始遍历，若相等则放回true，若小于target则向右移动，若大于则向上移动
        while (i>=0 && j<n){
            if (matrix[i][j]==target){
                return true;
            }else if (matrix[i][j] > target){
                i--;
            }else {
                j++;
            }
        }
        return false;
    }
}
