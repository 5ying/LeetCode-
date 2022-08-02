package HuaWei;/*
 *文件名: HJ8
 *创建者: wwy
 *创建时间:2022/3/2 22:31
 *描述:合并表记录
 */
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            for(int i = 0; i < n; ++i){
                int a = sc.nextInt();
                int b = sc.nextInt();
                map.put(a,map.getOrDefault(a,0) + b);
            }
        }
        for (Integer i : map.keySet()) {
            System.out.println(i + " " + map.get(i));
        }
    }
}

