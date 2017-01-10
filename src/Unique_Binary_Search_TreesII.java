import java.util.ArrayList;
import java.util.List;

/**第95题
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.
 * Created by zhaoshiqiang on 2017/1/3.
 */
//递归，由于要把所有的树都记录下来，每次都不是唯一的，所以这里没有重叠子问题，故用递归
public class Unique_Binary_Search_TreesII {
    public static List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new ArrayList<TreeNode>();
        }else {
            return createTrees(1,n);
        }
    }
    public static List<TreeNode> createTrees(int m, int n){
        List<TreeNode>result = new ArrayList<TreeNode>();
        if (m>n){
            //数的左右孩子可能为null，故这里要添加一个null
            result.add(null);
            return result;
        }
        for (int i=m; i<=n; i++){
            //得到(m, i - 1)中所有能构成的子树
            List<TreeNode> ls = createTrees(m, i - 1);
            //得到(i + 1, n)中所有能构成的子树
            List<TreeNode> rs = createTrees(i + 1, n);
            //然后以i为根，ls中各项为左子树，rs中各项为右子树，构建树，并将其填入列表
            for (TreeNode l : ls){
                for (TreeNode r : rs){
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    result.add(curr);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        generateTrees(3);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
