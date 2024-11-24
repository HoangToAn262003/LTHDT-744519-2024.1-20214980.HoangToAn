package hust.soict.hedspi.lab01;
// Hoàng Tố An - 20214980
// IDE: Eclipse
import java.util.Scanner;
import java.util.Arrays;
public class Array {

	public static void main(String[] args) {
		
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		double a[] = new double[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextDouble();
		}
		
//		double a[] = {124, -155, 0, -6.66, 3.14};
		
		System.out.println("Array: ");
		for (double num : a) {
			System.out.print(num + " ");
		}
		
		Arrays.sort(a);
		System.out.println("\nSorted Array: ");
		for (double num : a) {
			System.out.print(num + " ");
		}
		
		double sum = 0;
		for (double num : a) {
			sum += num;
		}
		System.out.println("\nSum of array elements = " + sum + "\nAverage of array elements = "+ sum / a.length);
	sc.close();
	}

}
