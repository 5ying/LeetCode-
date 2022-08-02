package HuaWei;/*
 *文件名: HJ14
 *创建者: wwy
 *创建时间:2022/3/3 10:08
 *描述: 字符串排序
 */

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class HJ14 {
//    有可能会出现重复值，所以不能用set.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        List list = new LinkedList();
//        Set set = new TreeSet();
//      for (int i =0;i<N;i++){
//          set.add(sc.next());
//          Iterator it = set.iterator();
//          while (it.hasNext()){
//              list.add(it.next());
//          }
//      }
//        Iterator it= set.iterator();
//      while (it.hasNext()){
//          System.out.println(it.next());
//      }

//        使用Map,map会自动对Key进行排序
//        使用set接受Map中Key
//        使用map中value记录key出现的次数

        Map<String,Integer> map = new TreeMap<String,Integer>();
        for (int i = 0;i<N;i++){
            String ss = sc.next();
            if (map.containsKey(ss)){
                map.put(ss,map.get(ss)+1);
            }else{
                map.put(ss,1);
            }
        }
        Set<String> get = map.keySet();
       for (String test:get)
            for (int j = 1;j<=map.get(test);j++){
                System.out.println(test);
            }
    }

}
