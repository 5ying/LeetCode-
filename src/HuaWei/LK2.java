package HuaWei;/*
 *文件名: LK2
 *创建者: wwy
 *创建时间:2022/3/13 10:31
 *描述:
 */

import java.util.HashSet;
import java.util.Set;

public class LK2 {

    public static void main(String[] args) {
//        int[] nums = {2,2,2,2,2};
//        int key = 2;
//        int k =2;
//        List list = findKDistantIndices(nums,key,k);
//        System.out.println(list);
        int n=8;
        int[][] artifacts = {{3,2,6,2},{2,7,3,7},{1,2,1,5},{4,4,4,7},{0,0,3,0},{5,6,7,6},{0,1,0,3},{6,0,7,1},{2,1,4,1},{2,4,2,4},{5,5,5,5},{5,3,7,3},{1,1,1,1},{0,7,1,7}};
        int[][] dig = {{0,0},{0,1},{0,3},{0,4},{0,5},{0,6},{1,4},{1,6},{2,2},{2,4},{2,5},{3,0},{3,1},{3,2},{3,5},{3,6},{4,0},{4,1},{4,2},{4,6},{5,1},{5,2},{5,4},{5,7},{6,0},{6,3},{6,4},{6,6},{7,5}};
        int count = digArtifacts(n,artifacts,dig);
        System.out.println(count);

    }

//    第一道
//    public  static  List<Integer> findKDistantIndices(int[] nums, int key, int k) {
//        List list = new ArrayList();
//        Set<Integer> set = new TreeSet<>();
//        List<Integer> jj = new ArrayList();
//        for (int i = 0;i<nums.length;i++){
//            if(nums[i]==key){
//                jj.add(i);
//            }
//        }
//
//        for (int i =0;i<nums.length;i++){
//            for (int j = 0;j<jj.size();j++){
//                if (Math.abs(i-jj.get(j))<=k){
//                    set.add(i);
//                }
//            }
//        }
//        Iterator it = set.iterator();
//        while (it.hasNext()){
//            list.add(it.next());
//        }
//        return list;
//    }


//    统计可以提取的工件
    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int count = 0;
        Set<Position> set = new HashSet();
//        for (int i =0;i<dig.length;i++){
//            Position pp = new Position(dig[i][0],dig[i][0]);
//            set.add(pp);
//        }
        for (int i = 0;i<artifacts.length;i++){
//            for (int j=0;j<artifacts[0].length;j++){
                boolean flag01 =false;
                boolean flag02  = false;
                int a = artifacts[i][0];
                int b = artifacts[i][1];
                int c = artifacts[i][2];
                int d = artifacts[i][3];
                if (Math.abs(a-c)>1 || Math.abs(b-d)>1){
                    continue;
                }else {
                    int[] temp01 = {a,b};
                    int[] temp02 = {c,d};
                    for (int j =0;j<dig.length;j++){
                        if(a==dig[j][0] && b==dig[j][1]){
                            flag01 = true;
                        }
                        if(c==dig[j][0] && d==dig[j][1]){
                            flag02 = true;
                        }
                        if(flag01 && flag02 ){
                            count++;
                            break;
                        }
                    }

                }
//                Position temp01 = new Position(a,b);
//                Position temp02 = new Position(b,c);

//                if (set.contains(temp01) && set.contains(temp02)){
//                    count++;
//                }
//                if(set.equals(temp01)){
//                    count++;
//                }
//            }
        }

        return count;

    }

    public static class  Position{
        int x;
        int y;

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }

    }


}
