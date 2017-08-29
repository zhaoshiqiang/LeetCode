package linklist;

/**第141题
 * Given a linked list, determine if it has a cycle in it.
 *
     Follow up:
     Can you solve it without using extra space?
 * Created by zhaoshiqiang on 2017/2/1.
 */
//快慢指针
public class Linked_List_Cycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //因为fast指针比slow指针走得快，所以只要判断fast指针是否为空就好。
        // 由于fast指针一次走两步（走得太快了，就容易跌倒！），fast.next可能已经为空（当fast为尾结点时），
        // fast.next.next将会导致NullPointerException异常，所以在while循环中我们要判断fast.next是否为空；

        //这里fast的判断要先放到前面，这样在fast为null时便可直接退出循环，从而不访问fast.next
        while ( fast!=null && fast.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        System.out.println(hasCycle(node1));
    }
}
