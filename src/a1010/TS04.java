package a1010;/*
 *文件名: TS04
 *创建者: wwy
 *创建时间:2022/4/12 18:35
 *描述:
 */

import java.util.*;

public class TS04 {
    public static void main(String[] args) {
//        输入
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for(int i =0;i<N;i++){
            A[i] = sc.nextInt();
       }
        for(int i =0;i<N;i++){
            B[i] = sc.nextInt();

        }
//        主要是这一块的判断，改成python的判断就可以了

        int count=0;  // 记录操作次数
        for (int i =1;i<N;i++){
            if (A[i-1]>A[i]){
                if ( B[i-1]<A[i]){
                    count ++;
                }else if (B[i]>A[i-1]){
                    count ++;
                } else {
                    count = -1;
                    break;
                }
            }
        }

        for (int i=0;i<N-1;i++){
            if(A[i]>A[i+1]){
                count = -1;
                break;
            }
        }

//        int count=0;  // 记录操作次数
//        for (int i =0;i<N-1;i++){
//            if (A[i]>A[i+1]){
//                if ( B[i]<A[i+1]){
//                    count ++;
//                }else if (B[i+1]>A[i]){
//                    count ++;
//                } else {
//                    count = -1;
//                    break;
//                }
//            }
//        }

        System.out.println(count);

    }


}
