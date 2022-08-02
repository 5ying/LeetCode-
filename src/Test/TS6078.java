package Test;/*
 *文件名: TS6078
 *创建者: wwy
 *创建时间:2022/5/29 10:36
 *描述:
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TS6078 {


    /*
     * 被自己蠢哭！！！ 为什么要写减法，明明是除数问题！！！*/
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> mm = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            set.add(s.charAt(i));
        }
        for (int j = 0; j < target.length(); j++) {
            mm.put(target.charAt(j), mm.getOrDefault(target.charAt(j), 0) + 1);
            //            可以添加进去说明S中没有该字符 ，直接返回0
            if (set.add(target.charAt(j))) {
                return 0;
            }
        }

        if (mm.size() == target.length()) {
//            挨个判断最小值差值

        }
//        判断s中有target的所有字符
        Set<Character> ss = mm.keySet();
        for (Character sss : ss) {
            int n = map.get(sss) / mm.get(sss);
            if (min > n) {
                min = n;
//            }else{
//                min = n;
//            }
            }


            for (int i = 0; i < target.length(); i++) {

                if (mm.size() == target.length()) {
//            挨个查找S中对应的最小值
                    if (min > map.get(target.charAt(i))) {
                        min = map.get(target.charAt(i));
                    }
                } else {
                    int ll = map.get(target.charAt(i)) - mm.get(target.charAt(i));
                    if (ll < 0) {
                        return 0;
                    }
                    if (min > ll) {
//                    min = Math.min(min,ll+1);
                        if (ll == 0) {
                            min = ll + 1;
                        } else {
                            min = ll;
                        }

                    }
                }

            }

            return min;
        }
        return min;

    }
}
