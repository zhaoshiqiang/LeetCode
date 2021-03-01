package tree;

import java.util.*;

/**第107题
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 For example:
 Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
 return its bottom-up level order traversal as:
 [
     [15,7],
     [9,20],
     [3]
 ]
 只是把{@link Binary_Tree_Level_Order_Traversal}的结果倒过来
 * Created by zhaoshiqiang on 2017/1/11.
 */
//BFS 树的层次遍历
public class Binary_Tree_Level_Order_TraversalII {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(result);
        return result;
    }


    public List<List<Integer>> levelOrderBottomII(TreeNode root) {
        // 注意，这里是LinkedList
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root==null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while(queue.size()>0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            // 每次都往队头塞
            res.addFirst(tmp);
        }
        return res;
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
        List<List<Integer>> lists = levelOrderBottom(t5);
        for (List<Integer> list : lists){
            System.out.println();
            for (Integer val : list){
                System.out.print(val + "   ");
            }
        }
    }
}
