package HuaWei;/*
 *文件名: HJ102
 *创建者: wwy
 *创建时间:2022/3/9 11:15
 *描述:字符统计
 */

import java.util.*;
public class HJ102 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            char[] carr = s.toCharArray();
            int[] arr = new int[129];
            StringBuilder sb = new StringBuilder();
            //建立字符和出现次数的关系
            for(char c : carr){
                //遍历字符数组,将字符转成ascii值当做下标,出现的次数存为int数组的值
                arr[(int)c]++;
            }
            int max=0;
            for(int i=0;i<arr.length;i++){
                if(max<arr[i]){
                    //max赋值为出现的最多次数
                    max=arr[i];
                }
            }
            //此时max已经是最大值
            while(max!=0){
                for(int i=0;i<arr.length;i++){
                    if(arr[i]==max){
                        //如果遍历到的值和最大值max相等时,则添加
                        sb.append((char)i);//直接将ascii转成字符
                    }
                }
                max--;//从最大值依次递减,直到为0时,表示字符没出现
            }
            System.out.println(sb.toString());
        }
    }
}

