/**
 * 第100
 * Given two binary trees, write a function to check if they are equal or not.

    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * Created by zhaoshq on 2017/8/2.
 */
//二叉树 递归
public class Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //是叶子节点
        if (p == null && q == null){
            return true;
        }
        //只有左孩子或者只有右孩子
        if (p != null && q == null || p == null && q != null){
            return false;
        }
        //左右孩子数值不相等
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
