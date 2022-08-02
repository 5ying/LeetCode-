package HuaWei;/*
 *文件名: HJ37
 *创建者: wwy
 *创建时间:2022/5/6 11:24
 *描述: 统计每个月兔子的数目
 */

// 斐波纳契数列

import java.util.Scanner;

public class HJ37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(f(n));
        }
    }

    public static int f(int n){
        if (n==1|| n==2){
            return 1;
        }
        return f(n-1)+f(n-2);
    }
}

//动态规划的解决方法 时间复杂度降低 动态转移方程是一样的
/*import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(dp(n));
        }
    }
    public static int dp(int n){
        int num[] = new int[n+1];
        num[1] = 1;
        num[2] = 1;
        for(int i=3;i<=n;i++){
            num[i] = num[i-1] + num[i-2];
        }
        return  num[n];
    }
}
*/
