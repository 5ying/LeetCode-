//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,104] 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 306 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：找树左下角的值
 class P513FindBottomLeftTreeValue{
    public static void main(String[] args) {
        Solution solution = new P513FindBottomLeftTreeValue().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        int ans = solution.findBottomLeftValue(root);
        System.out.println(ans);
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
//    层次遍历  存储输出最后一层第一个节点
    public int findBottomLeftValue(TreeNode root) {
        if (root.left==null && root.right==null){
            return root.val;
        }
        int height = height(root);

        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int hh =0;
        while (!queue.isEmpty()){
            hh++;
            int cnt = queue.size();
            if (hh==height){
                ans = queue.poll().val;
                break;
            }
            while (cnt-->0){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return ans;

    }

    public int height (TreeNode root){
        if (root==null){
            return 0;
        }
        int lf = height(root.left);
        int rf = height(root.right);
        return lf>rf?lf+1:rf+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
