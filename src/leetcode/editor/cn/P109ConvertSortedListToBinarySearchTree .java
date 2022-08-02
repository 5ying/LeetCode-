//给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [-10,-3,0,5,9]
//输出: [0,-3,9,-10,null,5]
//解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
//输入: head = []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 104] 范围内 
// -105 <= Node.val <= 105 
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 
// 👍 703 👎 0

package leetcode.editor.cn;
//Java：有序链表转换二叉搜索树
 class P109ConvertSortedListToBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P109ConvertSortedListToBinarySearchTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

// * Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

// * Definition for a binary tree node.
//  public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buileTree(head);
    }

    public TreeNode buileTree(ListNode head){
        int len = lengthNode(head);
        int root_index = len/2;
        ListNode pre = head;
        for (int i=1;i<root_index;i++){
            pre = pre.next;
        }

//这块取值没弄好
        ListNode root_node;
        if (pre==null ){
            return null;
        }else if(pre.next==null){
            root_node = pre;
        } else{
            root_node = pre.next;
        }


        TreeNode root = new TreeNode(root_node.val);
        pre.next = null;
        root.left = buileTree(head);
        root.right = buileTree(root_node.next);

        return root;

    }
    public int lengthNode(ListNode node){
        if (node==null){
            return 0;
        }
        int len =0;
        while(node!=null){
            len++;
            node = node.next;
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
