//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 
// 👍 842 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
 class P90SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len ==0) {
            return ans;
        }
//        排序是剪枝的条件
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int k=1;k<len+1;k++){
            dfs(nums,len,0,k,path,ans);
        }
        return ans;
    }

    public void dfs(int[] nums,int len,int star,int k,List<Integer> path,List<List<Integer>> ans){
        if (path.size()==k){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i =star;i<len;i++){
            if (i>star && nums[i]==nums[i-1]) {
                continue;
            }
                path.add(nums[i]);
                dfs(nums,len,i+1,k,path,ans);
                path.remove(path.size()-1);
            }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
