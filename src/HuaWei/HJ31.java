package HuaWei;/*
 *文件名: HJ31
 *创建者: wwy
 *创建时间:2022/3/5 9:44
 *描述:单词倒排
 */

import java.util.Scanner;

public class HJ31 {
    public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String res= "";
//        int length = str.length();
//        int start = length-1;
//        int end =0;
//        int current = 0;
//        while (start>=0){
//            if (start>=0 && str.charAt(start)==' '){
//                start--;
//            }else if( Character.isLetter(str.charAt(start))){
//                start--;
//                res = res +" ";
//            } else{
//                end = start;
//                while (start>=0 && (str.charAt(start) != ' '||  Character.isLetter(str.charAt(start)))){
//                    start--;
//                }
//                current = start+1;
//                while (current<=end){
////                    if ((str.charAt(current)>='a' && str.charAt(current)<='z') || (str.charAt(current)>='A' && str.charAt(current)<='Z') ) {
////                        res = res + str.charAt(current) + "";
////                    }else{
////                        res = res +" ";
////                    }
//                    res = res + str.charAt(current) + "";
//                    current++;
//                }
//                res = res+" ";
//            }
//        }
//        System.out.println(res);

        Scanner sc = new Scanner(System.in);
        String test = sc.nextLine();

        char[] ch = test.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetter(ch[i])) {
                sb.append(ch[i]);
            }else{
                sb.append(" ");
            }
        }
        String[] arr = sb.toString().split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]+" ");
        }

    }

}
