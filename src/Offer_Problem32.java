/**
 * 《剑指offer》从1到n整数中1出现的数字
 * Created by zhaoshq on 2017/8/10.
 */
public class Offer_Problem32 {

    public long countOne(long n){
        long count = 0;
        long i = 1; //表示位数
        long current =0;//当前位的数字
        long after =0;  //当前位后面的数字
        long before =0; //当前位前面的数字
        while ((n/i) != 0){
            current = (n/i) %10;
            before = n/(i*10);
            after = n - (n/i)*i;

            if (current > 1){
                //1的次数为（更高位+1）*当前位数，如12213中的百位
                count += (before + 1)*i;
            }else if (current == 0){
                //1的次数为 更高位*当前位数，如12013中百位
                count += before*i;
            }else if (current == 1){
                //1的次数为 更高位*当前位数 + 低位 + 1，如12113中的百位
                count += before*i + after + 1;
            }
            i = i * 10;
        }
        return count;
    }
}
