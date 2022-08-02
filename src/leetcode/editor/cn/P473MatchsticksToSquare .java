//你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能
//折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。 
//
// 如果你能使这个正方形，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: matchsticks = [1,1,2,2,2]
//输出: true
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: matchsticks = [3,3,3,3,4]
//输出: false
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 108 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 
// 👍 301 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：火柴拼正方形
 class P473MatchsticksToSquare{
    public static void main(String[] args) {
        Solution solution = new P473MatchsticksToSquare().new Solution();
//        solution.makesquare(new int[]{1,1,2,2,2,2});
        boolean flag = solution.makesquare(new int[]{3,3,3,3,4});
        System.out.println(flag);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//
////        回溯
//    public boolean makesquare(int[] matchsticks) {
//        int totalLen = Arrays.stream(matchsticks).sum();
//        if (totalLen%4!=0){
//            return false;
//        }
//        Arrays.sort(matchsticks);
//        for(int i =0,j = matchsticks.length-1;i<j;i++,j--){
//            int temp = matchsticks[i];
//            matchsticks[i] = matchsticks[j];
//            matchsticks[j] = temp;
//        }
//        int[] edages = new int[4];  //四条边
//        return dfs(0,matchsticks,edages,totalLen/4);
//
//    }
//
//    public boolean dfs(int index,int[] matchsticks,int[] edges,int len){
////        这里的这个条件没看明白
//        if(index==matchsticks.length){
//            return  true;
//        }
//        for(int i = 0;i<edges.length;i++){
//            edges[i] +=matchsticks[index];
////            这个也没看明白
//            if (edges[i]<=len && dfs(index+1,matchsticks,edges,len)){
//                return true;
//            }
//
//            edges[i] -=matchsticks[i];
//        }
//        return false;
//    }
//
//
//}
  class Solution {
//        int[] ms;
//        int t;
//        public boolean makesquare(int[] _ms) {
//            ms = _ms;
//            int sum = 0;
//            for (int i : ms) sum += i;
//            t = sum / 4;
//            if (t * 4 != sum) return false;
//            Arrays.sort(ms);
//            return dfs(ms.length - 1, new int[4]);
//        }
//        boolean dfs(int idx, int[] cur) {
//            if (idx == -1) {
//                boolean ok = true;
//                for (int i : cur) {
//                    if (i != t) ok = false;
//                }
//                return ok;
//            }
//            for (int i = 0; i < 4; i++) {
//                int u = ms[idx];
//                if (cur[i] + u > t) continue;
//                cur[i] += u;
//                if (dfs(idx - 1, cur)) return true;
//                cur[i] -= u;
//            }
//            return false;
//        }


//        新解答
        public boolean makesquare(int[] ms) {
            int len = ms.length;
            int sum = Arrays.stream(ms).sum();
            if(sum %4!=0){
                return false;
            }
            Arrays.sort(ms);
            int target = sum /4;
            int[] bucket = new int[4];
            return dfs(ms,len-1,bucket,target);


        }

        public boolean dfs(int[] ms,int index,int[] bucket,int target){
            if(index<0){
                return true;
            }

            for (int i=0;i<4;i++){

                if(i>0&& bucket[i]==bucket[i-1]){
                    continue;
                }
                if (bucket[i]+ms[index]>target){
                    continue;
                }

                    bucket[i] +=ms[index];
                    if (dfs(ms,index-1,bucket,target)){
                        return true;
                    }
                    bucket[i] -= ms[index];
                }
            return false;
        }
 }

//leetcode submit region end(Prohibit modification and deletion)

}
