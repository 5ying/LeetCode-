package HuaWei;/*
 *文件名: HJ7
 *创建者: wwy
 *创建时间:2022/3/2 21:59
 *描述:取近似值
 */

import java.util.Scanner;

public class HJ7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double dd = sc.nextDouble();
//        借助了java 自带的函数
        System.out.println(Math.round(dd));
        System.out.println(fourOrfive(dd));
    }
    public static int fourOrfive(double dd ){
//        直接加0.5，大于0.5的就+1，小于0.5的就保持原值
        return (int)(dd+0.5);
    }

}
