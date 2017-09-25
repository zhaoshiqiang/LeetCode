package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**第144
 * Given a binary tree, return the preorder traversal of its nodes' values.
     For example:
     Given binary tree {1,#,2,3},
     1
     \
      2
     /
     3
     return [1,2,3].

 Note: Recursive Main_zhongxing is trivial, could you do it iteratively?
 * Created by zhaoshiqiang on 2017/2/9.
 */
//二叉树前序和中序非递归遍历
public class Binary_Tree_Preorder_Traversal {

    //二叉树的非递归前序遍历，前序遍历思想：先让根进栈，只要栈不为空，就可以做弹出操作，
    // 每次弹出一个结点，记得把它的左右结点都进栈，记得右子树先进栈，
    // 这样可以保证右子树在栈中总处于左子树的下面。
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //和递归的流程类似
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node!=null){
                ret.add(node.val);
                System.out.print(node.val + "  ");
                //让右子树先进栈，这样可以保证右子树在栈中总是在左子树下面
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return ret;
    }

    /*
    * System.out.print(p.val+"  ");语句的位置不一样，决定是前序遍历还是后序遍历
    * */
    //前序遍历非递归版
    public static List<Integer> preorderTraversalII(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while ( p!=null || !stack.isEmpty() ){
            //一直遍历左子树最下边，边遍历边保存节点到栈中
            while (p!=null){
                System.out.print(p.val+"  ");
                stack.push(p);
                p=p.left;
            }
            //当p为空时，说明已经达到左子树最下边
            if (!stack.isEmpty()){
                p=stack.pop();
                p=p.right;
            }
        }
        return ret;
    }
    //中序遍历非递归版
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while ( p!=null || !stack.isEmpty() ){
            //一直遍历左子树最下边，边遍历边保存节点到栈中
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            //当p为空时，说明已经达到左子树最下边
            if (!stack.isEmpty()){
                p=stack.pop();
                //注意与前序遍历的对比
                System.out.print(p.val+"  ");
                p=p.right;
            }
        }
        return ret;
    }

    public static void bst(TreeNode root){
        if (root==null){
            return;
        }
        System.out.print(root.val + "  ");
        bst(root.left);
        bst(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.right=t3;
        t1.left=t4;
        t3.left=t2;
        preorderTraversal(t1);
        System.out.println();
        preorderTraversalII(t1);
        System.out.println();
        inorderTraversal(t1);
        System.out.println();
        bst(t1);
    }
}
