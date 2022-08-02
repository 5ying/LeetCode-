package HuaWei;/*
 *文件名: HJ92
 *创建者: wwy
 *创建时间:2022/3/11 11:00
 *描述: 在字符串中找出连续最长的数字串

 感觉之前做过一个类似的！！！ 查找最大子串的 ，然后我还写了Kmp,要去学习这个算法来着
 太狗了太狗了


 // 有个大神写了DP的解决方案、但是我看不懂啊看不懂，但是好简单啊好简单。
 还有另外的

 */

import java.util.Scanner;

public class HJ92 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        参考这个人用了一种非常凑巧的方法：把非数字字符全部改成a，然后通过字符串分割，提取出数字字符子串，查找子串的最大长度
//        最后输出子串
        while (sc.hasNext()){
            String str= sc.nextLine();
            String str1 = "";
            for (char cc:str.toCharArray()){
                if(cc>='0'&&cc<='9'){
                    str1 +=cc;
                }else {
                    str1+="a";
                }

            }

            String[] strs = str1.split("a");
            int max =0;
            for (int i =0;i<strs.length;i++){
                max = strs[i].length()>max?strs[i].length():max;
            }

            for (int i=0;i<strs.length;i++){
                if(strs[i].length()==max){
                    System.out.print(strs[i]);
                }
            }

            System.out.println(","+max);
        }
        sc.close();


/*
YYDS：好好看DP啊！！！

dp 解法：
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                int len = str.length();
                int[] dp = new int[len+1];
                int res = 0;
                for (int i =1; i <= len; i++) {
                    char tmp = str.charAt(i-1);
                    if (tmp >= '0' && tmp <= '9') {
                        dp[i] = dp[i-1] +1;
                        res = Math.max(res, dp[i]);
                    }
                }

                for (int i =1; i<= len; i++) {
                    if (dp[i] == res) {
                        System.out.print(str.substring(i - res, i));
                    }
                }
                System.out.println("," + res);
 */
    }
}
