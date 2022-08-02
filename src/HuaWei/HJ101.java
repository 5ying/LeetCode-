package HuaWei;/*
 *文件名: HJ101
 *创建者: wwy
 *创建时间:2022/3/9 11:05
 *描述:
 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HJ101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i =0;i<n;i++){
            list.add(sc.nextInt());
        }
        int flag  = sc.nextInt();
        list.sort(Comparator.naturalOrder());
        if(flag==1){
            list.sort(Comparator.reverseOrder());
        }
        for (int i =0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }

}
