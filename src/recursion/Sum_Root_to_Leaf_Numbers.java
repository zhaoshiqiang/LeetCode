package recursion;

/**
 * 第129
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

     An example is the root-to-leaf path 1->2->3 which represents the number 123.

     Find the total sum of all root-to-leaf numbers.

     For example,

        1
      / \
     2   3

     The root-to-leaf path 1->2 represents the number 12.
     The root-to-leaf path 1->3 represents the number 13.

     Return the sum = 12 + 13 = 25.
 * Created by zhaoshiqiang on 2017/8/1.
 */
public class Sum_Root_to_Leaf_Numbers {

    public static int sumNumbers(TreeNode root) {
        return sumhelper(root,0);
    }
    static int sumhelper(TreeNode root, int levelBase){
        //结束条件
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return levelBase + root.val;
        }
        //当遍历的节点往叶节点方向走一层的时候，该节点的值应为父节点的值*10+当前节点的值。
        int nextLevelBase = (levelBase + root.val) * 10;
        //向下一层递归
        int leftSubTreeSum = sumhelper(root.left,nextLevelBase);
        int rightSubTreeSum = sumhelper(root.right,nextLevelBase);

        return leftSubTreeSum + rightSubTreeSum;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        root.left = t1;
        System.out.println(sumNumbers(root));
    }
}
