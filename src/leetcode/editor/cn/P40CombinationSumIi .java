//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 
// 👍 979 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和 II
 class P40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//        感觉这个比较好写啊
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }

        Arrays.sort(candidates);
        boolean[] userd = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(candidates,0,len,target,userd,path,ans);
        return ans;

    }

    public void dfs(int[] nums,int sum,int len,int target,boolean[] used,List<Integer> path,List<List<Integer>> ans){
        if (sum==target){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i=0;i<len;i++){
            if (used[i]){
                continue;
            }
            if (i>0 &&used[i]==used[i-1]&& !used[i-1]){
                continue;
            }

            path.add(nums[i]);
            used[i] =true;

            dfs(nums,sum+nums[i],len,target,used,path,ans);
            used[i] = false;
            path.remove(path.size()-1);

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
