package HuaWei;/*
 *文件名: HJ77
 *创建者: wwy
 *创建时间:2022/5/10 10:55
 *描述: 火车进站
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class HJ77 {
    static List<String> l = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            l.clear();
            int n =sc.nextInt();
            int[] number = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i=0;i<n;i++){
                number[i] = sc.nextInt();
            }
            trainOut(number,0,stack,"",0);
            Collections.sort(l);
            for (String str:l){
                System.out.println(str);
            }
        }
    }

    // 回溯
    public static void trainOut(int[] id,int i,Stack<Integer> s,String str,int n){
        if (n==id.length){ // 均出栈保存结果
            l.add(str); // 结果集
        }
        if (!s.empty()){ //非空
            int temp = s.pop();
            trainOut(id,i,s,str+temp+" ",n+1);
            s.push(temp); //恢复现场
        }
        if (i<id.length){ //
            s.push(id[i]);
            trainOut(id,i+1,s,str,n);
            s.pop(); //恢复现场
        }
    }
}
