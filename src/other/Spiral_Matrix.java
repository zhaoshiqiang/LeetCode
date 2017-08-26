package other;

import java.util.ArrayList;
import java.util.List;

/**第54
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 For example,
 Given the following matrix:
 [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 * Created by zhaoshiqiang on 2017/1/29.
 */
//旋转矩阵，思路很固定，但是细节方面很容易出错
public class Spiral_Matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0){
            return res;
        }
        rec(matrix,res,0,0,matrix[0].length-1,matrix.length-1);
        return res;
    }
    //用(x1,y1)标识矩阵左上角，(x2,y2)标识矩阵右上角，从左到右为x轴，从上到下为y轴
    //这样用两个点限定范围是最不容易出错的
    public static void rec(int[][] matrix,List<Integer> res,int x1,int y1,int x2,int y2){
        if (x1>x2 || y1>y2){
            return;
        }
        //只剩下一列
        if (x1 == x2){
            for (int j=y1; j<=y2; j++){
                res.add(matrix[j][x1]);
            }
            return;
        }
        //只剩下一行
        if (y1 == y2){
            for (int i=x1; i<=x2; i++){
                res.add(matrix[y1][i]);
            }
            return;
        }
        //(x1,y1)-->(x2,y1)
        for (int i=x1;i<=x2; i++){
            res.add(matrix[y1][i]);
        }
        //(x2,y1+1)-->(x2,y2)
        for (int j=y1+1;j<=y2; j++){
            res.add(matrix[j][x2]);
        }
        //(x2-1,y2)-->(x1,y2)
        for (int i=x2-1;i>=x1;i--){
            res.add(matrix[y2][i]);
        }
        //(x1,y2-1)-->(x1,y1+1)
        for (int j=y2-1;j>=y1+1;j--){
            res.add(matrix[j][x1]);
        }
        rec(matrix,res,x1+1,y1+1,x2-1,y2-1);
    }

    public static void main(String[] args){
//        int[][] nums =new int[][]{{ 3 }};
        int[][] nums =new int[][]{{ 3,2 } };
//        int[][] nums =new int[][]{{ 1, 2, 3 },{ 4, 5, 6 },{ 7, 8, 9 } };
        List<Integer> res = spiralOrder(nums);
        for (int i=0; i<res.size(); i++){
            System.out.print(res.get(i)+" ");
        }
    }
}
