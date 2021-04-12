package tree;

import java.util.Stack;

/**
 * 第230
 * 二叉搜索树中第K小的元素
 *
 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int num=0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            num++;
            if (num == k){
                return cur.val;
            }
            cur = cur.right;
        }
        return 0;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
