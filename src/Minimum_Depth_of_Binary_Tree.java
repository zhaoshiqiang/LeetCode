/**
 * 第111
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Created by zhaoshq on 2017/8/2.
 */
//二叉树 递归 || 用图的BFS也可求解
public class Minimum_Depth_of_Binary_Tree {
    public static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return minDepthrecursion(root,1);
    }

    public static int minDepthrecursion(TreeNode node, int depth){

        if (node.left == null && node.right == null){
            return depth;
        }
        if (node.right != null && node.left != null){
            return Math.min(minDepthrecursion(node.left,depth+1),minDepthrecursion(node.right,depth+1));
        }else if (node.left != null){
            return minDepthrecursion(node.left,depth+1);
        }else {
            return minDepthrecursion(node.right,depth+1);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
