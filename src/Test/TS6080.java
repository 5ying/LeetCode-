package Test;/*
 *文件名: TS6080
 *创建者: wwy
 *创建时间:2022/5/30 10:48
 *描述:
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class TS6080 {

    public static void main(String[] args) {
        int ans = totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11});
        System.out.println(ans);
    }
        public static int totalSteps(int[] nums) {
            int ans = 0;
            Deque<int[]> st = new ArrayDeque<int[]>();
            for (int num : nums) {
                int maxT = 0;
                while (!st.isEmpty() && st.peek()[0] <= num) {
                    maxT = Math.max(maxT, st.peek()[1]);
                    st.pop();
                }
                if (!st.isEmpty()) ++maxT;
                ans = Math.max(ans, maxT);
                st.push(new int[]{num, maxT});
            }
            return ans;
        }


}
