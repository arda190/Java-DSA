public class BinarySearch {
    public static int binarySearch(int[] arr,int key,int start,int end){
        int med=(start+end)/2;
        if(arr[med]==key){
            return med;
        }
        else if(arr[med]<key){
            return binarySearch(arr,key,med+1,end);
        }
        else if(arr[med]>key){
            return binarySearch(arr,key,start,med);
        }
      return -1;
    }

    public static void main(String[] args) {
        int index=binarySearch(new int[]{1,2,3,4,5,6},6,0,6);
        System.out.println(index);
    }

}
