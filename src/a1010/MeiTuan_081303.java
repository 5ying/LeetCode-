package a1010;/*
 *文件名: Test03
 *创建者: wwy
 *创建时间:2022/8/13 17:44
 *描述: 扑克  根据操作后的牌堆序列 推断出 原来的牌堆序列
 解题思路： 双端队列

 */

import java.util.Scanner;

public class MeiTuan_081303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] intL = new int[n];
        int[] res = new int[n];
        for (int i =0;i<n;i++){
            intL[i] = sc.nextInt();
        }


        boolean[] intB = new boolean[n];
        int num = 0;
        int tmp = 1;
        int index = 0;
        while (index<n){
            for (int i =0;i<n;i++){
                if (tmp %3==0 && !intB[i]){
                    intB[i] = true;
                    res[i] = intL[index++];
                }
                else if (intB[i]){
                    continue;
                }
                tmp++;
            }
        }

        for (Integer i :res){
            System.out.println(i+" ");
        }
    }

}
