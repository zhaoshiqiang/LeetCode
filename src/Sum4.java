import java.util.*;

/**第18
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
     Note: The solution set must not contain duplicate quadruplets.

     For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

     A solution set is:
     [
         [-1,  0, 0, 1],
         [-2, -1, 1, 2],
         [-2,  0, 0, 2]
     ]
 * Created by zhaoshiqiang on 2017/2/7.
 */
public class Sum4 {
    //先求出每两个数的和，放到 HashSet 里，再利用之前的 2Sum 去求。
    // 这种算法比较快，复杂度 O(nnlog(n))，不过细节要处理的不少。
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer,List<Integer[]>> map = new HashMap<>();
        int length = nums.length;
        Arrays.sort(nums);

        for (int i=0; i<length-1; i++){
            for (int j=i+1; j<length; j++){
                int sum = nums[i]+nums[j];
                Integer[] value = {i,nums[i],j,nums[j]};
                if (!map.containsKey(sum)){
                    map.put(sum,new ArrayList<Integer[]>());
                }
                map.get(sum).add(value);
            }
        }
        //这里要把key单拉出来遍历，因为在接下来的操作中会设计到删除map中key的操作，如果直接遍历map，会出错
        Integer[] keys = map.keySet().toArray(new Integer[map.size()]);
        for (int i=0; i<keys.length;i++){
            if (map.containsKey(target-keys[i])){
                List<Integer[]> value1list = map.get(keys[i]);
                List<Integer[]> value2list = map.get(target - keys[i]);
                for (Integer[] value1s : value1list){
                    for (Integer[] value2s : value2list){
                        List<Integer> list = new ArrayList<>();
                        //这个四个元素在数组中是不同的
                        if (value1s[0]!=value2s[0] && value1s[0]!= value2s[2]
                                && value1s[2]!=value2s[0] && value1s[2]!=value2s[2]){
                            list.add(value1s[1]);
                            list.add(value1s[3]);
                            list.add(value2s[1]);
                            list.add(value2s[3]);
                            //这里排序是为了方便接下来是否重复
                            Collections.sort(list);
                            if (!ret.contains(list)){
                                ret.add(list);
                            }
                        }
                    }
                }
                map.remove(keys[i]);
                map.remove(target-keys[i]);
            }
        }
        return ret;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,0,0,0};
//        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        for (List<Integer> list : lists){
            System.out.println();
            for (Integer val : list){
                System.out.print(val + "   ");
            }
        }
    }
}
