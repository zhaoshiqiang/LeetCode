/**第73题
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Follow up:
     Did you use extra space?
     A straight forward solution using O(mn) space is probably a bad idea.
     A simple improvement uses O(m + n) space, but still not the best solution.
     Could you devise a constant space solution?
 * Created by zhaoshiqiang on 2017/1/13.
 */
/*
* 利用行列两个数组来存储是否该行/列是否为0。空间复杂度O(m+n)。
* 由于题目中提到in place的要求，所以我们可以考虑利用第一行和第一列来存储行/列是否为0的信息。
* 这样，就需要firstRowZero和firstColumnZero这两个变量表示原本的第一行第一列是否含0
* */
public class Set_Matrix_Zeroes {
    public static void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        if (matrix[0][0] == 0){
            firstColumnZero = true;
            firstRowZero = true;
        }
        if (firstColumnZero == false){
            for (int i=1 ; i<matrix.length; i++){
                if (matrix[i][0] == 0){
                    firstColumnZero = true;
                    break;
                }
            }
        }
        if (firstRowZero == false){
            for (int j=1; j<matrix[0].length ; j++){
                if (matrix[0][j] == 0){
                    firstRowZero = true;
                    break;
                }
            }
        }
        for (int i=1; i<matrix.length; i++){
            for (int j=1; j<matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for (int i=matrix.length-1; i>0 ; i--){
            if (matrix[i][0] == 0){
                for (int k=1; k<matrix[i].length; k++){
                    matrix[i][k]=0;
                }
            }
        }
        for (int j=matrix[0].length-1; j>0 ; j--){
            if (matrix[0][j] == 0){
                for (int k=1; k<matrix.length; k++){
                    matrix[k][j]=0;
                }
            }
        }
        if (firstRowZero){
            for (int k=0; k<matrix[0].length; k++){
                matrix[0][k]=0;
            }
        }
        if (firstColumnZero){
            for (int k=0; k<matrix.length; k++){
                matrix[k][0]=0;
            }
        }

    }
    public static void main(String[] args){
        int[][] a = new int[][]{{1,2,3},{0,2,3}};
        setZeroes(a);
        for (int i=0; i<a.length; i++){
            System.out.println();
            for (int j=0; j<a[0].length; j++){
                System.out.print(a[i][j]+"  ");
            }
        }
    }

}
