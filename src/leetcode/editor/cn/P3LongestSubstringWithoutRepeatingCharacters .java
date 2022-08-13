//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 7626 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：无重复字符的最长子串
class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        int ans =0;
        Map<Character,Integer> map = new HashMap<>();
        for (int end=0,start =0;end<n;end++){
            char temp = s.charAt(end);
            if (map.containsKey(temp)){
                start = Math.max(map.get(temp),start);
            }
            ans = Math.max(ans,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return ans;
    }

    public int  len (String s){
        int len = s.length();
        if (len<2){
            return len;
        }
        int[] freq = new int[128];
        char[] charArray = s.toCharArray();
        int left=0;
        int right =0;
        int res = 1;
        while (right<len){
            freq[charArray[right]]++;
            while (freq[charArray[right]]==2){
                freq[charArray[left]]--;
                left++;
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }




            public int lengthOfLongestSubstring1(String s) {
                int len = s.length();
                if (len < 2) {
                    return len;
                }
                // 当 window 中某个字符的频数为 2 时，表示滑动窗口内有重复字符
                // 频数数组，128 由测试数据的范围决定
                int[] freq = new int[128];
                // 转换为字符数组，避免每一次 s.charAt() 方法检查下标越界
                char[] charArray = s.toCharArray();
                int left = 0;
                int right = 0;
                int res = 1;
                // 循环不变量：区间[left..right] 内没有重复元素
                while (right < len) {
                    freq[charArray[right]]++;
                    // 此时 [left..right) 内如果没有重复元素，就尝试扩张 right
                    // 否则缩小左边界，while 循环体内不断缩小边界
                    while (freq[charArray[right]] == 2) {
                        freq[charArray[left]]--;
                        left++;
                    }
                    // 此时 [left..right] 内没有重复元素
                    res = Math.max(res, right - left + 1);
                    right++;
                }
                return res;
            }



//            滑动窗口
public int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        if (length<2){
            return length;
        }
        int[] frq = new int[128];
        char[] charArray = s.toCharArray();
        int left =0;
        int right =0;
        int res =1;
        while (right<length){
            frq[charArray[right]]++;

            while (frq[charArray[right]]==2){
                frq[charArray[left]]--;
                left++;
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;

}




}
//leetcode submit region end(Prohibit modification and deletion)

}
