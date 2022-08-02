//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 804 👎 0

package leetcode.editor.cn;


//Java：旋转链表
 //  2022-08-02 16:29:59	获取当前时间

 class P61RotateList{
    public static void main(String[] args) {
        Solution solution = new P61RotateList().new Solution();
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

//我想到的是方案是两次统计计数
//     在第一次进行链表统计的时候，将首尾连接起来
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
//        排除特殊情况
        if (head==null || head.next==null || k==0){
            return head;
        }
        int len =0;
        ListNode temp = head;
//        统计链表长度
        while (temp.next!=null){
            len++;
            temp = temp.next;
        }
        len++;
        if (k%len==0){
//            当k为len的倍数时，直接返回头节点就好了，等于不移动
            return head;
        }else{
//            当需要数字移动时，首先将首尾连接起来，然后查找需要断开的节点就可以了
            temp.next = head;
            //          计算 看需要从何地断开
            int kk=len-(k%len)-1;

            ListNode tt = head;
            for (int i =0;i<kk;i++){
                tt = tt.next;
            }
            ListNode th= tt.next;
            tt.next = null;
            return  th;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
