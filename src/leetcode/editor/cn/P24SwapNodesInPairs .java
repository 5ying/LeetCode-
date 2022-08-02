//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 
// 👍 1495 👎 0

package leetcode.editor.cn;

//Java：两两交换链表中的节点
 //  2022-08-02 18:26:21	获取当前时间
 class P24SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
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
/*
* 这个就是K个一组交换节点的特例啊：K=2*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pp = new ListNode(0);
        pp.next = head;
        ListNode pre =pp;
        while (head!=null){
            ListNode tail = pre;
            for (int i=0;i<2;++i){
                tail = tail.next;
                if (tail==null){
                    return pp.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] re = myReverse(head,tail);
            head = re[0];
            tail = re[1];

            pre.next = head;
            tail.next = nex;
            pre=tail;
            head = tail.next;
        }
        return pp.next;

    }

    public ListNode[] myReverse(ListNode head,ListNode tail){
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

    public ListNode ss(ListNode head){
        ListNode hair = new ListNode(0);
        hair.next= head;
        ListNode pre = hair;
        while (head!=null){
            ListNode tail = pre;
            for (int i=0;i<2;++i){
                tail = tail.next;
                if (tail==null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] re = swaps(head,tail);
            head = re[0];
            tail = re[1];

            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = nex;
        }
        return hair.next;
    }










//    顺一遍逻辑
//    当知道头尾节点，对其进行反转时
    public ListNode[] swaps(ListNode head,ListNode tail){
//        头插法
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
