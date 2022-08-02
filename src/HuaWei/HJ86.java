package HuaWei;/*
 *文件名: HJ86
 *创建者: wwy
 *创建时间:2022/3/8 17:21
 *描述: 最最大连续Bit数

 */

import java.util.Scanner;

public class HJ86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int number = sc.nextInt();
//            数字转化为二进制
            String bb = Integer.toBinaryString(number);
//            采用0进行字符串分割,即剩下的是全为1的字符串
            String[] strArray = bb.split("0");
            int result = 0;
//            找到全为1字符串最长的,打印其长度即可
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i].length() > result) {
                    result = strArray[i].length();
                }
            }
            System.out.println(result);

        }
        sc.close();
    }
}
