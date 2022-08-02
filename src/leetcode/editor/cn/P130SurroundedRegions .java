//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
//,"X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 810 👎 0

package leetcode.editor.cn;

//Java：被围绕的区域
 class P130SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    * 思路：先把边界上的O用-符号标记，然后再遍历数组将，数组中为O的变为X，将-变回o*/
class Solution {
//        private int[][] birections = {{1,0},{0,1},{-1,0},{0,-1}};
//        private int row;
//        private int col;
//        private boolean[][] visited;
//    public void solve(char[][] board) {
//        row = board.length;
//        if (row==0){
//            return;
//        }
//        col = board[0].length;
//        visited = new boolean[row][col];
//        for (int i =0;i<row;i++){
//            for (int j = 0;j<col;j++){
//                if (!visited[i][j] && board[i][j]=='O'){
//                    dfs(i,j,board);
//                }
//            }
//        }
//        return;
//    }
//
//    public void dfs(int x,int y,char[][] board){
//        visited[x][y]=true;
//        board[x][y] = 'X';
//        for (int k=0;k<4;k++){
//            int newx = x+birections[k][0];
//            int newy = y+birections[k][1];
//
//            if (inArea(newx,newy) && board[newx][newy]=='O' && !visited[newx][newy]){
//                board[newx][newy] = 'X';
//                dfs(newx,newy,board);
//            }
//        }
//    }
//
//    public boolean inArea(int x,int y){
//        return  x>0 && x<row-1 && y>0 && y<col-1;
//    }
        private int[][] birections = {{1,0},{0,1},{-1,0},{0,-1}};
        int n, m;
        private boolean[][] visited;

        public void solve(char[][] board) {
            n = board.length;
            if (n == 0) {
                return;
            }
            m = board[0].length;
            visited = new boolean[n][m];

//           循环两个列边界
            for (int i = 0; i < n; i++) {
                dfs(board, i, 0);
                dfs(board, i, m - 1);
            }
//           循环两个行边界
            for (int i = 1; i < m - 1; i++) {
                dfs(board, 0, i);
                dfs(board, n - 1, i);
            }
//            再遍历一遍修改最终结果
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

//        深度搜索将边界上的O 变成A
        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'A';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }

//        public void dfs(char[][] board,int x,int y){
//        visited[x][y]=true;
//        if(inArea(x,y) && board[x][y]=='O'){
//            board[x][y] ='A';
//
//            for (int k=0;k<4;k++){
//                int newx = x+birections[k][0];
//                int newy = y+birections[k][1];
//                if (inArea(newx,newy) && board[newx][newy]=='O' && !visited[newx][newy]){
//  //                  board[newx][newy] = 'A';
//                    dfs(board,newx,newy);
//                }
//            }
//        }
//
//    }
//
//    public boolean inArea(int x,int y){
//        return  x>=0 && x<n && y>=0 && y<m;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
