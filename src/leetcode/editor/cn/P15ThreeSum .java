//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 4824 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
 class P15ThreeSum{
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> list = new ArrayList<>();
       int len = nums.length;
//       当数组为空或者 数目不足时 直接返回空
       if (nums==null || len<3){
           return list;
       }
       Arrays.sort(nums);
       for (int i = 0;i<len;i++){
//           若当前节点>0,则拼凑不出0值
           if (nums[i]>0){
               break;
           }
//           去掉重复值
           if (i>0 && nums[i]==nums[i-1]){
               continue;
           }
//           双指针 左右边界
           int L = i+1;
           int R = len-1;

           while (L<R){
               int sum = nums[i]+nums[L] +nums[R];
               if (sum==0){
                   list.add(Arrays.asList(nums[i],nums[L],nums[R]));
                   while (L<R && nums[L]==nums[L+1]){
                       L++;
                   }
                   while (L<R && nums[R] == nums[R-1]){
                       R--;
                   }
                   L++;
                   R--;
               }
               else if(sum<0){
                   L++;
               }
               else if (sum>0){
                   R--;
               }
           }
       }

       return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
