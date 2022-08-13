package a1010;/*
 *文件名: TS0805
 *创建者: wwy
 *创建时间:2022/8/5 21:20
 *描述:
 2022年 用友集团秋招 代码
 第一题 ： 数字键盘输入
 第二题 ：  查看可以看到多少楼顶 （单调栈）
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Yongyou_0805 {



        public static void main(String[] args) {
            int[] aa =  findBuilding(new int[]{50,30,80,30,27,57});
            for (int i =0;i<aa.length;i++){
                System.out.println(aa[i]);
            }

        }
        public int[][] count (String str) {
            // write code here
            Map<Character,int[]> map = new HashMap<>();
            map.put('@',new int[]{1,1});
            map.put('!',new int[]{1,2});
            map.put('.',new int[]{1,3});
            map.put('/',new int[]{1,4});
            map.put('a',new int[]{2,1});
            map.put('b',new int[]{2,2});
            map.put('c',new int[]{2,3});
            map.put('d',new int[]{3,1});
            map.put('e',new int[]{3,2});
            map.put('f',new int[]{3,3});
            map.put('g',new int[]{4,1});
            map.put('h',new int[]{4,2});
            map.put('i',new int[]{4,3});

            map.put('j',new int[]{5,1});
            map.put('k',new int[]{5,2});
            map.put('l',new int[]{5,3});
            map.put('m',new int[]{6,1});
            map.put('n',new int[]{6,2});
            map.put('o',new int[]{6,3});

            map.put('p',new int[]{7,1});
            map.put('q',new int[]{7,2});
            map.put('r',new int[]{7,3});
            map.put('s',new int[]{7,4});

            map.put('t',new int[]{8,1});
            map.put('u',new int[]{8,2});
            map.put('v',new int[]{8,3});

            map.put('w',new int[]{9,1});
            map.put('x',new int[]{9,2});
            map.put('y',new int[]{9,3});
            map.put('z',new int[]{9,4});

            int[] count = new int[10];
            for (int i=0;i<str.length();i++){
                char c = str.charAt(i);
                count[map.get(c)[0]] +=map.get(c)[1];
            }

            List<int[]> res = new ArrayList<>();
            for (int i =1;i<=9;i++){
                if (count[i]!=0)
                    res.add(new int[]{i,count[i]});
            }

            int[][] ans = new int[res.size()][2];

            for (int i =0;i<res.size();i++){
                ans[i] = res.get(i);
            }

            return ans;

        }



//        双端队列 查看楼顶
        public  static  int[] findBuilding (int[] heights) {
            // write code here
            int n = heights.length;
            int[] res = new int[n];

            int[] right = new int[n];
            int[] left = new int[n];
            int[] ans = new int[n];
            Stack<Integer> rightStack = new Stack<>();
            Stack<Integer> leftStack = new Stack<>();


            for(int i=n-1;i>=0;i--){
                right[i] = rightStack.size();
                ans[i] = rightStack.size();
                if (i == n-1){
                    rightStack.push(heights[i]);
                }else if (heights[i]<rightStack.peek()){
                    rightStack.push(heights[i]);
                }else {
                    while (rightStack.size()!=0&& heights[i]>=rightStack.peek()){
                        rightStack.pop();
                    }
                    rightStack.push(heights[i]);
                }
            }

            for(int i=0;i<n;i++){
                left[i] = leftStack.size();
                ans[i] +=leftStack.size()+1;
                if (i == 0){
                    leftStack.push(heights[i]);
                }else if (heights[i]<leftStack.peek()){
                    leftStack.push(heights[i]);
                }else {
                    while (leftStack.size()!=0&& heights[i]>=leftStack.peek()){
                        leftStack.pop();
                    }
                    leftStack.push(heights[i]);
                }
            }

//        int index =0;
//        for (int i =0;i<n;i++){
//            if (right[i]!=0 || left[i] !=[0]){
//                ans[index++] = right[i];
//            }
//
//        }
//        for (int i =0;i<n;i++){
//            if (left[i]!=0){
//                ans[index++] = left[i];
//            }
//
//        }

            return ans;

        }




}
