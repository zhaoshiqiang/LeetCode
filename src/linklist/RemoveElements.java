package linklist;

/**
 * 203
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        ListNode pre= dummy;
        while (head != null){
            if (head.val !=val){
                pre.next = head;
                pre=pre.next;
            }
            head=head.next;
        }
        pre.next=null;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
