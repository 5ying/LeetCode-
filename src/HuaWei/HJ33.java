package HuaWei;/*
 *文件名: HJ33
 *创建者: wwy
 *创建时间:2022/3/11 9:41
 *描述: 正数与IP地址间的转换

 分析：进制转换 long int 整数型 十进制 二进制 十六进制
 */

import java.util.Scanner;

public class HJ33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            if (str.contains(".")){
                String[] ss = str.split("\\.");
                StringBuilder sb = new StringBuilder();
                for (String s:ss){
                    int x = Integer.parseInt(s);
                    String  temp = Integer.toBinaryString(x);
//            数字前面先补0
                    for (int i =0;i<8-temp.length();i++){
                        sb.append(0);
                    }
                    sb.append(temp);

                }
                long nn= Long.parseLong(sb.toString(),2);
                System.out.println(nn);
            }else {
                String s = Long.toBinaryString(Long.parseLong(str));
                while (s.length()<32){
                    s = "0"+s;
                }
                StringBuilder sb = new StringBuilder();
                for (int i =0;i<4;i++){
                    String ss = s.substring(8*i,8*i+8);
                    ss = Integer.toString(Integer.parseInt(ss,2));
                    sb.append(ss);
                    if(i<3){
                        sb.append(".");
                    }
                }
                System.out.println(sb.toString());

            }
        }
        sc.close();
//        int x = sc.nextInt();
//        System.out.println(Long.toBinaryString(x));


    }
}
