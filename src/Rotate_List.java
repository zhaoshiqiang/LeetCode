/**第61
 * Given a list, rotate the list to the right by k places, where k is non-negative.
     For example:
     Given 1->2->3->4->5->NULL and k = 2,
     return 4->5->1->2->3->NULL.
 * Created by zhaoshiqiang on 2017/2/2.
 */
//链表，倒数，用快慢指针
public class Rotate_List {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        if (k<=0){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        ListNode last=null;
        int num=0;
        while (p != null){
            num++;
            last=p;
            p=p.next;
        }
        //k是可以大于整个list的长度的，所以这时要对k对len取模如果取模之后得0，相当于不用rotate，直接返回
        if (num<=k){
            k=k%num;
            if (k==0){
                return head;
            }
        }
        int prenum=num-k;
        ListNode ppre=null;
        p=head;
        for (int i=0; i<prenum; i++){
            ppre=p;
            p=p.next;
        }
        dummy.next=p;
        ppre.next=null;
        last.next=head;
        return dummy.next;
    }
    //快慢指针
    public static ListNode rotateRightII(ListNode head, int k){
        if (head == null || head.next == null){
            return head;
        }
        if (k<=0){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode fast=head,slow=head,curcount=head;
        int num=0;
        while (curcount!=null){
            num++;
            curcount=curcount.next;
        }
        //k是可以大于整个list的长度的，所以这时要对k对len取模如果取模之后得0，相当于不用rotate，直接返回
        int n=k%num;
        if (n==0){
            return head;
        }
        //先对faster设步长为n，然后faster和slower再一起走，
        for (int i=0; i<n; i++){
            fast=fast.next;
        }
        // 知道faster.next==null，说明slower指向要倒着数的开始点的前一个位置。
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode pre=slow;
        //slow.next就是要返回的newhead，保存一下。
        slow=slow.next;
        //faster.next接到head上
        fast.next=head;
        //pre.next存为null，作队尾。
        pre.next=null;
        dummy.next=slow;
        return dummy.next;
    }

    //把整个list连起来，变成环，找到切分点断开
    public static ListNode rotateRightIII(ListNode head, int k){
        if (head==null|| head.next==null){
            return head;
        }
        ListNode p = head;
        int num=1;
        while (p.next!=null){
            num++;
            p=p.next;
        }
        p.next=head;
        int n=k%num;
        for (int i=0; i<num-n; i++){
            p=p.next;
        }
        head=p.next;
        p.next=null;
        return head;
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
        ListNode p = rotateRightIII(node1,2);
//        ListNode p = rotateRightII(node1,2);
//        ListNode p = rotateRight(node1,2);

        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
