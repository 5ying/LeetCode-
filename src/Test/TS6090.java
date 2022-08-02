package Test;/*
 *文件名: TS6090
 *创建者: wwy
 *创建时间:2022/6/5 10:30
 *描述:
 */

public class TS6090 {
    public static void main(String[] args) {
        int ans = minMaxGame(new int[]{70,38,21,22});
        System.out.println(ans);
    }

    public static int minMaxGame(int[] nums) {
        int[] temp = nums;
        int asn = 0;
       while (temp.length!=0){
           int n = temp.length;
            int[] newNums = new int[n/2];
            for (int i=0;i<newNums.length;i++){
                if (i%2==0){
                    newNums[i] = Math.min(temp[2*i+1],temp[2*i]);
                }else{
                    newNums[i] = Math.max(temp[2*i+1],temp[2*i]);
                }
            }

            if (n==1){
                asn = temp[0];
               break;
            }
           temp = newNums;
        }
       return asn;
    }

}
