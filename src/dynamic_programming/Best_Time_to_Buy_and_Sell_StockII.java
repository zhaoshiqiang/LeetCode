package dynamic_programming;

/**第122
 * Say you have an array for which the ith element is the price of a given stock on day i.
     Design an algorithm to find the maximum profit. You may complete as many transactions as you like
     (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
     transactions at the same time (ie, you must sell the stock before you buy again).

     你有一个数组,第i个元素是某个股票在i天的价格。
     设计一个算法找到最大的利润。你可以完成多次交易（即买卖股票多次）。
     然而，你不可以从事多个事务在同一时间（即，你必须卖出股票，在你再次购买之前）
 * Created by zhaoshiqiang on 2017/1/26.
 */
public class Best_Time_to_Buy_and_Sell_StockII {
    public static int maxProfit(int[] prices) {
        if (prices.length==0 || prices==null){
            return 0;
        }
        int local=0;
        int global=0;
        int length=prices.length;
        //只要后一天比前一天的价值高即可进行交易，累加这些值即可。
        for (int i=0; i<length-1 ; i++){

            local=prices[i+1]-prices[i];
            if (local>0){
                global+=local;
            }
        }
        return global;
    }
    public static void main(String[] args){
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
