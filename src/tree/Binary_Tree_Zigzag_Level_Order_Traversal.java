package tree;

import java.util.*;

/**第103题
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).

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
            //访问节点
            layer.add(node.val);
            //扩展节点
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

    public List<List<Integer>> zigzagLevelOrderIII(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //栈1来存储右节点到左节点的顺序
        Stack<TreeNode> stack1 = new Stack<>();
        //栈2来存储左节点到右节点的顺序
        Stack<TreeNode> stack2 = new Stack<>();

        //根节点入栈
        stack1.push(root);

        //每次循环中，都是一个栈为空，一个栈不为空，结束的条件两个都为空
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> subList = new ArrayList<>(); // 存储这一个层的数据
            TreeNode cur = null;

            if (!stack1.isEmpty()) { //栈1不为空，则栈2此时为空，需要用栈2来存储从下一层从左到右的顺序
                while (!stack1.isEmpty()) {	//遍历栈1中所有元素，即当前层的所有元素
                    cur = stack1.pop();
                    subList.add(cur.val);	//存储当前层所有元素

                    if (cur.left != null) {	//左节点不为空加入下一层
                        stack2.push(cur.left);
                    }
                    if (cur.right != null) {	//右节点不为空加入下一层
                        stack2.push(cur.right);
                    }
                }
                list.add(subList);
            }else {//栈2不为空，则栈1此时为空，需要用栈1来存储从下一层从右到左的顺序
                while (!stack2.isEmpty()) {
                    cur = stack2.pop();
                    subList.add(cur.val);

                    if (cur.right != null) {//右节点不为空加入下一层
                        stack1.push(cur.right);
                    }
                    if (cur.left != null) { //左节点不为空加入下一层
                        stack1.push(cur.left);
                    }
                }
                list.add(subList);
            }
        }
        return list;
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
