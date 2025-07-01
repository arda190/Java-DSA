public class QuickSort {
    public static int[] quickSort(int[]arr,int left,int right){
        if(left < right) {
            int pivot = arr[left];
            int index = left;
            for (int i = left + 1; i <= right; i++) {
                if (arr[i] < pivot) {
                    index++;
                }
            }
            int temp=arr[left];
            arr[left]=arr[index];
            arr[index]=temp;


            int i = left;
            int j = right;
            while (i < index && j > index) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
        return arr;
    }


    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }



    public static void main(String[] args) {
        printArray(quickSort((new int[]{4,7,9,1,8,2}),0,5));
    }
}
