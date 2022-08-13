package a1010;/*
 *文件名: TS0806
 *创建者: wwy
 *创建时间:2022/8/6 11:16
 *描述:
 */

public class TS0806 {
    public static void main(String[] args) {
        boolean s = sss(new int[]{2,5,6,5},new int[]{5,4,2,2},8);
        System.out.println(s);
    }
    public static boolean sss(int[] a,int[] b,int s){
        int[] dp = new int[s+1];
        for (int i=0;i<a.length;i++){
            if (dp[a[i]]==0){
                dp[a[i]]=1;
            } else if (dp[b[i]]==0){
                dp[b[i]]=1;
            }else {
                return false;
            }
        }
        return true;
    }
}
