package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 第94
 * Given a binary tree, return the inorder traversal of its nodes' values.

     For example:
     Given binary tree [1,null,2,3],
      1
       \
        2
       /
      3
     return [1,3,2].

     Note: Recursive solution is trivial, could you do it iteratively?
 * Created by zhaoshq on 2017/8/2.
 */
//二叉树 中序遍历
public class Binary_Tree_Inorder_Traversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while ( p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()){
                p = stack.pop();
                ret.add(p.val);
                p = p.right;
            }
        }
        return ret;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
