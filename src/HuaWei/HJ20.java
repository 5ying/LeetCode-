package HuaWei;/*
 *文件名: HJ20
 *创建者: wwy
 *创建时间:2022/3/10 10:20
 *描述:验证密码合格程序

 第一直觉：正则表达式
 */

import java.util.Scanner;

public class HJ20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str = sc.nextLine();

            int big = 0;
            int small = 0;
            int number =0;
            int flag = 0;
            boolean err = true;
            if (str.length()>8){
                for (char cc :str.toCharArray()){
                    if(Character.isDigit(cc)){
                        number=1;
                    }else if(Character.isLetter(cc)){
                        if(cc>='a'&&cc<='z' ){
                            small=1;
                        }else{
                            big=1;
                        }
                    }else if (cc==' ' || cc == '\n'){
                        err = false;
                        break;
                    }else {
                        flag = 1;
                    }
                }

                if (err){
                    if(big+small+number+flag>=3){
                        if (reStr(str)){
                            System.out.println("OK");
                        }else {
                            System.out.println("NG");
                        }
                    }else {
//                     字符种类小于3种
                        System.out.println("NG");
                    }

                }else{
//                 存在空格和换行
                    System.out.println("NG");
                }


            }else {
//             长度<8
                System.out.println("NG");

        }

         }
        sc.close();

    }

    private static boolean reStr(String s) {
        for (int i = 3; i < s.length(); i++) {
            if (s.substring(i).contains(s.substring(i - 3, i))) {
                return false;
            }
        }
        return true;
    }
}
