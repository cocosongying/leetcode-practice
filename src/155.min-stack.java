import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (43.34%)
 * Likes:    3213
 * Dislikes: 314
 * Total Accepted:    535.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * Methods pop, top and getMin operations will always be called on non-empty
 * stacks.
 * 
 * 
 */

// @lc code=start
class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }
    
    public void pop() {
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }
    
    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException();
    }
    
    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

