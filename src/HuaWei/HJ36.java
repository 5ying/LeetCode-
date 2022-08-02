package HuaWei;/*
 *文件名: HJ36
 *创建者: wwy
 *创建时间:2022/3/11 10:19
 *描述: 字符串 加密
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HJ36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        String str = sc.nextLine();
        Set set = new LinkedHashSet();
        for (char c:key.toCharArray()){
            set.add(c);
        }
//        创建字母表
        char x ='a';
        while (x<='z'){
            set.add(x);
            x = (char)(x+1);
        }
        Iterator it = set.iterator();
        List list = new ArrayList();
        while (it.hasNext()){
            list.add(it.next());
        }
        StringBuilder sb = new StringBuilder();

//        加密：
        for (char cc:str.toCharArray()){
            if(Character.isLetter(cc)){
                if (cc>='A'&&cc<='Z'){
                    sb.append(Character.toUpperCase((char)list.get(cc-'a')));
                }else {
                    sb.append((char)list.get(cc-'a'));
                }
            }else{
                sb.append(cc);
            }
        }

        System.out.println(sb.toString());

    }
}
