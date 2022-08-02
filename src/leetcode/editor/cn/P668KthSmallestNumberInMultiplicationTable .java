//几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？ 
//
// 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。 
//
// 例 1： 
//
// 
//输入: m = 3, n = 3, k = 5
//输出: 3
//解释: 
//乘法表:
//1	2	3
//2	4	6
//3	6	9
//
//第5小的数字是 3 (1, 2, 2, 3, 3).
// 
//
// 例 2： 
//
// 
//输入: m = 2, n = 3, k = 6
//输出: 6
//解释: 
//乘法表:
//1	2	3
//2	4	6
//
//第6小的数字是 6 (1, 2, 2, 3, 4, 6).
// 
//
// 注意： 
//
// 
// m 和 n 的范围在 [1, 30000] 之间。 
// k 的范围在 [1, m * n] 之间。 
// 
// Related Topics 数学 二分查找 
// 👍 320 👎 0

package leetcode.editor.cn;
//Java：乘法表中第k小的数
 class P668KthSmallestNumberInMultiplicationTable{
    public static void main(String[] args) {
        Solution solution = new P668KthSmallestNumberInMultiplicationTable().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left =1;
        int right = n*m;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if (check(n,m,k,mid)){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return  left;
    }

    public boolean check(int n,int m,int k,int mid){
        int cnt =0;
        int i=n;
        int j = 1;
        while (i>=1 && j <=m){
            if (i*j <=mid){
                cnt += i;
                j++;
            }else {
                i--;
            }
        }
        return cnt>=k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
