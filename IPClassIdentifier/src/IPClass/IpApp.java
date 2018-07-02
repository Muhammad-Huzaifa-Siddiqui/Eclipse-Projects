package IPClass;

import java.util.Scanner;
import java.util.regex.*;

public class IpApp {
	public static final String regexPattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])"; // Pattern
																															// Matching
	private static Scanner in;

	public static void main(String[] args) {
		// TODO Auto-generated method
		IPClassIdentifier obj = new IPClassIdentifier(); // new object creation
		in = new Scanner(System.in); // Input ip
		Pattern ipv4 = Pattern.compile(regexPattern); // Pattern Matching
		System.out.println("Enter IP address:");
		String ip = in.next();
		String ip1 = ip.substring(0, ip.indexOf("/")); // Ip seperated from subnet mask
		String subnetMask = ip.substring(ip.indexOf("/") + 1, ip.length()); // saving subnet mask
		int subMask = Integer.parseInt(subnetMask); // parsing string input as int
		if (subMask < 2 || subMask > 32) { // checking validity of subnet
			System.out.print("Subnet Mask not valid");
		} else

		if (ipv4.matcher(ip1).matches()) { // returns true iff pattern matches
			obj.CovertBinary(ip1); // converting ip to binary
			System.out.println();
			if (obj.DisplayIPClass(ip1).substring(0, 1).equals("A")) { // Checking the class
				System.out.print(obj.DisplayIPClass(ip) + "\nsubnet to binary: "); // Subnet to binary conversion
				obj.subnetToBinary(subnetMask, 8); // obj calling method to check for valid hosts and subnets
			} else if (obj.DisplayIPClass(ip1).substring(0, 1).equals("B")) { // Checking the class
				System.out.print(obj.DisplayIPClass(ip) + "\nsubnet to binary: "); // Subnet to binary conversion
				obj.subnetToBinary(subnetMask, 16); // obj calling method to check for valid hosts and subnets
			} else if (obj.DisplayIPClass(ip1).substring(0, 1).equals("C")) { // Checking the class
				System.out.print(obj.DisplayIPClass(ip) + "\nsubnet to binary: "); // Subnet to binary conversion
				obj.subnetToBinary(subnetMask, 24);// obj calling method to check for valid hosts and subnets
			}

		} else
			System.out.println("Wrong IP address"); // if pattern does not match

	}

}
