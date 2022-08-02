package Test;/*
 *文件名: TS6092
 *创建者: wwy
 *创建时间:2022/6/5 11:07
 *描述:
 */

import java.util.HashMap;
import java.util.Map;

public class TS6092 {
    public static void main(String[] args) {
        int[] ans = arrayChange(new int[]{1,2},new int[][]{{1,3},{2,1},{3,2}});
    }
    public  static int[] arrayChange(int[] nums, int[][] operations) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for (int i=0;i<operations.length;i++){
            if (map.containsKey(operations[i][0])){
                int index = map.get(operations[i][0]);
                nums[index] = operations[i][1];
                map.remove(operations[i][0]);
                map.put(operations[i][1],index);
//                map.replace(operations[i][0],operations[i][1]);
            }

        }

        return nums;


//        for (int i =0;i<nums.length;i++){
//            if (map.containsKey(nums[i])){
//                nums[i] = map.get(nums[i]);
//            }
//        }
//
//        int i=0;
//        int count = map.size();
//        while (i<nums.length){
//            if (map.containsKey(nums[i])){
//                nums[i] = map.get(nums[i]);
//                i++;
//                count--;
//            }
//            if (i==nums.length && count>0){
//                i =0;
//            }
//        }
//
//        return nums;
    }
}
