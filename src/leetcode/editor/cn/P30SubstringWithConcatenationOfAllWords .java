//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 704 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：串联所有单词的子串
 class P30SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
        Solution solution = new P30SubstringWithConcatenationOfAllWords().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n =words.length;
        int wordLength = words[0].length();
        List<Integer> list = new ArrayList<>();
        Map<String ,Integer> map = new HashMap<>();
        for (String s1:words){
            map.put(s1,map.getOrDefault(s1,0)+1);
        }

        for (int i =0;i<s.length()-wordLength*n+1;i++){
            HashMap<String,Integer> curMap = new HashMap<>();
            boolean errorFlag = false;
            for (int j=0;j<n;j++){
                String curWord = s.substring(i+j*wordLength,i+(j+1)*wordLength);
                if (!map.containsKey(curWord)){
                    errorFlag = true;
                    break;
                }
                curMap.put(curWord,curMap.getOrDefault(curWord,0)+1);
                if (curMap.get(curWord)>map.get(curWord)){
                    errorFlag = true;
                    break;
                }
            }

            if (!errorFlag){
                list.add(i);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
