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
    public static void main(String[] args) {
        KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
        kadanesAlgorithm.Kadanes(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
