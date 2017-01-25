import java.util.*;

/**第103题
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

     For example:
     Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
     return its zigzag level order traversal as:
     [
        [3],
        [20,9],
        [15,7]
     ]
 * Created by zhaoshiqiang on 2017/1/19.
 */
//BFS 树的层次遍历 两个栈交替遍历
public class Binary_Tree_Zigzag_Level_Order_Traversal {

    //这个思路是先正常顺序层次遍历完，之后在将需要反转的层拿出来反转之后再添加到对应位置
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
                queue.offer(new queueitem(node.left, layer + 1));
            }
            if (node.right != null){
                queue.offer(new queueitem(node.right,layer+1));
            }
        }
        for (int i=0; i<result.size(); i++){
            if (i%2 == 1){
                List<Integer> list = result.get(i);
                Collections.reverse(list);
                result.remove(i);
                result.add(i,list);
            }
        }
        return result;
    }
    static class queueitem{
        TreeNode node;
        int layer;

        public queueitem(TreeNode node, int layer) {
            this.node = node;
            this.layer = layer;
        }
    }

    //这个思路是用两个栈，遍历时交替进行。注意这里是栈，队列是不符合要求的
    public static List<List<Integer>> zigzagLevelOrderII(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        boolean flag = false;   //标识本层是否需要反转
        List<Integer> layer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> nextstack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            layer.add(node.val);
            if (!flag){
                //如果不需要反转，则由左到右添加
                if (node.left != null)
                    nextstack.push(node.left);
                if (node.right != null)
                    nextstack.push(node.right);
            }else {
                //如果需要，这由右向左添加
                if (node.right != null)
                    nextstack.push(node.right);
                if (node.left != null)
                    nextstack.push(node.left);
            }
            //当前层已经处理完
            if (stack.isEmpty()){
                //交换两个队列
                Stack<TreeNode> temp = stack;
                stack=nextstack;
                nextstack=temp;
                //记录下一层处理的方向
                flag = !flag;
                //保存本层结果
                result.add(layer);
                // 创建新的链表处理下一层的结果
                layer=new ArrayList<>();
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

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left= t2;
        t1.right=t3;
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t2.left=t4;
        t3.right=t5;
        List<List<Integer>> lists = zigzagLevelOrderII(t1);
        for (List<Integer> list : lists){
            System.out.println();
            for (Integer val : list){
                System.out.print(val + "   ");
            }
        }
    }
}
