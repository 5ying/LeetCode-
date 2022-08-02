//给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 5
//输出: 2
//解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。 
//
// 示例 2: 
//
// 
//输入: n = 9
//输出: 3
//解释: 9 = 4 + 5 = 2 + 3 + 4 
//
// 示例 3: 
//
// 
//输入: n = 15
//输出: 4
//解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 109 
// 
// Related Topics 数学 枚举 
// 👍 191 👎 0

package leetcode.editor.cn;
//Java：连续整数求和
 class P829ConsecutiveNumbersSum{
    public static void main(String[] args) {
        Solution solution = new P829ConsecutiveNumbersSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans =0;
        n = n*2;
        for (int i=1; i*i<n;i++ ){
            if (n%i!=0){
                continue;
            }
            if((n/i-(i-1))%2==0){
                ans++;
            }
        }

return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
