package Test;/*
 *文件名: TS6091
 *创建者: wwy
 *创建时间:2022/6/5 10:50
 *描述:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TS6091 {
    public static void main(String[] args) {

    }
    public boolean[] visited;
    public int partitionArray(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        int b = (sum-k)/2;
        if (b<0){
            return 0;
        }
        visited = new boolean[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        return 0;


    }
    public void dfs(int sum,boolean[] visited,int[] nums,List<Integer> path,List<int[]> list){
        if (path.stream().mapToInt(Integer::intValue).sum()==sum){
//            list.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i =0;i<nums.length;i++){
            if(!visited[i]){

            }
        }
    }

    public int partitionArray1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n==1){
            return 1;
        }
        int indexa =0;
        int index2 =0;
        int ans =1;
        while (index2<n){
            if(nums[index2]-nums[indexa]>k){
                ans+=1;
                indexa = index2;
            }
            index2 +=1;
        }
        return ans;

    }
}
