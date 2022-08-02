//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
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
// 树中节点数范围是 [0, 104] 
// 0 <= Node.val <= 104 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 
// 👍 293 👎 0

package leetcode.editor.cn;
//Java：序列化和反序列化二叉搜索树
//public class P449SerializeAndDeserializeBst{
//    public static void main(String[] args) {
//        Solution solution = new P449SerializeAndDeserializeBst().new Solution();
//        // TO TEST
//    }

import java.util.ArrayList;
import java.util.List;

//      Definition for a binary tree node.
 class TreeNode {
          int val;
         TreeNode left;
         TreeNode right;
         public TreeNode(int val){
             this.val = val;
         }
      }

    //leetcode submit region begin(Prohibit modification and deletion)

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        List<String> list = new ArrayList<>();
        dfs1(root, list);
        int n = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i));
            if (i != n - 1) sb.append(",");
        }
        return sb.toString();
    }
    void dfs1(TreeNode root, List<String> list) {
        if (root == null) return ;
        list.add(String.valueOf(root.val));
        dfs1(root.left, list);
        dfs1(root.right, list);
    }

//    反序列化
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null){
            return null;
        }
        String[] str = data.split(",");
        return dfs2(0,str.length-1,str);

    }
//前序遍历，第一个数值就是根节点
    TreeNode dfs2(int l,int r,String[] ss){
        if (l>r){
            return null;
        }
        int j = l+1;
        int t = Integer.parseInt(ss[l]);
        TreeNode ans = new TreeNode(t);
//        找到第一个比t的节点值，以此来区分左右子树
        while (j<=r && Integer.parseInt(ss[j])<=t){
            j++;
        }
//        递归建立左右子树
        ans.left = dfs2(l+1,j-1,ss);
        ans.right = dfs2(j,r,ss);

        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

//}
