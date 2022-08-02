//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都 互不相同 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1981 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和
 class P39CombinationSum{
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = candidates.length;
        if (len==0){
            return ans;
        }

        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs(candidates,0,len,path,ans,target);
        return ans;

    }

    public void dfs(int[] can,int begin,int  len,List<Integer> path,List<List<Integer>> ans,int target){
        if(target<0){
            return;
        }
        if (target==0){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin;i<len;i++){
//            小剪枝: 去掉当前层相同的节点
            if (i > begin && can[i] == can[i - 1]) {
                continue;
            }
//            大剪枝：如果当前i节点<0,则i+1，i+2后面的值也会<0
            if(target-can[i]<0){
                break;
            }
            path.add(can[i]);
//            这里的i不可以
            dfs(can,i+1,len,path,ans,target-can[i]);
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
