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
//树形动态规划
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
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
