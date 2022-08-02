package HuaWei;/*
 *文件名: HJ97
 *创建者: wwy
 *创建时间:2022/3/9 10:29
 *描述:
 */

import java.util.Scanner;

public class HJ97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            int count = 0;
            int zero = 0;
            int[] number = new int[n];
            for (int i = 0; i < n; i++) {
                number[i] = sc.nextInt();
                if (number[i] > 0) {
                    sum = sum + number[i];
                } else if (number[i] == 0) {
                    zero++;
                } else {
                    count++;
                }
            }

            System.out.print(count + " ");
            System.out.println(String.format("%.1f", sum*1.0 / (n - count - zero) ));
        }
        sc.close();
    }
}
