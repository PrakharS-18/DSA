import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int arr[],int low ,int high){

        if(low<high){
            int pidx = partition(arr,low,high);

            quickSort(arr,low,pidx-1);

            quickSort(arr,pidx+1,high);
        }

    }

    public static int partition(int arr[],int low,int high){
        int pivot = arr[high];
        int i = low-1; // managing space for smaller then pivaot element

        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;

                //swap

                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        // bringing pivot from lst to original index

        i++;

        int temp = arr[i];
        arr[i]=pivot;
        arr[high]=temp;

        return i;
    }


    public static void main(String[] args) {
        int arr[]={4,5,9,3,2,8};
        System.out.println("BEFORE SORTING THE ARRAY:");
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,5);
        System.out.println("AFTER SORTING THE ARRAY:");
        System.out.println(Arrays.toString(arr));

    }
}