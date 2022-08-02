package a1010;/*
 *文件名: TS07
 *创建者: wwy
 *创建时间:2022/4/14 19:33
 *描述:
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TS07 {
    public static void main(String args[]) {

//         输入：
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
//        字符串转数组
        int[] a = new int[str.length()];
        for (int i =0;i<a.length;i++){
            a[i] = str.charAt(i)-'0';
        }
//        判断子序列是否是9的倍数
        double countt = getSub(a,a.length)%(Math.pow(10,9)+7);
        int count = (int) countt;

        System.out.println(count);
    }

    private static int getSub(int[] arr, int length) {
        int mark = 0;
        int count =0 ; // 记录最后结果
        int nEnd = 1 << length;
        boolean bNullset = false;
        int flag = 0;
        for (mark = 0; mark < nEnd; mark++) {
            ArrayList<Integer> aList = new ArrayList<>();
            String str = "";
            bNullset = true;
            for (int i = 0; i < length; i++) {
                if (((1 << i) & mark) != 0) {
                    bNullset = false;
                    str += arr[i]+"";
                    flag ++;
                }
            }
            if (flag!=0){
                int temp = Integer.parseInt(str);
                if (temp%9==0){
                    count ++;
                }
            }
        }
        return count;
    }
}
