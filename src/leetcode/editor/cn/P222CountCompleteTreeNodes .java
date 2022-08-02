//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2h 个节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 104] 
// 0 <= Node.val <= 5 * 104 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
// Related Topics 树 深度优先搜索 二分查找 二叉树 
// 👍 690 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：完全二叉树的节点个数
class P222CountCompleteTreeNodes{
    public static void main(String[] args) {
        Solution solution = new P222CountCompleteTreeNodes().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

//        TreeNode root = new TreeNode();
        solution.inor(root);
        solution.countNodes(root);



    }

//      Definition for a binary tree node.
//      public class TreeNode {
//          int val;
//          TreeNode left;
//          TreeNode right;
//          TreeNode() {}
//          TreeNode(int val) { this.val = val; }
//          TreeNode(int val, TreeNode left, TreeNode right) {
//             this.val = val;
//              this.left = left;
//              this.right = right;
//          }
//      }

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
    int count;
    public int countNodes(TreeNode root) {
//以为是返回叶子节点个数
        //        int height = treeHright(root);
//        int upNode =(int) Math.pow(2,height-1);
//        return treeNode(root)-upNode;
//
//        层次遍历 ：返回所有节点个数
//        return treeNode(root);
//        使用完全二叉树的性质 : 树高+叶子节点
        int height = treeHright(root);
        inor(root);
        int upNode;
        if (height>=1){
             upNode =(int) Math.pow(2,height-1)-1;
        }else{
            upNode =0;
        }

        return upNode+count;



    }
    public int treeHright(TreeNode root){
        if (root==null){
            return 0;
        }
//        int left = treeHright(root.left);
//        int right = treeHright(root.right);
        return treeHright(root.left)>treeHright(root.right)?treeHright(root.left)+1:treeHright(root.right)+1;
    }
    public int treeNode(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        int sum =0;
        if (root==null){
            return 0;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            sum +=n;
            while (n-->0){
                TreeNode temp = queue.poll();
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        return sum;
    }
//    也可以用其他遍历吧
    public void inor(TreeNode root){
        if (root==null){
            return;
        }
        if (root.left==null && root.right==null){
            count++;
        }
        inor(root.left);
        inor(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
