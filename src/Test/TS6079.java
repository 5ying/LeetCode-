package Test;/*
 *文件名: TS6079
 *创建者: wwy
 *创建时间:2022/5/29 11:21
 *描述:
 */

import java.text.DecimalFormat;

public class TS6079 {
    public static void main(String[] args) {
        String s = "$76111 ab $6 $";
        int n = 48;
        String ss = discountPrices(s,n);
        System.out.println(ss);
    }
    public  static  String discountPrices(String sentence, int discount) {
        if (sentence==null){
            return sentence;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = sentence.split(" ");
        for (int i =0;i<str.length;i++){
            String s = str[i];
            int n =0;
            for (int j =0;j<s.length();j++){
                if (s.charAt(j)=='$'){
                    n++;
                }
                if (n>1){
                    break;
                }
            }

            if (s.charAt(0)=='$' && n==1 && s.length()>1){
                long number = Long.parseLong(s.substring(1));
                DecimalFormat df = new DecimalFormat("0.00");
                double ans = number*1.00 * (1 - discount/100.00);
                String aa = '$'+String.valueOf(df.format(ans));
                if (i == str.length - 1) {
                    stringBuilder.append(aa);
                }
                else{
                    stringBuilder.append(aa+" ");
                }
            }else {
                if (i==str.length-1){
                    stringBuilder.append(s);
                }
                else{
                    stringBuilder.append(s+" ");
                }
            }

        }
        return stringBuilder.toString();
    }
}
