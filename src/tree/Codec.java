package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /*
        用BFS遍历树，与一般遍历的不同点是不管node的左右子节点是否存在，统统加到队列中
        在节点出队时，如果节点不存在，在返回值res中加入一个”null“；如果节点存在，则加入节点值的字符串形式
         */
        if (root == null){
            return "[]";
        }
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (node == null){
                sb.append("null,");
            }else {
                sb.append(node.val + ",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return "[" + sb.toString() + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        /*
        同样使用BFS方法，利用队列新建二叉树
        首先要将data转换成列表，然后遍历，只要不为null将节点按顺序加入二叉树中；同时还要将节点入队
        队列为空时遍历完毕，返回根节点
         */
        if (data == "[]"){
            return null;
        }
        String[] datas = data.substring(1,data.length()-1).split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(datas[0]));
        q.offer(root);
        int i=1;
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (!datas[i].equals("null")){
                cur.left = new TreeNode(Integer.valueOf(datas[i]));
                q.offer(cur.left);
            }
            i++;
            if (!datas[i].equals("null")){
                cur.right = new TreeNode(Integer.valueOf(datas[i]));
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
