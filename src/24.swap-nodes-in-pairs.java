/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (49.04%)
 * Likes:    1950
 * Dislikes: 160
 * Total Accepted:    436.8K
 * Total Submissions: 890.6K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode temp = result;
        while (head != null && head.next != null) {
            ListNode node1 = head;
            ListNode node2 = head.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
            head = node1.next;
        }
        return result.next;
    }
}
// @lc code=end

