package HuaWei;/*
 *文件名: HJ62
 *创建者: wwy
 *创建时间:2022/5/6 15:44
 *描述: 寻找1的个数
 */

import java.util.Scanner;

public class HJ62 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            String b = Integer.toBinaryString(a);
            String c = b.replaceAll("1", "");
            System.out.println(b.length() - c.length());

        }
    }
}
