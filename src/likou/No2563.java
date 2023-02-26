package likou;

import java.util.Arrays;

public class No2563 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 4, 5, 7};
        int lower = 3, upper = 6;
//        System.out.println(countFairPairs(arr, lower, upper));
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, 7));

    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return 0;
    }

    public static int binarySearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int middle = (left + right) / 2;
        while (left <= right) {
            middle = (left + right) / 2;
            if (target == nums[middle]) {
                return middle;
            }
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }
}
