package HuaWei;/*
 *文件名: HJ91
 *创建者: wwy
 *创建时间:2022/3/9 9:06
 *描述: 走方格的方案数

 分析:最简单的DP思想解决该问题
 */

import java.util.Scanner;

public class HJ91 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][]  dp= new int[n+1][m+1];
            for (int i =0;i<=n;i++){
                dp[i][0] = 1;
            }

            for (int j =0;j<=m;j++){
                dp[0][j] =1;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            System.out.println(dp[n][m-1]+dp[n-1][m]);
        }
        sc.close();
    }
}
