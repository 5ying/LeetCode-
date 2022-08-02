package HuaWei;/*
 *文件名: HJ59
 *创建者: wwy
 *创建时间:2022/3/5 22:25
 *描述: 找出字符串中第一个只出现一次的字符
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ59 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            boolean flag = false;
            Map<Character,Integer> map = new LinkedHashMap();
            for (char c : str.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }

            for (char ii:map.keySet()){
                if(map.get(ii)==1){
                    System.out.println(ii);
                    flag=true;
                    break;
                }
            }
            if (!flag){
                System.out.println(-1);
            }
        }
}
}
