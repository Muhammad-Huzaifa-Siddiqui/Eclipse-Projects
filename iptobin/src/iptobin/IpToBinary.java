package iptobin;



import java.util.*;
import java.net.*;
public class IpToBinary {
	public static void main(String[] args) {
	    String source;
	    Scanner ipS;
	    ipS = new Scanner(System.in);
	    source = ipS.next();
	    InetAddress ip = null;
	    try {
	        ip = InetAddress.getByName(source);
	    } catch (UnknownHostException e) {
	        e.printStackTrace();
	        return;
	    }
	    System.out.println( "source : " + ip);

	    // To bit sequence ------------
	    byte[] binaryIP = ip.getAddress();
	    BitSet[] bitsets = new BitSet[binaryIP.length];
	    int k = 0;
	    StringBuilder a = new StringBuilder();
	    a = a.reverse();
	    a.append(binaryIP);
	  
	    
	    System.out.print("to binary: ");
	    for (byte b : binaryIP) {
	        bitsets[k] = byteToBitSet(b);
	        System.out.print( toString( bitsets[k] ) + ".");
	        k++;
	    }
	    System.out.println();

	  /*  // Back to InetAdress ---------
	    byte[] binaryIP2 = new byte[4];
	    k = 0;
	    for (BitSet b : bitsets) {
	        binaryIP2[k] = bitSetToByte(b);
	        k++;
	    }

	    InetAddress ip2 = null;
	    try {
	        ip2 = InetAddress.getByAddress(binaryIP2);
	    } catch (UnknownHostException e) {
	        e.printStackTrace();
	        return;
	    }

	    System.out.println( "flipped back to : " + ip2);
	*/
	}

	public static BitSet byteToBitSet(byte b) {
	    BitSet bits = new BitSet(8);
	    for (int i = 0; i < 8; i++) {
	        bits.set(i, ((b & (1 << i)) != 0) );
	    }
	    return bits;
	}

	public static byte bitSetToByte(BitSet bits) {
	    int value = 0;
	    for (int i = 0; i < 8; i++) {
	        if (bits.get(i) == true) {
	            value = value | (1 << i);
	        }
	    }
	    return (byte) value;
	}

	public static byte bitsToByte(boolean[] bits) {
	    int value = 0;
	    for (int i = 0; i < 8; i++) {
	        if (bits[i] == true) {
	            value = value | (1 << i);
	        }
	    }
	    return (byte) value;
	}

	public static boolean[] byteToBits(byte b) {
	    boolean[] bits = new boolean[8];
	    for (int i = 0; i < bits.length; i++) {
	        bits[i] = ((b & (1 << i)) != 0);
	    }
	    return bits;
	}

	public static String toString(BitSet bits){
	    String out = "";
	    for (int i = 0; i < 8; i++) {
	        out += bits.get(i)?"1":"0";         
	    }
	    return out;
	}
}
