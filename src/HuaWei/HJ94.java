package HuaWei;/*
 *文件名: HJ94
 *创建者: wwy
 *创建时间:2022/3/9 9:18
 *描述:计票统计
 */

import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Scanner;

public class HJ94 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String[] sb = new String[n];
            Map<String,Integer> map = new LinkedHashMap<>();
            int count =0;
            for (int i =0;i<n;i++){
                sb[i] = sc.next();
                map.put(sb[i],map.getOrDefault(sb[i],0));
            }
            int m  =  sc.nextInt();
            String[] ssb = new String[m];
            for (int j =0;j<m;j++){
                ssb[j] = sc.next();
                if (map.containsKey(ssb[j])){
                    map.put(ssb[j],map.get(ssb[j])+1);
                }else{
                    count ++;
                }
            }
            for (int i =0;i<map.size();i++){
                System.out.println(sb[i]+" : "+map.get(sb[i]));
            }
            System.out.println("Invalid : "+count);

        }
        sc.close();
    }
}
