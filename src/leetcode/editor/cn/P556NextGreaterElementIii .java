//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 数学 双指针 字符串 
// 👍 263 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：下一个更大元素 III
 //  2022-07-03 20:29:04	获取当前时间
 class P556NextGreaterElementIii{
    public static void main(String[] args) {
        Solution solution = new P556NextGreaterElementIii().new Solution();
        // TO TEST
        System.out.println(solution.nextGreaterElement(2147483486));
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[len];
        dfs(n,len,str,visited,list,path);
        long ans = Long.MAX_VALUE;
        if(!list.isEmpty()){
            for (List<Integer> ll:list){
                StringBuffer sb = new StringBuffer();
                for (Integer ii :ll){
                    sb.append(ii);
                }
                if (Long.valueOf(sb.toString())<ans){
                    ans = Long.valueOf(sb.toString());
                }
            }
            return ans>Integer.MAX_VALUE?-1:(int)ans;
        }else {
            return -1;
        }



    }

    public void dfs(int n,int len,String str,boolean[] visited,List<List<Integer>> list,List<Integer> path){
        if (path.size()==len){
            StringBuffer sb = new StringBuffer();
            for (Integer ii : path){
                sb.append(ii);
            }
            if (Integer.valueOf(sb.toString())>n){
                list.add(new ArrayList<>(path));
                return;
            }else {
                return;
            }
        }

        for (int i =0;i<len;i++){
//            if (i>0&& str.charAt(i)==str.charAt(i-1)){
//                continue;
//            }
            if(!visited[i]){
                path.add(Integer.parseInt(str.charAt(i)+""));
                visited[i]=true;
                dfs(n,len,str,visited,list,path);
                visited[i]=false;
                path.remove(path.size()-1);

            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
