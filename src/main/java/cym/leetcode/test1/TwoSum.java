package cym.leetcode.test1;

import java.util.*;

/**
 * Date time: 2018/6/6 15:52
 * Author: yiming.chen@navercorp.com
 * Description:
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] base = {2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum(base, 9)));

        System.out.println("--------------------------------------");

        System.out.println(Arrays.toString(twoSum2(base, 9)));

        System.out.println("--------------------------------------");

        System.out.println(Arrays.toString(twoSum3(base, 9)));

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            tempMap.put(nums[i], i);
        }
        int tempInt = -1;
        for (int i = 0; i < nums.length; i++) {
            tempInt = target - nums[i];
            if (tempMap.containsKey(tempInt) && i != tempMap.get(tempInt)) {
                return new int[]{i, tempMap.get(tempInt)};
            }
        }
        return null;
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>(nums.length);
        int tempInt = -1;
        for (int i = 0; i < nums.length; i++) {
            tempInt = target - nums[i];
            if (tempMap.containsKey(tempInt)) {
                return new int[]{i, tempMap.get(tempInt)};
            }
            tempMap.put(nums[i], i);
        }
        return null;
    }

}
