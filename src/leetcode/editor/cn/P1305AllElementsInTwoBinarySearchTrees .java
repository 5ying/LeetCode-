//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -105 <= Node.val <= 105 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 
// 👍 102 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：两棵二叉搜索树中的所有元素
 class P1305AllElementsInTwoBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new P1305AllElementsInTwoBinarySearchTrees().new Solution();
        // TO TEST
    }

     //* Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    //leetcode submit region begin(Prohibit modification and deletion)
    //  中序遍历+归并
class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        indoder(root1,nums1);
        indoder(root2,nums2);
        List<Integer> merged  = new ArrayList<>();
        int p1 =0;
        int p2 = 0;
        while (true){
            if (p1 ==nums1.size()){
                merged.addAll(nums2.subList(p2,nums2.size()));
                break;
            }
            if (p2 == nums2.size()){
                merged.addAll(nums1.subList(p1,nums1.size()));
                break;
            }
            if (nums1.get(p1)<nums2.get(p2)){
                merged.add(nums1.get(p1++));
            }else {
                merged.add(nums2.get(p2++));
            }
        }
        return merged;
    }
    public void indoder(TreeNode node,List<Integer> res){
        if (node!=null){
            indoder(node.left,res);
            res.add(node.val);
            indoder(node.right,res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
