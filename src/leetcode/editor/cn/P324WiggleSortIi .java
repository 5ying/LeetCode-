//给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 你可以假设所有输入数组都可以得到满足题目要求的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,1,1,6,4]
//输出：[1,6,1,5,1,4]
//解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,2,3,1]
//输出：[2,3,1,3,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// 0 <= nums[i] <= 5000 
// 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果 
// 
//
// 
//
// 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
// Related Topics 数组 分治 快速选择 排序 
// 👍 381 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：摆动排序 II
class P324WiggleSortIi{
    public static void main(String[] args) {
        Solution solution = new P324WiggleSortIi().new Solution();
        solution.wiggleSort(new int[]{1,1,2,1,2,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*
* 一开始想的是，直接通过原数组进行数值交换
* 也是排序+双指针
* 但是在一个数组上实现不了，有各种各样的情况需要处理 没有考虑周全
* */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len<=2){
            return;
        }
        int i =1;
        int j = len-1;
        boolean ll = true;
        while (i<j && i<len){
            if (nums[i]==nums[j]){
                i = j;
                j = len-1;
                ll = false;
            }
           swap(nums,i,j);
            i = i+2;
            j--;
        }
        if (ll && len%2==0){
            swap(nums,len-2,len-1);
        }else if(ll && len%2 != 0) {
            swap(nums,i,j);
        }

        for (int n :nums){
            System.out.println(n);
        }

    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }



        /*
        * 这里的排序+双指针 是借助了额外的空间，复制了数组进行的重新赋值*/
        public void wiggleSort1(int[] nums) {
            int[] clone = nums.clone();
            Arrays.sort(clone);
            //两个指针
            int left = (nums.length - 1) / 2, right = nums.length - 1;
            for (int i = 0;i < nums.length;i++) {
                if (i % 2 == 0) {
                    nums[i] = clone[left];
                    left--;
                } else {
                    nums[i] = clone[right];
                    right--;
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
