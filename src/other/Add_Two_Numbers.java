package other;

/**第2题
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
   You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
 * Created by zhaoshiqiang on 2017/2/22.
 */
//模拟加法运算
public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int carry=0;
        while (l1!=null || l2!=null){
            if (l1!=null){
                carry+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                carry+=l2.val;
                l2=l2.next;
            }
            pre.next=new ListNode(carry%10);
            carry=carry/10;
            pre=pre.next;
        }
        if (carry==1){
            pre.next=new ListNode(1);
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
}
