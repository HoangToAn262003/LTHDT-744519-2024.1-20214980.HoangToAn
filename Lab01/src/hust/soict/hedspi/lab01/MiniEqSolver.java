// Hoàng Tố An - 20214980
// IDE: none

import javax.swing.JOptionPane;

public class MiniEqSolver{
	public static void main(String[] args){
		String option1 = "First-degree equation with one variable";
		String option2 = "System of first-degree equations with two variables ";
		String option3 = "Second-degree equation with one variable";
		String options[] = {option1, option2, option3};
		String input = (String) JOptionPane.showInputDialog(null, "Select the type of equation:", "Mini Equation Solver", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		String str_a, str_b, str_c;
		String str_a1, str_b1, str_c1, str_a2, str_b2, str_c2;
		double a, b, c;
		
		if (input == option1){
			str_a = JOptionPane.showInputDialog(null, "Enter coefficient a:", option1, JOptionPane.INFORMATION_MESSAGE);
			str_b = JOptionPane.showInputDialog(null, "Enter coefficient b:", option1, JOptionPane.INFORMATION_MESSAGE);
			a = Double.parseDouble(str_a);
			b = Double.parseDouble(str_b);
			
			if (a != 0) {
				double sol = -b/a;
				JOptionPane.showMessageDialog(null, "The solution is: " +sol, option1, JOptionPane.INFORMATION_MESSAGE);
			}
			else if (a == 0) {
				if (b != 0) {
					JOptionPane.showMessageDialog(null, "The equation has no solution.", option1, JOptionPane.INFORMATION_MESSAGE);
				}
				else if (b == 0) {
					JOptionPane.showMessageDialog(null, "The equation has infinite solutions.", option1, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
			
		if (input == option2){
			str_a1 = JOptionPane.showInputDialog(null, "Enter coefficient a11 of the first equation:", option2, JOptionPane.INFORMATION_MESSAGE);
			str_b1 = JOptionPane.showInputDialog(null, "Enter coefficient a12 of the first equation:", option2, JOptionPane.INFORMATION_MESSAGE);
			str_c1 = JOptionPane.showInputDialog(null, "Enter result c1 of the first equation: ", option2, JOptionPane.INFORMATION_MESSAGE);
			
			str_a2 = JOptionPane.showInputDialog(null, "Enter coefficient a21 of the second equation:", option2, JOptionPane.INFORMATION_MESSAGE);
			str_b2 = JOptionPane.showInputDialog(null, "Enter coefficient a22 of the second equation:", option2, JOptionPane.INFORMATION_MESSAGE);
			str_c2 = JOptionPane.showInputDialog(null, "Enter result c2 of the second equation:", option2, JOptionPane.INFORMATION_MESSAGE);
			
			double a1 = Double.parseDouble(str_a1);
			double b1 = Double.parseDouble(str_b1);
			double c1 = Double.parseDouble(str_c1);
			
			double a2 = Double.parseDouble(str_a2);
			double b2 = Double.parseDouble(str_b2);
			double c2 = Double.parseDouble(str_c2);
			
			double D = a1 * b2 - a2 * b1;
			double DX = c1 * b2 - c2 * b1;
			double DY = a1 * c2 - a2 * c1;
			double sol1 = DX/D;
			double sol2 = DY/D;
			
			if(D != 0) {
				JOptionPane.showMessageDialog(null, "The solution (x1, x2) is: " + sol1 + ", " + sol2, option2, JOptionPane.INFORMATION_MESSAGE);
			}
			else if(D == 0) {
				if(DX != 0 || DY != 0) {
				   JOptionPane.showMessageDialog(null, "The system has no solution.", option2, JOptionPane.INFORMATION_MESSAGE);
				}
				else if(DX == 0 && DY == 0) {
					JOptionPane.showMessageDialog(null, "The system has infinite solutions.", option2, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		
		if(input == option3) {
			str_a = JOptionPane.showInputDialog(null, "Enter coefficient a: ", option2, JOptionPane.INFORMATION_MESSAGE);
			str_b = JOptionPane.showInputDialog(null, "Enter coefficient b: ", option2, JOptionPane.INFORMATION_MESSAGE);
			str_c = JOptionPane.showInputDialog(null, "Enter coefficient c: ", option2, JOptionPane.INFORMATION_MESSAGE);
			
			a = Double.parseDouble(str_a);
			b = Double.parseDouble(str_b);
			c = Double.parseDouble(str_c);
			
			double delta = b*b-4*a*c;
			if (delta < 0) {
				JOptionPane.showMessageDialog(null, "The equation has no solution.", option2, JOptionPane.INFORMATION_MESSAGE);
			}
			else if (delta == 0) {
				  double sol1 = b / (-2)*a;
				  JOptionPane.showMessageDialog(null, "The equation has one solution: " + sol1, option2, JOptionPane.INFORMATION_MESSAGE);
			}
			else if (delta > 0) {
				double sol1 = (-b + Math.sqrt(delta))/(2*a);
				double sol2 = (-b - Math.sqrt(delta))/(2*a);

				JOptionPane.showMessageDialog(null, "The equation has two solutions: " + sol1 + ", " + sol2, option2, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}