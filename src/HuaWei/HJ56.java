package HuaWei;/*
 *文件名: HJ56
 *创建者: wwy
 *创建时间:2022/3/5 11:39
 *描述:完全数计算
 */

import java.util.Scanner;

public class HJ56 {
    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            if(N< 6){
                System.out.println(0);
                continue;
            }

            int count =0;

             for (int i =6;i<=N;i++){
                 int res = 0;

                 for (int j =1;j<=i/2;j++){
                     if(i%j==0){
                         res = res+j;
                     }

                 }
                 if(res == i){
                     count++;
                 }

             }
                System.out.println(count);
        }
         */

//        不同路径
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] dp = new int[m][n];

//        for (int i =0;i<m;i++){
////            dp[i][0] = 1;
////        }
////        for (int j = 0;j<n;j++){
////            dp[0][j] =1;
////        }
////
////        for (int i =1;i<m;i++){
////            for (int j =1;j<n;j++){
////                dp[i][j] = dp[i][j-1]+dp[i-1][j];
////            }
////        }
////        System.out.println(dp[m-1][n-1]);

//        不同路径II

    }
}
