//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 740 👎 0

package leetcode.editor.cn;
import java.util.HashMap;
import java.util.Map;

//Java：从中序与后序遍历序列构造二叉树
 class P106ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
//从后续、中序重建二叉树
class Solution {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeNode(inorder, postorder, 0, n, 0, n);


    }

    public TreeNode buildTreeNode(int[] inor, int[] post, int inor_left, int inor_right, int post_left, int post_right) {
        if (post_right < post_left) {
            return null;
        }
        int post_root = post_right;
        int inor_root = map.get(post[post_root]);

        TreeNode root = new TreeNode(post[post_root]);
        int size_left = inor_root - inor_left;

//         这里的先序与后序的边界很有意思
        root.left = buildTreeNode(inor, post, inor_left, inor_root - 1, post_left, post_left + size_left - 1);
        root.right = buildTreeNode(inor, post, inor_root + 1, inor_right, post_left + size_left, post_root - 1);

        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
