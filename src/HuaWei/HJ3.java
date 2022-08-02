package HuaWei;/*
 *文件名: HJ3
 *创建者: wwy
 *创建时间:2022/3/2 20:39
 *描述:  明明的随机数
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HJ3 {
    public static final int MAX_num = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        Set studentSet = new HashSet();
//        多组数据输入
        while (sc.hasNextInt()) {
            N = sc.nextInt();
//            依次输入N个数据，使用set,避免输入的值出现重复
            for (int i = 0; i < N; i++) {
                studentSet.add(sc.nextInt());
            }
//将哈希表的中数据便利到list中，这样可以使用list的自动排序功能。
            List list = new ArrayList();
//            遍历Set时使用容器
            Iterator<Integer> it = studentSet.iterator();
            while (it.hasNext()){
                list.add(it.next());
            }
            list.sort(Comparator.naturalOrder());
            for (int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }

        }
    }
}

