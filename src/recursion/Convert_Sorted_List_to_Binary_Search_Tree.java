package recursion;

/**第109
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * Created by zhaoshiqiang on 2017/2/25.
 */
//递归 反中序遍历构建二叉树
public class Convert_Sorted_List_to_Binary_Search_Tree {
    private ListNode currentHead=null;

    public TreeNode sortedListToBST(ListNode head) {
        int len=0;
        ListNode node = head;
        while (node!=null){
            len++;
            node=node.next;
        }
        currentHead=head;
        return bulidTree(0,len-1);
    }
    /*
    * 先递归构建左子树，在构建左子树的同时不断移动链表的头指针，链表的头指针永远是对应当前子树位置的。
    * 一直到左叶子节点，左叶子节点对应的就是链表的第一个元素，生成左叶子节点之后移动链表当前指针。
    * 时间复杂度为O(n)
    * */
    private TreeNode bulidTree(int start, int end){
        if (start > end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode left = bulidTree(start,mid-1);
        TreeNode root = new TreeNode(currentHead.val);
        root.left=left;
        currentHead=currentHead.next;
        root.right=bulidTree(mid+1,end);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
