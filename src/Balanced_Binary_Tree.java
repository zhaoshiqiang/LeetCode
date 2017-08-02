/**
 * 第110
 * Given a binary tree, determine if it is height-balanced.

    For this problem, a height-balanced binary tree is defined as
    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


 * Created by zhaoshq on 2017/8/2.
 */
//平衡二叉树的判断 两次递归 一次求深度，一次判断是否平衡
public class Balanced_Binary_Tree {
    public static boolean isBalanced(TreeNode root) {
        //递归结束条件
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }

        //判断当前节点是否是平衡的
        if (Math.abs(depthRecursion(root.left) - depthRecursion(root.right)) > 1){
            return false;
        }
        //判断子节点是否是平衡的
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int depthRecursion(TreeNode node){
        if (node == null){
            return 0;
        }
        return Math.max(depthRecursion(node.left),depthRecursion(node.right))+1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
