package HuaWei;/*
 *文件名: HJ26
 *创建者: wwy
 *创建时间:2022/3/10 10:46
 *描述: 字符串排序
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HJ26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Character> list = new ArrayList<>();
        for (char ch:str.toCharArray()){
            if(Character.isLetter(ch)){
                list.add(ch);
            }
        }

        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1)-Character.toLowerCase(o2);
            }
        });


//        这个自带的排序 是按照ASCII码进行排序的。 故会出现大小写的排序
//        list.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for (int i =0,j=0;i<str.length();i++){
            if (Character.isLetter(str.charAt(i))){
                sb.append(list.get(j++));
            }
            else {
                sb.append(str.charAt(i));
            }
        }

        System.out.println(sb.toString());

    }
}
