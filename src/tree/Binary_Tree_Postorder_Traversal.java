package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**第145
 * Given a binary tree, return the postorder traversal of its nodes' values.
     For example:
     Given binary tree {1,#,2,3},
     1
      \
       2
      /
     3
     return [3,2,1].
 Note: Recursive Main_zhongxing is trivial, could you do it iteratively?
 * Created by zhaoshiqiang on 2017/2/11.
 */
//非递归后序遍历
public class Binary_Tree_Postorder_Traversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        //一直遍历左子树最下边，边遍历边保存节点到栈中
        while (p!=null){
            stack.push(p);
            p=p.left;
        }
        while ( !stack.isEmpty() ){
            //当p为空时，说明已经达到左子树最下边
            p=stack.pop();
            //访问根节点的条件是没有右子树或者右子树已经访问过了
            if ( p.right==null || p.right==pre){
                pre=p;
                ret.add(p.val);
//                System.out.print(p.val+"  ");
            }else {
                //将根节点再次压栈，开始访问右子树
                stack.push(p);
                p=p.right;
                //一直遍历左子树最下边，边遍历边保存节点到栈中
                while (p!=null){
                    stack.push(p);
                    p=p.left;
                }
            }
        }
        return ret;
    }

    /**
     * 取巧的方法。该写法的访问顺序并不是后序遍历，而是利用先序遍历“根左右”的遍历顺序，
     * 将先序遍历顺序更改为“根右左”，反转结果List，得到结果顺序为“左右根”。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalII(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            if(node.right != null) stack.push(node.right);//后将右结点入栈
            res.add(0,node.val);                        //逆序添加结点值
        }
        return res;
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
        bst(root.right);
        System.out.print(root.val + "  ");
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
        t4.right=t5;
        postorderTraversal(t1);
        System.out.println();
        bst(t1);
    }
}
