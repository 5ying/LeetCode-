//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -231 <= val <= 231 - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 104 次 
// 
// Related Topics 栈 设计 
// 👍 1312 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：最小栈
 class P155MinStack{
//    public static void main(String[] args) {
//        Solution solution = new P155MinStack().new Solution();
//        // TO TEST
//    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
        Stack<Integer> data;
        Stack<Integer> helper;

    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int val) {
        data.add(val);
        if (helper.isEmpty() || helper.peek()>=val){
            helper.add(val);
        }else {
            helper.add(helper.peek());
        }

    }
    
    public void pop() {
        if (!data.isEmpty()){
            helper.pop();
            data.pop();
        }

    }
    
    public int top() {
        if (!data.isEmpty()){
            return data.peek();
        }
       throw  new RuntimeException("栈中元素为空，此操作非法");

    }
    
    public int getMin() {
        if (!helper.isEmpty()){
            return helper.peek();
        }

        throw  new RuntimeException("栈中元素为空，此操作非法");
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
