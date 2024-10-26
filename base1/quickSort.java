package base1;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 7, 2, 9, 8, 1, 4};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a,int l,int r){
        if(l<r){
            int p=partition(a,l,r);
            if(l<p-1)
                quickSort(a,l,p-1);
            if(p+1<r)
                quickSort(a,p+1,r);
        }
    }

    private static int partition(int[] a,int l,int r){
        int pv=a[r];
        int i=l;
        int j=l;
        while(j<r){
            if(a[j]<pv){
                if(i!=j){
                    swap(a,i,j);
                }
                i++;
            }
            j++;
        }
        if(i!=r)
            swap(a,i,r);
        System.out.println(Arrays.toString(a)+"i="+i);
        return i;
    }



    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
