//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 递归 数学 
// 👍 675 👎 0

package leetcode.editor.cn;

//Java：排列序列
 class P60PermutationSequence{
    public static void main(String[] args) {
        Solution solution = new P60PermutationSequence().new Solution();
        // TO TEST
        solution.caculationFactorial(3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


//       这个写的时候的思路是：全排列 然后输出第K个，会出现超时
        /*
    public String getPermutation(int n, int k) {
        if (n==0 || k==0 ){
            return "";
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n+1];
        dfs(n,0,0,k,used,path,ans);
        String s ="";
        for (Integer t : path){
            s = s+t.toString();
        }
        return s;

    }

    public void dfs(int n,int t,int len,int k,boolean[] used,List<Integer> path,List<List<Integer>> ans){
        if (t==n){
            len = len+1;
            if (len==k){
                return ;
            }
        }
        for (int i =1;i<=n;i++){
            if(!used[i]){
                path.add(i);
                used[i] = true;
                dfs(n,t+1,len,k,used,path,ans);
//                used[i] = false;
//                path.remove(path.size()-1);
                return;
            }
        }

    }

         */

/*
* 回溯搜索算法+剪枝，直接来到叶子节点*/
        private boolean[] used;
        private  int[] factorial;
        private int n;
        private  int k;
        public String getPermutation(int n, int k) {
            this.n = n;
            this.k = k;
            caculationFactorial(n);

            used = new boolean[n+1];
            StringBuilder path = new StringBuilder();
            dfs(0,path);
            return  path.toString();
        }

        public void dfs(int index, StringBuilder path){
            if (index==n){
                return;
            }
//            剪枝的时候有点意思：计算还未确定的数字的全排列的个数，第一次进入的是n-1
            int cnt = factorial[n-1-index];
            for (int i =1;i<=n;i++){
                if (used[i]){
                    continue;
                }
                if (cnt<k){
                    k -= cnt;
                    continue;
                }
                path.append(i);

                used[i] = true;
                dfs(index+1,path);
//                算法设计是一下来到叶子节点，因此没有回溯
//                直接返回
                return;
            }
        }

//        计算阶承数组
        public  void caculationFactorial(int n){
            factorial = new int[n+1];
            factorial[0]=1;
            for (int i=1;i<=n;i++){
                factorial[i] = factorial[i-1]*i;
            }
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
