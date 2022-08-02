package HuaWei;/*
 *文件名: HJ55
 *创建者: wwy
 *创建时间:2022/3/5 11:31
 *描述: 挑7
 */

import java.util.Scanner;

public class HJ55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int count=0;
            for (int i =1;i<=n;i++){
                if(i%7==0 ){
                    count++;
                }else {
                    String s = String.valueOf(i);
                    if(s.contains("7")){
                        count++;
                    }
                }
            }
                System.out.println(count);
        }
    }
}
