
/**
 * 《剑指offer》圆圈中最后剩下的数字
 * Created by zhaoshq on 2017/8/10.
 */
public class Offer_Problem45 {
    public int lastRemaining(int n, int m){
        if (n<1 || m<1){
            return -1;
        }
        int last = 0;
        for (int i=2; i<m; i++){
            //这个公式是数学推到出来的
            last = (last+m)%i;
        }
        return last;
    }
}
