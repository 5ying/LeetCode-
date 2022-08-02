package Test;/*
 *文件名: TS02
 *创建者: wwy
 *创建时间:2022/4/27 20:00
 *描述: 二叉树的层次遍历
 *  删除二叉树的第n层，然后以树的形式返回剩下的所有的节点
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TS02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(1);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list =   findNum(root,3);
        System.out.println(list);
    }

    public static List<List<Integer>> findNum(TreeNode root,int n) {
        List<List<Integer>> rest =new LinkedList<>();
        if(root == null) return rest;
        Queue<TreeNode> qu = new LinkedList<>();//用于记录每层的值
        Queue<TreeNode> qq = new LinkedList<>();//用于记录每层的值
        qu.add(root);//首先将根节点放入队列，也就是第一层
        List<Integer> temp = new LinkedList<>();  //保存n层之前的结果
        int height =1;

        // n层之前的结果进行保存
        while(qu.size()>0 && height<n){
            int c = qu.size(); // 记录层数
            height++;

            while(c>0){
                    TreeNode t =  qu.poll();
                    temp.add(t.data);
                    if(t.left!=null)qu.add(t.left);
                    if(t.right!=null)qu.add(t.right);
                    c--;
                }
            }
        rest.add(temp);
//        n层之后，将每一个弹出的节点看作一个树来进行存储。
        while (qu.size()>0){
            TreeNode tt = qu.poll();
            if (tt.left!=null){
                qq.add(tt.left);
                List<Integer> temps= new LinkedList<>();;
                while (qq.size()>0){
                    TreeNode ts1 = qq.poll();
                    temps.add(ts1.data);
                    if(ts1.left!=null)qq.add(ts1.left);
                    if(ts1.right!=null)qq.add(ts1.right);
                }
                rest.add(temps);
            }

            if (tt.right!=null) {
                qq.add(tt.right);
                List<Integer> temps2 = new LinkedList<>();
                while (qq.size() > 0) {
                    TreeNode ts2 = qq.poll();
                    temps2.add(ts2.data);
                    if (ts2.left != null) qq.add(ts2.left);
                    if (ts2.right != null) qq.add(ts2.right);
                }
                rest.add(temps2);
            }
        }
        return rest;

    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }

    }
}
