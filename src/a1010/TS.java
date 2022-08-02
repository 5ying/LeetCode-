package a1010;/*
 *文件名: TS
 *创建者: wwy
 *创建时间:2022/4/6 19:18
 *描述:
 */

import java.util.*;

public class TS {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int l=Integer.parseInt(sc.nextLine());
        int n=Integer.parseInt(sc.nextLine());
        String input=sc.nextLine();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(input.split(",")[i]);
        }
        int result=getResult(l,n,arr);
        System.out.println(result);
    }

    public static int getResult(int l,int n,int[] arr){
        int res = 0;
        //求每个深度对应的最大宽度就可以了
        //当宽度满足要求时，最大深度的相反数就为可以放的最多的物品
        for(int i=0;i<arr.length;i++){
            int w=1;
            for(int k=i-1;k>=0;k--){
                if(arr[k]<=arr[i]){
                    w++;
                }
            }
            for(int k=i+1;k<arr.length;k++){
                if(arr[k]<=arr[i]){
                    w++;
                }
            }
            //和接雨水关键的不同就在于这一步，这个负深度就很巧妙，完美避开了正深度
            if(w>=l){
                res=Math.max(res,-arr[i]);
            }
        }
        return res;
    }
}