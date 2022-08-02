package HuaWei;/*
 *文件名: HJ15
 *创建者: wwy
 *创建时间:2022/3/3 10:56
 *描述:
 */

import java.util.Scanner;

public class HJ15 {
    public static void main(String[] a12rgs) {
        Scanner sc = new Scanner(System.in);
        int ii = sc.nextInt();
        int count =0;
        while (ii>=2){
            if(ii%2==1){
                count++;
            }
            ii = ii/2;
        }
        count = count+1;
        System.out.println(count);
    }
}
