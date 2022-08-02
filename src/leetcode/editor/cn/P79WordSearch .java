//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 1324 👎 0

package leetcode.editor.cn;
//Java：单词搜索
 class P79WordSearch{
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        private int row;
        private int col;
        private boolean[][] visited;
        private  char[][] grid;
        private  String str;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        if (row==0){
            return false;
        }
        col = board[0].length;
        grid = board;
        str = word;
        visited = new boolean[row][col];
        int index =0;
        boolean ok=true;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (!visited[i][j] && grid[i][j]==str.charAt(index)){
                     ok = dfs(i,j,index+1);
                     if (!ok){
                         return ok;
                     }
                }
            }
        }
        return ok;

    }
    public boolean dfs(int x,int y,int index){
        visited[x][y] =true;
        boolean ok = false;
        for (int k=0;k<4;k++){
            int newx = x+directions[k][0];
            int newy = y+directions[k][1];
            if (inArea(newx,newy) && grid[newx][newy]==str.charAt(index)&& !visited[newx][newy] &&index<str.length()){
                ok = true;
                   dfs(newx,newy,index+1);
                }
            }
        return  ok;
        }

    public boolean inArea(int x,int y){
        return  x>=0 && x<row && y>=0 && y<col;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
