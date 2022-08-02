package Test;/*
 *文件名: TS6112
 *创建者: wwy
 *创建时间:2022/7/10 10:41
 *描述:
 */

import java.util.Arrays;

public class TS6112 {
    public static void main(String[] args) {

    }
    public int fillCups(int[] amount) {
//        Arrays.sort(amount);
//        int ans =amount[0];
//        amount[2] -= amount[0];
//        if (amount[2]<=0){
//            ans +=amount[1];
//            return ans;
//        }else{
//            if (amount[2]>amount[1]){
//                ans +=amount[1];
//                amount[2]-=amount[1];
//                ans += amount[2];
//                return ans;
//            }else {
//                ans +=amount[2];
//                amount[1]-=amount[2];
//                ans += amount[1];
//                return ans;
//            }
//        }
        Arrays.sort(amount);
        int index=0;
        int ans =0;
        while(index<2){
            if (amount[index]==0){
                index+=1;
            }else{
                amount[index]-=1;
                amount[2]-=1;
                ans +=1;
                Arrays.sort(amount);
            }


        }
        ans+=amount[2];
        return ans;

    }

}
