package tree;

/**第99
 * Two elements of a binary search tree (BST) are swapped by mistake.
     Recover the tree without changing its structure.

     Note:
     A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * Created by zhaoshiqiang on 2017/2/2.
 */
//二叉树中序遍历
public class Recover_Binary_Search_Tree {
    private static TreeNode pre=null;
    private static TreeNode n1=null;
    private static TreeNode n2=null;
    /*
    * 这题的要点就是想到使用树的递归中序遍历，因为二叉查找树合法的情况，中序遍历的值是从小到大排列的。
    * */
    public static void recoverTree(TreeNode root) {
        findTwoNode(root);
        if (n1!=null && n2!=null){
            int value = n1.val;
            n1.val=n2.val;
            n2.val=value;
        }
    }

    private static void findTwoNode(TreeNode root){
        if (root==null){
            return;
        }
        findTwoNode(root.left);
        //当出现当前值比前一个值小的时候，就是存在不合法的节点
        if (pre!=null && pre.val>root.val){
            //用s1，s2记录这两个不合法序列的位置，s1存较大的值，s2存较小的值
            if (n1==null)
                n1=pre;
            n2=root;
        }
        //用pre存中序遍历时当前节点的前一个节点，方便值的大小对比
        pre=root;
        findTwoNode(root.right);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void bst(TreeNode root){
        if (root==null){
            return;
        }
        bst(root.left);
        System.out.print(root.val + "  ");
        bst(root.right);
    }
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t2.left= t3;
        t2.right=t1;
//        t3.left=t4;
//        t4.right=t5;
        bst(t2);
        recoverTree(t2);
        System.out.println();
        bst(t2);
    }
}
