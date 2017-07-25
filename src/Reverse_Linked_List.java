/**第206题
 * Reverse a singly linked list.
 *
 * Created by zhaoshiqiang on 2017/2/1.
 */
//链表倒序（前插法）
public class Reverse_Linked_List {
    public static ListNode reverseList(ListNode head) {
        //前插法标准写法
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode ptemp, p =head;
        while (p != null){
            ptemp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = ptemp;
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
        ListNode p= reverseList(node1);
        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
