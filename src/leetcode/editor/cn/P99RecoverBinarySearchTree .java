//给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
//
// 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 718 👎 0

package leetcode.editor.cn;
//Java：恢复二叉搜索树
//public class P99RecoverBinarySearchTree{
//    public static void main(String[] args) {
//        Solution solution = new P99RecoverBinarySearchTree().new Solution();
//        // TO TEST
//    }
    //leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
//恢复二叉搜索树
    /*
    * 查看左右子树是否存在违规情况*/
class Solution {
    List<TreeNode> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        isBST(root);
        TreeNode x = null;
        TreeNode y = null;
        for (int i =0;i<list.size()-1;i++) {
            if (list.get(i).val>list.get(i+1).val) {
                y = list.get(i+1);
                if (x==null) {
                    x = list.get(i);
                }
            }
        }

        if (x!=null && y!=null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }


    public List<TreeNode> isBST(TreeNode root) {
        if (root != null) {
            isBST(root.left);
            list.add(root);
            isBST(root.right);
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

//}
