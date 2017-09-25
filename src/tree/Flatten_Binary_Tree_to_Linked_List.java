package tree;

import java.util.Stack;

/**第114
 * Given a binary tree, flatten it to a linked list in-place.
     For example,
     Given

         1
        / \
       2   5
      / \   \
     3   4   6
 The flattened tree should look like:
     1
      \
       2
        \
         3
          \
           4
            \
             5
              \
               6
 与{@link Binary_Tree_Preorder_Traversal}是一个题
 * Created by zhaoshiqiang on 2017/2/9.
 */
//本质上是先序遍历
public class Flatten_Binary_Tree_to_Linked_List {
    public static void flatten(TreeNode root) {
        if (root == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            //先入栈
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            //将节点左节点赋值为null，右子树设为栈顶节点
            node.left=null;
            if (!stack.isEmpty())
                node.right=stack.peek();
            else
                node.right=null;
        }
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
        TreeNode t6 = new TreeNode(6);
        t1.left=t2;
        t1.right=t5;
        t2.left=t3;
        t2.right=t4;
        t5.right=t6;
        flatten(t1);
        TreeNode t = t1;
        while (t!=null){
            System.out.print(t.val + "  ");
            t=t.right;
        }
    }
}
