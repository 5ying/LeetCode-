package Test;/*
 *文件名: TS6099
 *创建者: wwy
 *创建时间:2022/6/20 9:46
 *描述: 小于等于K的最长二进制子序列
 */

import java.util.ArrayList;
import java.util.List;

public class TS6099 {
    public static void main(String[] args) {
        int ans = longestSubsequence("00101001",1);
        System.out.println(ans);

    }
//    这些方法是基于回溯思想，但是不减枝的回溯相当于暴力，剪枝没减好，会超时
    public  static int longestSubsequence(String s, int k) {
        int max = 0;
        int n = s.length();
        if (n==0){
            return max;
        }
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        dfs(stringBuilder,s,max ,k,n,0,list);

        for (StringBuilder ss:list){
            max = Math.max(max,ss.length());
        }

        return max;
    }
    public  static void dfs(StringBuilder stringBuilder,String s, int max,int k,int n,int start, List<StringBuilder> list){
//        System.out.println(stringBuilder);
//        if (stringBuilder==null){
//            System.out.println(stringBuilder);
//        }
//        System.out.println(stringBuilder.toString());
        if (!stringBuilder.toString().isEmpty() ){
            if (Integer.valueOf(stringBuilder.toString(),2)<=k){
                list.add(new StringBuilder(stringBuilder));
                max = Math.max(max,stringBuilder.length());
            }
        }
        for (int i = start;i<n;i++){
//            System.out.println("**"+(n-i));
//            if (n-start<max){
//                continue;
//            }
            stringBuilder.append(s.charAt(i));
//            System.out.println(max);
            dfs(stringBuilder,s,max,k,n,i+1,list);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }
    }

//    看了别人的求解办法 ： 贪心+滑动窗口
        public int longestSubsequence1(String s, int k) {
            int n = s.length();
            int[] left = new int[n];
            int ans =0;
            char[] cs = s.toCharArray();
            for (int i =0,cnt =0;i<n-1;i++){
                if (cs[i]=='0') {
                    cnt++;
                }
//                记录前面有几个0
                left[i+1] = cnt;
            }

            int l = 0;
            int r =0;
            int cur =0;
            while (r<l){
                cur = (cur<<1)+cs[r]-'0';
                if (cur<=k){
                    ans = Math.max(ans,r-l+1+left[l]);
                }
                while (cur>k){
                    if (cs[l]=='1'){
                        cur -= 1 << (r-1);
                    }
                    l++;
                }
                r++;
                ans = Math.max(ans,r-1);
            }
            return ans;
        }

//        贪心解法二
    public int longsetSubsequence(String s,int k){
        long sum =0;
//        curCnt表示当前数字有多少位
        int curCnt = 0;
//        从后往前遍历：遇到0就加进来
        for (int i =s.length()-1;i>=0;i--){
            if (s.charAt(i)=='0'){
                curCnt++;
            }else {
                if (curCnt<=30 && sum +(1L<<curCnt)<=k){
                    sum += (1L<<curCnt);
                }
            }
        }
        return curCnt;
    }

}
