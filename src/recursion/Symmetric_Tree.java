package recursion;

/**第101
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

     For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

         1
        / \
       2   2
      / \ / \
     3  4 4  3
     But the following [1,2,2,null,3,null,3] is not:
       1
      / \
     2   2
     \   \
     3    3
     Note:
     Bonus points if you could solve it both recursively and iteratively.
 * Created by zhaoshq on 2017/8/2.
 */
//二叉树 递归
public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }else {
            return isSame(root.left,root.right);
        }
    }

    private boolean isSame(TreeNode left, TreeNode right){
        //是叶子节点
        if (left == null && right == null){
            return true;
        }
        //只有左孩子或者只有右孩子
        if (left != null && right == null || left == null && right != null){
            return false;
        }
        //左右孩子数值不相等
        if (left.val != right.val){
            return false;
        }
        return isSame(left.left,right.right) && isSame(right.left,left.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
