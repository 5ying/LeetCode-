//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 
// 👍 999 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合
class P77Combinations{
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n==0 || k==0){
            return ans;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n+1];
        dfs(n,k,0,1,used,path,ans);
        return ans;

    }
    public  void dfs(int n,int k,int len,int begin,boolean[] used,List<Integer> path,List<List<Integer>> ans){
        if(len==k){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i=begin;i<=n - (k - path.size()) + 1;i++){
//            需要一个剪枝操作
                path.add(i);
                used[i] = true;

                dfs(n,k,len+1,i+1,used,path,ans);
                used[i] =false;
                path.remove(path.size()-1);


        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
