package HuaWei;/*
 *文件名: HJ23
 *创建者: wwy
 *创建时间:2022/3/4 10:31
 *描述:删除字符串中出现次数最少的字符
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character,Integer> map = new LinkedHashMap<Character, Integer>();

        for (char test:str.toCharArray()){
            map.put(test,map.getOrDefault(test,0)+1);
        }

        int min = Integer.MAX_VALUE;
        for(int times:map.values()){
            min = Math.min(min,times);
        }
        StringBuilder res = new StringBuilder();
        for (char ch:str.toCharArray()){
            if(map.get(ch)!=min){
                res.append(ch);
            }
        }

        res.toString();

//        for (int i =0;i<str.length();i++) {
//            if (map.containsKey(str.charAt(i) + "")) {
//                map.put(str.charAt(i) + "", map.get(str.charAt(i) + "") + 1);
//            } else {
//                map.put(str.charAt(i) + "", 1);
//            }
//        }
//            Set<String> set = map.keySet();
//            List list = new LinkedList();
//            for (String test:set){
//                list.add(map.get(test));
//            }
//            list.sort(Comparator.naturalOrder());
//            Integer ll = (Integer) Collections.min(list);
//            String last = "";
//            for (String test :set){
//                if(map.get(test)> ll){
//                    for (int i1 =0;i1<map.get(test);i1++){
//                        last = last+test;
//                    }
//                }
//            }
        System.out.println(res);
    }



}
