//你有 n 枚花的种子。每枚种子必须先种下，才能开始生长、开花。播种需要时间，种子的生长也是如此。给你两个下标从 0 开始的整数数组 plantTime 和 
//growTime ，每个数组的长度都是 n ： 
//
// 
// plantTime[i] 是 播种 第 i 枚种子所需的 完整天数 。每天，你只能为播种某一枚种子而劳作。无须 连续几天都在种同一枚种子，但是种子播种必须
//在你工作的天数达到 plantTime[i] 之后才算完成。 
// growTime[i] 是第 i 枚种子完全种下后生长所需的 完整天数 。在它生长的最后一天 之后 ，将会开花并且永远 绽放 。 
// 
//
// 从第 0 开始，你可以按 任意 顺序播种种子。 
//
// 返回所有种子都开花的 最早 一天是第几天。 
//
// 
//
// 示例 1： 
//
// 输入：plantTime = [1,4,3], growTime = [2,3,1]
//输出：9
//解释：灰色的花盆表示播种的日子，彩色的花盆表示生长的日子，花朵表示开花的日子。
//一种最优方案是：
//第 0 天，播种第 0 枚种子，种子生长 2 整天。并在第 3 天开花。
//第 1、2、3、4 天，播种第 1 枚种子。种子生长 3 整天，并在第 8 天开花。
//第 5、6、7 天，播种第 2 枚种子。种子生长 1 整天，并在第 9 天开花。
//因此，在第 9 天，所有种子都开花。 
// 
//
// 示例 2： 
//
// 输入：plantTime = [1,2,3,2], growTime = [2,1,2,1]
//输出：9
//解释：灰色的花盆表示播种的日子，彩色的花盆表示生长的日子，花朵表示开花的日子。 
//一种最优方案是：
//第 1 天，播种第 0 枚种子，种子生长 2 整天。并在第 4 天开花。
//第 0、3 天，播种第 1 枚种子。种子生长 1 整天，并在第 5 天开花。
//第 2、4、5 天，播种第 2 枚种子。种子生长 2 整天，并在第 8 天开花。
//第 6、7 天，播种第 3 枚种子。种子生长 1 整天，并在第 9 天开花。
//因此，在第 9 天，所有种子都开花。 
// 
//
// 示例 3： 
//
// 输入：plantTime = [1], growTime = [1]
//输出：2
//解释：第 0 天，播种第 0 枚种子。种子需要生长 1 整天，然后在第 2 天开花。
//因此，在第 2 天，所有种子都开花。
// 
//
// 
//
// 提示： 
//
// 
// n == plantTime.length == growTime.length 
// 1 <= n <= 105 
// 1 <= plantTime[i], growTime[i] <= 104 
// 
// Related Topics 贪心 数组 排序 
// 👍 28 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Java：全部开花的最早一天
 //  2022-06-29 14:41:54	获取当前时间
class P2136EarliestPossibleDayOfFullBloom{
    public static void main(String[] args) {
        Solution solution = new P2136EarliestPossibleDayOfFullBloom().new Solution();
        // TO TEST
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /*
        * 贪心：
        * 1、种植的总时间是固定的，种不完，花也生长不完
        * 2、所以要尽量让“露出的尾巴”短。（意思就是尽量让中化的时间短）
        * */
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;

        List<Integer> ids = new ArrayList<>();
        for (int i =0;i<n;i++){
            ids.add(i);
        }

//        这里就是写了一个排序规则 降序排序
//        花的生长天数逆序排序  生长天数长的优先播种 ids记录了花生长天数的排序下标
        Collections.sort(ids, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return growTime[o2]-growTime[o1];
            }
        });

        int res =0;
        int pt =-1;
        for (int i:ids){
            pt += plantTime[i];
            int gt = pt+growTime[i]+1;
            res = Math.max(res,gt);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
