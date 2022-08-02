//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 1359 👎 0

package leetcode.editor.cn;

//Java：反转链表 II
 //  2022-08-02 20:21:51	获取当前时间
 class P92ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode(0);
        hair.next=head;
        ListNode pre = hair;
        ListNode t_head = head;
        ListNode t_tail;
        ListNode pp = hair;
        for (int i=0;i<right;++i){
            if (i+1==left){
                t_head = pre.next;
                pp = pre;
            }
            pre = pre.next;
        }
        t_tail = pre;
        ListNode nex = pre.next;
        ListNode[] re =swaps(t_head,t_tail);
        t_head = re[0];
        t_tail = re[1];
        pp.next = t_head;
        if (nex!=null){
            t_tail.next = nex;
        }
        return  hair.next;
    }

    public ListNode[] swaps(ListNode head,ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev!=tail){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }

        return  new ListNode[]{tail,head};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
