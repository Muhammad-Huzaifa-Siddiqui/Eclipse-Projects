package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 10;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String email;
	private String companySuffix = "company.com";

	// constructor
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("email created " + this.firstName + " " + this.lastName);
		// call method asking for dep
		this.department = setDepartment();
		System.out.println("Your department is: " + this.department);
		// call method to set random pass
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("your password is " + this.password);
		// combine fName and lName for email
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		System.out.println("your email is " + email);

	}

	// department
	private String setDepartment() {
		System.out.println("Enter the department code for\n1)sales\n2)development\n3)accounting\n0)none");
		Scanner in = new Scanner(System.in);
		try {
			int depChoice = in.nextInt();
			if (depChoice == 1) {
				return "sales";
			} else if (depChoice == 2) {
				return "dev";
			} else if (depChoice == 3) {
				return "acc";
			} else {
				return "";
			}
		} finally {
			in.close();
		}

	}

	// genarate_random_pass
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPRSTUVWXYZ123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// setmailbox_capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// set_alternate_email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// change_password
	public void changePassword(String password) {
		this.password = password;
	}

	// get mail box capacity
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	// get alternate email
	public String getAlternateEmail() {
		return alternateEmail;
	}

	// get changed password
	public String getChangedPassword() {
		return password;
	}

	// Show INfo
	public String showInfo() {
		return "Diplay Name:" + firstName + " " + lastName + "\nDisplay Email: " + email + "\nMailbox Capacity: "
				+ mailboxCapacity + "mb";
	}

}
