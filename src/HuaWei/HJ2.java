package HuaWei;/*
 *文件名: HJ5
 *创建者: wwy
 *创建时间:2022/3/2 21:37
 *描述:计算某个字符出现的次数
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ2 {
//    计算某个字符出现的次数

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();
        String cc = sc.next();
       String  str_01 = str.toUpperCase();
       String cc_01 = cc.toUpperCase();
//       int count = Num(str_01,cc_01);
//        int count = 0;
//        for (int i = 0;i<str_01.length();i++){
//            if(str_01.charAt(i) == cc_01.charAt(0)){
//                count++;
//            }
//        }
        System.out.println(Num(str_01,cc_01));

    }
//    唯一值可以，但有两两相同的值 就不行还得添加判断条件 直接循环可以
    public static int  Num(String str,String cc){
        Set set = new HashSet();
        set.add(cc.charAt(0));
        int num = 0;
        for (int i =0;i<str.length();i++){
            if (!set.add(str.charAt(i))){
                num++;
            }
        }
        return num;
    }
}
