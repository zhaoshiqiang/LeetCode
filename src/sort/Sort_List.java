package sort;

/**第148
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Created by zhaoshiqiang on 2017/2/11.
 */
//链表的归并排序+快慢指针
public class Sort_List {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        return margeSort(head);
    }

    private static ListNode margeSort(ListNode head){
        //只有一个元素
        if (head.next == null){
            return head;
        }
        //用快慢指针确定链表的中心位置
        ListNode fast=head, slow=head,pre=null;
        while (fast!=null && fast.next!=null ){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        //分
        ListNode left = margeSort(head);
        ListNode right = margeSort(slow);
        //归并
        return margeSort(left,right);
    }

    private static ListNode margeSort(ListNode left,ListNode right){
        ListNode newhead = new ListNode(-1);
        ListNode p=left,q=right,k=newhead; //此时，慢指针指向链表中间位置
        while (p!=null && q!=null){
            if (p.val > q.val){
                k.next=q;
                q=q.next;
                k=k.next;
            }else {
                k.next=p;
                p=p.next;
                k=k.next;
            }
        }
        if (p==null){
            k.next=q;
        }else if (q==null){
            k.next=p;
        }
        return newhead.next;
    }
    static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(4);
        head.next=second;
        second.next=third;
        ListNode p=sortList(head);
        while (p!=null){
            System.out.print(p.val + "  ");
            p=p.next;
        }
    }
}
