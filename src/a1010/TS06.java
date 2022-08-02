package a1010;/*
 *文件名: TS06
 *创建者: wwy
 *创建时间:2022/4/14 19:27
 *描述:
 */

import java.util.Scanner;

public class TS06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] res = new char[4*n][4*n];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (j < n || j >= res[0].length - n){
                    if (i < res.length - n){
                        res[i][j] = '*';
                    }else {
                        res[i][j] = '.';
                    }
                }else {
                    res[i][j] = '.';
                }
            }
        }
        int N = n;
        for (int i = res.length - 1; i >= res.length - n; i--){
            if (i == res.length - 1){
                for (int k = n; k < res[0].length - n; k++){
                    res[i][k] = '*';
                }
                N--;
            }else {
                for (int j = N; j < N + n; j++) {
                    res[i][j] = '*';
                }
                for (int j = res[0].length - N - 1 ; j >= res[0].length - N - n; j--){
                    res[i][j] = '*';
                }
                N--;
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (j != res[0].length - 1){
                    System.out.print(res[i][j]);
                }else {
                    System.out.println(res[i][j]);
                }
            }
        }
    }
}
