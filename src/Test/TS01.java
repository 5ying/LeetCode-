package Test;/*
 *文件名: TS01
 *创建者: wwy
 *创建时间:2022/4/27 11:45
 *描述: 全排列 1-N的全排列问题
 */

import java.util.Arrays;

/**
 * 打个断点，查看深度优先搜索流程
 */
public class TS01 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        dfsPermutation(0);
    }
    static int N = 3;//1~N的全排列
    static int[] box = new int[N];//用来放N个排列的数字
    static int[] book = new int[N+1];//对使用过的数字进行标记，数字即下标
    //对当下状态的处理，即N种可能尝试，每个盒子可以放入1~N中的任一数字
    //index 即数组box的下标，从0开始进行dfs遍历，直到N-1有效
    static void dfsPermutation(int index) {
        //达到临界条件，输出结果，中断遍历，返回上一状态
        if (index == N) {
            System.out.println(Arrays.toString(box));
            return;
        }
        //每个盒子可以放入1~N的数字，每个状态有N次尝试
        for (int i=1; i<=N; i++) {
            if (book[i] == 0) {//放入数字的时候有限制条件，只能使用未用过的数字i，未用过的数字的标记位 book[i]=0
                box[index] = i; //把数字 i 放入到box数组，生成全排列
                book[i] = 1;//标记数字i 已经被使用了
                dfsPermutation(index+1); //进入到下一次转移
                book[i] = 0;//从上一个状态返回时，清空i的使用标志，进行下一个尝试
            }
        }
    }
}
