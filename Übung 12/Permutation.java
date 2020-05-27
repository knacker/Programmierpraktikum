//@author maximilian raspe
import java.util.Arrays;

public class Permutation {

    public static void main(String[] args) {
        int n = 4;
        int[] array = new int[n];
        arrayFuellen(array);
        permutationAusgeben(array, n);
    }
    //füllt den array mit zahlen
    private static void arrayFuellen(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }
    private static void permutationAusgeben(int[] array, int n) {
        //sobald n= 1 erreicht wurde wird der array ausgegeben
        if(n == 1) {
            System.out.println(Arrays.toString(array));
        }
        //array wird getauscht und ausgegeben
        for(int i = 0; i < n; i++) {
            tauschen(array, i, n - 1);
            permutationAusgeben(array, n - 1);
            tauschen(array, i, n - 1);
        }

    }
    //tauscht ints an index i und j
    private static void tauschen(int[] array, int i, int j) {
        int k = array[i];
        array[i] = array[j];
        array[j] = k;
    }
}
