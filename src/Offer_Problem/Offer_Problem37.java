package Offer_Problem;

/**
 * 《剑指offer》两个链表的第一个公共结点
 * Created by zhaoshq on 2017/8/10.
 */
public class Offer_Problem37 {

    public ListNode findFirstCommonNode(ListNode root1, ListNode root2){
        if (root1 == null || root2 == null ){
            return null;
        }
        ListNode result = null;
        int list1Length = 0;
        int list2Length = 0;
        ListNode p1 = root1;
        ListNode p2 = root2;

        //计算两个链表的长度
        while (p1 != null){
            p1=p1.next;
            list1Length++;
        }
        while (p2 != null){
            p2=p2.next;
            list2Length++;
        }
        //将longList指向长链表，并移动diff长度
        ListNode longList = null;
        ListNode shortList = null;
        int diff = 0;
        if (list1Length > list2Length){
            longList = root1;
            shortList = root2;
            diff = list1Length - list2Length;
        }else {
            longList = root2;
            shortList = root1;
            diff = list2Length - list1Length;
        }
        for (int i = 0; i < diff; i++) {
            longList = longList.next;
        }
        //longList和shortList一起移动，第一次相同的结点便是所求
        while (longList != null && shortList != null && longList != shortList){
            longList = longList.next;
            shortList = shortList.next;
        }
        result = longList;
        return result;
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
