/**第108
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Created by zhaoshiqiang on 2017/2/25.
 */
//递归 反中序遍历构建二叉树
public class Convert_Sorted_Array_to_Binary_Search_Tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return bulidTree(nums,0,nums.length-1);
    }

    private TreeNode bulidTree(int[] nums,int start, int end){
        if (start > end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode left = bulidTree(nums,start,mid-1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left=left;
        root.right=bulidTree(nums,mid+1,end);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
