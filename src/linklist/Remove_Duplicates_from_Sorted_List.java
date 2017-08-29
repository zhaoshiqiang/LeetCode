package linklist;

/** 第83题
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

     For example,
     Given 1->1->2, return 1->2.
     Given 1->1->2->3->3, return 1->2->3.

 * Created by zhaoshiqiang on 2017/2/1.
 */
public class Remove_Duplicates_from_Sorted_List {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode pre = head;
        ListNode p = head.next;
        while (p!=null){
            if (pre.val==p.val){
                pre.next=p.next;
                p=p.next;
            }else {
                pre=p;
                p=p.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next=node2;
        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        ListNode p= deleteDuplicates(node1);
        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
