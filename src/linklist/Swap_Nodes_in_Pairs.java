package linklist;

/**第24
 * Given a linked list, swap every two adjacent nodes and return its head.
     For example,
     Given 1->2->3->4, you should return the list as 2->1->4->3.

    Your algorithm should use only constant space. You may not modify the values in the list,
    only nodes itself can be changed.
 * Created by zhaoshiqiang on 2017/2/2.
 */
public class Swap_Nodes_in_Pairs {
    public static ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        //用一个辅助指针作为表头，这是链表中比较常用的小技巧，因为这样可以避免处理head的边界情况，
        // 一般来说要求的结果表头会有变化的会经常用这个技巧
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode ptr0=dummy;
        ListNode ptr1=dummy.next;
        ListNode ptr2=dummy.next.next;
        while (ptr1!=null && ptr2!=null){
            ptr0.next=ptr2;
            ptr1.next=ptr2.next;
            ptr2.next=ptr1;

            ptr0=ptr1;
            ptr1=ptr1.next;
            if (ptr1!=null){
                ptr2=ptr1.next;
            }else {
                ptr2=null;
            }
        }
        return dummy.next;
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
        ListNode p = swapPairs(node1);

        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
