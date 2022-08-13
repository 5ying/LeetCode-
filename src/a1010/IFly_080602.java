package a1010;/*
 *文件名: TS080602
 *创建者: wwy
 *创建时间:2022/8/6 19:30
 *描述:  貌似是科大讯飞的题目
 */

public class IFly_080602 {
    public static void main(String[] args) {

    }

    public int findEwordCount (String string) {
        // write code here
        int ans =0;
        String[] ss = string.split(" ");
        for (String s:ss){
            if (s.contains("e")||s.contains("E")){
                ans++;
            }
        }
        return ans;

    }

    public class Point {
    int x;
    int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

//求四边形面积
    public long getArea (Point p1, Point p2, Point p3, Point p4) {
        // write code here
//        long san1 = Math.abs ((p1.x*p2.y+p2.x*p3.y+p3.x*p1.y
//                -(p1.x*p3.y+p2.x*p1.y+p2.x*p2.y)));
//
//        long san2 = Math.abs((p1.x*p3.y+p3.x*p4.y+p4.x*p1.y
//                -(p1.x*p4.y+p3.x*p1.y+p4.x*p3.y)));
//
//        long sum = san1+san2;
//        return sum;

        long san1 = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y
                -(p1.x*p3.y+p2.x*p1.y+p2.x*p2.y));

        long san2 =(p1.x*p3.y+p3.x*p4.y+p4.x*p1.y
                -(p1.x*p4.y+p3.x*p1.y+p4.x*p3.y));

        long sum = Math.abs(san1+san2)/2;
        return sum;
    }

//    寻找iflytek
public int findIflytek (String str) {
    // write code here
    String t = "iflytek";
    if (str.length()<t.length()){
        return 0;
    }
    int[][] dp = new int[str.length()+1][t.length()+1];
    dp[0][0]=1;
    for (int i=0;i<str.length();i++){
        dp[i+1][0]=1;
        for (int j=0;j<=i&&j<t.length();j++){
            dp[i+1][j+1]=str.charAt(i)==t.charAt(j)?dp[i][j]+dp[i][j+1]:
                    dp[i][j+1];
        }
    }

    return dp[str.length()][t.length()];


}

}
