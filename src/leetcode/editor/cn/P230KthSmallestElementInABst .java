//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 624 👎 0

package leetcode.editor.cn;
//Java：二叉搜索树中第K小的元素
 class P230KthSmallestElementInABst{
    public static void main(String[] args) {
        Solution solution = new P230KthSmallestElementInABst().new Solution();
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
    int N = 10001;
    int[] number = new int[N];
    int index =0;
    int kk;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
//        二叉搜索树的特点： 左小右大
//        简单的办法：先序遍历存储数据
/*
* 这个方法在数据量大的情况下会超时，复杂度和树的节点个数有关系，但是显然这不是最优的方法 进阶优化 一下*/
//        per(root);
//        return number[k-1];
        kk = k;
        dfs(root);
        return ans;
    }
    public void per(TreeNode root){
        if (root==null){
            return;
        }
        per(root.left);
        number[index++] = root.val;
        per(root.right);

    }
//    直接用k  时间复杂度很低的，不用遍历完整个树  只需要查找到K的元素即可
    public void dfs(TreeNode root){
        if (root==null ||kk<=0){
            return;
        }
        dfs(root.left);
        if (--kk==0){
            ans = root.val;
        }
        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
