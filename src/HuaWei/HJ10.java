package HuaWei;/*
 *文件名: HJ10
 *创建者: wwy
 *创建时间:2022/3/3 9:34
 *描述:字符个数统计
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Set set = new HashSet();
        int count = 0;
        for (int i = 0;i<str.length();i++){
            if (Integer.valueOf(str.charAt(i))>=0 && Integer.valueOf(str.charAt(i))<=127){
                if(set.add(str.charAt(i))){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
