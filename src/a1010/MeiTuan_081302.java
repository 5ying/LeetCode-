package a1010;/*
 *文件名: Test00
 *创建者: wwy
 *创建时间:2022/8/13 17:31
 *描述: 扫地机器人
  解题思路：模拟
 */

import java.util.Scanner;

public class MeiTuan_081302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] room = new int[n][m];
        String str = sc.nextLine();
        room[0][0] =1;

        int x=0;
        int y =0;
        int num =0;
        int index =0;
        for (Character s:str.toCharArray()){
            if (s=='S'){
                ++x;
                if (room[x][y]==0){
                    num++;
                }
                room[x][y]=1;
            }else if (s=='D'){
                ++y;
                if (room[x][y]==0){
                    num++;
                }
                room[x][y]=1;
            }else if (s=='W'){
                --x;
                if (room[x][y]==0){
                    num++;
                }
                room[x][y]=1;
            } else if (s=='A'){
                --y;
                if (room[x][y]==0){
                    num++;
                }
                room[x][y]=1;
            }
            if (num ==  n*m){
                break;
            }
            index++;
        }
        if (num == n*m){
            System.out.println("YES");
            System.out.println(index+1);
        }else {
            System.out.println("NO");
            System.out.println(n*m-num);
        }
    }
}
