package Test;/*
 *文件名: TS2305
 *创建者: wwy
 *创建时间:2022/6/13 17:33
 *描述: 公平发放饼干
 */

import java.util.Arrays;

//这个题目和 组合II 火柴拼正方形  有点像 回溯+递归
// 但又有一点不同
public class TS2305 {
    public static void main(String[] args) {

    }
    int ans = Integer.MAX_VALUE;
    int[] cookies;
    int n;
    int k;

    public int distributeCookies(int[] cookies, int k) {

//        排序
        Arrays.sort(cookies);
        this.cookies = cookies;
        n = cookies.length;
        this.k = k;

        dfs(new int[k],n-1);
        return ans;

    }
    public void dfs(int[] bucket,int start){
//        start <0 饼干分发完毕
        if (start<0){
            int curAns = Integer.MIN_VALUE;
            for (int count :bucket){
                curAns = Math.max(curAns,count);
            }

            ans = Math.min(ans, curAns);
            return;
        }

//        剪枝1:假如剩下的饼干 不够空手的小朋友分 直接返回
//        bucket 初始为0
        int zeroCount =0;
        for (int count : bucket){
            if (count == 0){
                zeroCount ++;
            }

            if (zeroCount>start+1){
                return;
            }
        }

//        剪枝2：如果某位小朋友的饼干数量比当前答案还多，就直接返回
        for (int i =0;i<k;i++){
            if (bucket[i]>ans)
                return;
        }

//        剪枝3:
        for (int i =0;i<k;i++){
            if ( i>0 && start==n-1){
                return;
            }
            bucket[i] += cookies[start];
            dfs(bucket,start-1);
            bucket[i] -= cookies[start]; //回溯
        }

        return;
    }

//    新的求解办法  我能可以自己写出来的
//        public int distributeCookies1(int[] cookies, int k) {
//        int len = cookies.length;
//        Arrays.sort(cookies);
//        int[] bucket = new int[k];
//
//        dsf1(cookies,len,bucket,k);
//        int temp = Integer.MIN_VALUE;
//        for (int cc :bucket){
//            temp = Math.max(cc,temp);
//        }
//        return temp;
//        }
//
//        public void dsf1(int[] cookies,int len,int[] bucket,int k){
//            if (len<0){
//                return;
//            }
//            for (int i=0;i<k;i++){
//                if (i>0 && bucket[i]==bucket[i-1]){
//                    continue;
//                }
//                if (bucket[i]+)
//            }
//
//        }

}
