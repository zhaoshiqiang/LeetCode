import java.util.Stack;

/**第11题
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 *
 * Created by zhaoshiqiang on 2017/1/26.
 */
public class Container_With_Most_Water {

    //用两个指针从两端开始向中间靠拢，如果左端线段短于右端，那么左端右移，反之右端左移，
    // 知道左右两端移到中间重合，记录这个过程中每一次组成木桶的容积，返回其中最大的。
    //当左端线段L小于右端线段R时，我们把L右移，这时舍弃的是L与右端其他线段（R-1, R-2, ...）组成的木桶，
    // 这些木桶是没必要判断的，因为这些木桶的容积肯定都没有L和R组成的木桶容积大。
    public static int maxArea(int[] height) {
        int length = height.length;
        int max=0;
        int area=0;
        int left=0;
        int right=length-1;
        while (left!=right){
            area = (right-left)*(height[left]>height[right]? height[right] : height[left]);
            if (max < area){
                max=area;
            }
            if (height[left]>height[right]){
                right--;
            }else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] a =new int[]{3,2,1,3};
        System.out.println(maxArea(a));

    }
}
