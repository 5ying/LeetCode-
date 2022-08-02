//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[3,2],[1,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？ 
// Related Topics 数组 二分查找 矩阵 
// 👍 98 👎 0

package leetcode.editor.cn;
//Java：统计有序矩阵中的负数
 class P1351CountNegativeNumbersInASortedMatrix{
    public static void main(String[] args) {
        Solution solution = new P1351CountNegativeNumbersInASortedMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
// 简单的方法： 直接两层循环
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans=0;
        for (int i =0;i<n;i++){
            for (int j =0;j<m;j++){
                if (grid[i][j]<0){
                  ans+=1;
                }
            }
        }
        return ans;
    }

//    进阶版本 ： 双指针
        public int countNegatives1(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int ans = check(grid,n,m);
            return ans;
        }
        public int check(int[][] grid,int n,int m){
        int ans = 0;
        int i = n-1;
        int j = 0;
        while (i>=0 && j<m){
            if (grid[i][j]<0){
                ans += m-j ;
                i--;
            }
            else {
                j++;
            }
        }
        return ans;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
