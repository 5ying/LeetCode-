package HuaWei;/*
 *文件名: HJ21
 *创建者: wwy
 *创建时间:2022/3/4 9:36
 *描述: 简单密码
 */

import java.util.Scanner;

public class HJ21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String result = "";
            for (int i = 0;i<str.length();i++){
                if(str.charAt(i)>='A' && str.charAt(i) <= 'Z'){
                    if (str.charAt(i)=='Z'){
                        result = result + 'a';
                    }else {
                        int aa = Integer.valueOf(str.charAt(i))+33;
                        result = result+(char)aa;
                    }
                }else if(str.charAt(i)>='a' && str.charAt(i) <= 'z'){
                    switch (str.charAt(i)){
                        case 'a':
                            result = result +'2';
                            break;
                        case  'b':
                            result = result +'2';
                            break;
                        case  'c':
                            result = result +'2';
                            break;
                        case  'd':
                            result = result +'3';
                            break;
                        case  'e':
                            result = result +'3';
                            break;
                        case  'f':
                            result = result +'3';
                            break;
                        case  'g':
                            result = result +'4';
                            break;
                        case  'h':
                            result = result +'4';
                            break;
                        case  'i':
                            result = result +'4';
                            break;
                        case  'j':
                            result = result +'5';
                            break;
                        case  'k':
                            result = result +'5';
                            break;
                        case  'l':
                            result = result +'5';
                            break;
                        case  'm':
                            result = result +'6';
                            break;
                        case  'n':
                            result = result +'6';
                            break;
                        case  'o':
                            result = result +'6';
                            break;
                        case  'p':
                            result = result +'7';
                            break;
                        case  'q':
                            result = result +'7';
                            break;
                        case  'r':
                            result = result +'7';
                            break;
                        case  's':
                            result = result +'7';
                            break;
                        case  't':
                            result = result +'8';
                            break;
                        case  'u':
                            result = result +'8';
                            break;
                        case  'v':
                            result = result +'8';
                            break;
                        case  'w':
                            result = result +'9';
                            break;
                        case  'x':
                            result = result +'9';
                            break;
                        case  'y':
                            result = result +'9';
                            break;
                        case  'z':
                            result = result +'9';
                            break;
                    }

                } else{
                    result = result +str.charAt(i);
                }

            }

            System.out.println(result);
        }
    }
}
