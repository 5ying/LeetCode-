//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 600 👎 0

package leetcode.editor.cn;
//Java：分隔链表
 //  2022-08-02 19:50:07	获取当前时间
 class P86PartitionList{
    public static void main(String[] args) {
        Solution solution = new P86PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
        ListNode hair = new ListNode(0);
//        大于等于X的值我们进行尾插
//        小于X的我们进行头插
//        上面这个方案不行 这样的话 就不能保证相对位置了

        /*
        * 简单的解法分开存储，后续进行合并就可以啦*/
//       >=x的放在hh,<x的放在hair
        ListNode hh= new ListNode(0);
        hh.next = head;
        ListNode cur = hh;
        ListNode pp = hair;
        while (head!=null){
            if (head.val>=x){
                /*
                * 指针下移*/
                head = head.next;
                cur = cur.next;
            }else {
                /*
                * pp下移，head下移，但是cur不动*/
                pp.next = head;
                pp = pp.next;
                cur.next = head.next;
                head = head.next;
            }
        }
        /*最后拼接*/
        pp.next = hh.next;
        return hair.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
