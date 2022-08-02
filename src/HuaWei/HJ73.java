package HuaWei;/*
 *文件名: HJ73
 *创建者: wwy
 *创建时间:2022/3/8 10:15
 *描述:
 */

import java.util.Scanner;

public class HJ73 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.split(" ");
        int[] a = {31,29,31,30,31,30,31,31,30,31,30,31};
        int[] b = {31,28,31,30,31,30,31,31,30,31,30,31};
        int days = 0;
        int year = Integer.parseInt(ss[0]);
        int mon = Integer.parseInt(ss[1]);
        int day = Integer.parseInt(ss[2]);
        if((year%4==0&&year%100!=0)||(year%400==0)){
            for (int i =0;i<mon-1;i++){
                days = days+a[i];
            }
        }else{
            for (int i =0;i<mon-1;i++){
                days = days+b[i];
            }
        }

        days = days+day;
        System.out.println(days);
    }
}
