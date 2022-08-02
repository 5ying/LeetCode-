package HuaWei;/*
 *文件名: HJ34
 *创建者: wwy
 *创建时间:2022/3/5 10:17
 *描述:图片整理
 */

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Character> list = new LinkedList<>();
        for(char test : str.toCharArray()){
            list.add(test);
        }
        list.sort(Comparator.naturalOrder());
        String ss ="";
        for (int i =0;i<list.size();i++){
            ss = ss+list.get(i);
        }

        System.out.println(ss);
    }
}
