/**
 * 第104
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Created by zhaoshiqiang on 2017/8/1.
 */
//二叉树 递归
public class Maximum_Depth_of_Binary_Tree {
    static int maxdepth = 0;
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
//        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        dfs(root,1);
        return maxdepth;
    }

    private static void dfs(TreeNode root, int curdepth) {
        if (root == null){
            return;
        }
        if (root.right == null && root.left == null){
            if (curdepth > maxdepth){
                maxdepth = curdepth;
            }
        }
        dfs(root.left,curdepth+1);
        dfs(root.right,curdepth+1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(0);
        TreeNode r2 = new TreeNode(0);
        TreeNode r3 = new TreeNode(0);
        TreeNode r4 = new TreeNode(0);
        TreeNode r5 = new TreeNode(0);
        TreeNode r6 = new TreeNode(0);
        r1.left = r2;
        r2.left = r3;
        r1.right = r4;
        r4.right = r5;
        r5.right = r6;
        System.out.println(maxDepth(r1));
    }
}
