/**第69
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 * Created by zhaoshiqiang on 2017/2/22.
 */
public class Sqrtx {
    //牛顿迭代法
    public static int mySqrt(int x) {
        if (x ==0)
            return 0;
        double pre;
        double cur = 1;
        do
        {
            pre = cur;
            cur = x / (2 * pre) + pre / 2.0;
        } while (Math.abs(cur - pre) > 0.00001);
        return (int) cur;
    }
    //二分法
    public static int mySqrtII(int x) {
        if (x==1) return 1;

        long begin=0;
        long end=x/2;
        long mid;
        long tmp;
        while (begin<end){
            mid=(begin+end)/2;
            tmp=mid*mid;
            if (tmp==x)
                return (int) mid;
            else if (tmp<x)
                begin=mid+1;
            else
                end=mid-1;
        }
        //这里用end和begin都可以
        tmp=end*end;
        if (tmp>x)
            return (int) (end-1);
        else
            return (int) end;
    }

    public static void main(String[] args){
        System.out.println(mySqrtII(10));

    }
}
