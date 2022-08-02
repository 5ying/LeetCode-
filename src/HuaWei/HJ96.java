package HuaWei;/*
 *文件名: HJ96
 *创建者: wwy
 *创建时间:2022/3/9 10:10
 *描述: 表示数字
 */

import java.util.Scanner;

public class HJ96 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
//            前面一个数是否为数字的标志
            boolean flag = false;
            for (char cc:str.toCharArray()){
//                假如是数字
                if(Character.isDigit(cc)){
//                    为真，则前面一个数是数字
                    if (flag){
                        sb.append(cc);
                    }else{
//                        当前面一个数不是数字时，就在数字之前添加一个*，并且把标志改为true
                        sb.append('*');
                        sb.append(cc);
                        flag = true;
                    }
//                    是字母
                }else{
//                    当前字符非数字，并且前一个数字是数字时，在其前面添加*，并改为false
                    if (flag){
                        sb.append('*');
                        sb.append(cc);
                        flag = false;
                    }else{
                        sb.append(cc);
                    }
                }

            }
//            判断输入的最后一个字符是什么
            if (Character.isDigit(str.charAt(str.length()-1))){
                sb.append('*');
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
