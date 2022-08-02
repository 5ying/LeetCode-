package HuaWei;/*
 *文件名: HJ9
 *创建者: wwy
 *创建时间:2022/3/3 9:19
 *描述:提取不重复的数字
 */

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String last ="";
        Set set = new  LinkedHashSet();
        for (int i =num.length()-1;i>=0;i--){
            set.add(num.charAt(i));
        }
        Iterator it = set.iterator();
        while (it.hasNext()){
//            System.out.println(it.next());
            last = last+it.next();
        }
//        int last_num = Integer.valueOf(last).intValue();
//
        System.out.println(last);
//        System.out.println(last_num);
    }
}
