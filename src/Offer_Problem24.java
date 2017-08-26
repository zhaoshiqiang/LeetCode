
/**
 * 《剑指offer》二叉搜索树的后序遍历序列
 * Created by zhaoshq on 2017/8/9.
 */
public class Offer_Problem24 {

    public static boolean verfiySequenceOfBST(int[] sequence,int start,int end){
        if (sequence == null || sequence.length == 0){
            return false;
        }
        int rootVal = sequence[end];
        int index = start;
        for (;index<end; index++){
            if (sequence[index] > rootVal){
                break;
            }
        }
        //左子数要均小于根节点
        for (int i = start; i < index; i++) {
            if (sequence[i] > rootVal){
                return false;
            }
        }
        //右子数要均大于根节点
        for (int i = index+1; i < end; i++) {
            if (sequence[i] < rootVal){
                return false;
            }
        }

        boolean verfiyLeft = true;
        //存在左子树，则判断左子树是否为BST
        if (index > start){
            verfiyLeft = verfiySequenceOfBST(sequence,start,index-1);
        }

        boolean verfiyRight = true;
        //存在右子树，则判断右子树是否为BST
        if (index < end)
        {
            verfiyRight = verfiySequenceOfBST(sequence,index,end-1);
        }
        return verfiyLeft && verfiyRight;
    }

    public static void main(String[] args) {
//        int[] nums = {5,7,6,9,11,10,8};
//        int[] nums = {7,4,6,5};
        int[] nums = {6,7,8,5};
        Offer_Problem24 o = null;
        System.out.println(o.verfiySequenceOfBST(nums,0,nums.length-1));
    }
}
