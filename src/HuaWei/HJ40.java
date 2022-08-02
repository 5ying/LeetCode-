package HuaWei;/*
 *文件名: HJ40
 *创建者: wwy
 *创建时间:2022/3/6 10:25
 *描述: 统计字符
 */

import java.util.Scanner;

public class HJ40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str = sc.nextLine();
            int ying = 0;
            int kong = 0;
            int shu = 0;
            int other = 0;
            for (char cc :str.toCharArray()){
                if(Character.isLetter(cc)){
                    ying++;
                }
                else if (Character.isDigit(cc)){
                    shu++;
                }
                else if (cc==' '){
                    kong++;
                }else{
                    other++;
                }
            }

            System.out.println(ying);
            System.out.println(kong);
            System.out.println(shu);
            System.out.println(other);

        }

    }
}
