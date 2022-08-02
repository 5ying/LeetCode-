package Test;/*
 *文件名: TS6108
 *创建者: wwy
 *创建时间:2022/7/3 10:39
 *描述: 密码解密
 */

import java.util.HashMap;
import java.util.Map;

public class TS6108 {
    public static void main(String[] args) {
      String str =   decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv");
        System.out.println(str);
    }
    public static String decodeMessage(String key, String message) {
        char[] zimu = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l'
        ,'m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int len = key.length();
        Map<Character,Character> map = new HashMap<>();
        char[] chars = key.toCharArray();
        int j=0;
        for (int i=0;i<len;i++){
            if (Character.isLetter(chars[i])&&!map.containsKey(chars[i])){
                map.put(chars[i],zimu[j]);
                j++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int k=0;k<message.length();k++){
            char c = message.charAt(k);
            if (Character.isLetter(c)){
                sb.append(map.get(c));
            }else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
