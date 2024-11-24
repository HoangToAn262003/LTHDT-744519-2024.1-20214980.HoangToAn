package hust.soict.hedspi.lab01;
// Hoàng Tố An - 20214980
// IDE: Eclipse
import java.util.Scanner;
public class StarTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How tall do you want the triangle?");
		int sz = sc.nextInt();
		
		for (int i = 1; i <= sz; i++) {
			for (int k = sz - i; k > 0; k--) {
				System.out.print(" ");
			}
			for (int j = i; j <= i + 2*(i-1); j++)
				System.out.print("*");
			System.out.println();
		}
		sc.close();
	}

}
