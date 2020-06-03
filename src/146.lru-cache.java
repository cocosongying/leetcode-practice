import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (31.81%)
 * Likes:    5549
 * Dislikes: 246
 * Total Accepted:    534.3K
 * Total Submissions: 1.7M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 / * capacity * / );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */

// @lc code=start
class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    private void removeNode (DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

