package base1;

import java.util.ArrayList;
import java.util.Arrays;

public class quicksort2 {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 7, 2, 9, 8, 1, 4};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        ArrayList<Object> objects = new ArrayList<>();
    }

    public static void quickSort(int[] a,int l,int r){
        if(l<r) {
            System.out.println(Arrays.toString(a));
            int partition = partition(a, l, r);
            quickSort(a, l, partition - 1);
            quickSort(a, partition + 1, r);
        }
    }

    public static int partition(int[] a,int l,int r){
        int privot = a[r];
        int i = l;
        int j = l;
        while(j<r){
            if(a[j]<privot){
                if(i!=j){
                    swap(a,i,j);
                }
                i++;
            }
            j++;
        }
        if(i!=r){
            swap(a,i,r);
        }
        return i;
    }

    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
