package HuaWei;/*
 *文件名: HJ84
 *创建者: wwy
 *创建时间:2022/3/8 11:18
 *描述:统计大写字母的个数
 */

import java.util.Scanner;

public class HJ84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int count = 0;
            for (char cc :str.toCharArray()){
                if (cc>='A' && cc<='Z'){
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
