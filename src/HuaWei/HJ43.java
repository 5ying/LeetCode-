package HuaWei;/*
 *文件名: HJ43
 *创建者: wwy
 *创建时间:2022/3/5 21:20
 *描述: 迷宫问题
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//刚看了动态规划的 不同路径 和 不同路径II 寻思这个题目也是用动态规划解决，
//但是 不是的，用到的是深度有限搜索：寻找路径，加上回溯的方法
public class HJ43 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int [][] map = new int[n][m];
            for (int i = 0;i<n;i++){
                for (int j =0;j<m;j++){
                    map[i][j] = sc.nextInt();
                }
            }
//            路径存储的数组
            List<Pos> path = new ArrayList<>();
            dfs(map,0,0,path);
            for (Pos test:path){
                System.out.println("(" + test.x + "," + test.y + ")");
            }

        }
    }

    public static boolean dfs(int[][] map,int x,int y,List<Pos> path){
//        添加路径,并标记已走!
        path.add(new Pos(x,y));
        map[x][y]=1;

//        结束条件:走到出口了
        if(x==map.length-1 && y ==map[0].length-1 ){
            return true;
        }

//        向下能走时
        if (x+1<map.length && map[x+1][y]==0){
            if(dfs(map,x+1,y,path)){
                return true;
            }
        }
//        向左
        if (y-1>-1 && map[x][y-1]==0){
            if(dfs(map,x,y-1,path)){
                return true;
            }
        }
//        向右
        if (y+1<map[0].length && map[x][y+1]==0){
            if(dfs(map,x,y+1,path)){
                return true;
            }
        }
//        向上
        if (x-1>-1 && map[x-1][y]==0){
            if(dfs(map,x-1,y,path)){
                return true;
            }
        }
        path.remove(path.size()-1);
        map[x][y]=0;
        return false;
    }

    public static class Pos{
        int x;
        int y;
        public Pos(int x,int y){
            this.x =x;
            this.y=y;
        }


    }

}
