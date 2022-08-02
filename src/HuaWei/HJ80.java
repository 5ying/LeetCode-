package HuaWei;/*
 *文件名: HJ80
 *创建者: wwy
 *创建时间:2022/3/8 10:48
 *描述: 整型数组合并
 */

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HJ80 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i =0;i<N;i++){
                set.add(sc.nextInt());
            }
            int M = sc.nextInt();
            for (int i =0;i<M;i++){
                set.add(sc.nextInt());
            }
            Iterator it = set.iterator();
            String str = "";
            while (it.hasNext()){
                str = str+it.next();
            }
            System.out.println(str);

        }
        sc.close();

    }
}
