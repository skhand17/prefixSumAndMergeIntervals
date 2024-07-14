package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArraySumEqualK {

    public static void main(String[] args) {

        int[] nums = new int[] {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;

        int maxAns = maxLength(nums, k);
        System.out.println(maxAns);
    }

    public static int maxLength(int[] nums, int k) {

        int cumSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            cumSum += nums[i];

            if(cumSum == k)
                maxLength = i + 1;

            if(map.containsKey(cumSum - k)){
                maxLength = Math.max(maxLength, i - map.get(cumSum - k));
            }

            if(!map.containsKey(cumSum)){
                map.put(cumSum, i);
            }
        }

        return maxLength;

    }
}
