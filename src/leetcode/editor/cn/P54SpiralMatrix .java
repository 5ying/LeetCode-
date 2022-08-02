//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 1130 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：螺旋矩阵
 //  2022-07-03 22:10:51	获取当前时间
 class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int bootem = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (true){
            for (int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            if (++top>bootem){
                break;
            }
            for (int i=top;i<=bootem;i++){
                list.add(matrix[i][right]);
            }
            if (--right<left){
                break;
            }
            for (int i =right;i>=left;--i){
                list.add(matrix[bootem][i]);
            }
            if (--bootem<top){
                break;
            }
            for (int i =bootem;i>=top;--i){
                list.add(matrix[i][left]);
            }
            if (++left>right){
                break;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
