package HuaWei;/*
 *文件名: HJ29
 *创建者: wwy
 *创建时间:2022/3/11 9:08
 *描述: 字符串加解密
 */

import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str_01 = sc.nextLine();
        String Str_02 = sc.nextLine();
        StringBuilder sb01 = new StringBuilder();
        StringBuilder sb02 = new StringBuilder();
        for (char cc:str_01.toCharArray()){
            if(Character.isLetter(cc)){
                if(cc>='a'&&cc<='z'){
//                    变大写后移一位
                    char temp;
                    if (cc=='z'){
                        temp = 'A';
                    }else {
                        temp = (char)(Character.toUpperCase(cc)+1);
                    }
                    sb01.append(temp);
                }else{
//                    变小写后移一位
                    char tt;
                    if (cc=='Z'){
                        tt = 'a';
                    }else {
                        tt = (char)(Character.toLowerCase(cc)+1);
                    }
                    sb01.append(tt);
                }
            }else if(Character.isDigit(cc)){
                char temp;
                if(cc=='9'){
                    temp = '0';
                }else{
                    temp = (char)(cc+1);
                }
                sb01.append(temp);

            }
            else {
//                不是字符就按照原来的添加进去
                sb01.append(cc);
            }
        }
//        解密

        for (char cc:Str_02.toCharArray()){
            if(Character.isLetter(cc)){
                if(cc>='a'&&cc<='z'){
//                    变大写后移一位
                    char temp;
                    if (cc=='a'){
                        temp = 'Z';
                    }else {
                        temp = (char)(Character.toUpperCase(cc)-1);
                    }
                    sb02.append(temp);
                }else{
//                    变小写后移一位
                    char tt;
                    if (cc=='A'){
                        tt = 'z';
                    }else {
                        tt = (char)(Character.toLowerCase(cc)-1);
                    }
                    sb02.append(tt);
                }
            }else if(Character.isDigit(cc)){
                char temp;
                if(cc=='0'){
                    temp = '9';
                }else{
                    temp = (char)(cc-1);
                }
                sb02.append(temp);

            }
            else {
//                不是字符就按照原来的添加进去
                sb02.append(cc);
            }
        }

        System.out.println(sb01.toString());
        System.out.println(sb02.toString());
    }
}
