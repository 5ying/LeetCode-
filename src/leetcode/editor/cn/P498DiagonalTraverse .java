//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 104 
// 1 <= m * n <= 104 
// -105 <= mat[i][j] <= 105 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 315 👎 0

package leetcode.editor.cn;
//Java：对角线遍历
 class P498DiagonalTraverse{
    public static void main(String[] args) {
        Solution solution = new P498DiagonalTraverse().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
        int m = mat[0].length;
        int cnt = n*m;
        int[] ans = new int[cnt];
        int x =0;
        int y =0;
        int dir = 1;
        int idx = 0;
        while(idx != cnt ){
            ans[idx++] = mat[x][y];
            int nx = x;
            int ny = y;
//            左上 右下
            if(dir== 1){
                nx = x-1;
                ny = y+1;
            }else {
                nx = x+1;
                ny = y-1;
            }
//            越界情况
            if (idx<cnt &&(nx<0 || nx>=n || ny<0||ny>=m)){
                if (dir == 1) {
                    nx = y + 1 < m ? x : x + 1;
                    ny = y + 1 < m ? y + 1 : y;
                } else {
                    nx = x + 1 < n ? x + 1 : x;
                    ny = x + 1 < n ? y : y + 1;
                }
                dir *= -1;
            }
            x = nx; y = ny;

            }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
