// Hoàng Tố An - 20214980
// IDE: none

import javax.swing.JOptionPane;

public class MiniCalculator{
	public static void main(String [] args){
		double sum, diff, prod, quot;
		String strNum1, strNum2;
		
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number", JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number", JOptionPane.INFORMATION_MESSAGE);
		double n2 = Double.parseDouble(strNum2);
		double n1 = Double.parseDouble(strNum1);
		
		sum = n1 + n2;
		diff = n1 - n2;
		prod = n1 * n2;
		quot = n1 / n2;
		
		JOptionPane.showMessageDialog(null, "Sum = "+ sum + "\nDifference = "+ diff + "\nProduct = " + prod + "\nQuotient = "+ quot);
		System.exit(0);
	}
}