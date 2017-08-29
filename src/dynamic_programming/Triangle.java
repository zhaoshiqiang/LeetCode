package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/** 120题
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    For example, given the following triangle
     [
        [2],
        [3,4],
        [6,5,7],
        [4,1,8,3]
     ]
     The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     Note:
     Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * Created by zhaoshiqiang on 2017/3/26.
 */
//区间动态规划
public class Triangle {
    //简单的动态规划，唯一的问题是题目里给的空间复杂度的要求。
    public static int minimumTotal(List<List<Integer>> triangle) {
        /*
        * 先来说动态规划，当选择下面一层中的数字时，我们只能选择相邻的数字。什么是相邻的数字呢？
        * 拿上面的例子来说，对于2，下一行里3和4是相邻的；对于3来说，6和5>是相邻的；
        * 对于4来说，5和7是相邻的；对于6来说，4和1是相邻的；对于5来说，1和8是相邻的；
        * 对于7来说，8和3是相邻的；对于4/1/8/3来说，没有下一行所以没有相邻数字了。
        * 如果我们把数字都对应到数据在每一行中的下标上，可以很容易发现，
        * 对于一个data[i][j]，和它相邻的数字就是data[i+1][j]和data[i+1][j+1]。
        * 这样一来问题就简单了。假如我们用minimus[i][j]来表示从第i行第j列处的数字开始往下到最后一层的最小路径和，那么有
        *   minimus[i][j]=data[i][j]+min(minimums[i+1][j]+minimums[i+1][j+1])
        * 然而上述描述中需要一个O（n^2）的额外空间，接下来我们来解决这个问题。
        * */

        /*
        * 由于我们在公式里需要递归求解子问题，那么我们不妨反过来想一下，先求解子问题，然后再解决父问题。
        * 即，从下往上求解最小路径和。我们可以发现如下规律，当我们求解minimum[i][j]时，我们会用到minimum[i+1][j]和minimum[i+1][j+1]，
        * 但是当求解完所有minimum[i]之后minimum[i+1]就没有用处了。
        * 既然如此，我们是否可以复用同一个空间来存储minimum的值呢？
        * 答案是可以的。进一步观察发现，存储最后一行的每个数字的最小路径和需要n个空间>，因此至少我们需要n个空间，
        * 这也是题目里给出O（n）的空间复杂度的原因；之后存储倒数第二行时，我们只需要前面的n-1个空间……以此类推，
        * 第一行只需要一个空间来存储最小路径和，这也正是我们要求解的结果。
        * */
        int length = triangle.size();
        int[] tmp = new int[triangle.get(length-1).size()];
        for (int i=0; i<tmp.length; i++){
            tmp[i]=Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (List<Integer> nums : triangle){
            for (int i=nums.size()-1; i>=0; i--){
                int num = nums.get(i);
                if (i==0){
                    if (tmp[i]!=Integer.MAX_VALUE){
                        tmp[i] = tmp[i]+num;
                    } else{
                        tmp[i] = num;
                    }
                }else {
                    if (tmp[i] != Integer.MAX_VALUE){
                        if (tmp[i-1]+num < tmp[i]+num){
                            tmp[i]=tmp[i-1]+num;
                        }else {
                            tmp[i] = tmp[i]+num;
                        }
                    }else {
                        tmp[i]=tmp[i-1]+num;
                    }
                }
            }
        }
        for (int i=0; i<tmp.length; i++){
            if (min > tmp[i]){
                min=tmp[i];
            }
        }
        return min;
    }

    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(minimumTotal(triangle));
    }
}
