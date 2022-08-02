//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 
// 👍 594 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：划分为k个相等的子集
class P698PartitionToKEqualSumSubsets{
    public static void main(String[] args) {
        Solution solution = new P698PartitionToKEqualSumSubsets().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum  = Arrays.stream(nums).sum();
        if (sum%k!=0){
            return false;
        }
        int target = sum /k;
        int[] bucket = new int[k+1];
        Arrays.sort(nums);
        return  dfs(nums,nums.length-1,bucket,k,target);
    }
    public  boolean dfs(int[] nums,int index,int[] bucket,int k,int target){
        if (index==-1){
            return true;
        }

        for (int i =0;i<k;i++){
            if(bucket[i]+nums[index]>target){
                continue;
            }
            if (i>0 &&bucket[i]==bucket[i-1] ){
                continue;
            }
            if (i>0&& index==nums.length-1){
                break;
            }
            bucket[i] += nums[index];
            if (dfs(nums,index-1,bucket,k,target)){
                return true;
            }
            bucket[i] -= nums[index];

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
