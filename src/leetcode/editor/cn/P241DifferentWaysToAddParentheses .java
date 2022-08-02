//给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。 
//
// 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。 
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20 
// expression 由数字和算符 '+'、'-' 和 '*' 组成。 
// 输入表达式中的所有整数值在范围 [0, 99] 
// 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 
// 👍 640 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：为运算表达式设计优先级
 //  2022-07-01 13:25:49	获取当前时间
class P241DifferentWaysToAddParentheses{
    public static void main(String[] args) {
        Solution solution = new P241DifferentWaysToAddParentheses().new Solution();
        // TO TEST
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        char[] cs;
    public List<Integer> diffWaysToCompute(String expression) {
        cs = expression.toCharArray();
        return dfs(0,cs.length-1);
    }

    public  List<Integer> dfs(int l,int r){
        List<Integer> ans = new ArrayList<>();
        for (int i=l;i<=r;i++){
            if (cs[i]>='0' && cs[i]<='9'){
                continue;
            }
            List<Integer> l1 = dfs(l,i-1);
            List<Integer> l2 = dfs(i+1,r);
            for (int a:l1){
                for (int b:l2){
                    int cur =0;
                    if (cs[i]=='+'){
                        cur = a+b;
                    }else if(cs[i]=='-'){
                        cur = a-b;
                    }else{
                        cur = a*b;
                    }
                    ans.add(cur);
                }
            }
        }
        if(ans.isEmpty()){
            int cur =0;
            for (int i=l;i<=r;i++){
                cur = cur*10+(cs[i]-'0');

            }
            ans.add(cur);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
