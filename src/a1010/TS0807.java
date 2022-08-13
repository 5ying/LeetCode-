package a1010;/*
 *文件名: TS0807
 *创建者: wwy
 *创建时间:2022/8/7 19:47
 *描述:
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TS0807 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while (n-->0){
//            int[] v2v = new int[4];
//            int[] kalpas = new int[4];
//            for(int i = 0; i < 4; i++){
//                v2v[i] = sc.nextInt();
//            }
//            for(int i = 0; i < 4; i++){
//                kalpas[i] = sc.nextInt();
//            }
//
//
//            System.out.println(" I love V2V forever!");
//
//
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new Hashtable<>();
        String[] ans = new String[n];
        while (n-->1){
            int a = sc.nextInt();
            int b = sc.nextInt();
            List<Integer> list = map.getOrDefault(a,new ArrayList<>());
            List<Integer> list1 = map.getOrDefault(b,new ArrayList<>());
            list.add(b);
            list1.add(a);
            map.put(a,list);
            map.put(b,list1);
        }
        Set<Integer> key = map.keySet();
        for (Integer k :key){
            int index = Integer.valueOf(k);
            List<Integer> l = map.get(k);
            if ( ans[index-1]==null && l.size()>=2 ){
                ans[index-1] = "R";

//                if (ans[l.get(0)-1]==null){
//                    ans[l.get(0)-1] = "G";
//                }
//                if (ans[l.get(1)-1]==null){
//                    ans[l.get(1)-1] = "B";
//                }
//                for (int i =2;i<l.size();i++){
//                    if (ans[l.get(i)-1]==null){
//                        ans[l.get(i)-1]="R";
//                    }
//                }

                String temp = ans[index-1];
                Set<String> set = new HashSet<>();
                set.add(temp);
                for (int i =0;i<l.size();i++){
                    String tt = ans[l.get(i)-1];
                    set.add(tt);
                }
                for (int i=0;i<l.size();i++){
                    if (ans[l.get(i)-1]==null){
                        if (!set.contains("R")){
                            ans[l.get(i)-1]="R";
                        }else if (!set.contains("B")){
                            ans[l.get(i)-1]="B";
                        }else {
                            ans[l.get(i)-1]="G";
                        }
                    }
                }

            }else if (ans[index-1]!=null && l.size()>=2){
                String temp = ans[index-1];
                Set<String> set = new HashSet<>();
                set.add(temp);
                for (int i =0;i<l.size();i++){
                    String tt = ans[l.get(i)-1];
                    set.add(tt);
                }
                for (int i=0;i<l.size();i++){
                    if (ans[l.get(i)-1]==null){
                        if (!set.contains("R")){
                            ans[l.get(i)-1]="R";
                        }else if (!set.contains("B")){
                            ans[l.get(i)-1]="B";
                        }else {
                            ans[l.get(i)-1]="G";
                        }
                    }
                }
            } else if (ans[index-1]==null && l.size()<2){
                ans[index-1] = "R";
            }else {
                ans[index-1] = "R";
            }
        }
        String ss = "";
        for (int i =0;i<ans.length;i++){
            ss = ss+ans[i];
        }
        System.out.println(ss);


    }

//
//public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    String str = sc.nextLine();
//    int aa = number(str);
//    System.out.println(aa);
//
//}
//public  static  int number(String str){
//    int ans = 0;
//    char[] cc = str.toCharArray();
//    for (char c :cc){
//        if (c=='/'){
//            ans++;
//        }
//    }
//    return ans;
//}

}
