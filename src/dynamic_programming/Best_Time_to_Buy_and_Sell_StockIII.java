package dynamic_programming;

/**第123
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Created by zhaoshiqiang on 2017/1/27.
 */
public class Best_Time_to_Buy_and_Sell_StockIII {
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int[] local = new int[3];
        int[] global = new int[3];
        for(int i=0;i<prices.length-1;i++)
        {
            int diff = prices[i+1]-prices[i];
            for(int j=2;j>=1;j--)
            {
                local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[2];
    }

    public static void main(String[] args){
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
