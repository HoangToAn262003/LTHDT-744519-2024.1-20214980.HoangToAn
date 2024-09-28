// Hoàng Tố An - 20214980
// IDE: Eclipse
import java.util.Scanner;
public class DaysInMonth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int days = 0;
		
		System.out.println("Enter year:");
		int year = sc.nextInt();
		
		while (year < 0) {
			System.out.println("Invalid year! Try again:");
			year = sc.nextInt();
		}
		
		System.out.println("Enter month:");
		String month = sc.next();
		
		switch(month) {
		case "January": case "Jan.": case "Jan": case "1":
		case "March": case "Mar.": case "Mar": case "3":
		case "May": case "5":
		case "July": case "Jul.": case "Jul": case "7":
		case "August": case "Aug.": case "Aug": case "8":
		case "October": case "Oct.": case "Oct": case "10":
		case "December": case "Dec.": case "Dec": case "12":
			days = 31;
			break;
		case "February": case "Feb.": case "Feb": case "2":
			if (year % 4 == 0) {
				if (year % 100 == 0) {
					if (year % 400 == 0) days = 29;
					else days = 28;
				} else days = 29;
			} else days = 28;
			break;
		case "April": case "Apr.": case"Apr": case "4":
		case "June": case "Jun.": case "Jun": case "6":
		case "September": case "Sep.": case "Sep": case "9":
		case "November": case "Nov.": case "Nov": case "11":
			days = 30;
			break;
		default:
			System.out.println("Invalid month! Try again:");
			month = sc.next();
		}
		
		System.out.println("Year is " + year + "\nMonth is " + month + "\nThere are " + days + " days in this month.");
		sc.close();
	}
}
