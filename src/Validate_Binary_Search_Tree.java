/**
 * 第98
 * Given a binary tree, determine if it is a valid binary search tree (BST).

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than the node's key.
     Both the left and right subtrees must also be binary search trees.
     Example 1:
        2
       / \
      1   3
     Binary tree [2,1,3], return true.
     Example 2:
       1
      / \
     2   3
     Binary tree [1,2,3], return false.

 * Created by zhaoshq on 2017/8/2.
 */
//二叉树中序遍历
public class Validate_Binary_Search_Tree {

    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }else {
            //以下操作是中序遍历
            if (!isValidBST(root.left)){
                return false;
            }
            if (pre != null && pre.val >= root.val){
                return false;
            }
            pre = root;
            return isValidBST(root.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
