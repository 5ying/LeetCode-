//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 2572 👎 0

package leetcode.editor.cn;

//Java：合并两个有序链表
 //  2022-08-02 17:15:48	获取当前时间
class P21MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
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

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//设置一个头节点，然后将两个链表中数字进行比较进行添加就可以啦
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pp = new ListNode(-1);
        ListNode tt = pp;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1!=null && p2!=null){
            if (p1.val<=p2.val){
                tt.next = p1;
                p1 = p1.next;
                tt = tt.next;
            }else {
                tt.next = p2;
                p2 = p2.next;
                tt = tt.next;
            }
        }
        if (p1==null){
            tt.next = p2;
        }
        if (p2==null){
            tt.next=p1;
        }
        return  pp.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
