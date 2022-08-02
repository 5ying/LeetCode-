//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 
// 👍 152 👎 0

package leetcode.editor.cn;

//Java：一次编辑
 class P面试题OneAwayLcci{
    public static void main(String[] args) {
        Solution solution = new P面试题OneAwayLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public boolean oneEditAway(String first, String second) {
////        if (first.length()-second.length()>1){
////            return false;
////        }
////        if (first.length()-second.length()==1 && !isChuan(first,second)){
////            return false;
////        }
////        if (first.length()==second.length()){
////            for (int i =0;i<first.length();i++){
////                if (!first.contains(second.charAt(i)+"")){
////                    return false;
////                }
////            }
////
////        }
////        return true;
////    }
////    public boolean isChuan(String a,String b){
////        int j =0;
////        int i =0;
////        for (;i<a.length();){
////            for (;j<b.length();){
////                if (b.charAt(i)==a.charAt(j)){
////                    i++;
////                    j++;
////                    break;
////                }
////                else{
////                    j++;
////                }
////            }
////        }
////
////        if (i==b.length()-1 && j== a.length()-1){
////            return true;
////        }else {
////            return false;
////        }
////
////    }

//        双指针就可以了，之前的想法还挺麻烦的
        public boolean oneEditAway(String a, String b) {
            int n =a.length();
            int m = b.length();
            if (Math.abs(n-m)>1){
                return false;
            }
            if (n>m){
                return oneEditAway(b,a);
            }
            int i=0;
            int j=0;
            int count =0;
            while (i<n&& j<m&&count <=1){
                char c1 = a.charAt(i);
                char c2 = b.charAt(j);
                if (c1==c2){
                    i++;
                    j++;
                } else {
                    if (n==m){
                        i++;
                        j++;
                        count++;
                    }else {
                        j++;
                        count++;
                    }
                }
            }
            return count<=1;
        }


}
//leetcode submit region end(Prohibit modification and deletion)

}
