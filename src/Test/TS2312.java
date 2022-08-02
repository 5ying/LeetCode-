package Test;/*
 *文件名: TS2312
 *创建者: wwy
 *创建时间:2022/6/21 15:07
 *描述: 卖木头块

 使用动态规划进行解决
 */

public class TS2312 {
    public static void main(String[] args) {

    }
    public long sellingWood(int m, int n, int[][] prices) {
//        记录直接卖掉的收益
        int[][] pr = new int[m+1][n+1];
        for (int[] p:prices){
            pr[p[0]][p[1]] = p[2];
        }
//        记录最大收益
        long[][] f = new long[m+1][n+1];

        for (int i =1;i<=m;i++){
            for (int j =1;j<=n;j++){
//                不切割直接卖
                f[i][j] = pr[i][j];
                for (int k =1;k<=i-1;k++){  //横着切
                    f[i][j] = Math.max(f[i][j],f[k][j]+f[i-k][j]);
                }
                for (int k=1;k<=j-1;k++){ // 竖着切
                    f[i][j] = Math.max(f[i][j],f[i][k]+f[i][j-k]);
                }
            }
        }
        return f[m][n];
    }
}
