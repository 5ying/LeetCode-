//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 901 👎 0

package leetcode.editor.cn;
//Java：回文子串
class P647PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new P647PalindromicSubstrings().new Solution();
        // TO TEST
        int ans = solution.countSubstrings("aaa");
        System.out.println(ans);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int ans =0;
        if (len<2){
            return ans+1;
        }
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        for (int j =0;j<len;j++){
            for (int i=0;i<=j;i++){
                if (chars[i]==chars[j]){
                    if (j-i<3){
                        dp[i][j] = true;
                        ans ++;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                        if (dp[i][j]){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
