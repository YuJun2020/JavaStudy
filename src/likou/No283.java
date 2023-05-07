package likou;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class No283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return;
        }
        //统计0的个数
        int count = 0;
        for (int i = 0; i < length; i++) {
            //若索引i处的元素为0，且索引小于数组长度减已统计的0的个数，后面元素前移1
            if (nums[i] == 0&&i<length-1-count) {
                for (int j = i; j < length - 1-count; j++) {
                    nums[j] = nums[j + 1];
                }
                //移位后，数组末位非0元素置0
                nums[length-1-count]=0;
                count++;
                if(nums[i]==0){
                    i--;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
