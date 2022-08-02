package HuaWei;/*
 *文件名: HJ6
 *创建者: wwy
 *创建时间:2022/3/2 21:56
 *描述:质数因子
 */

import java.util.Scanner;

public class HJ6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();
        long k = (long) Math.sqrt(num);

        for (long i = 2; i <= k; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "": num+" ");
    }
}
