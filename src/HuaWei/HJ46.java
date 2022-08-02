package HuaWei;/*
 *文件名: HJ46
 *创建者: wwy
 *创建时间:2022/3/5 9:37
 *描述:截取字符串
 */

import java.util.Scanner;

public class HJ46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            int K= sc.nextInt();
            String last = str.substring(0,K);

            System.out.println(last);
        }
    }
}
