//给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [5,2,-3]
//输出: [2,-3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [5,2,-5]
//输出: [2]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 104] 范围内 
// -105 <= Node.val <= 105 
// 
// Related Topics 树 深度优先搜索 哈希表 二叉树 
// 👍 163 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P508MostFrequentSubtreeSum{
    public static void main(String[] args) {
        Solution solution = new P508MostFrequentSubtreeSum().new Solution();
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
//    首先想到了使用map进行存储，采用map.val值进行排序
Map<Integer,Integer> map = new HashMap<>();
int max =0;
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (int k:map.keySet()){
            if (map.get(k)==max){
                list.add(k);
            }
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i=0;i<n;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public int  dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        int cur= root.val+dfs(root.left)+dfs(root.right);
        map.put(cur,map.getOrDefault(cur,0)+1);
        max = Math.max(max,map.get(cur));
        return cur;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
