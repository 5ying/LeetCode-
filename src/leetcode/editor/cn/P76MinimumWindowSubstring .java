//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 2049 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：最小覆盖子串
 //  2022-08-06 15:30:18	获取当前时间
class P76MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hs = new HashMap<>();
        HashMap<Character,Integer> ht= new HashMap<>();
        for (int i=0;i<t.length();i++){
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i),0)+1);
        }
        String ans ="";
        int len  = Integer.MAX_VALUE;
        int cnt =0;
        for (int i =0,j=0;i<s.length();i++){
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
            if (ht.containsKey(s.charAt(i))&& hs.get(s.charAt(i))<=ht.get(s.charAt(i))){
                cnt ++;
            }

            while (j<i&& (!ht.containsKey(s.charAt(j))||hs.get(s.charAt(j))>ht.get(s.charAt(j)))){
                int count = hs.get(s.charAt(j))-1;
                hs.put(s.charAt(j),count);
                j++;
            }
            if (cnt==t.length() && i-j+1<len){
                len = i-j+1;
                ans = s.substring(j,i+1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
