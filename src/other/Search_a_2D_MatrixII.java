package other;

/**第240
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

     Integers in each row are sorted in ascending from left to right.
     Integers in each column are sorted in ascending from top to bottom.
     For example,

     Consider the following matrix:

     [
         [1,   4,  7, 11, 15],
         [2,   5,  8, 12, 19],
         [3,   6,  9, 16, 22],
         [10, 13, 14, 17, 24],
         [18, 21, 23, 26, 30]
     ]
     Given target = 5, return true.

     Given target = 20, return false.
 * Created by zhaoshiqiang on 2017/2/23.
 */
public class Search_a_2D_MatrixII {
    //从右上角开始, 比较target 和 matrix[i][j]的值. 如果小于target, 则该行不可能有此数,  所以i++;
    // 如果大于target, 则该列不可能有此数, 所以j--. 遇到边界则表明该矩阵不含target.
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0)
            return false;
        int i=0;
        int j=matrix[0].length-1;
        while (i<matrix.length && j>=0){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] < target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
