//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 双指针 
// 👍 957 👎 0

package leetcode.editor.cn;
//Java：删除排序链表中的重复元素 II
 //  2022-08-02 19:29:26	获取当前时间
 class P82RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
        // TO TEST
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hair = new ListNode(0);
        hair.next=head;
        ListNode pre = hair;
        while (pre.next!=null && pre.next.next!=null){
            if (pre.next.val==pre.next.next.val){
                int x = pre.next.val;
                while(pre.next!=null && pre.next.val==x){
                    pre.next =pre.next.next;
                }
            }else{
                pre = pre.next;
            }
        }

        return hair.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
