package HuaWei;/*
 *文件名: HJ27
 *创建者: wwy
 *创建时间:2022/3/10 11:07
 *描述:查找兄弟单词
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HJ27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ss = new String[n+1];
        List<String> list = new ArrayList<>();
        for (int i =0;i<n;i++){
            ss[i] = sc.next();
        }
        String x = sc.next();
        int k = sc.nextInt();
        int count =0;

        for (int i= 0;i<n;i++){
            if(x.length()==ss[i].length()){
                if (ss[i].equals(x)) {
                    continue;
                }else{
                    char[] x_s  = ss[i].toCharArray();
                    char[] y_s = x.toCharArray();
                    Arrays.sort(x_s);
                    Arrays.sort(y_s);
                    if ( x_s.toString().equals(y_s.toString())){
                        list.add(ss[i]);
                    }

                }
            }
        }

        list.sort(Comparator.naturalOrder());

        if (k<=list.size()){
            System.out.println(list.size());
            System.out.println(list.get(k-1));
        }


    }
}
