import java.util.ArrayList;
import java.util.Arrays;

public class shellSort {
	
	private static int[] array = new int[20];
	
	public static void main(String[] args) {
		
		gerarRandomArray();
		System.out.println("Vetor desordenado: " + "\n" + Arrays.toString(array) + "\n");
		ordenador(array, 1);
		System.out.println("Vetor ordenado:    " + "\n" + Arrays.toString(array));
	}

	public static void ordenador(int[] array, int intervalo) {
		
		int temp;
		int i, j;
		
		if (intervalo > array.length) return;
		
		ordenador(array, intervalo * 3 + 1);  //Shellsort com sequência de intervalos do Knuth (1, 4, 13, 40, ...).
		
		for (i = intervalo; i < array.length; i++) {
			temp = array[i];
			for (j = i; j >= intervalo && array[j - intervalo] > temp; j -= intervalo) {
				array[j] = array[j - intervalo];
			}
			array[j] = temp;
		}
	}

	public static void gerarRandomArray() {
		
		int num;
		ArrayList<Integer> numUnico = new ArrayList<Integer>();
		
		for (int i = 0; i < array.length; i++) {
			num = (int) (Math.random() * (100 - 0) + 0);
			while (numUnico.contains(num)) {
				num = (int) (Math.random() * (100 - 0) + 0);
			}
			numUnico.add(num);
			array[i] = num;
		}
	}
}