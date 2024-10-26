package base1;

import java.util.Arrays;

class bubble {
    public static int[] bubble(int[] nums) {
        int l=0;
        int len=nums.length;
        boolean swap=false;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                    swap=true;
                }
            }
            if(!swap){
                break;
            }
        }
        return nums;
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] ints = bubble_v2(new int[]{5, 9, 7, 4, 1, 3, 2, 8});
        System.out.println(Arrays.toString(ints));
    }

    public static int[] bubble_v2(int[] nums) {
        int len=nums.length;
        int n=len-1;
        while(true){
            int last=0;
            for (int i = 0; i < n; i++) {
                if(nums[i]>nums[i+1]){
                    swap(nums,i,i+1);
                    last=i;
                }
            }
            n=last;
            if(last==0){
                break;
            }
        }
        return nums;
    }
}
