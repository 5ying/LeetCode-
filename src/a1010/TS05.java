package a1010;/*
 *文件名: TS05
 *创建者: wwy
 *创建时间:2022/4/14 19:13
 *描述:
 */

import java.util.HashMap;
import java.util.Scanner;

public class TS05 {
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] number = new int[N];
        for (int i =0;i<N;i++){
            number[i] = sc.nextInt();
        }
        String str = sc.next();
        char[] c_str = str.toCharArray();

        // 总体思想：将红蓝字符 分别取出来，然后遍历相同的值
        int[] red = new int[N];
        int index_r =0;

        HashMap<Integer,Integer> map = new HashMap();
        for (int i =0;i<N;i++){
            if (c_str[i]=='R'){
                red[index_r++] = number[i];
            }
            if (c_str[i]=='B'){
                map.put(number[i],map.getOrDefault(number[i],0)+1);
            }
        }
        int count = 0; // 记录结果
        for (int j = 0;j<index_r;j++){
            if (map.isEmpty()){
                break;
            }
            if ( map.containsKey(red[j])){
                count += map.get(red[j]);
            }

        }
        // 输出
        System.out.println(count);
    }
}
