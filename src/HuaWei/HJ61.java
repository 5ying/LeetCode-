package HuaWei;/*
 *文件名: HJ61
 *创建者: wwy
 *创建时间:2022/3/7 22:10
 *描述:放苹果
 背包问题:动态规划

 */
/*
分析：
         设f(m,n) 为m个苹果，n个盘子的放法数目，先对n作讨论：
         当n>m：f(m,n) = f(m,m) （必定有n-m个盘子永远空着，去掉它们对摆放苹果方法数目不产生影响）；
         当n<=m：不同的放法可以分成两类：
         1、有空盘子（至少一个盘子为空），把m个苹果放在除空盘外其余的盘子里，即相当于f(m,n-1);
         2、所有盘子都有苹果，相当于可以从每个盘子中拿掉一个苹果，共拿走n＊1个苹果，不影响不同放法的数目，即f(m-n,n)。
         而总的放苹果的放法数目等于两者的和，即 f(m,n) =f(m,n-1)+f(m-n,n)
     递归出口条件说明：
         当n=1时，所有苹果必然放在一个盘子里，所以返回１；
         当没有苹果可放时，定义为１种放法；
         递归的两条路，第一条n会逐渐减少，终会到达出口n==1;
         第二条m会逐渐减少，因为n>m时，我们会return f(m,m)　所以终会到达出口m==0．
 */

import java.util.Scanner;

public class HJ61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(putApple(m,n));

        }
        sc.close();
    }

    public static int putApple(int m,int n){
        if(m<0||n<0){
            return 0;
        }else if(m==0 || n==1){
            return 1;
        }else if(m<n){
            return putApple(m,m);
        }else{
            return putApple(m,n-1)+putApple(m-n,n);
        }
    }
}
