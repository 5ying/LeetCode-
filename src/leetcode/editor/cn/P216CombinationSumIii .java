//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
// Related Topics 数组 回溯 
// 👍 498 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合总和 III
 //  2022-07-02 20:10:25	获取当前时间
class P216CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new P216CombinationSumIii().new Solution();
        // TO TEST
        System.out.println(solution.combinationSum3(9,45));
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> list ;
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] number = new int[]{1,2,3,4,5,6,7,8,9};
        List<Integer> path = new ArrayList<>();
        list = new ArrayList<>();
            dfs(n,k,0,number,path);

        return list;
    }
    public void dfs(int n,int k,int start,int[] number ,List<Integer> path){
        if (path.size()==k){
            if (path.stream().mapToInt(Integer::byteValue).sum()==n){
                list.add(new ArrayList<>(path));
                return;
            }else {
                return;
            }
        }

        for (int i=start;i<number.length;i++){
//            if(number.length-start<k){
//                break;
//            }
//            if(i>start && number[i]==number[i-1]){
//                continue;
//            }
            if (n-path.stream().mapToInt(Integer::intValue).sum()<0){
                return;
            }

            path.add(number[i]);
//            System.out.println(path);
            dfs(n,k,i+1,number,path);
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
