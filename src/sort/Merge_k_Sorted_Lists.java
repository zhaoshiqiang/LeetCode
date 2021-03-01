package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**第23题
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * Created by zhaoshq on 2017/3/16.
 */
//外排序
public class Merge_k_Sorted_Lists {
    //第一种思路类似于归并排序中归并的过程，先把k个list分成两半，然后继续划分，直到剩下两个list就合并起来，
    // 合并时会用到Merge Two Sorted Lists这道题，代码如下
    //假设总共有k个list，每个list的最大长度是n，那么运行时间满足递推式T(k) = 2T(k/2)+O(n*k)。
    // 根据主定理，可以算出算法的总复杂度是O(nklogk)。空间复杂度的话是递归栈的大小O(logk)。
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        return helper(lists,0,lists.length-1);
    }
    private ListNode helper(ListNode[] lists, int l, int r)
    {
        if(l<r)
        {
            int m = (l+r)/2;
            return merge(helper(lists,l,m),helper(lists,m+1,r));
        }
        return lists[l];
    }
    private ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                l1 = l1.next;
            }
            else
            {
                ListNode next = l2.next;
                cur.next = l2;
                l2.next = l1;
                l2 = next;
            }
            cur = cur.next;
        }
        if(l2!=null)
            cur.next = l2;
        return dummy.next;
    }
    //第二种方法用到了堆的数据结构。
    // 维护一个大小为k的堆，每次取堆顶的最小元素放到结果中，然后读取该元素的下一个元素放入堆中，重新维护好。
    // 因为每个链表是有序的，每次又是去当前k个元素中最小的，所以当所有链表都读完时结束，这个时候所有元素按从小到大放在结果链表中。
    // 这个算法每个元素要读取一次，即是k*n次，然后每次读取元素要把新元素插入堆中要logk的复杂度，所以总时间复杂度是O(nklogk)。
    // 空间复杂度是堆的大小，即为O(k)
    public static ListNode mergeKListsII(ListNode[] lists) {
        if (lists == null || lists.length==0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (int i=0; i<lists.length; i++){
            if (lists[i] != null){
                heap.offer(lists[i]);
            }
        }
        ListNode pre = dummy;
        while (!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre=cur;
            if (cur.next != null){
                heap.offer(cur.next);
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
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
//        n1.next=n2;
//        n2.next=n3;
        ListNode[] lists = new ListNode[]{n1,n2,n3};
        System.out.println(mergeKListsII(lists));
    }
}
