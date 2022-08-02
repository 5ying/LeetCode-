package HuaWei;/*
 *文件名: HJ35
 *创建者: wwy
 *创建时间:2022/3/5 10:28
 *描述:蛇形矩阵
 */

import java.util.Scanner;

public class HJ35 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        while (sc.hasNext()){
//            int N = sc.nextInt();
//            int[][] aa = new int[N+1][N+1];
//            aa[0][0]=1;
//            for (int i =0;i<N-1;i++){
//                for (int j =i;j<N;j++){
//                    aa[i][j+1] = aa[i][j]+j+2+i;
//                }
//                aa[i+1][0]=aa[i][0]+i+1;
//            }
//
//            for (int i =0;i<N-1;i++){
//                for (int j =0;j<N-1;j++){
//                   System.out.print(aa[i][j]);
//                }
//                System.out.println();
//            }
//
//        }

        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();    //读入正整数n

            int[][] result = new int[n][];    //建立数组（n行）
            int t = 1;    //记录依次赋予的数组值
            for(int i=0; i < n; i++){
                result[i] = new int[n-i];    //数组第i行有n-i个元素
                for(int j=0; j < i+1; j++){    //对第i个对角线赋值
                    result[i-j][j] = t;
                    t++;
                }
            }

            //输出数组值
            for(int[] a : result){
                for(int a1 : a)
                    System.out.print(a1 + " ");
                System.out.println();
            }
        }
    }
}
