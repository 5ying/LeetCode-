//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1751 👎 0

package leetcode.editor.cn;
//Java：岛屿数量
 class P200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private  final int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        private  boolean[][] visited;
        private int row;
        private int col;
        private char[][] grid;
    public int numIslands(char[][] grid) {
        row = grid.length;
        if (row==0){
            return 0;
        }
        col = grid[0].length;

        this.grid = grid;
        visited = new boolean[row][col];
        int count =0;
        for (int i=0;i<row;i++){
            for (int j =0;j<col;j++){
                if (!visited[i][j] && grid[i][j]== '1'){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }

//    网格dfs的模板写法
    public void dfs(int x,int y){

        visited[x][y] = true;
        for (int k=0;k<4;k++){
            int newX = x+directions[k][0];
            int newY = y+directions[k][1];

//            若当前节点超出节点范围，就不进行操作
            if (inArea(newX,newY) && grid[newX][newY]=='1' && !visited[newX][newY]){
                dfs(newX,newY);
            }
        }
    }

//    判断当前节点是否合法
    public boolean inArea(int x,int y){

        return x>=0&& x<row && y>=0 && y<col;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
