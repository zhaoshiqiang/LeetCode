package Offer_Problem;

/**
 *《剑指offer》面试题12 打印1到最大的n位数
 * Created by zhaoshiqiang on 2017/8/8.
 */
public class Offer_Problem12 {

    public static void printNum(int n){
        if (n <= 0){
            return;
        }
        dfs("",0,n);
    }

    public static void dfs(String num, int index, int n){
        if (index == n){
            num = num.replaceAll("^0*","");
            System.out.println(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            dfs(num+i, index+1, n);
        }
    }

    public static void main(String[] args) {
        printNum(3);
    }
}
