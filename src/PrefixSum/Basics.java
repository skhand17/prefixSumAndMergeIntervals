package PrefixSum;

public class Basics {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 2, 3, 4};
        int[] prefix = computePrefixSum(arr);
        for(int i: prefix){
            System.out.print(i + " ");
        }
    }

    public static int[] computePrefixSum(int[] arr) {

        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for(int i=1; i<arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }


        return prefix;
    }
}
