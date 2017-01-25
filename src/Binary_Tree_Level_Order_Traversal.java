import java.util.*;

/**第102题
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 For example:
 Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
 return its level order traversal as:
 [
     [3],
     [9,20],
     [15,7]
 ]
 * Created by zhaoshiqiang on 2017/1/11.
 */
//BFS 树的层次遍历
public class Binary_Tree_Level_Order_Traversal {
    private static Map<TreeNode,Integer> layertree = new HashMap<>();
    //利用hash表存放每个节点对应层数
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        layertree.put(root, 0);
        while (!queue.isEmpty()){
            List<Integer> list ;
            TreeNode node = queue.poll();
            int layer = layertree.get(node);
            if (result.size()<=layer){
                list=new ArrayList<>();
                result.add(list);
                list.add(node.val);
            }else {
                list = result.get(layer);
                list.add(node.val);
            }
            if (node.left != null){
                queue.offer(node.left);
                layertree.put(node.left,layer+1);
            }
            if (node.right != null){
                queue.offer(node.right);
                layertree.put(node.right,layer+1);
            }
        }
        return result;
    }
    //这个方法只不过是把层数集成到队列元素中，思想是一样的
    public static List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<queueitem> queue = new LinkedList();
        queue.offer(new queueitem(root,0));
        while (!queue.isEmpty()){
            List<Integer> list ;
            queueitem item = queue.poll();
            TreeNode node = item.node;
            int layer = item.layer;
            if (result.size()<=layer){
                list=new ArrayList<>();
                result.add(list);
                list.add(node.val);
            }else {
                list = result.get(layer);
                list.add(node.val);
            }
            if (node.left != null){
                queue.offer(new queueitem(node.left, layer+1));
            }
            if (node.right != null){
                queue.offer(new queueitem(node.right,layer+1));
            }
        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class queueitem{
        TreeNode node;
        int layer;

        public queueitem(TreeNode node, int layer) {
            this.node = node;
            this.layer = layer;
        }
    }
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(15);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(20);
        t3.left= t1;
        t3.right=t2;
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(3);
        t5.left=t4;
        t5.right=t3;
        List<List<Integer>> lists = levelOrderII(t5);
        for (List<Integer> list : lists){
            System.out.println();
            for (Integer val : list){
                System.out.print(val + "   ");
            }
        }
    }
}
