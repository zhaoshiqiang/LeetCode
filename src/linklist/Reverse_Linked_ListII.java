package linklist;

/**第92题
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

     For example:
     Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     return 1->4->3->2->5->NULL.

     Note:
     Given m, n satisfy the following condition:
     1 ≤ m ≤ n ≤ length of list.
 * Created by zhaoshiqiang on 2017/2/1.
 */
//链表，部分倒序
public class Reverse_Linked_ListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode front = null,last,pre,cur;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        cur=dummy;
        for (int i=1; i<m; i++){
            cur=cur.next;
        }
        //这里是把m,n之间的节点全部从原链表拉出来倒序排，newtail指向单拉出来的表头
        ListNode newdummy = new ListNode(-1);
        ListNode newtail = cur.next;
        ListNode p = cur.next;
        ListNode ptemt = null;
        for (int i = m; i <= n; i++) {
            //这里是标准的前插法倒叙链表
            ptemt = p.next;
            p.next = newdummy.next;
            newdummy.next = p;
            p = ptemt;
        }
        //将新链表与原链表对接上
        cur.next = newdummy.next;
        newtail.next = p;

        return dummy.next;
    }

    static class ListNode {
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
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        ListNode p= reverseBetween(node1,1,2);
        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
