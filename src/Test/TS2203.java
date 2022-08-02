package Test;/*
 *文件名: TS2203
 *创建者: wwy
 *创建时间:2022/6/13 17:02
 *描述: 计算应缴税款总额
 */

public class TS2203 {
    public static void main(String[] args) {
        double dd = calculateTax(new int[][]{{3,50},{7,10},{12,25}},10);
        System.out.println(dd);
    }

    public static double calculateTax(int[][] brackets, int income) {
        int len = brackets.length;
        double ans = 0;
        if (income==0){
            return ans;
        }
        int tenmp_ans = 0;
        for (int i =0;i<len;i++){
            if (income-brackets[i][0]<0){
                ans += (income-tenmp_ans)*1.0 * brackets[i][1]*1.0/100;
                return ans;
            }else {
                if (i==0){
                    ans  = ans+  brackets[i][0]*1.0*brackets[i][1]*1.0/100;
                    tenmp_ans += brackets[i][0];
                }else {
                    ans += (brackets[i][0]-brackets[i-1][0])*1.0*brackets[i][1]*1.0/100;
                    tenmp_ans += brackets[i][0]-brackets[i-1][0];
                }
            }
        }

        return ans;
    }
}
