
import java.util.Arrays;

public class HeapSort {

    static int heapArr[];

    static int pre=1;


    private static void insert(int val,int ind){

        if(pre==9){
            System.out.println("NI ADD HOPAYEGA SPACE FULL");
            return;
        }
        pre++;
        heapArr[ind]=val;
        while(ind>1 && heapArr[ind/2]< heapArr[ind]){
            int temp = heapArr[ind];
            heapArr[ind]=heapArr[ind/2];
            heapArr[ind/2]=temp;
            ind/=2;
        }
    }
    private static void delete(){

        int ind = pre;

        // this function deletes the head of the heapArr
        int temp = heapArr[ind];
        heapArr[ind]=heapArr[1];
        heapArr[1]=temp;

        // make ind val =0;
        heapArr[ind]=0;

        int i=1;

        while(i<=ind-1){
            int lc = 2*i;
            int rc = 2*i+1;
            int l=0;
            if(lc>=heapArr.length && rc>=heapArr.length){
                return;
            }
            else if(lc<heapArr.length && rc<heapArr.length){
                l = heapArr[lc]>heapArr[rc]?lc:rc;
            }
            else if(lc>=heapArr.length){
                l=rc;
            } else if (rc<=heapArr.length) {
                l=lc;
            }


//            System.out.println(heapArr[i]);

            if(heapArr[i]<heapArr[l]){
                int temp1 = heapArr[i];
                heapArr[i]=heapArr[l];
                heapArr[l]=temp1;
                i=l;
            }
            else{
                pre--;
                return;
            }
        }

        pre--;


    }

    // above insertion for n elements can be done in o(n) known as Heapify Algo:
    private static void heapify(int arr[],int n,int i){
        // i represent the index which needed to be heapify

        int largest = i;
        int left = 2*i;
        int right = 2*i+1;

        if(left<n && arr[largest]<arr[left]){
            largest = left;
        }

        if(right<n && arr[largest]<arr[right]){
            largest = right;
        }

        if(largest!=i){
            int temp = arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;

            heapify(arr,n,largest);
        }
    }

    public static void heapSort(int arr[],int size){
        int t = size;

        while(t>1){
            // step 1 : swap the index first at last
            int temp = arr[1];
            arr[1]=arr[t];
            arr[t]=temp;

            t--;

            // step 2: first index ko krdo heapify
            heapify(arr,t+1,1);

        }
    }

    public static void main(String[] args) {
        heapArr = new int[10];

        pre = 1;

//        insert(16,pre);
//        insert(23,pre);
//        insert(12,pre);
//        insert(18,pre);
//
//        delete();
//        delete();
//        delete();
//
//        insert(26,pre);
//        insert(23,pre);
//        insert(28,pre);
//
//        delete();
//
//        insert(1,pre);
//        insert(28,pre);
//
        int arr[]={-1,54,53,55,52,50};

        int n = 5;

        for(int i=n/2;i>0;i--){
            heapify(arr,arr.length, i);
        }

//        int arr1[]={34,54,66,32,46};

        heapSort(arr,5);

        System.out.println(Arrays.toString(arr));

//        System.out.println("Max element in heap:"+heapArr[1]);
    }
}