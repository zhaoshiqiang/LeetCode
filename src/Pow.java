/**第50
 * Implement pow(x, n).
 * Created by zhaoshiqiang on 2017/2/22.
 */
public class Pow {

    //直接递归n个x相乘，时间复杂度为O(n)
    public double myPow(double x, int n) {
        if (n==0)
            return 1;
        else if (n<0)
            return 1.0/myPow(x,-n);
        return x*myPow(x,n-1);
    }

    //pow(x,n) = pow(x,n/2)*pow(x,n-n/2)，时间复杂度为O(logn)
    public double myPowII(double x, int n) {
        if(n==0)
            return 1.0;
        if(n<0)
            return 1.0/myPowII(x, -n);
        double half = myPowII(x, n >> 1);
        if(n%2==0)
            return half*half;
        else
            return half*half*x;
    }

    //该方法通过扫描n的二进制表示形式里不同位置上的1，来计算x的幂次
    public double myPowIII(double x, int n)
    {
        //x取值为0时，0的正数次幂是1，而负数次幂是没有意义的；判断x是否等于0不能直接用“==”。
        if (n==0){
            return 1;
        }else if (n<0){
            //对于n取值INT_MIN时，-n并不是INT_MAX，这时需要格外小心。
            if (n==Integer.MIN_VALUE){
                return 1/(myPowIII(x,Integer.MAX_VALUE)*x);
            }
        }
        double ans = 1.0;
        //尽量使用移位运算来代替除法运算，加快算法执行的速度。
        for (; n>0; x*=x, n>>=1){
            if ((n&1)>0){
                ans*=x;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int i=0;
        i=i++;
        System.out.println(i);
    }
}
