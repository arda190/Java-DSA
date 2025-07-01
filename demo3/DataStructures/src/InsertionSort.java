public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
       for(int i=1;i<arr.length;i++) {
           int key=arr[i];
           int j=i-1;
           while(j>=0 && arr[j]>key){
               arr[j+1]=arr[j];
               j--;
           }
           arr[j+1]=key;
       }
       return arr;
    }




    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        printArray(insertionSort(new int[]{4,7,9,1,8,2}));
    }

}
