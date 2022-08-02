//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 5258 👎 0

package leetcode.editor.cn;

//Java：最长回文子串
 class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("bb"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//        暴力破解 超时
    public String longestPalindrome(String s) {
        String ans="";
        int maxlen=Integer.MIN_VALUE;
        if (s.length()==1){
            return s;
        }
        for (int i=0;i<s.length();i++){
            for (int j = s.length();j>i;j--){
                String ss = s.substring(i,j);
                if (isHuiwen(ss)){
                    if (maxlen<(j-i+1)){
                        maxlen = j-i+1;
                        ans = ss;
                    }
                }
            }
        }

return ans;
    }
    public boolean isHuiwen(String s){
        if (s==null){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        String ss = sb.reverse().toString();
        if (ss.equals(s)){
            return true;
        }else {
            return  false;
        }
    }

    public String longs(String s) {
//      使用动态规划的方法进行解决
        int len = s.length();
//       用于特例判断
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i =0;i<len;i++){
            dp[i][i]=true;
        }

        for (int j=1;j<len;j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }

            }



        }
        return s.substring(begin, begin + maxLen);
    }

//
}
//leetcode submit region end(Prohibit modification and deletion)

}
