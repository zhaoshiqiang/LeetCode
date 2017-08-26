package other;

/**第59题
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     For example,Given n = 3,
     You should return the following matrix:
     [
         [ 1, 2, 3 ],
         [ 8, 9, 4 ],
         [ 7, 6, 5 ]
     ]
 * Created by zhaoshiqiang on 2017/1/31.
 */
//旋转矩阵
public class Spiral_MatrixII {
    public static int[][] generateMatrix(int n) {
        if (n == 0){
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        if (n == 1){
            res[0][0]=1;
            return res;
        }
        rec(res,1,0,0,n-1,n-1);
        return res;
    }

    //用(x1,y1)标识矩阵左上角，(x2,y2)标识矩阵右上角，从左到右为x轴，从上到下为y轴
    public static void rec(int[][] matrix,int num,int x1,int y1,int x2,int y2){
        if (x1>x2 || y1>y2){
            return;
        }
        //只剩下一列
        if (x1 == x2){
            for (int j=y1; j<=y2; j++){
                matrix[j][x1]=num++;
            }
            return;
        }
        //只剩下一行
        if (y1 == y2){
            for (int i=x1; i<=x2; i++){
                matrix[y1][i]=num++;
            }
            return;
        }
        //(x1,y1)-->(x2,y1)
        for (int i=x1;i<=x2; i++){
            matrix[y1][i]=num++;
        }
        //(x2,y1+1)-->(x2,y2)
        for (int j=y1+1;j<=y2; j++){
            matrix[j][x2]=num++;
        }
        //(x2-1,y2)-->(x1,y2)
        for (int i=x2-1;i>=x1;i--){
            matrix[y2][i]=num++;
        }
        //(x1,y2-1)-->(x1,y1+1)
        for (int j=y2-1;j>=y1+1;j--){
            matrix[j][x1]=num++;
        }
        rec(matrix,num,x1+1,y1+1,x2-1,y2-1);
    }

    public static void main(String[] args){
        int[][] res = generateMatrix(0);
//        int[][] res = generateMatrix(1);
//        int[][] res = generateMatrix(3);
        for (int i=0; i<res.length; i++){
            System.out.println();
            for (int j=0; j<res[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
        }
    }
}
