package Test;/*
 *文件名: ts5218
 *创建者: wwy
 *创建时间:2022/6/19 10:49
 *描述:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/*
* 想的超级复杂！！！ 回溯剪枝之类的，就离谱 就是说 用回溯的写 也没有写出来！
*
*
*
* */
public class TS5218 {
    public static void main(String[] args) {
        int ans = minimumNumbers(58,9);
        System.out.println(ans);

    }
    public static int minimumNumbers(int num, int k) {
        Set<Integer> set;
        List<Integer> list;
        List<List<Integer>> ll;
        if (num==0){
            return 0;
        }
        String s = String.valueOf(num-k);

        if (Integer.parseInt(String.valueOf(s.charAt(s.length()-1)))==0){
            return 1;
        }
//        if (Integer.parseInt(String.valueOf(s.charAt(s.length()-1)))!= k){
//            return -1;
//        }
        if (k==1){
            return num;
        }
//        int ans = 0;
        int max_ans=-1;
        for (int i =0;i<num/10+1;i++){
//            int ans =  check(num,k,set= new HashSet<>());
            list = new ArrayList<>();
            ll = new ArrayList<>();
            check(num,k,list,ll);
            int ans = list.size();
            max_ans = Math.max(ans,max_ans);
        }

//        for (int i =0;i<num/10;i++){
//            int temp = num-(k+i*10);
//            String str = String.valueOf(temp);
//            int ii = Integer.parseInt(str.charAt(str.length()-1)+"");
//            if (ii==k){
//                if (!set.add(temp)){
//                    break;
//                }
//                set.add(k+i*10);
//            }else {
//                break;
//            }
//        }

        return max_ans;

    }
    public static int  check(int num,int k,List<Integer> set,List<List<Integer>> list){


            for (int i =0;i<num/10;i++){
                int temp = num-(k+i*10);

                String str = String.valueOf(temp);
                int ii = Integer.parseInt(str.charAt(str.length()-1)+"");
                if (ii==k){
                    if (set.contains(temp)){
                        break;
                    }
//                if (!set.add(temp)){
//                    break;
//                }

                    set.add(k+i*10);
                    check(temp,k,set,list);
                    set.add(temp);
//                set.add(k+i*10);
                }else {
                    break;
                }

            }

        System.out.println(set);
        if (set.size()==0){
            return -1;
        }else {
            System.out.println(set);
            return set.size();
        }
    }
}
