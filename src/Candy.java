/**
 * 第135
 *  There are N children standing in a line. Each child is assigned a rating value.

     You are giving candies to these children subjected to the following requirements:

     Each child must have at least one candy.
     Children with a higher rating get more candies than their neighbors.

     What is the minimum candies you must give?
 * Create by zhaoshiqiang on 10:11 2017/8/19
 */
public class Candy {

    public static int candy(int[] ratings) {
        if (ratings.length == 0){
            return -1;
        }
        if (ratings.length == 1){
            return 1;
        }
        int[] candys = new int[ratings.length];
        candys[0]=1;
        //正向扫描一遍，如果右边的rating比左边高，那么右边的糖果数就比左边多一个，否则只给一个糖果
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]){
                candys[i]=candys[i-1]+1;
            }else {
                candys[i] = 1;
            }
        }
        //反向扫描一遍，如果左边的rating比右边高，并且左边的糖果数比右边少，那么左边的糖果数应比右边多
        for(int i=ratings.length-2; i>=0 ;i--){
            if (ratings[i] > ratings[i+1] && candys[i] <= candys[i+1]){
                candys[i] = candys[i+1]+1;
            }
        }
        int result = 0;
        for (int i = 0; i < candys.length; i++) {
            result += candys[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,2}));
    }
}
