package likou;

public class No2562 {
    public static void main(String[] args){
        int[] arr = {5,14,13,8,12};
        System.out.println(findTheArrayConcVal(arr));
    }

    public static long findTheArrayConcVal(int[] nums) {
        if(nums.length == 0){
            return nums[0];
        }
        long num = 0;
        int len = nums.length;
        for(int i=0,j=len-1;i<=j;i++,j--){
            if(i == j){
                num += nums[i];
            }else{
                num += Integer.valueOf(String.valueOf(nums[i]) + String.valueOf(nums[j]));
            }
        }
        return num;
    }
}
