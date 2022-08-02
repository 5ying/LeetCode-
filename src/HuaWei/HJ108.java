package HuaWei;/*
 *文件名: HJ108
 *创建者: wwy
 *创建时间:2022/3/9 11:33
 *描述:最小公倍数

 辗转相除法
 欧几里得算法
 */

import java.util.Scanner;

public class HJ108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a*b/gcd(a,b));
    }
    private static int gcd(int a, int b) {
        // TODO Auto-generated method stub
        return b==0?a:gcd(b,a%b);
    }
}
