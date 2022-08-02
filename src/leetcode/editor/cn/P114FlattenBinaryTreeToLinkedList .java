//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 
// 👍 1168 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树展开为链表


 class P114FlattenBinaryTreeToLinkedList{
//     class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;
//         TreeNode() {}
//         TreeNode(int val) { this.val = val; }
//         TreeNode(int val, TreeNode left,TreeNode right) {
//             this.val = val;
//             this.left = left;
//             this.right = right;
//         }
//     }

    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
        // TO TEST

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        solution.pre(root);
        solution.flatten(root);
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
    List<Integer> list = new ArrayList<>();
    public void pre(TreeNode root){
        if (root==null){
            return;
        }
        list.add(root.val);
        pre(root.left);
        pre(root.right);
    }
    public void flatten(TreeNode root) {
//        先序遍历存起来，然后再形成单链表
//        TreeNode cur = root;
        if (list.size()==0){
            root=null;
        }else {
            TreeNode cur = new TreeNode(list.get(0));
            root  = cur;
            for (int i =1;i<list.size();i++){
                cur.right = new TreeNode(list.get(i));
                cur.left = null;
                cur = cur.right;
            }
        }

//        for (TreeNode node:list){
//            cur.right = node;
//            cur.left = null;
//            cur = cur.right;
//        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
