package Niuke;/*
 *文件名: NK01
 *创建者: wwy
 *创建时间:2022/7/5 10:13
 *描述:  开班测评1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NK01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            List<String> list = new ArrayList<>();
            W:for (int i =0;i<n;++i){
                String s = sc.next();
                for (String t:list){
                    if(t.contains(s)&&t.length()==s.length()*2){
                        continue W;
                    }
                }
                list.add(s+s);
            }
            System.out.println(list.size());
        }

    }
}
