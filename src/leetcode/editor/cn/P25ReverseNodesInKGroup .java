//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
// Related Topics 递归 链表 
// 👍 1738 👎 0

package leetcode.editor.cn;

//Java：K 个一组翻转链表
 //  2022-08-02 14:47:38	获取当前时间
class P25ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
        // TO TEST
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

//  关闭链表题目的要点：在进行每一次操作之前我们都要记录 前一个节点 和后一个节点，防止在操作过程中，节点的丢失

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre=hair;
        while (head!=null){
            ListNode tail = pre;
//            统计K，K个一组进行反转
            for (int i =0;i<k;i++){
                tail = tail.next;
                if (tail==null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
//            获取反转之后的头节点和尾节点
            ListNode[] reverse = myReverse(head,tail);
            head = reverse[0];
            tail = reverse[1];
//            进行每个小组之间的连接
            pre.next = head;
            tail.next = nex;
            head = tail.next;
        }
        return hair.next;
    }

//    反转链表拆分出来一个方法
    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev!=tail){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail,head};
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
