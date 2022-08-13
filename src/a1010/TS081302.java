package a1010;/*
 *文件名: TS081302
 *创建者: wwy
 *创建时间:2022/8/13 16:35
 *描述:
 */

import java.util.Scanner;

public class TS081302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] a = new int[n];
        for (int i =0;i<n;i++){
            a[i] = sc.nextInt();
        }
        if (n==1){
            System.out.println(a[0]);
            return;
        }
        int[] ans = new int[n];


    }

}
