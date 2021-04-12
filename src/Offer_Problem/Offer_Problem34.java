package Offer_Problem;

/**
 * 《剑指offer》丑数
 * Created by zhaoshq on 2017/8/10.
 */
public class Offer_Problem34 {
    public static int getUglyNumber(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        //保存n个丑数
        int[] uglyArray = new int[n];
        uglyArray[0] = 1;
        int m2 = 0; //第m2个数*2便大于当前数组中最大的丑数
        int m3 = 0; //第m3个数*3便大于当前数组中最大的丑数
        int m5 = 0; //第m5个数*5便大于当前数组中最大的丑数
        for (int i=1; i<n; i++){
            //计算第i个丑数
            int min = min(uglyArray[m2]*2, uglyArray[m3]*3, uglyArray[m5]*5);
            uglyArray[i] = min;
            //更新m2，m3，m5
            while (uglyArray[m2]*2 <= min){
                m2++;
            }
            while (uglyArray[m3]*3 <= min){
                m3++;
            }
            while (uglyArray[m5]*5 <= min){
                m5++;
            }
        }

        return uglyArray[n-1];
    }

    private static int min(int n1, int n2, int n3) {

        int min = n1 > n2 ? n2 : n1;
        return min > n3 ? n3 : min;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(15));
    }
}
