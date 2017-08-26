
/**
 * 《剑指offer》面试题18 树的子结构
 * Created by zhaoshiqiang on 2017/8/8.
 */
public class Offer_Problem18 {

    public static boolean HasSubtree(TreeNode root1,TreeNode root2){
        boolean ret = false;
        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                ret = isSubTree(root1,root2);
            }
            if ( !ret){
                ret = HasSubtree(root1.left,root2);
            }
            if ( !ret){
                ret = HasSubtree(root1.right,root2);
            }
        }
        return ret;
    }

    private static boolean isSubTree(TreeNode root1,TreeNode root2){

        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val == root2.val){
            return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
        }else {
            return false;
        }

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
}
