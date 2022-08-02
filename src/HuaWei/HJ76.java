package HuaWei;/*
 *文件名: HJ76
 *创建者: wwy
 *创建时间:2022/3/8 10:31
 *描述: 尼科彻斯定理
 */
/*
分析
题目的意思是已知等差数列和 S_{n}S n为 m^{3}m3 ，项数n为m，公差d为2，求首项a_{1}a1
​
  ：S_{n} = na_{1} + \frac{n(n-1)}{2}dS n=na
1
​
 +
2
n(n−1)
​
 d
 */

import java.util.Scanner;

public class HJ76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            long ll = n*n*n;
            int a1 = (int)ll/n-(n-1);
            StringBuilder sb = new StringBuilder(Integer.toString(a1));
            for (int i = 1;i<n;i++){
                a1 = a1+2;
                sb.append("+");
                sb.append(a1);

            }
            System.out.println(sb);
        }
        sc.close();
    }
}
