import java.util.Stack;

/**
 * 《剑指offer》二叉搜索树与双向链表
 * Created by zhaoshq on 2017/8/10.
 */
public class Offer_Problem27 {

    public static TreeNode convert(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode preNode = convertNode(root);
        while (preNode != null && preNode.left != null){
            preNode = preNode.left;
        }
        return preNode;
    }

    private static TreeNode convertNode(TreeNode root) {
        if (root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        //记录前一个结点
        TreeNode pre = null;
        //以下是二叉搜索树中序遍历
        while ( p != null || !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()){
                p = stack.pop();
                //将该节点与前一个节点关联起来
                p.left = pre;
                if (pre != null){
                    pre.right = p;
                }
                pre = p;
                p = p.right;
            }
        }
        return pre;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

// TODO Auto-generated method stub

        TreeNode root = new TreeNode(10);

        TreeNode six=new TreeNode(6);

        TreeNode four=new TreeNode(4);

        TreeNode eight=new TreeNode(8);

        TreeNode fourteen=new TreeNode(14);

        TreeNode twelve=new TreeNode(12);

        TreeNode sixteen=new TreeNode(16);

        root.left=six;

        root.right=fourteen;

        six.left=four;

        six.right=eight;

        four.left=null;

        four.right=null;

        eight.left=null;

        eight.right=null;

        fourteen.left=twelve;

        fourteen.right=sixteen;

        twelve.left=null;

        twelve.right=null;

        sixteen.right=null;

        sixteen.left=null;

        TreeNode result=convert(root);

//                TreeNode result=baseconvert(root, null);

        while (result!=null) {

            System.out.print(result.val +" ");

            result=result.right;

        }
    }
}
