package HuaWei;/*
 *文件名: HJ53
 *创建者: wwy
 *创建时间:2022/3/5 11:16
 *描述: 杨辉三角的变形
 */

import java.util.Scanner;

public class HJ53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if(num == 1 || num == 2){
                System.out.println(-1);
                continue;
            }
            else if(num % 4 == 1 || num % 4 == 3){
                System.out.println(2);
                continue;
            }
            else if(num % 4 == 0){
                System.out.println(3);
                continue;
            }
            else if(num % 4 == 2){
                System.out.println(4);
                continue;
            }
        }
    }
}
