//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 双指针 
// 👍 145 👎 0

package leetcode.editor.cn;

//Java：复写零
 class P1089DuplicateZeros{
    public static void main(String[] args) {
        Solution solution = new P1089DuplicateZeros().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] temp =new int[n];
        int j =0;
        for (int i :arr){
            temp[j++] = i;
        }
        for (int i =0,index =0;index<n && i<n;i++){
            if (temp[i]==0){
                arr[index]=0;
                index++;
                if (index>=n){
                    break;
                }else {
                    arr[index]=0;
                    index++;
                }
            }else {
                arr[index]=temp[i];
                index++;
            }
        }

    }

//    采用从后像前遍历的方法进行移动，空间复杂度为1
            public void duplicateZeros2(int[] A) {
                int n = A.length, cnt0 = 0;
                // 先统计零的总数
                for (int i = 0; i < n; ++i) if (A[i] == 0) ++cnt0;
                for (int i = n - 1; i >= 0; --i) {
                    // 碰到零就减去，剩余的就是左边零的个数
                    if (A[i] == 0) --cnt0;
                    // A[i] 向右移动 cnt0 位
                    if (i + cnt0 < n) {
                        A[i + cnt0] = A[i];
                        // 如果 A[i] 是零，移动完之后，后面还要补个零
                        if (A[i] == 0 && i + cnt0 + 1 < n) {
                            A[i + cnt0 + 1] = 0;
                        }
                    }
                }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
