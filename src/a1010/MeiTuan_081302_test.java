package a1010;/*
 *文件名: Test02
 *创建者: wwy
 *创建时间:2022/8/13 17:17
 *描述: 扫地机器人 另一种题解
 */

import java.util.Scanner;

public class MeiTuan_081302_test {
    private static String res = "No";
    private static int num =0;
    private static  int left = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] room = new int[n][m];
        String str = sc.nextLine();
        char[] chars = new char[k];
        boolean[][] used =  new boolean[n][m];
        dfs(used,0,0,str,0);
        System.out.println(res);
        if (res=="Yes"){
            System.out.println(num);
        }else {
            System.out.println(left);
        }


    }
    public  static void dfs(boolean[][] used,int i,int j,String str,int index){
        if (i<0||i>used.length || j<0 ||j>used[0].length){
            return;
        }
        used[i][j] = true;
        if (check(used)){
            res = "Yes";
            num =index;
            return;
        }
        if (index>=str.length()){
            return;
        }

        char ch = str.charAt(index);
        if (ch == 'W'){
            dfs(used,i-1,j,str,index+1);
        }else if (ch=='A'){
            dfs(used,i,j-1,str,index+1);
        }
        else if (ch=='S'){
            dfs(used,i+1,j,str,index+1);
        }else {
            dfs(used,i,j+1,str,index+1);
        }
    }

    private static boolean check(boolean[][] used){
        left =0;
        for (int i =0;i<used.length;i++){
            for (int j=0;j<used[0].length;j++){
                if (used[i][j]!=true){
                    left ++;
                }
            }
        }

        return  left==0?true:false;
    }
}
