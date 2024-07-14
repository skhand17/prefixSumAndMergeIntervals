package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK {
    public static void main(String[] args) {

        int[] arr = new int[] {5, 1, 2, -3, 4, -2};
        int k = 3;
    }
    public static int subArraySum(int[] nums, int k){
        int count = 0, cumulativeSum = 0;
        Map<Integer, Integer> cumulativeSumFrequency = new HashMap<>();
        cumulativeSumFrequency.put(0, 1);  // Initialize with 0 sum count as 1

        for (int num : nums) {
            cumulativeSum += num;  // Update cumulative sum
            // Check if there's a subarray sum that equals k
            count += cumulativeSumFrequency.getOrDefault(cumulativeSum - k, 0);
            // Update the frequency map for the current cumulative sum
            cumulativeSumFrequency.put(cumulativeSum, cumulativeSumFrequency.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;  // Return the total count of subarrays
    }
}
