package sort;

/**第147
 * Sort a linked list using insertion sort.
 * Created by zhaoshiqiang on 2017/2/14.
 */
//链表插入排序，这里要从表头开始往后搜索
public class Insertion_Sort_List {
    public static ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next=null;
        ListNode pre=dummy;
        ListNode p=dummy.next;
        ListNode q=head;
        while (q!=null){
            while (p!=null && p.val<q.val){
                pre=p;
                p=p.next;
            }
            pre.next=q;
            q=q.next;
            pre.next.next=p;
            p=dummy.next;
            pre=dummy;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(6);
//        ListNode node5 = new ListNode(8);
        node1.next=node2;
        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        ListNode p = insertionSortList(node1);

        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
