//爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。 
//
// 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。 
//
// 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。 
//
// 游戏一直持续到所有石子都被拿走。 
//
// 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [2,7,9,4,4]
//输出：10
//解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那
//么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
// 
//
// 示例 2: 
//
// 
//输入：piles = [1,2,3,4,5,100]
//输出：104
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 100 
// 1 <= piles[i] <= 104 
// 
// Related Topics 数组 数学 动态规划 博弈 
// 👍 133 👎 0

package leetcode.editor.cn;
//Java：石子游戏 II
 //  2022-07-04 10:35:19	获取当前时间
 class P1140StoneGameIi{
    public static void main(String[] args) {
        Solution solution = new P1140StoneGameIi().new Solution();
        // TO TEST
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp[i][j][0]表示 piles[i~end]，m=j先手获得的最大石头数量；
        // dp[i][j][1]表示 piles[i~end]，m=j后手获得的最大石头数量；
        int[][][] dp;
        public int stoneGameII(int[] piles) {
            if (piles.length == 1) {
                return piles[0];
            }
            dp = new int[piles.length][piles.length][2];
            return dfs(piles, 0, 1)[0];
        }

        public int[] dfs(int[] piles, int start, int m) {
            // 递归结束条件
            if (start == piles.length) {
                return new int[]{0, 0};
            }

            if (dp[start][m][0] != 0) {
                return dp[start][m];
            }
            int[] max = new int[]{0, 0};
            int sum = 0;
            // 循环先手可能的选择情况，找出最佳选择
            for (int x = 1; x <= 2*m; x++) {
                // 选前x堆石子, 以sum作前i堆石子的总数
                int index = start + x - 1;
                if (index >= piles.length) {
                    break;
                }
                sum += piles[index];
                // res[0]是下一轮先手者能获得的最大石子数: 即本轮后手者总体能获得的最大石子数 即 dp[i][j][1]
                // res[1]是下一轮后手者能获得的最大石子数: 即本轮先手者后续还能获得的最大石子数
                // sum是当前选择的石子数目, res[1] + sum就是 本轮先手者 总体能获得的最大石子数 即dp[i][j][0]
                int[] res = dfs(piles, start + x, Math.max(m, x));
                if (res[1] + sum > max[0]) {
                    max[0] = res[1] + sum;
                    max[1] = res[0];
                }
            }
            dp[start][m] = max;
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
