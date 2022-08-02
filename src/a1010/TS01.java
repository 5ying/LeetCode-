package a1010;/*
 *文件名: TS01
 *创建者: wwy
 *创建时间:2022/4/6 19:51
 *描述:
 */

import java.util.*;


public class TS01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<List> list = new ArrayList<>(); //存放依赖表
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            ArrayList ll = new ArrayList();
//            ll.add(a);
            for (int j = 0; j < a; j++) {
                ll.add(sc.nextInt());
            }
            list.add(ll);
        }

//         查找依赖
        Set set = new HashSet();
        List cc = list.get(M);
        for (int k = 0; k < cc.size(); k++) {
            int a = (int) cc.get(k);
            set.add(a);
            List l = list.get(a);
            for (int n = 0; n < l.size(); n++) {
                if ((int) l.get(n) == M) {
                    System.out.println("-1");
                    return;
                }
                set.add(l.get(n));
//                此处修改
                if (!cc.contains(l.get(n))) {
                    List l2 = list.get((int) l.get(n));
                    for (int m = 0; m < l.size(); m++) {
                        if ((int) l.get(n) == M) {
                            System.out.println("-1");
                            return;
                        }
                        set.add(l2.get(m));
                    }
                }
            }

            Iterator IT = set.iterator();
            while (IT.hasNext()) {
                System.out.println(IT.next());
            }
        }
    }
}
