/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
 *
 * https://leetcode.com/problems/insertion-sort-list/description/
 *
 * algorithms
 * Medium (40.17%)
 * Likes:    551
 * Dislikes: 557
 * Total Accepted:    179.5K
 * Total Submissions: 444K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list using insertion sort.
 * 
 * 
 * 
 * 
 * 
 * A graphical example of insertion sort. The partial sorted list (black)
 * initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and
 * inserted in-place into the sorted list
 * 
 * 
 * 
 * 
 * 
 * Algorithm of Insertion Sort:
 * 
 * 
 * Insertion sort iterates, consuming one input element each repetition, and
 * growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it
 * there.
 * It repeats until no input elements remain.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode prev = temp;
        ListNode node = head;
        while (node != null) {
            ListNode curr = node;
            node = node.next;
            if (curr.val < prev.val) {
                prev = temp;
            }
            while (prev.next != null && curr.val > prev.next.val) {
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
        }
        return temp.next;
    }
}
// @lc code=end

