//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。 
//
// 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。 
//
// 
//
// 示例 1： 
//
// 
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 
//输入: equation = "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 
//输入: equation = "2x=x"
//输出: "x=0"
// 
//
// 
//
// 提示: 
//
// 
// 3 <= equation.length <= 1000 
// equation 只有一个 '='. 
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 151 👎 0

package leetcode.editor.cn;
//Java：求解方程
 //  2022-08-10 16:12:51	获取当前时间
class P640SolveTheEquation{
    public static void main(String[] args) {
        Solution solution = new P640SolveTheEquation().new Solution();
        // TO TEST
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String solveEquation(String equation) {
       int factor =0;
       int val =0;
       int index =0;
       int n =equation.length();
       int signl =1;
       while (index<n){
           if (equation.charAt(index)=='='){
               signl = -1;
               index++;
               continue;
           }

           int sign2 = signl;
           int number = 0;
           boolean vaild = false;
           if (equation.charAt(index)=='-' || equation.charAt(index)=='+'){
               sign2 = (equation.charAt(index)=='-')?-signl:signl;
               index++;
           }
           while (index<n && Character.isDigit(equation.charAt(index))){
               number = number * 10+ (equation.charAt(index)-'0');
               index++;
               vaild = true;
           }

           if (index<n&& equation.charAt(index)=='x'){
               factor +=vaild?sign2*number :sign2;
               index++;
           }else {
               val += sign2*number;
           }

       }

       if (factor==0){
           return val ==0?  "Infinite solutions" : "No solution";
       }
       return "x=" + (-val/factor);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
