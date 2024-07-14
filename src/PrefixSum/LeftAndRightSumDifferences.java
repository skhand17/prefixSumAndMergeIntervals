package PrefixSum;

public class LeftAndRightSumDifferences {

    public static void main(String[] args) {

        int[] arr = new int[] {2, 5, 1, 6};
        int[] difference = computeDifference(arr);
        for(int n: difference){
            System.out.print(n + " ");
        }
    }

    public static int[] computeDifference(int[] arr) {
        int[] differenceArray = new int[arr.length];
        int leftSum = 0;
        int totalSum = 0;

        for(int n: arr) {
            totalSum += n;
        }

        for(int i=0; i<arr.length; i++) {
            int rightSum = totalSum - arr[i] - leftSum;
            differenceArray[i] = Math.abs(leftSum - rightSum);
            leftSum += arr[i];
        }

        return differenceArray;
    }
}
