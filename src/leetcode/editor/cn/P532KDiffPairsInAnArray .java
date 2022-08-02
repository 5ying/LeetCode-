//给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。 
//
// k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件： 
//
// 
// 0 <= i, j < nums.length 
// i != j 
// nums[i] - nums[j] == k 
// 
//
// 注意，|val| 表示 val 的绝对值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3, 1, 4, 1, 5], k = 2
//输出：2
//解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
//尽管数组中有两个 1 ，但我们只应返回不同的数对的数量。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1, 2, 3, 4, 5], k = 1
//输出：4
//解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5) 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1, 3, 1, 5, 4], k = 0
//输出：1
//解释：数组中只有一个 0-diff 数对，(1, 1) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -107 <= nums[i] <= 107 
// 0 <= k <= 107 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 206 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：数组中的 k-diff 数对
 class P532KDiffPairsInAnArray{
    public static void main(String[] args) {
        Solution solution = new P532KDiffPairsInAnArray().new Solution();
        // TO TEST
        int ans = solution.findPairs(new int[]{1,3,1,5,4},0);
        System.out.println(ans);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//        我想的是回溯剪枝
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        if (n<2){
            return 0;
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);

        int[] bucket = new int[2];
        dfs(0,n,nums,k,path,list);
        for (List ll : list){
            System.out.println(ll);
        }
        int ans = list.size();
        return ans;
    }
    public void dfs(int index,int n,int[] nums,int k,List<Integer> path,List<List<Integer>> list){
        if (path.size()==2  ){
            if (path.get(1)-path.get(0)==k){
                list.add(new ArrayList<>(path));
                return;
            }else {
                return;
            }

        }
        for (int i =index;i<n;i++){
            if (i>index && nums[i]==nums[i-1]){
                continue;
            }
//            if (path.size()>2){
//                continue;
//            }
            if (path.size()>0 && nums[i]-path.get(0)>k){
                break;
            }
            path.add(nums[i]);
            dfs(i+1,n,nums,k,path,list);
            path.remove(path.size()-1);
        }
    }


//    采用的时排序+双指针
        public int findPairs2(int[] nums, int k) {
            int n = nums.length, res = 0;
            Arrays.sort(nums);
            for (int i = 0; i < n - 1; i++) {
                //重复的不计算，如果相同nums[i-1]已经计算过了
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = nums[i] + k;
                //在[i+1,n-1]中找target
                int left = i + 1, right = n - 1;
                int ans = -1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] >= target) {
                        ans = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                //判断是否找到
                if (ans != -1 && nums[ans] == target) {
                    res++;
                }
            }
            return res;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
