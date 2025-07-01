public class KadanesAlgorithm {
    public void Kadanes(int[]array) {
        int maxSoFar = array[0]; //Şu ana kadar görülen en büyük toplam
        int maxEndingHere = array[0];  //o anki alt dizi toplamı

        for(int i = 1; i < array.length; i++) {
            maxEndingHere=Math.max(array[i],array[i]+maxEndingHere);
            maxSoFar=Math.max(maxSoFar,maxEndingHere);
        }
      System.out.println(maxSoFar);
    }

    public int[] Kadane(int[]array){
        int maxSoFar=array[0];
        int maxEndingHere = array[0];
        int start=0;
        int end=0;
        int tempStart=0;
        for(int i = 1; i < array.length; i++) {
            if(maxEndingHere+array[i]<array[i]) {
                maxEndingHere=array[i];
                tempStart=i;
            }
            else if(maxEndingHere+array[i]>array[i]){
                maxEndingHere=maxEndingHere+array[i];

            }
            if(maxSoFar<maxEndingHere) {
                maxSoFar=maxEndingHere;
                start=tempStart;
                end=i;
            }
        }
        int[] newArray=new int[end-start+1];
        int j=0;
        for(int i = start; i <= end; i++) {
            newArray[j]=array[i];
            j++;
        }
        return newArray;

    }



    public static void main(String[] args) {
        KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
        kadanesAlgorithm.Kadanes(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        int[] result = kadanesAlgorithm.Kadane(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(java.util.Arrays.toString(result));
    }
}
