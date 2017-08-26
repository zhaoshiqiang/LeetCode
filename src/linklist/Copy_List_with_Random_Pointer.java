package linklist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**第138题 复制带随机指针的链表
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Created by zhaoshiqiang on 2017/1/13.
 */
//哈希表 or 链表
public class Copy_List_with_Random_Pointer {
    /**
     * 普通的链表复制就是遍历一次就能够得到结果，因此遍历一次我们可以将next这个链表复制完成，
     * 这个题的难点在于如何找到新链表中每个节点random所指向的节点
     * 一个思路是：
     *   首先指向在原链表的每个节点后面，复制一个新的节点，原链表长度变为2倍，random 指针指向的是原链表节点 random 指针指向的节点的后面的那个节点
     *   之后将链表拆分成两个list
     * 另一个思路是：
     *   用map来存储复制节点与原始节点的关系，这个因为涉及到查询map，所以速度要比上一个慢很多
     * */
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        RandomListNode p = head;
        RandomListNode newnode = null;
        while (p != null){
            //复制新节点
            newnode = new RandomListNode(p.label);
            newnode.next = p.next;
            p.next = newnode;

            p = newnode.next;
        }
        p = head;
        while (p != null){
            if (p.random != null){
                newnode = p.next;
                newnode.random = p.random.next;
            }
            p = p.next.next;
        }
        RandomListNode newhead = head.next;
        RandomListNode newp = newhead;
        p = head;
        while (p != null){
            p.next = newp.next;
            if (p.next != null){
                newp.next = p.next.next;
                newp = newp.next;
            }
            p = p.next;
        }
        return newhead;
    }

    public static RandomListNode copyRandomListII(RandomListNode head){
        Map<RandomListNode,RandomListNode> relation = new HashMap<>();
        if (head == null){
            return null;
        }
        RandomListNode p = head;
        RandomListNode copyhead = null;
        RandomListNode copyp = null;
        while (p != null){
            RandomListNode newnode = new RandomListNode(p.label);
            relation.put(p,newnode);
            if (copyhead == null){
                copyhead = newnode;
                copyp = copyhead;
            }else {
                copyp.next = newnode;
                copyp = newnode;
            }
            p = p.next;
        }
        p = head;
        copyp = copyhead;
        while (p != null){
            if (p.random != null){
                RandomListNode random = relation.get(p.random);
                copyp.random = random;
            }
            p = p.next;
            copyp= copyp.next;
        }
        return copyhead;
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public static void main(String[] args){
        RandomListNode randomListNode = new RandomListNode(-1);
        RandomListNode node = copyRandomListII(randomListNode);
        while (node != null){
            System.out.print(node.label + "  ");
            node = node.next;
        }
    }
}
