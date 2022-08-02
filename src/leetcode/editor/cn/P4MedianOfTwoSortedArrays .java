//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治 
// 👍 5462 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：寻找两个正序数组的中位数
 class P4MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = (len1+len2)/2;
        int j=0;
        int count =0;
       int[] nums = new int[len1+len2];
       for (int i =0;i<len1;i++){
           nums[j++] = nums1[i];
       }
       for (int i=0;i<len2;i++){
           nums[j++] = nums2[i];
       }

        Arrays.sort(nums);

       if ((len1+len2)%2==0){
           return (nums[len]+nums[len-1])/2.0;
       }else {
           return nums[len];
       }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
