//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 636 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的锯齿形层序遍历
 class P103BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = cengT(root);
        if (ans.size()>1){
            for (int i =2;i<=ans.size();i++){
                if (i%2==0){
                    Collections.reverse( ans.get(i-1));
                }
            }
        }

        return ans;
    }
//    二叉树的层次遍历
    public  List<List<Integer>> cengT(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }else{
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int n = queue.size();
                List<Integer> list = new ArrayList<>();
                while (n-->0){
                    TreeNode temp = queue.poll();
                    list.add(temp.val);
                    if (temp.left!=null){
                        queue.add(temp.left);
                    }
                    if (temp.right!=null){
                        queue.add(temp.right);
                    }
                }
                res.add(list);
            }
            return  res;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
