public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            int minValue=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(minValue>arr[j]){
                    minValue=arr[j];
                    minIndex=j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }



    public static void main(String[] args) {
        int[] newList={4,7,9,1,8,2};
        int[] arr=selectionSort(newList);
        printArray(arr);

    }


}
