package sort;

/**第86题
 * Given a linked list and a value x, partition it such that
 * all nodes less than x come before nodes greater than or equal to x.

     You should preserve the original relative order of the nodes in each of the two partitions.
     For example,
     Given 1->4->3->2->5->2 and x = 3,
     return 1->2->2->4->3->5.
 * Created by zhaoshiqiang on 2017/2/1.
 */
//链表——快排思想应用
public class Partition_List {
    public static ListNode partition(ListNode head, int x) {
        if (head==null || head.next == null){
            return head;
        }
        ListNode lessnode=new ListNode(-1);
        ListNode greaternode=new ListNode(-1);
        ListNode p = head;
        ListNode pless = lessnode;
        ListNode pgreater = greaternode;
        //将链表以x为界限分开
        while (p!=null){
            if (p.val < x){
                pless.next=p;
                p=p.next;
                pless=pless.next;
            }else {
                pgreater.next=p;
                p=p.next;
                pgreater=pgreater.next;
            }
        }
        //处理每段链表的尾节点
        if (pless!=null){
            pless.next=null;
        }
        if (pgreater!=null){
            pgreater.next=null;
        }
        //如果有段链表为空，则直接返回另一段
        if (lessnode.next == null){
            return greaternode.next;
        }
        if (greaternode.next == null){
            return lessnode.next;
        }
        //将两段链表连接起来
        p=lessnode.next;
        while (p.next!=null){
            p=p.next;
        }
        p.next=greaternode.next;
        return lessnode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node4;
        node4.next=node3;
        node3.next=node2;
        node2.next=node5;
        ListNode p = partition(node1,3);

        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
