package HuaWei;/*
 *文件名: HJ99
 *创建者: wwy
 *创建时间:2022/3/9 10:50
 *描述:自守数
 */

import java.util.Scanner;

public class HJ99 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int count = 0;
            for (int i =0;i<=n;i++){
                String  nstr = i+"";
                int nn = i*i;
                String str = nn+"";

                String ss = str.substring(str.length()-nstr.length());
                if(Integer.parseInt(ss)==i){
                    count++;
                }
            }

            System.out.println(count);

        }
        sc.close();
    }
}
