package HuaWei;/*
 *文件名: HJ85
 *创建者: wwy
 *创建时间:2022/3/8 11:23
 *描述:
 */

import java.util.Scanner;

public class HJ85 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int max = 0;
        /**
         *双指针遍历找到最长子串
         */
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String toBeJuged = s.substring(i, j);
                if (isPalindromeString(toBeJuged)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        System.out.print(max);
    }

    /**
     *判断一个字符串是否是回文字符串的方法
     */
    static boolean isPalindromeString(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
