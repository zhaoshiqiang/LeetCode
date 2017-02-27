/**第116
 * Given a binary tree

 struct TreeLinkNode {
     TreeLinkNode *left;
     TreeLinkNode *right;
     TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

     Initially, all next pointers are set to NULL.

     Note:

     You may only use constant extra space.
     You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
     For example,
     Given the following perfect binary tree,
            1
          /  \
         2    3
        / \  / \
       4  5  6  7
     After calling your function, the tree should look like:
            1 -> NULL
          /  \
         2 -> 3 -> NULL
        / \  / \
       4->5->6->7 -> NULL
 * Created by zhaoshiqiang on 2017/2/25.
 */
//用固定的空间搜索变形二叉树
public class Populating_Next_Right_Pointers_in_Each_Node {
    /*
    * 这道题之所以放上来是因为题目中的那句话：You may only use constant extra space
        这就意味着，深搜是不能用的，因为递归是需要栈的，因此空间复杂度将是 O(logn)。
        毫无疑问广搜也不能用，因为队列也是占用空间的，空间占用还高于 O(logn)
        难就难在这里，深搜和广搜都不能用，怎么完成树的遍历？
        我拿到题目的第一反应便是：用广搜，接着发现广搜不能用，便犯了难。
        看了一些提示，有招了：核心仍然是广搜，但是我们可以借用 next 指针，做到不需要队列就能完成广度搜索。
        如果当前层所有结点的next 指针已经设置好了，那么据此，下一层所有结点的next指针 也可以依次被设置。
    * */
    public void connect(TreeLinkNode root) {
        if (root == null || root.left==null){
            return;
        }
        TreeLinkNode curLev;
        //因为是满树，所以有左孩子，就肯定有右孩子
        while (root.left != null){
            curLev=root;
            //处理root的下一层所有节点的next
            while (curLev!=null){
                curLev.left.next=curLev.right;
                if (curLev.next != null){
                    curLev.right.next=curLev.next.left;
                }
                curLev=curLev.next;
            }
            root=root.left;
        }
    }
    //递归版,已知某一层级已经建立的右兄弟的关系后，建立下一层级会非常方便。利用递归便能全部完成。
    public void connectII(TreeLinkNode root) {
        TreeLinkNode p=root;
        while (p != null){
            build(p);
            p=p.left;
        }
    }
    private void build(TreeLinkNode root){
        if (root != null){
            if (root.left != null){
                root.left.next=root.right;
            }
            if (root.next != null){
                if (root.right != null){
                    root.right.next=root.next.left;
                }
            }
            build(root.next);
        }
    }
    public static class TreeLinkNode {
             int val;
             TreeLinkNode left, right, next;
             TreeLinkNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeLinkNode p1=new TreeLinkNode(1);
        TreeLinkNode p2=new TreeLinkNode(2);
        TreeLinkNode p3=new TreeLinkNode(3);
        TreeLinkNode p4=new TreeLinkNode(4);
        TreeLinkNode p5=new TreeLinkNode(5);
        TreeLinkNode p6=new TreeLinkNode(6);
        TreeLinkNode p7=new TreeLinkNode(7);
        p1.left=p2;
        p1.right=p3;
        p2.left=p4;
        p2.right=p5;
        p3.left=p6;
        p3.right=p7;
        new Populating_Next_Right_Pointers_in_Each_Node().connectII(p1);
    }
}
