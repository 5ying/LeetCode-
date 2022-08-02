package HuaWei;/*
 *文件名: HJ87
 *创建者: wwy
 *创建时间:2022/3/8 17:27
 *描述:密码强度等级
 */

import java.util.Scanner;

public class HJ87 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int num = 0;
            char[] cc = str.toCharArray();
//          密码长度得分
            if(cc.length<=4){
                num = num + 5;
            }else if(cc.length>=5&&cc.length<=7) {
                num = num + 10;
            }else{
                num = num +25;
            }

            int zimuBig = 0;
            int zimuSmall = 0;
            int shuzi = 0;
            int fuhao = 0;
            for (char c :cc){
//                先判断是否是字母
                if (Character.isLetter(c)){
//                    继续分大小写
                    if(c>='a' && c<='z' ){
                        zimuSmall++;
                    }else{
                        zimuBig++;
                    }

                }else if (Character.isDigit(c)){
//                    是否是数字
                    shuzi++;
                }else{
//                    符号
                    fuhao ++;
                }
            }

//            进行加分
            if (zimuBig==0&&zimuSmall==0){
                num += 0;
            }else if (zimuBig == 0|| zimuSmall == 0){
                num +=10;
            }else {
                num += 20;
            }

            if(shuzi==0){
                num += 0;
            }else if(shuzi==1){
                num +=10;
            }else{
                num += 20;
            }

            if(fuhao==0){
                num += 0;
            }else if(fuhao==1){
                num +=10;
            }else{
                num += 25;
            }

            if (zimuBig > 0 && zimuSmall > 0 && shuzi>0 && fuhao>0){
                num += 5;
            }else if((zimuBig > 0 || zimuSmall > 0) && shuzi>0 && fuhao>0){
                num +=3;
            }else if ((zimuBig > 0 || zimuSmall > 0) && shuzi>0){
                num += 2;
            }else{
                num += 0;
            }

            if(num>=90){
                System.out.println("VERY_SECURE");
            }else if(num>=80) {
                System.out.println("SECURE");

            }else if(num>=70) {
                System.out.println("VERY_STRONG");

            }else if(num>=60) {
                System.out.println("STRONG");

            }else if(num>=50) {
                System.out.println("AVERAGE");

            }else if(num>=20) {
                System.out.println("WEAK");

            }else{
                System.out.println("VERY_WEAK");

            }


        }

        sc.close();
    }
}
