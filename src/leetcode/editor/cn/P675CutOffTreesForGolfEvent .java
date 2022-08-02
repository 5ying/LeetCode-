//你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中： 
//
// 
// 0 表示障碍，无法触碰 
// 1 表示地面，可以行走 
// 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度 
// 
//
// 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。 
//
// 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。 
//
// 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。 
//
// 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。 
//
// 
//
// 示例 1： 
//
// 
//输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
//输出：6
//解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。 
//
// 示例 2： 
//
// 
//输入：forest = [[1,2,3],[0,0,0],[7,6,5]]
//输出：-1
//解释：由于中间一行被障碍阻塞，无法访问最下面一行中的树。
// 
//
// 示例 3： 
//
// 
//输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
//输出：6
//解释：可以按与示例 1 相同的路径来砍掉所有的树。
//(0,0) 位置的树，可以直接砍去，不用算步数。
// 
//
// 
//
// 提示： 
//
// 
// m == forest.length 
// n == forest[i].length 
// 1 <= m, n <= 50 
// 0 <= forest[i][j] <= 109 
// 
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 
// 👍 127 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

//Java：为高尔夫比赛砍树
 class P675CutOffTreesForGolfEvent{
    public static void main(String[] args) {
        Solution solution = new P675CutOffTreesForGolfEvent().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int N = 50;
        int[][] g = new int[N][N];
        int n,m;
        List<int[]> list = new ArrayList<>();
        public int cutOffTree(List<List<Integer>> forest) {
            n = forest.size(); // 行
            m = forest.get(0).size(); // 列
            for (int i =0;i<n;i++){
                for (int j=0;j<m;j++){
                    g[i][j] = forest.get(i).get(j); // 将数据转存为矩阵
                    if (g[i][j]>1){
                        list.add(new int[]{g[i][j],i,j}); // 将可以被砍的树的信息进行存储
                    }
                }
            }
//            砍树是按照树的高度升序的顺序进行排队的
            Collections.sort(list,(a,b)->a[0]-b[0]); // 按照树的高度进行升序排序
//            起点为0.表明无法进行砍树操作
            if (g[0][0]==0){
                return -1;
            }
//            起始点
            int x =0;
            int y =0;
//            砍树步数
            int ans = 0;
            for (int[] ne : list){
//              当前树中最矮的树的位置
                int nx = ne[1];
                int ny = ne[2];
//                从当前位置到最矮树的位置走的距离
                int d = bfs(x,y,nx,ny);
//                只要出现一次-1.就说明无法砍完所有的树
                if (d==-1){
                    return -1;
                }
                ans +=d;
                x = nx;
                y = ny;
            }
            return ans;
    }


//    BFS
//    基于本题目的其他逻辑不用管，本部分主要是实现广度优先遍历
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int bfs(int X,int Y,int P,int Q){
//        找到目标树，直接返回0
            if (X==P &&Y==Q){
                return 0;
            }
//            记录当前树是否被访问过
            boolean[][] vis = new boolean[n][m];
            Deque<int[] > deque = new ArrayDeque<>();
            deque.addLast(new int[]{X,Y});  //添加的是 可以被砍伐的树的坐标
            vis[X][Y] = true;
            int level = 0;
            while (!deque.isEmpty()){
                int size = deque.size();
                while (size-->0){
                    int[] info = deque.pollFirst();
                    int x = info[0];
                    int y = info[1];
//                    查找当前节点的四个邻位
                    for (int[] di :dirs){
                        int nx = x+di[0];
                        int ny = y+di[1];
//                      节点范围超出边界
                        if (nx<0 || nx>n || ny<0 || ny>m){
                            continue;
                        }
//                        当前节点为0（当前路径不可通过）或者节点无效
                        if (g[nx][ny]==0 || vis[nx][ny]){
                            continue;
                        }
//                        找到目标节点
                        if (nx==P && ny==Q){
                            return level+1;
                        }
                        deque.addLast(new int[]{nx,ny});
                        vis[nx][ny] = true;
                    }
                }
                level++;
            }
            return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
