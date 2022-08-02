package Test;/*
 *文件名: TS2299
 *创建者: wwy
 *创建时间:2022/6/17 10:03
 *描述:
 */

public class TS2299 {
    public static void main(String[] args) {

    }
    public boolean strongPasswordCheckerII(String password) {
        int len = password.length();
        if (len<8){
            return false;
        }
        char[] str = password.toCharArray();
        String specStr = "!@#$%^&*()-+";
        boolean lowerCase = false;
        boolean upCase = false;
        boolean digit = false;
        boolean spec = false;
        for (int i =0;i<len;i++){
            char ss = str[i];
            if (i>0 && ss== str[i-1]){
                return false;
            }
            if (Character.isLetter(ss) && (!lowerCase || !upCase)){
                if (Character.isLowerCase(ss)){
                    lowerCase = true;
                }else {
                    upCase = true;
                }
            }
           else if (Character.isDigit(ss) && !digit){
                digit = true;
            }
           else if (specStr.contains(ss+"") && !spec){
                spec = true;
            }else {
               continue;
            }
        }
        return lowerCase && upCase&& digit && spec;
    }
}
