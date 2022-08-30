package greedalgorithm;

import org.junit.Test;

/**
 * 在⼀条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有⼀辆油箱容量⽆限的的汽⻋，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的⼀个加
 * 油站出发，开始时油箱为空。
 * 如果你可以绕环路⾏驶⼀周，则返回出发时加油站的编号，否则返回 -1。
 * 说明:
 * 示例 1:
 * 输⼊:
 * gas = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3
 *
 * @author xyd
 * @create 2022-08-29 7:13
 */
public class GasStation {
    // 暴力法
    int canCompleteCircuit1(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
           int rest = gas[i] - cost[i];
           int index = (i + 1) % gas.length;
           while ( rest > 0 && index != i) {
               rest += (gas[index] - cost[index]);
               index = (index + 1) % gas.length;
           }
           if(index == i && rest >= 0) {
               return  i;
           }
        }
        return -1;
    }

    // 贪心法一
    int canCompleteCircuit2(int[] gas, int[] cost) {
        int curSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            if(min > curSum) {
                min = curSum;
            }
        }
        if(curSum < 0) {
            return -1;
        }
        if(min >= 0 ) {
            return 0;
        }

        for (int i = gas.length - 1; i >= 0 ; i--) {
            int rest = gas[i] - cost[i];
            min += rest;
            if(min >= 0) {
                return i;
            }
        }
        return -1;
    }

    // 贪心算法2
    int canCompleteCircuit3(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            totalSum += rest;
            curSum += rest;
            if(curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if(totalSum < 0 ) {
            return -1;
        }
        return start;
    }


    @Test
    public void test() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int start = canCompleteCircuit3(gas, cost);
        System.out.println(start);
    }
}
