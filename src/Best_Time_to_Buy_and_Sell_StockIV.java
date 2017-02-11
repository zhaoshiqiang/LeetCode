/** 第188
 * Say you have an array for which the ith element is the price of a given stock on day i.
     Design an algorithm to find the maximum profit. You may complete at most k transactions.
     Note:
     You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again)
 * Created by zhaoshiqiang on 2017/1/27.
 */
//背包动态规划
/*
* 传统的动态规划我们会这样想，到第i天时进行j次交易的最大收益，
* 要么等于到第i-1天时进行j次交易的最大收益（第i天价格低于第i-1天的价格），要么等于到第i-1天时进行j-1次交易，
* 然后第i天进行一次交易（第i天价格高于第i-1天价格时）。于是得到动规方程如下（其中diff = prices[i] – prices[i – 1]）：
    profit[i][j] = max(profit[i – 1][j], profit[i – 1][j – 1] + diff)
    看起来很有道理，但其实不对，为什么不对呢？
    因为diff是第i天和第i-1天的差额收益，如果第i-1天当天本身也有交易呢，那么这两次交易就可以合为一次交易，
    这样profit[i – 1][j – 1] + diff实际上只进行了j-1次交易，而不是最多可以的j次，这样得到的最大收益就小了。
那么怎样计算第i天进行交易的情况的最大收益，才会避免少计算一次交易呢？我们用一个局部最优解和全局最有解表示到第i天进行j次的收益，这就是该动态规划的特殊之处。
我们维护两种量，一个是当前到达第i天可以最多进行j次交易，最好的利润是多少（global[i][j]），
另一个是当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少（local[i][j]）
下面我们来看递推式，全局的比较简单，
    global[i][j]=max(local[i][j],global[i-1][j])，
也就是去当前局部最好的，和过往全局最好的中大的那个（因为最后一次交易如果包含当前天一定在局部最好的里面，否则一定在过往全局最优的里面）。
对于局部变量的维护，递推式是
    local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
也就是看两个量，第一个是全局到i-1天进行j-1次交易，然后加上今天的交易，如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），
第二个量则是取local第i-1天j次交易，然后加上今天的差值
（这里因为local[i-1][j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，并不会增加交易次数，而且这里无论diff是不是大于0都一定要加上，因为否则就不满足local[i][j]必须在最后一天卖出的条件了）。
* */
public class Best_Time_to_Buy_and_Sell_StockIV {

    public static int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        int diff=0;
        int length=prices.length;
        for (int i=1; i<length; i++){
            diff = prices[i]-prices[i-1];
            for (int j=k; j>0; j--){
                local[j]=Math.max(global[j-1] + (diff>0?diff:0),local[j]+diff);
                global[j]=Math.max(global[j],local[j]);
            }
        }
        return global[k];
    }

    public static void main(String[] args){
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(2,prices));
    }
}
