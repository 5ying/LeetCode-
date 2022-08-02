//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 1081 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列 II
 class P47PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            int len = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            if (len==0){
                return ans;
            }
// 剪枝的前提是排序
            Arrays.sort(nums);
            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();

            dfs(nums,len,0,path,used,ans);

            return ans;

        }
        public void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> ans){
            if (depth==len){
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i =0;i<len;i++){
                if (used[i]){
                    continue;
                }
                if (i>0&& nums[i]==nums[i-1] && !used[i-1]){
                    continue;
                }

                    path.add(nums[i]);
                    used[i] = true;

                    dfs(nums,len,depth+1,path,used,ans);

                    used[i] = false; // 重置现场
                    path.remove(path.size()-1);
                }


        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
