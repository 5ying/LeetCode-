package HuaWei;/*
 *文件名: HJ51
 *创建者: wwy
 *创建时间:2022/5/6 14:55
 *描述:
 */

import java.util.Scanner;

public class HJ51 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            // 构建链表
            int n = sc.nextInt();
            ListNode dy = new ListNode(-1);
            ListNode node = dy;
//             ListNode node = new ListNode();
//             dy.next = node;
            for (int i =0;i<n;i++){
                ListNode temp = new ListNode(sc.nextInt());
                node.next = temp;
                node = node.next;
            }

            int K = sc.nextInt();
            // 输出链表的倒数第K个值
            if (findK(dy,K)!=null){
                System.out.println(findK(dy,K).data);
            }else {
                System.out.println(0);
            }

        }


    }
    //查找倒数第K个值
    public static ListNode findK(ListNode node,int K){
        if (K<0){
            return null;
        }
        if (node==null)
            return null;

        ListNode fist = node;
        ListNode last = node;
        for (int i=0;i<K;i++){
            if (fist==null){
                return fist;
            }
            fist = fist.next;
        }
        while (fist!=null) {
            fist = fist.next;
            last = last.next;
        }
        return last;

    }

    static class ListNode{
        int data;
        ListNode next;
        public ListNode(){

        }
        public ListNode(int data, ListNode next){
            this.data = data;
            this.next = next;

        }
        public ListNode(int data){
            this.data = data;
        }

    }
}
