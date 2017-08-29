package linklist;

/**第143题
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     You must do this in-place without altering the nodes' values.

     For example,
     Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * Created by zhaoshiqiang on 2017/2/1.
 */
//链表，链表倒序(前插法)和快慢指针
//看到是链表，还是倒着数数的，就条件反射时快慢指针
public class Reorder_List {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        //先计算链表的长度
        ListNode p = head;
        int num=0;
        while ( p!=null ){
            num++;
            p=p.next;
        }
        //取半
        int length = num/2;
        p=head;
        for (int i=0; i<length-1; i++){
            p=p.next;
        }
        //利用前插法将后半部分倒序，newhead将指向后半部分的首部
        ListNode newhead = p.next;
        p.next=null;
        ListNode q = newhead.next;
        newhead.next=null;
        while (q!=null){
            ListNode node = q.next;
            q.next=newhead;
            newhead=q;
            q=node;
        }
        //交替插入
        p=head;
        q=newhead;
        ListNode ppre=null;
        while (q!=null && p!=null ){
            ListNode node = p.next;
            p.next=q;
            q=q.next;
            p.next.next=node;
            ppre=p;
            p=node;
        }
        ppre.next.next=q;
    }

    //利用快慢两个指针将链表一分为二，针对第二个子链表求倒序，最后将两个子链表合并。
    public static void reorderListII(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // find the second half head
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the second half
        ListNode p = slow.next;
        slow.next = null; // cut the first half
        ListNode pPre = null;
        ListNode pSuf = p.next;
        while (p != null) {
            pSuf = p.next;
            p.next = pPre;
            pPre = p;
            p = pSuf;
        }

        // combine two halves
        ListNode l1 = head;
        ListNode l2 = pPre;
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
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
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        reorderListII(node1);
//        reorderList(node1);
        ListNode p=node1;
        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
