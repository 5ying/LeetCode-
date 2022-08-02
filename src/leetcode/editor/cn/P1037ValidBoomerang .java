//给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
// 
//
// 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,3],[3,2]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：false 
//
// 
//
// 提示： 
// 
//
// 
// points.length == 3 
// points[i].length == 2 
// 0 <= xi, yi <= 100 
// 
// Related Topics 几何 数组 数学 
// 👍 49 👎 0

package leetcode.editor.cn;
//Java：有效的回旋镖
 class P1037ValidBoomerang{
    public static void main(String[] args) {
        Solution solution = new P1037ValidBoomerang().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBoomerang(int[][] points) {

//        这个想法不对啊！！！
        for (int i=1;i<points.length;){
            if ((points[i][0]==points[i-1][0]) && (points[i][0]==points[i+1][0])){
                return false;
            }
            if (points[i][1]==points[i-1][1]&&points[i][1]==points[i+1][1]){
                return false;
            }
            if (points[i][0]==points[i][1] && points[i-1][0]==points[i-1][1] && points[i+1][0]==points[i+1][1]){
                return false;
            }


        }
        return true;
    }

//    就直接用数学公式 向量交叉乘积,简单快捷
    public boolean isBoomerang1(int[][] ps) {
        return (ps[1][0] - ps[0][0]) * (ps[2][1] - ps[0][1]) != (ps[2][0] - ps[0][0]) * (ps[1][1] - ps[0][1]);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
