package a1010;/*
 *文件名: TS02
 *创建者: wwy
 *创建时间:2022/4/10 10:30
 *描述:
 */

import java.util.Scanner;

public class TS02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i=0;i<N;i++){
            nums[i] = sc.nextInt();
        }

        int i=0;
        int j=0;

        for (;i<nums.length;){
            if (nums[i]>=nums.length-i-1){
                System.out.println("True");
                return;
            }
            if (nums[i]==0){
                System.out.println("False");
                return;
            }
            int max = nums[i+1];
            int index = i+1;
            for (j =i+1;j<=i+nums[i];j++){
                if (nums[j]>=max){
                    max = nums[j];
                    index =j;
                }
            }

            i = index;
        }

        System.out.println("False");
    }
}
