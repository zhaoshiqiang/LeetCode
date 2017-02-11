/**第105
 * Given preorder and inorder traversal of a tree, construct the binary tree.
    Note:
    You may assume that duplicates do not exist in the tree.

 * Created by zhaoshiqiang on 2017/2/7.
 */
//依照中序前序遍历结果生成树
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //这里是preorder.length-1，否则会溢出
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }

    private static TreeNode buildTree(int[] preorder,int prestart, int preend, int[] inorder,int instart,int inend){
        //递归的终止条件
        if (prestart>preend || instart>inend){
            return null;
        }

        int rootvalue = preorder[prestart];
        int i=instart;
        for (;i<inorder.length; i++){
            if (inorder[i] == rootvalue){
                break;
            }
        }
        //求得左树节点的个数
        int len = i-instart;
        TreeNode root = new TreeNode(rootvalue);
        root.left=buildTree(preorder,prestart+1,prestart+len,inorder,instart,i-1);
        root.right=buildTree(preorder,prestart+len+1,preend,inorder,i+1,inend);
        return root;
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
        int[] preorder = new int[]{1,2,4,5,3,6,7};
        int[] inorder = new int[]{4,2,5,1,6,3,7};
        TreeNode root = buildTree(preorder,inorder);
        System.out.println();
        bst(root);
    }
}
