//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 751 👎 0

package leetcode.editor.cn;

//Java：螺旋矩阵 II
 //  2022-07-03 22:23:58	获取当前时间
 class P59SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top = 0;
        int bootem = n-1;
        int left = 0;
        int right = n-1;
        int nn = (int)Math.pow(n,2);
        int number =1;
        while (number<=nn){
            for (int i=left;i<=right;i++){

                ans[top][i] = number++;
            }
            if (++top>bootem){
                break;
            }
            for (int i=top;i<=bootem;i++){

                ans[i][right] = number++;
            }
            if (--right<left){
                break;
            }
            for (int i =right;i>=left;i--){

                ans[bootem][i] = number++;
            }
            if (--bootem<top){
                break;
            }
            for (int i =bootem;i<=top;i--){

                ans[i][left] = number++;
            }
            if (--left<right){
                break;
            }
        }
//        return list;
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
