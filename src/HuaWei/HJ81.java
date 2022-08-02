package HuaWei;/*
 *文件名: HJ81
 *创建者: wwy
 *创建时间:2022/3/8 10:57
 *描述:字符串字符匹配
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ81 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.next();
            String b = sc.next();
            Set set = new HashSet();
            boolean flag = true;
            for (char cc : b.toCharArray()){
                set.add(cc);
            }

            for (char cc : a.toCharArray()){
                if(set.add(cc)){
                    flag = false;
                    break;
                }
            }

            System.out.println(flag);
        }
        sc.close();
    }
}
