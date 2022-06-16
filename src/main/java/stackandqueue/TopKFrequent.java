package stackandqueue;

import org.junit.Test;

import javax.print.DocFlavor;
import java.util.*;

/**
 * leetcode 347
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * @author xyd
 * @create 2022-06-16 9:09
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        //统计每一个元素的频率
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num, 0 ) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if(queue.size() > k){
                queue.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0 ; i--) {
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
    @Test
    public void test(){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ans = topKFrequent(nums, k);
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
