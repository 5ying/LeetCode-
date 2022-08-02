package HuaWei;/*
 *文件名: HJ5
 *创建者: wwy
 *创建时间:2022/3/2 21:37
 *描述:字符串最后一个单词的长度
 */
/**
 * 这个文件 是 牛客上华为题目集中100题
 */

import java.util.Scanner;
//字符串最后一个单词的长度

class HJ1 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len_01 = str.length();
        char[] c_str = str.toCharArray();
        int len = c_str.length;
        int count =0;
        while (len>=1 && c_str[len-1]!=' '){
            len--;
            count++;
        }
        System.out.println(count);
    }

}
