package org.example.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2021/6/24 15:36
 * @descrpte 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo1 {

    /**
     * 两数之和 暴力破解（不采用）
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int source = target - nums[i];
            //是否包含这个值，包含的话直接返回
            if (map.containsValue(source)) {
                arr[0] = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == source) {
                        arr[1] = j;
                        return arr;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 通过数据添加到指定的数据中，那么就指定的方式存放(map相当于一个结果临时表)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int source = target - nums[i];
            if (map.containsKey(source)) {
                return new int[]{map.get(source), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSumMap(nums, target);
        for (int a : ints) {
            System.out.println(a);
        }
    }
}
