package HuaWei;/*
 *文件名: HJ17
 *创建者: wwy
 *创建时间:2022/3/4 9:23
 *描述: 坐标移动

 分析：这个采用 正则表达式进行计算是比较简单的
 */

import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] ss = str.split(";");
//        int x =0;
//        int y=0;
//        for (int i =0;i<ss.length;i++){
//            if( ss[i] == null || ss[i].trim().length() == 0) {
//                continue;
//            }
//            if(!(ss[i].charAt(0)=='A'||ss[i].charAt(0)=='D'||ss[i].charAt(0)=='W'||ss[i].charAt(0)=='S')){
//                continue;
//            }
//            int mv = 0;
//            try{
//                mv = Integer.valueOf(ss[i].substring(1));
//            }catch(Exception e){
//                continue;
//            }
//
//            if((ss[i].charAt(0) == 'A')){
//                x -=mv;
//            }else if (ss[i].charAt(0)=='D'){
//                x += mv;
//            }else if (ss[i].charAt(0)=='W'){
//                y += mv;
//            }else if (ss[i].charAt(0)=='S'){
//                y -=mv;
//            }
//        }
//
//        System.out.println(x+","+y);

            String fl = new Scanner(System.in).nextLine();
            String[] split = fl.split(";");
            int x = 0;
            int y = 0;
            for (int i=0;i<split.length;i++){
                if (split[i].matches("[AWSD][0-9]*")){
                    String first = split[i].substring(0,1);
                    Integer number = Integer.valueOf(split[i].substring(1));
                    if ("A".equals(first)){
                        x = x-number;
                    }else if ("D".equals(first)){
                        x = x+number;
                    }else if ("W".equals(first)){
                        y = y+number;
                    }else if ("S".equals(first)){
                        y = y-number;
                    }
                }
            }
            System.out.println(x+","+y);

    }
}
