//给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [-4,-2,1,4,8]
//输出：1
//解释：
//-4 到 0 的距离为 |-4| = 4 。
//-2 到 0 的距离为 |-2| = 2 。
//1 到 0 的距离为 |1| = 1 。
//4 到 0 的距离为 |4| = 4 。
//8 到 0 的距离为 |8| = 8 。
//所以，数组中距离 0 最近的数字为 1 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,-1,1]
//输出：1
//解释：1 和 -1 都是距离 0 最近的数字，所以返回较大值 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 
// 👍 5 👎 0

package leetcode.editor.cn;
//Java：找到最接近 0 的数字
 //  2022-06-29 11:30:55	获取当前时间
 class P2239FindClosestNumberToZero{
    public static void main(String[] args) {
        Solution solution = new P2239FindClosestNumberToZero().new Solution();
        // TO TEST
        System.out.println( solution.findClosestNumber(new int[]{-4,-2,1,4,8}));
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int temp = Integer.MAX_VALUE;
        for (int i =0;i<nums.length;i++){
            temp = Math.min(Math.abs(nums[i]),temp);
        }
        for (int j=0;j<nums.length;j++){
            if (Math.abs(nums[j])==temp){
                ans = Math.max(ans,nums[j]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
