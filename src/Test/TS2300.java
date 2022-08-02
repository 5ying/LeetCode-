package Test;/*
 *文件名: TS2300
 *创建者: wwy
 *创建时间:2022/6/17 10:22
 *描述:
 */

import java.util.Arrays;

public class TS2300 {
    public static void main(String[] args) {

    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] paris = new int[n];
        Arrays.sort(potions);

        for (int i =0;i<n;i++){
            int spell = spells[i];
            int left = 0;
            int right = m-1;
            if ((long)spell*potions[right]<success){
                paris[i] = 0;
            } else {
                while (left<=right){
                    int mid = left+(right-left)/2;
                    if ((long)spell*potions[mid]<success){
                        left = mid+1;
                    }else {
                        right = mid-1;
                    }
                }

                paris[i] = m-left;
            }
        }
        return paris;
    }
}
