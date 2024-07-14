package PrefixSum;

public class FindMiddleIndexInArray {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 7, 3, 6, 5, 6};
        int middleIndex = findMiddleIndex(nums);
        System.out.println(middleIndex);
    }

    public static int findMiddleIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = 0;

        for(int n: nums){
            totalSum += n;
        }

        for(int i=0; i<nums.length; i++){
            int rightSum = totalSum - nums[i] - leftSum;
            if(leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }

        return -1;
    }

}
