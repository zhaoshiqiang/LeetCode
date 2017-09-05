package sort;

/**第75
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
   Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

   Note:
   You are not suppose to use the library's sort function for this problem.
 * Created by zhaoshiqiang on 2017/2/22.
 */
//类快速排序
public class Sort_Colors {
    //扫描两遍的计数排序
    public void sortColors(int[] nums){
        int r,w,b;
        r=w=b=0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==0) r++;
            else if (nums[i]==1) w++;
            else if (nums[i]==2) b++;
        }
        for (int i=0; i<nums.length; i++){
            if (i<r)
                nums[i]=0;
            else if (i<r+w)
                nums[i]=1;
            else
                nums[i]=2;
        }
    }
    //扫描一遍，单向遍历
    public void sortColorsII(int[] nums){
        int r=-1,b=nums.length;
        for (int i=0; i<b; i++){
            if (nums[i]==0){
                swap(nums,++r,i);
            }else if (nums[i]==2){
                swap(nums,--b,i);
                --i;    //交换过来的数也要进行判断
            }
        }
    }

    private void swap(int num[], int x, int y){
        int tmp = num[x];
        num[x] = num[y];
        num[y] = tmp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2};
        new Sort_Colors().sortColorsII(nums);
        for (int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
