//现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。 
//
// 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 269 题相同： https://leetcode-cn.com/problems/alien-dictionary/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 
// 👍 39 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Java：外星文字典
 class POfferIIJf1JuT{
    public static void main(String[] args) {
        Solution solution = new POfferIIJf1JuT().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String alienOrder(String[] words) {
        int[] degree = new int[26];
        Map<Character, List<Character>> grap = new HashMap<>();
        int n = words.length;
//        将所有的字符存储起来，并且每个字符建立一个关系链表
//        链表里存储的是什么？在单词中出现的后面的字母？
        for (String word:words){
            for (int i =0;i<word.length();i++){
                grap.putIfAbsent(word.charAt(i),new ArrayList<>());
            }
        }

        for (int i=0;i<n-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int t = Math.min(w1.length(),w2.length());
            boolean find = false;
            for (int j =0;j<t;j++){
                if (w1.charAt(j)!=w2.charAt(j)){
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);

                    grap.get(c1).add(c2);
                    degree[c2-'a']++; // 记录入队次数
                    find = true;
                    break;
                }
            }
//            前一部分相等，并且前面长度大于后面，直接返回空
            if (!find&& w1.length()>w2.length()){
                return "";
            }
        }
//出队
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for (int i =0;i<26;i++){
//            入度为0的字符，入队
            if (degree[i]==0 && grap.containsKey((char)(i+'a'))){
                queue.offer(i);
            }
        }

//        出队
        while (!queue.isEmpty()){
            int pos = queue.poll();
            char c = (char) (pos+'a');
            sb.append(c);
            if (!grap.containsKey(c)){
                return "";
            }
            for (Character next:grap.get(c)){
                degree[next-'a']--;
                if (degree[next-'a']==0){
                    queue.offer(next-'a');
                }
            }
        }
        return sb.length()<grap.size()?"":sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
