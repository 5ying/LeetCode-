//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 cos
//ts 来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。 
//
// 请计算出粉刷完所有房子最少的花费成本。 
//
// 
//
// 示例 1： 
//
// 
//输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
//输出: 10
//解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
// 
//
// 示例 2： 
//
// 
//输入: costs = [[7,6,2]]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// costs.length == n 
// costs[i].length == 3 
// 1 <= n <= 100 
// 1 <= costs[i][j] <= 20 
// 
//
// 
//
// 注意：本题与主站 256 题相同：https://leetcode-cn.com/problems/paint-house/ 
// Related Topics 数组 动态规划 
// 👍 115 👎 0

package leetcode.editor.cn;
//Java：粉刷房子
 class P剑指OfferII091JEj789{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII091JEj789().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] cs) {
            int n = cs.length;
            int a = cs[0][0], b = cs[0][1], c = cs[0][2];
            for (int i = 1; i < n; i++) {
                int d = Math.min(b, c) + cs[i][0];
                int e = Math.min(a, c) + cs[i][1];
                int f = Math.min(a, b) + cs[i][2];
                a = d; b = e; c = f;
            }
            return Math.min(a, Math.min(b, c));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
