// Hoàng Tố An - 20214980
// IDE: Eclipse
import java.util.Scanner;

public class AddTwoMatrices {
	static int[][] addMatrices(int a[][], int b[][], int sz){
		int res[][] = new int[sz][sz];
		
		for (int i = 0; i < sz; i++)
			for (int j = 0; j < sz; j++)
				res[i][j] = a[i][j] + b[i][j];
		
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[][] = new int[n][n], b[][] = new int[n][n];
		System.out.println("Enter values for matrix a:");
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();
		System.out.println("Enter values for matrix b:");
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) b[i][j] = sc.nextInt();
		
		int c[][] = addMatrices(a, b, n);
		System.out.println("Result matrix: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) System.out.print(c[i][j] + " ");
			System.out.println();
		}

		sc.close();
	}

}
