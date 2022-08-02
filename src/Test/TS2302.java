package Test;/*
 *文件名: TS2302
 *创建者: wwy
 *创建时间:2022/6/17 10:49
 *描述:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TS2302 {
    public static void main(String[] args) {
        long sum = countSubarrays(new int[]{1,1,1},5);
        System.out.println(sum);

    }
    public static long countSubarrays(int[] nums, long k) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (len==0){
            return list.size();
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        for (int i=1;i<len;i++){
            dfs(nums,i,k,len,0,list,path);
        }
        for (List ll :list){
            System.out.println(ll);
        }
        return list.size();
    }

    public static void dfs(int[] nums,int kk,long k,int len,int start,List<List<Integer>> list,List<Integer> path){
        if (path.size()==kk){
            int sum = path.stream().mapToInt(Integer::intValue).sum();
            if ((long)sum*kk<k){
                list.add(new ArrayList<>(path));
                return;
            }else {
                return;
            }
        }

        for (int i =start;i<kk+1;i++){
//            if (i>start && nums[i]==nums[i-1]){
//                continue;
//            }
            path.add(nums[i]);
            dfs(nums,kk,k,len,i+1,list,path);
            path.remove(path.size()-1);
        }
    }
}
