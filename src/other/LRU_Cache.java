package other;

import java.util.HashMap;
import java.util.Map;

/**第146
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:
 LRUCache cache = new LRUCache( 2 capacity );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 * Created by zhaoshiqiang on 2017/1/31.
 */
//利用 链表和hashmap 实现缓存
public class LRU_Cache {

    private Map<Integer, Note> map;
    private Note head;
    private Note tail;
    private int capacity;
    private int size;

    public LRU_Cache(int capacity) {
        map=new HashMap<>(capacity);
        this.capacity=capacity;
        this.size=0;
        head=tail=null;
    }

    public int get(int key) {
        Note note = map.get(key);
        if (note != null){
            operateUpdate(note);
            return note.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Note note = map.get(key);
        if (note != null){
            note.value=value;
            operateUpdate(note);
        }else {
            note = new Note(key,value,null,null);
            map.put(key,note);
            operateAdd(note);
        }
    }

    /**
     * 向链表中前插节点
     * @param note
     */
    private void operateAdd(Note note){

        moveNode2Head(note);
        //链表长度+1
        size++;
        if (size == 1){
            tail=note;
        }
        if (size > capacity){
            map.remove(tail.key);
            tail=tail.pre;
            size--;
        }
    }

    /**
     * 调整对应节点到链表首位
     * @param note
     */
    private void operateUpdate(Note note){
        //只把对应节点调整到链表首位
        if (head != note){
            //把note原来位置的前后节点链接起来
            note.pre.next=note.next;
            if (tail != note){
                //node节点不在尾部
                note.next.pre=note.pre;
            }else {
                //node节点在尾部
                tail=note.pre;
            }

            //把note移动到链表首位
            moveNode2Head(note);
        }
   }

    private void moveNode2Head(Note note) {
        Note p = head;
        head=note;
        head.next=p;
        head.pre=null;
        if (p!=null){
            p.pre=note;
        }
    }

    class Note {
        int key;
        int value;
        Note next;
        Note pre;
        public Note(int key,int value, Note next,Note pre) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }

    public static void main(String[] args){
        LRU_Cache cache = new LRU_Cache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
