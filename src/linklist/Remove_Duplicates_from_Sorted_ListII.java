package linklist;

/**第82题
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.

     For example,
     Given 1->2->3->3->4->4->5, return 1->2->5.
     Given 1->1->1->2->3, return 2->3.

 * Created by zhaoshiqiang on 2017/2/1.
 */
public class Remove_Duplicates_from_Sorted_ListII {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        boolean flag=false; //判断当前是否遇到有重复，这个flag能帮助识别是否需要删除重复。
        dummy.next=head;
        ListNode ptr0=dummy;
        ListNode ptr1=dummy.next;
        ListNode ptr2=dummy.next.next;
        while (ptr2!=null){
            //当遇到重复值时，设置flag为true，并让ptr2一直往后找找到第一个与ptr1值不等的位置时停止，
            if (ptr1.val == ptr2.val){
                ptr2=ptr2.next;
                flag=true;
                //ptr2==null（这种情况就是list的最后几个元素是重复的，例如1->2->3->3->null)，
                // 这时ptr1指向的值肯定是需要被删除的，所以要特殊处理，令ptr0的next等于null，把重复值删掉。
                if (ptr2==null){
                    ptr0.next=ptr2;
                }
            }else {
                if (flag){
                    // 这时，ptr1指向的node的值是一个重复值，需要删除，所以这时就需要让ptr0的next连上当前的ptr2，
                    // 这样就把所有重复值略过了。然后，让ptr1和ptr2往后挪动继续查找。
                    ptr0.next=ptr2;
                    flag=false;
                }else {
                    //当没有遇到重复值（flag为false）时，3个指针同时往后移动：ptr0 = ptr1;ptr1 = ptr2;ptr2 = ptr2.next;
                    ptr0=ptr1;
                }
                ptr1=ptr2;
                ptr2=ptr2.next;

            }
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicatesII(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        head=dummy;
        while (head.next!=null && head.next.next!=null){
            if (head.next.val == head.next.next.val){
                //记录重复的值
                int value=head.next.val;
                //将有重复值的节点跳过，注意这里判断的是head.next的值，跳过的是next，从而将重复节点全部删除
                while (head.next!=null && head.next.val==value){
                    head.next=head.next.next;
                }
            }else {
                head=head.next;
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
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        ListNode p= deleteDuplicatesII(node1);
        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
