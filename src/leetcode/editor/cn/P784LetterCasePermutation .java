//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
// Related Topics 位运算 字符串 回溯 
// 👍 386 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：字母大小写全排列
 class P784LetterCasePermutation{
    public static void main(String[] args) {
        Solution solution = new P784LetterCasePermutation().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> str = new ArrayList<>();
//        int len = s.length();
        char[] charArray = s.toCharArray();
//        if (len==0){
//            return str;
//        }

//        StringBuffer sb = new StringBuffer();
//        visited = new boolean[len];
        dfs(charArray,str,0);

        return str;

    }

    public void dfs(char[] charArrays,List<String> str,int index){
        if (index==charArrays.length){
            str.add(new String(charArrays));
            return;
        }
        dfs(charArrays,str,index+1);
        if (Character.isLetter(charArrays[index])){
            charArrays[index] ^= 1<< 5;
            dfs(charArrays,str,index+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
