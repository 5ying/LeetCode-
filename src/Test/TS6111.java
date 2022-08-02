package Test;/*
 *文件名: TS6111
 *创建者: wwy
 *创建时间:2022/7/3 10:57
 *描述:
 */

public class TS6111 {
    public static void main(String[] args) {

    }

//    通过了，惊奇！
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        int top =0;
        int bottom = m-1;
        int left =0;
        int right = n-1;

        ListNode cur = head;
        while (true){
            for (int i =left;i<=right;i++){
                if (cur!=null){
                    ans[top][i] = cur.val;
                    cur = cur.next;
                }else {
                    ans[top][i] = -1;
                }

            }
            if (++top>bottom){
                break;
            }
            for (int i =top;i<=bottom;i++){
                if (cur!=null){
                    ans[i][right] = cur.val;
                    cur = cur.next;
                }else{
                    ans[i][right] = -1;
                }

            }

            if(--right<left){
                break;
            }
            for (int i =right;i>=left;--i){
                if (cur!=null){
                    ans[bottom][i] = cur.val;
                    cur = cur.next;
                }else {
                    ans[bottom][i] = -1;
                }

            }

            if (--bottom<top){
                break;
            }

            for (int i =bottom;i>=top;--i){
                if (cur!=null){
                    ans[i][left] = cur.val;
                    cur = cur.next;
                }else {
                    ans[i][left] =-1;
                }


            }

            if (++left>right){
                break;
            }

        }
        return ans;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
