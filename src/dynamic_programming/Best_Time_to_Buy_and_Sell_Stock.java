package dynamic_programming;

/**第121题
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.
 Example 1:
     Input: [7, 1, 5, 3, 6, 4]
     Output: 5
    max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

 Example 2:
     Input: [7, 6, 4, 3, 1]
     Output: 0
     In this case, no transaction is done, i.e. max profit = 0.

 假设你有一个数组，其中i元素是给定股票在第i天的价格。
 如果你只允许最多完成一个交易（即买入一个股票，卖出一份股票）
 设计一个最大利润的算法。
 * Created by zhaoshiqiang on 2017/1/26.
 */
//动态规划，局部最优+全局最优
public class Best_Time_to_Buy_and_Sell_Stock {
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int local = 0;
        int global = 0;
        int length= prices.length;
        for(int i=0;i<length-1;i++)
        {
            //每天连着买今天卖明天，就相当于在某天买入，在之后卖出
            local = Math.max(local+prices[i+1]-prices[i],0);
            global = Math.max(local, global);
        }
        return global;
    }

    public static int maxProfitII(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int length= prices.length;
        int min=prices[0];
        int maxprice=0;
        for (int i=1; i<length; i++){
            int price = prices[i]-min;
            if (price >0){
                if (price > maxprice){
                    maxprice=price;
                }
            }else {
                //挑出之前历史中最小的
                min=prices[i];
            }
        }
        return maxprice;
    }

    public static void main(String[] args){
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
