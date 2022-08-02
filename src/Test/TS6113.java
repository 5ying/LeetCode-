package Test;/*
 *文件名: TS6113
 *创建者: wwy
 *创建时间:2022/7/10 11:13
 *描述:
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TS6113 {
    List<Integer> list;
    Set<Integer> set;
    public static void main(String[] args){

    }
    public TS6113() {
        list = new ArrayList<>();
        set = new HashSet<>();

    }

    public int popSmallest() {
//        Collections.sort(list);
//        set.add(list.get(0));
        int i =1;
        for (;;i++){
            if (!set.contains(i)){
                set.add(i);
                break;
            }
        }
        return i;


    }

    public void addBack(int num) {
        if (set.contains(num)){
//            list.add(num);
            set.remove(num);
        }

    }
}
