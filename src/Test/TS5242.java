package Test;/*
 *文件名: TS5242
 *创建者: wwy
 *创建时间:2022/6/19 10:30
 *描述:
 */

public class TS5242 {
    public static void main(String[] args) {

    }
    public String greatestLetter(String s) {
        int len = s.length();
        char ans = ' ';
        for (int i =0;i<len;i++){
            char c = s.charAt(i);
            if (Character.isLowerCase(c)){
                int a = c-32;
                char cc = (char)a;
                if (s.contains(cc+"")){
                    if ((int)ans<(int)cc){
                        ans = cc;
                    }
                }
            }
            if (Character.isUpperCase(c)){
                int a = c+32;
                char cc = (char)a;
                if (s.contains(cc+"")){
                    if ((int)ans<(int)c){
                        ans = c;
                    }
                }
            }
        }
        if (ans==' '){
            return new String("");
        }else {
            return ans+"";
        }

    }
}

