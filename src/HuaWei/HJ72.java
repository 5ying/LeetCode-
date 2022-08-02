package HuaWei;/*
 *文件名: HJ72
 *创建者: wwy
 *创建时间:2022/3/7 22:35
 *描述: 百钱买百鸡问题
 */

import java.util.Scanner;

public class HJ72 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = sc.nextInt();
            int x,y,z,middle;
            for(x = 0; x<=14;x++){
                if((100 - 7*x) % 4 == 0){
                    y = (100 - 7*x) / 4;
                    z = 100-x-y;
                    System.out.print(x +" ");
                    System.out.print(y +" ");
                    System.out.print(z +" ");
                    System.out.println();
                }
            }


        }
        sc.close();
    }
}
