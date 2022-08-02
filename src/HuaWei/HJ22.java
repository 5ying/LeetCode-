package HuaWei;/*
 *文件名: HJ22
 *创建者: wwy
 *创建时间:2022/3/4 10:04
 *描述: 汽水瓶
 */

import java.util.Scanner;

public class HJ22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            if (number == 0) {
                System.exit(0);
            } else {
                int a = number;
                int b = number;
                int count = 0;
                while (a + b > 2) {
//                    取余数，是不够3的倍数，剩下的汽水
                    a = a % 3;
//                    取商，是够3的倍数，换来的汽水。
                    b = b / 3;
                    count = count + b;
//                    如果两者想加的数量>=3,就还可以换汽水
                    if (a + b > 2) {
                        a = a + b;
                        b = a;
                    } else {
//                        假如数量<3，就不能再换汽水了
                        break;
                    }
                }
//                如果手里省两个空瓶，就存在借老板一瓶汽水的情况
                if (a + b == 2) {
                    count = count + 1;
                }
                System.out.println(count);
            }
        }

    }
}
