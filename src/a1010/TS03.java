package a1010;/*
 *文件名: TS03
 *创建者: wwy
 *创建时间:2022/4/10 10:58
 *描述:
 */

public class TS03 {
    public static void main(String[] args) {
        int nums[] = {9,6,7,8};
        boolean ff = ss(nums);

        if (ff) {
            System.out.println("1");
        }else {
            System.out.println("0");
        }

    }

    public static boolean ss(int nums[]) {
        boolean flag = false;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] - 1 == nums[i + 1]) {
                flag = true;
                i++;

            } else if (nums[i] - 1 == nums[nums.length - 1 - i]) {

                flag = true;
            } else {
                flag = false;
                return flag;
            }

        }
//        int left =0;
//        int right = nums.length-1;
//        int number;
//        while (left<right){
//            if (nums[left]>nums[right]){
////                number = nums[left];
//               while (nums[left]-1==nums[left-1]){
//                   left--;
//               }
//               if (nums[left]-1==nums[right]){
//
//               }
//
//            }
//            if (nums[left-1]==nums[right] ){
//                right--;
//            }

        return flag;
    }


//    判断该网球是否符合规定



}
