//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 2044 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：全排列
 class P46Permutations{
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//    DFS+回溯
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len==0){
            return ans;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums,len,0,path,used,ans);

        return ans;

    }
    public void dfs(int[] nums,int len,int depth,List<Integer> path, boolean[] used,List<List<Integer>> ans){
        if (depth==len){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i =0;i<len;i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;

                dfs(nums,len,depth+1,path,used,ans);

                used[i] = false; // 重置现场
                path.remove(path.size()-1);
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
