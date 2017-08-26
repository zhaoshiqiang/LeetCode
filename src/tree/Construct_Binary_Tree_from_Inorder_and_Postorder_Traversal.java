package tree;

/**第106
 * Given inorder and postorder traversal of a tree, construct the binary tree.
     Note:
     You may assume that duplicates do not exist in the tree.
        1
       / \
      2   3
     / \ / \
    4  5 6  7

 对于上图的树来说，
 index: 0 1 2 3 4 5 6
 中序遍历为: 4 2 5 1 6 3 7
 后序遍历为: 4 5 2 6 7 3 1
 * Created by zhaoshiqiang on 2017/2/11.
 */
//依照中序后序遍历结果生成树
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private static TreeNode buildTree(int[] inorder,int instart,int inend, int[] postorder,int poststart,int postend){
        if (instart>inend || poststart>postend){
            return null;
        }
        int rootvalue = postorder[postend];
        TreeNode root = new TreeNode(rootvalue);
        int i=instart;
        while ( inorder[i]!=rootvalue ){
            i++;
        }
        int length = i-instart;
        root.left=buildTree(inorder,instart,i-1,postorder,poststart,poststart+length-1);
        root.right=buildTree(inorder,i+1,inend,postorder,poststart+length,postend-1);
        return root;
    }

    public static void bst(TreeNode root){
        if (root==null){
            return;
        }
        bst(root.left);
        System.out.print(root.val + "  ");
        bst(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        int[] postorder = new int[]{4,5,2,6,7,3,1};
        int[] inorder = new int[]{4,2,5,1,6,3,7};
        TreeNode root = buildTree(inorder,postorder);
        System.out.println();
        bst(root);
//        System.out.println();
//        int i=0;
//        i=i++;
//        System.out.println(i);
    }
}
