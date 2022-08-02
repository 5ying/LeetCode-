//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。 
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：[2,2,2,5,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定树的节点数范围是 [1, 100]。 
// 每个节点的值都是整数，范围为 [0, 99] 。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 140 👎 0

package leetcode.editor.cn;
//Java：单值二叉树
 class P965UnivaluedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P965UnivaluedBinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean flag = true;
    int root_num;
    public boolean isUnivalTree(TreeNode root) {
        root_num = root.val;
        per(root);
        return  flag;
    }

    public void per(TreeNode root){
        if (root==null){
            return;
        }
        if (root.val != root_num){
            flag = false;
            return;
        }
        per(root.left);
        per(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
