package HuaWei;/*
 *文件名: HJ100
 *创建者: wwy
 *创建时间:2022/3/9 11:02
 *描述:等差数列

 重 ： 等差数列公式
 */

import java.util.Scanner;

public class HJ100 {
    public static void main(String[] args) {
        Scanner scc = new Scanner(System.in);
        while (scc.hasNext()){
            int n = scc.nextInt();
            System.out.println(2*n+(n*(n-1)/2*3));
        }
        scc.close();
    }
}
