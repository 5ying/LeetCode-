package a1010;/*
 *文件名: TS0813
 *创建者: wwy
 *创建时间:2022/8/13 15:46
 *描述:  送外卖的魔法师
 */

import java.util.Scanner;

public class MeiTuan_081301 {



//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int t = sc.nextInt();
//        int[] take = new int[n];
//        for (int i=0;i<n;i++){
//            take[i] = sc.nextInt();
//        }
//        Arrays.sort(take);
//        int ans =0;
//        int time =0;
//        for (int i =0;i<n;i++){
//            time += t;
//            if (time<=take[i]){
//                continue;
//            }else {
//                ans++;
//                time -= t;
//            }
//        }
//        System.out.println(ans);
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int ans =0;
        if (n<3){
            System.out.println(0);
            return;
        }

        for (int i =0;i<n;i++){
            for (int j =i+1;j<n;j++){
                for (int k =j+1;k<n;k++){
                    if (a[i]-a[j]==2*a[j]-a[k]){
                        ans +=1;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
