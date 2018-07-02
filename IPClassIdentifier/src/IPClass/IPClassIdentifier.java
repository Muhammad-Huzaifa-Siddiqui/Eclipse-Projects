package IPClass;

import java.util.*;

public class IPClassIdentifier {

	private static String error = "subnet mask not valid"; // global error msg
	private static int[] out = new int[32]; // global array for saving subnet bits

	public String DisplayIPClass(String input) { // method for checking class
		int str = Integer.parseInt(input.substring(0, input.indexOf(".")));
		if (str >= 10 && str <= 126) {
			return "A class ip.\nDefault subnet is 255.0.0.0";
		} else if (str >= 128 && str <= 191) {
			return "B class ip.\nDefault subnet is 255.255.0.0";
		} else if (str >= 192 && str <= 223) {
			return "C class ip.\nDefault subnet is 255.255.255.0";
		} else if (str >= 224 && str <= 239) {
			return "D class ip.\n";
		} else if (str >= 240 && str <= 254) {
			return "E class ip.\n";
		} else
			return "ip is out of range";

	}

	public void CovertBinary(String in) { // method for converting ip to binary
		String[] arr = new String[8];
		String[] octetArray = in.split("\\.");
		for (String string : octetArray) {
			int octet = Integer.parseInt(string);
			String binaryOctet = Integer.toBinaryString(octet);
			System.out.print(binaryOctet + ".");
		}
	}

	public void subnetToBinary(String in, int temp) { // method for converting subnet to binary
		int count = 0;	//used to place '.' after each octet
		int zeroCount = 0;  //checking condition for '0'
		int flag = 0; //Secret checker
		int str = Integer.parseInt(in); // argument parsed as int
		if (str < 2 || str > 32) {
			System.out.print(error);
		} else
			for (int i = 0; i < str; i++) {   //loop for printing the subnet mask as binary
				out[i] = 1;
				System.out.print(1);
				count++;
				flag++;
				if (count == 8 && flag < 32) {
					System.out.print(".");
					count = 0;
				}
			}
		for (int j = 0; j < 32 - str; j++) {
			out[str] = 0;
			System.out.print(0);
			zeroCount++;
				if (zeroCount == 8 && flag < 32) {
					System.out.print(".");
					zeroCount = 0;
				}
		
		}

		int vSubnet = 0;
		int vHosts = 0;
		for (int i = temp; i < out.length; i++) { // loop for calculating subnet and host bits
			if (out[i] == 1) {
				vSubnet++;
			} else if (out[i] == 0) {
				vHosts++;
			}
		}
		// valid hosts and valid subnets
		
		System.out.println("\nNumber of valid subnets: " + (int) Math.pow(2, vSubnet) + "\nNumber of valid Hosts: "
				+ (int) (Math.pow(2, vHosts) - 2));   //Calculation for valid hosts and subnets
	}
}