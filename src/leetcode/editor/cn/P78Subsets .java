//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1659 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：子集
 class P78Subsets{
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        solution.subsets(new int[]{1,2,3});
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(len==0){
            return  ans;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        for(int k = 1;k<len+1;k++){
            dfs(nums,len,0,k,used,path,ans);
        }
        ans.add(new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums,int len,int start,int k,boolean[] used,List<Integer> path,List<List<Integer>> ans){
        if (path.size()==k){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i =start;i<len;i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;

                dfs(nums,len,i+1,k,used,path,ans);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
