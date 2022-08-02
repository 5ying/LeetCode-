package HuaWei;/*
 *文件名: LK
 *创建者: wwy
 *创建时间:2022/3/6 10:39
 *描述:
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LK {
//    public static void main(String[] args) {
//        String ss = "A1:F1";
//        List<String > list = cellsInRange(ss);
//        list.sort(Comparator.naturalOrder());
//        System.out.println(list);
//    }
//    public static List<String> cellsInRange(String s) {
//        String[] ss = s.split(":");
//        List<String> list = new ArrayList<>();
//
//        int a = Integer.parseInt(String.valueOf(ss[0].charAt(1)));
//        int b = Integer.parseInt(String.valueOf(ss[1].charAt(1)));
//        char a1 = ss[0].charAt(0);
//        char b1 = ss[1].charAt(0);
//        for(int i =a;i<=b;i++){
//            for(char j = a1;j<=b1; j++){
//                String t = j + String.valueOf(i);
//                list.add(t);
//            }
//        }
//        list.sort(Comparator.naturalOrder());
//        return  list;
//
//
////        if (ss[0].charAt(1)==ss[1].charAt(1)){
////            String temp = ss[0].charAt(0)+"";
////            while(Integer.valueOf(temp)<=Integer.valueOf(ss[1].charAt(0)+"")){
////                list.add(temp+ss[0].charAt(1)+"");
////                temp = temp +1;
////            }
////        }
////       else{
//
//
////        }
//
//
//    }
//
//  public static void main(String[] args) {
//        int[] nums  = {5,6};
//        int k =6;
//        long sum = minimalKSum(nums,k);
//        System.out.println(sum);
//    }
//
////
//
//    public  static long minimalKSum(int[] nums, int k) {
//        Set<Integer> set = new TreeSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        set.add(0);
//        set.add(Integer.MAX_VALUE);
//        // 找出每两个数之间的间隔，算入结果中
//        long res = 0;
//        int lastNum = 0;
//        for (int num : set) {
//            int diff = num - lastNum;
//            if (diff > 1 && k > 0) {
//                // res += (lastNum+1) + (lastNum+2) + ... + (lastNum+diff-1)且不超过k个
//                long range = Math.min(diff - 1, k);
//                res += (lastNum + 1 + lastNum + range) * range / 2;
//                k -= range;
//            }
//            lastNum = num;
//        }
//        return res;
//    }


//    public static  long minimalKSum(int[] nums, int k) {
////        Set<Integer> set = new TreeSet<>();
//        long sum = 0;
//        List<Integer> list = new ArrayList<>();
//        for (int ii :nums) {
////            set.add(ii);
//            list.add(ii);
//        }
//
//            for (int i =1;k>0;i++ ){
//                if(!list.contains(i)){
//                    k--;
//                    sum = sum+i;
//                }
//            }
//
//        return sum;

    //    }
    public static void main(String[] args) {
        int[][] descriptions = {{20, 15, 1}, {20, 17, 0}};
        TreeNode root = createBinaryTree(descriptions);

    }

    public static TreeNode createBinaryTree(int[][] descriptions) {

        Set<Integer> set = new HashSet<>();

        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] d : descriptions) {
            int pval = d[0];
            int cval = d[1];
            boolean left = (d[2] == 1) ? true : false;

            TreeNode pNode = map.get(pval);
            if (pNode == null) {
                pNode = new TreeNode(pval);
                map.put(pval, pNode);
            }

            TreeNode cNode = map.get(cval);
            if (cNode == null) {
                cNode = new TreeNode(cval);
                map.put(cval, cNode);
            }
            set.add(cval);

            if (left) {
                pNode.left = cNode;
            } else {
                pNode.right = cNode;
            }
        }
        TreeNode root = null;
        for (int v : map.keySet()) {
            if (set.contains(v)) continue;
            else {
                root = map.get(v);
                break;
            }
        }

        return root;
    }



//        TreeNode root = new TreeNode();
//        for (int i = 0;i<descriptions.length;i++){
//            int a = descriptions[i][0];
//            int b = descriptions[i][1];
//            int c = descriptions[i][2];
//            if(c==1){
//
//            }
//            if (root.val == b){
//                root = new TreeNode
//            }
//            TreeNode node = new TreeNode();
//
//
//            for (int j = 0;j<descriptions[0].length;j++){
//                int[] a = descriptions[i];
//                int b = 0;
//            }
//        }
//        return root;
//

//    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
