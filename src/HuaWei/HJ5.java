package HuaWei;/*
 *文件名: HJ5
 *创建者: wwy
 *创建时间:2022/3/2 21:37
 *描述:进制转换
 */

import java.util.Scanner;

public class HJ5 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while (sc.hasNext()){
            String str_num = sc.nextLine();
            String str= str_num.substring(2);
            int a = Integer.valueOf(str,16);
            System.out.println(a);
        }
    }
}
