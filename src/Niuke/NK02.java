package Niuke;/*
 *文件名: NK02
 *创建者: wwy
 *创建时间:2022/7/5 10:45
 *描述:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NK02 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] mu = new int[n];
        for (int i =0;i<n;i++){
            mu[i] = sc.nextInt();
        }
        Arrays.sort(mu);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n,0,mu,list,path);
        for (List l:list){
            System.out.println(l);
        }
        System.out.println(list.size());

    }
    public  static void dfs(int n,int start,int[] mu, List<List<Integer>> list,List<Integer> path){
        if (path.size()==3){
            if (path.get(0)+path.get(1)>path.get(2)&&path.get(0)-path.get(1)<path.get(2)){
                list.add(new ArrayList<>(path));
                return;
            }else {
                return;
            }
        }

        for(int i=start;i<n-(3-path.size())+1;i++){
            path.add(mu[i]);
            dfs(n,i+1,mu,list,path);
            path.remove(path.size()-1);
        }
    }
}
