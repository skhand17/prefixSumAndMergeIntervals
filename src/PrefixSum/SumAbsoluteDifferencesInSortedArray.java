package PrefixSum;

public class SumAbsoluteDifferencesInSortedArray {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 6};
        int[] result = sumAbsolute(nums);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    public static int[] sumAbsolute(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // ToDO: Write Your Code Here.

        int leftSum = 0;
        int totalSum = 0;
        int firstIndex = 0;
        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - nums[i] - leftSum;
            result[i] = Math.abs(rightSum - (n - 1 - i) * nums[i]) + Math.abs(leftSum - (i - firstIndex) * nums[i]);
            leftSum += nums[i];
        }

        return result;
    }
}
