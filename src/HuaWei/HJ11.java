package HuaWei;/*
 *文件名: HJ11
 *创建者: wwy
 *创建时间:2022/3/3 9:40
 *描述:数字颠倒
 */

import java.util.Scanner;

public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ss = "";
        for (int i = str.length()-1;i>=0;i--){
            ss =ss+str.charAt(i);
        }
        System.out.println(ss);
    }
}
