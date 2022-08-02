package HuaWei;/*
 *文件名: HJ106
 *创建者: wwy
 *创建时间:2022/3/9 11:28
 *描述:字符逆序
 */

import java.util.Scanner;

public class HJ106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char c :str.toCharArray()){
            sb.append(c);
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
