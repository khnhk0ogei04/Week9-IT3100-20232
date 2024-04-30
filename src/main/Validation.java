package main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
public class Validation {
	private static Scanner sc = new Scanner(System.in);
	private static final String PHONE_VALID = "^\\d{10}\\d*$";
	private static final String EMAIL_VALID = "^[A-za-z0-9.+-%]+@[A-za-z.-]+\\.[A-za-z]{2,4}$";
	public static int checkInputIntLimit(int min, int max) {
		while (true) {
			try {
			int result = Integer.parseInt(sc.nextLine().trim());
			if (result < min || result > max) {
				throw new NumberFormatException();
				}
			return result;
			} catch (NumberFormatException ex) {
				System.out.println("Enter again: ");
			}
		}
	}
	public static String checkInputString() {
		while (true) {
			String result = sc.nextLine().trim();
			if (result.equals("")) {
				System.out.println("Enter again: Input can't be blank");
			}
			else return result;
		}
	}
	public static boolean checkInputYesNo() {
		while (true) {
			String result = checkInputString();
			if (result.equalsIgnoreCase("Y")) {
				return true;
			}
			else if (result.equalsIgnoreCase("N")) {
				return false;
			}
			else {
				System.out.println("Please input y/Y or N/N for Yes|No: ");
			}
		}
	}
	public static String checkInputPhone() {
		while (true) {
			String result = checkInputString();
			if (result.matches(PHONE_VALID)) {
				return result;
			}
			else {
				System.out.println("Enter again: At least 10 digits");
			}
		}
	}
	
	public static String checkInputEmail() {
	    while (true) {
	        String result = checkInputString();
	        if (result.matches("^[A-Za-z0-9.+%-]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$")) {
	            return result;
	        } else {
	            System.out.println("Input is not a valid type, type again");
	        }
	    }
	}

	public static int checkInputExperience(int birthDate) {
		int age = Calendar.getInstance().get(Calendar.YEAR) - birthDate;
		while (true) {
			int yearExperience = checkInputIntLimit(1,100);
			if (yearExperience > age) {
				System.out.println("Please honest");
			} else return yearExperience;		
		}
	}
	public static String checkInputGraduationRank() {
		while(true) {
			String result = checkInputString();
			if (result.equalsIgnoreCase("Excellence") || result.equalsIgnoreCase("Good") || result.equalsIgnoreCase("Fair") || result.equalsIgnoreCase("Poor")) {
				return result;
			}
			else {
				System.out.println("Enter again: ");
			}
		}
	}
	
	public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
		for (Candidate candidate : candidates) {
			if (candidate.getId().equalsIgnoreCase(id)) {
				return false;
			}
		}
		return true;
	}
}
