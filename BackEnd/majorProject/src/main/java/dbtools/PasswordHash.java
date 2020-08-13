package dbtools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {

	public static String createHash(String string) {
		StringBuilder result = new StringBuilder();
		try {
			byte[] bytes = MessageDigest.getInstance("SHA-256").digest(string.getBytes());
			result.append(new BigInteger(1, bytes).toString(16));
			while(result.length() < 32) {
				result.insert(0, '0');
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException in hashing method, double check the MessageDigest.getInstance()");
			e.printStackTrace();
		}
		return result.toString();
	}
	
}
