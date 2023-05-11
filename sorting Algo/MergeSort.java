import java.util.Arrays;

public class MergeSort {
    public static void merge(int arr[],int low,int mid,int high){
        int n1 = mid-low+1;
        int n2 = high-mid;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i=0;i<n1;i++){
            left[i]=arr[low+i];
        }

        for(int i=0;i<n2;i++){
            right[i]=arr[mid+i+1];
        }

        int k = low;
        int i=0,j=0;

        while(i<n1 && j<n2){
            if(left[i]>right[j]){
                arr[k++]=right[j];
                j++;
            }
            else{
                arr[k++]=left[i];
                i++;
            }
        }

        while(i<n1){
            arr[k++]=left[i++];
        }

        while (j<n2){
            arr[k++]=right[j++];
        }
    }

    public static void mergeSort(int arr[],int low,int high){
        if(low<high){
            int mid = low + (high-low)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    public static void main(String[] args) {
        int arr[]={4,5,9,3,2,8};
        System.out.println("BEFORE SORTING THE ARRAY:");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,5);
        System.out.println("AFTER SORTING THE ARRAY:");
        System.out.println(Arrays.toString(arr));
    }
}