package sort;

/**第21题
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Created by zhaoshiqiang on 2017/2/2.
 */
//组合两个链表，思路类似归并排序
public class Merge_Two_Sorted_Lists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p=dummy;
        ListNode pl1=l1;
        ListNode pl2=l2;
        while (pl1!=null && pl2!=null){
            if (pl1.val < pl2.val){
                p.next=pl1;
                pl1=pl1.next;
                p=p.next;
            }else {
                p.next=pl2;
                pl2=pl2.next;
                p=p.next;
            }
        }
        if (pl1 == null){
            p.next=pl2;
        }else if (pl2 == null){
            p.next=pl1;
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
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(8);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
//        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        ListNode p= mergeTwoLists(node1,node5);
        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
