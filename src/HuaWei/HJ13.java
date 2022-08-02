package HuaWei;/*
 *文件名: HJ13
 *创建者: wwy
 *创建时间:2022/3/3 9:51
 *描述:句子逆序
 */

import java.util.Scanner;

public class HJ13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String reStr = "";
            int end;
            int current;
            int start = str.length()-1;
            while(start>=0){
                if (start>=0 && str.charAt(start)==' '){
                    reStr = reStr +" ";
                    start--;
                }else{
                        end = start;
                        while (start>=0 && str.charAt(start)!=' '){
                            start--;
                        }
                        current = start+1;
                        while (current<=end){
                            reStr = reStr + str.charAt(current);
                            current++;
                        }
                    }
                }

            System.out.println(reStr);
        }
    }
}
