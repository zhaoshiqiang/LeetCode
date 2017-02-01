/**第122
 * Say you have an array for which the ith element is the price of a given stock on day i.
     Design an algorithm to find the maximum profit. You may complete as many transactions as you like
     (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
     transactions at the same time (ie, you must sell the stock before you buy again).

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
