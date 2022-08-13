package a1010;/*
 *文件名: TS081303
 *创建者: wwy
 *创建时间:2022/8/13 16:57
 *描述:
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TS081303 {

    class Point{
        int x;
        int y;
        public  Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] room = new int[n][m];
        String str = sc.nextLine();
        int ans_clear =1;
        int ans_notClear =0;

        Map<Point,Integer> map  = new HashMap<>();
        for (int i =0;i<n;i++){
            for (int j =0;j<m;j++){
                Point p  = new Point(i,j);
                map.put(p,map.getOrDefault(p,0));
            }
        }

        int n_i = 0;
        int m_i = 0;
        for (int i= 0;i<k;i++){

            if (str.charAt(i)=='S'){
                m_i = m_i +1;

            }
        }
    }
}
