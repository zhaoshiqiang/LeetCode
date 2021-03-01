package tree;

import java.util.*;

/**第102题
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
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
            //对节点进行处理
            if (result.size()<=layer){
                //是新的一层
                list=new ArrayList<>();
                result.add(list);
                list.add(node.val);
            }else {
                list = result.get(layer);
                list.add(node.val);
            }
            //扩展节点，将其入队
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

    public List<List<Integer>> levelOrderIII(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
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
            //如果节点的左/右子树不为空，也放入队列中
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
            //将临时list加入最终返回结果中
            res.add(tmp);
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
        List<List<Integer>> lists = levelOrderII(t5);
        for (List<Integer> list : lists){
            System.out.println();
            for (Integer val : list){
                System.out.print(val + "   ");
            }
        }
    }
}
