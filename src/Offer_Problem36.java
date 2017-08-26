
/**
 * 《剑指offer》数组中的逆序对
 * Created by zhaoshq on 2017/8/11.
 */
public class Offer_Problem36 {
    static long count = 0;
    public static void mergeSort(int []input,int left,int right){
        if (left < right){
            //分治
            int mid = (left + right)/2;
            //左边
            mergeSort(input,left,mid);
            //右边
            mergeSort(input,mid+1,right);
            //左右归并
            merge(input,left,mid,right);
        }
    }

    /**
     * 二路归并
     * @param input
     * @param left 左数组的第一个元素的索引
     * @param center 左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right 右数组最后一个元素的索引
     */
    public static void merge(int[]input,int left,int center,int right){
        int[] temp = new int[right-left+1];
        int indexTemp = 0;
        int mergeLeft = left;
        int mergeRight = center+1;
        while (mergeLeft<=left && mergeRight<=right){
            if (input[mergeLeft] > input[mergeRight]){
                temp[indexTemp++] = input[mergeRight++];
                /*
                 * 如果input[mergeLeft] > input[mergeRight]，那么表明下标为mergeLeft~center的值都会比input[mergeRight]大;
                 * (5,7,8)(4,9)合并为 3+0+0+0
                 * */
                count += center+1 - mergeLeft;
            }else {
                temp[indexTemp++] = input[mergeLeft++];            }
        }

        //只会执行一个
        while (mergeLeft<=left){
            temp[indexTemp++] = input[mergeLeft++];
        }
        while (mergeRight<=right){
            temp[indexTemp++] = input[mergeRight++];
        }

        indexTemp = 0;
        int indexInput = left;
        while (indexInput<=right){
            input[indexInput++] = temp[indexTemp++];
        }
    }
}
