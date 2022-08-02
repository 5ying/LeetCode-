package HuaWei;/*
 *文件名: HJ4
 *创建者: wwy
 *创建时间:2022/3/2 21:14
 *描述:字符串分割：重要的地方在于使用字符串缓冲区填充0，以及字符串截取的函数
 */

import java.util.Scanner;

public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
//            字符串缓冲区
//            我觉的不一定用字符缓冲区啊，用list也行,用List 不行，因为这时候Str 还没有输入，其长度是未知的。
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            int size = str.length();
            int addZero = 8 - size % 8;
            while ((addZero > 0) && (addZero < 8)) {
                sb.append("0");
                addZero--;
            }
            String str1 = sb.toString();
            while (str1.length() > 0) {
                System.out.println(str1.substring(0, 8));
                str1 = str1.substring(8);
            }
        }
    }
}
