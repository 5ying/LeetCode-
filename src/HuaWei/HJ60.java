package HuaWei;/*
 *文件名: HJ60
 *创建者: wwy
 *创建时间:2022/3/7 21:20
 *描述:查找一个偶数最接近的两个素数
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HJ60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            list2.add(0);
            list2.add(Integer.MAX_VALUE);
//            找到N之内的所有素数
            for(int i = 2; i<N; i++){
                boolean flag = true;
                for (int j = 2;j<=i-1;j++){
                    if(i%j==0){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    list.add(i);
                }

            }

            // 查找全部素数里 加和等于N,并且差值最小的一对素数
            for (int i = 0;i<list.size();i++){
                int a = list.get(i);
                for(int j = i;j<list.size();j++){
                    int b = list.get(j);
                    if(a+b==N){
                        if(Math.abs(a-b)<Math.abs(list2.get(1)-list2.get(0))){
                            list2.remove(0);
                            list2.remove(0);
                            list2.add(a);
                            list2.add(b);
                        }
                    }
                }
            }
            list2.sort(Comparator.naturalOrder());
            System.out.println(list2.get(0));
            System.out.println(list2.get(1));

        }
    }
}
