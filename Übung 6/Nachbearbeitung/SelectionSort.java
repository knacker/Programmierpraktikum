//@author Maximilian Raspe
import java.util.Arrays;
import java.util.Scanner;
public class SelectionSort {

	public static void main(String[] args) {
		
		Scanner laenge = new Scanner(System.in);		//arrayl�nge einlesen
		System.out.println("Array l�nge eingeben");
		int length = laenge.nextInt();
		laenge.close();
		
		mixArray(newArray(length));

	}
	
	private static int[] newArray(int n) {	//f�llt den array mit zahlen
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
		System.out.print("[");	//hübschere formatierung
		for(int i = 0; i < array.length; i++) {	//gibt an i-ter stelle array aus
			System.out.print(array[i] + "");
			if( i + 1 < array.length) {	//hilft um kommata richtig zu setzen
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	private static void selectionSort(int[] array) {

		for(int i = 0; i < array.length - 1; i++) {// array an i-ter stelle wird hochgez�hlt
            int counter = i;
		    for(int j = i + 1; j < array.length; j++) {	//array an stelle j wird hochgez�hlt
				if(array[j] < array[counter]) {		//wenn array an j-ter stelle < array an i-ter stelle, dann wird counter  der wert von j zugewiesen
					counter = j;
				}
			}
		    int temp = array[i];
		    array[i] = array[counter];
		    array[counter] = temp;
		}
		System.out.println("Sortierter Array : ");
		showArray(array);
	}
}