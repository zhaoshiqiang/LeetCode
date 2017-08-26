package linklist;

/**第142题
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     Note: Do not modify the linked list.
     Follow up:
     Can you solve it without using extra space?
 * Created by zhaoshiqiang on 2017/2/1.
 */
//快慢指针
//关于这道题的解释和变形参考http://blog.sina.com.cn/s/blog_6f611c300101fs1l.html
public class Linked_List_CycleII {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean flag=false;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                flag=true;
                break;
            }
        }
        if (flag){
            slow=head;
            while (slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }else {
            return null;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
