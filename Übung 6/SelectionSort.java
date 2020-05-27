//@author Maximilian Raspe
import java.util.Arrays;
import java.util.Scanner;
public class SelectionSort {

	public static void main(String[] args) {
		
		Scanner laenge = new Scanner(System.in);		//arraylänge einlesen
		System.out.println("Array länge eingeben");
		int length = laenge.nextInt();
		laenge.close();
		
		mixArray(newArray(length));

	}
	
	private static int[] newArray(int n) {	//füllt den array mit zahlen
		int [] array = new int [n];
		for(int i = 0; i < n ; i++) {
			array[i] = i + 1; 
		}
		return array;	//@return das erzeugt array
	}
	private static void mixArray(int[] array) {	//mischt den array
		int i = array.length / 2;
		int j = array.length - 1;
		while(i > 0) {	//misch den array, indem er in 2 geteilt wird und die zahlen vorne und hiten vertauscht werden(wie beim karten mischen)
			int temp = array[i];
			array[i--] = array[j];
			array[j--] = temp;
		}
		int temp = array[0];	//damit auch die 1. zahl vertauscht wird, ist das nochmal extra
		array[0] = array[array.length - 1];
		array[array.length - 1] = temp;
		
		showArray(array);
		selectionSort(array);
	}
	
	private static void showArray(int[] array) {	//gibt den gemischten array aus
		
		System.out.println(Arrays.toString(array));
	}
	
	private static void selectionSort(int[] array) {
		int counter = 1;
		for(int i = 0; i <= array.length - 1; i++) {	// array an i-ter stelle wird hochgezählt
			for(int j = 1; j < array.length; j++) {	//array an stelle j wird hochgezählt
				if(array[j] == counter) {		//wenn j == i + 1 ist, dann werden die wert an j-ter und i-ter stelle vertauscht
					int temp = array[i];
					array[i] = counter;
					array[j] = temp;
					counter++;
					j = array.length;	//hilft bei der abbruchbedingung für die innere schleife
				}
			}
		}
		System.out.println("Sortierter Array : " + Arrays.toString(array));
	}
}
