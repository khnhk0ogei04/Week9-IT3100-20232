package main;

import java.util.ArrayList;
import java.util.Calendar;

public class Manager {
	public static int menu() {
		System.out.println("1. Experience");
		System.out.println("2. Fresher");
		System.out.println("3. Internship");
		System.out.println("4. Searching");
		System.out.println("5. Exit");
		int choice = Validation.checkInputIntLimit(1, 5);
		return choice;
	}
	public static void createCandidate(ArrayList<Candidate> candidates, int type) {
		while (true) {
			System.out.print("Enter id: ");
			String id = Validation.checkInputString();
			System.out.print("Enter first name: ");
			String firstName = Validation.checkInputString();
			System.out.print("Enter last name: ");
			String lastName = Validation.checkInputString();
			System.out.print("Enter birth date: ");
			int birthDate = Validation.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
			System.out.print("Enter address: ");
			String address = Validation.checkInputString();
			System.out.print("Enter phone: ");
			String phone = Validation.checkInputPhone();
			System.out.print("Enter email: ");
			String email = Validation.checkInputEmail();
			Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);
			if (!Validation.checkIdExist(candidates, id)) {
				switch(type) {
				case 0:
					createExperience(candidates, candidate);
					break;
				case 1:
					createFresherCandidate(candidates, candidate);
					break;
				case 2:
					createInternship(candidates, candidate);
					break;
				}
			} else {
				return;
			}
			System.out.print("Do you want to continue(Y for yes/N for no): ");
			if (!Validation.checkInputYesNo()) {
				return;
			}
		}	
	}
	private static void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
		System.out.print("Enter years of experience: ");
		int yearExperience = Validation.checkInputExperience(candidate.getBirthDate());
		System.out.print("Enter professional skills: ");
		String professionalSkill = Validation.checkInputString();
		Candidate newCandidate = new Experience(yearExperience, professionalSkill, candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getCandidateType());
		candidates.add(newCandidate);
		System.out.println("Successfully create Experience");
	}
	private static void createFresherCandidate(ArrayList<Candidate> candidates, Candidate candidate) {
		System.out.print("Enter graduation date: ");
		String graduationDate = Validation.checkInputString();
		System.out.print("Enter graduation rank: ");
		String graduationRank = Validation.checkInputGraduationRank();
		Candidate newCandidate = new FresherCandidate(graduationDate, graduationRank, candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getCandidateType());
		candidates.add(newCandidate);
		System.out.println("Successfully create FresherCandidate");
	}
	private static void createInternship(ArrayList<Candidate> candidates, Candidate candidate) {
		System.out.print("Enter major: ");
		String major = Validation.checkInputString();
		System.out.print("Enter semester: ");
		String semester = Validation.checkInputString();
		System.out.print("Enter university: ");
		String university = Validation.checkInputString();
		Candidate newCandidate = new Internship(major, semester, university, candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getCandidateType());
		candidates.add(newCandidate);
		System.out.println("Successfully create Internship");
	}
	public static void searchCandidate(ArrayList<Candidate> candidates) {
		printListNameCandidate(candidates);
		System.out.print("Enter candidate name(First or last name): ");
		String searchName = Validation.checkInputString();
		System.out.print("Choose type: 0 for Experience, 1 for FresherCandidate, 2 for Internship: ");
		int typeOfCandidate = Validation.checkInputIntLimit(0, 2);
		for (Candidate candidate : candidates) {
			if (candidate.getCandidateType() == typeOfCandidate && (candidate.getFirstName().contains(searchName) || candidate.getLastName().contains(searchName))) {
				System.out.println(candidate.toString());
			}
		}
	}
	public static void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.out.println("Experience Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.out.println("Fresher Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof FresherCandidate) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.out.println("Internship Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }

}
