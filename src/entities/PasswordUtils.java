package entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {
	public static final int MIN_LENGTH = 8; 

	public PasswordUtils() {
	}
	
	public static String hashPassword(String password) {
		try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(
                    password.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
		return (Objects.equals(hashPassword(plainTextPassword), hashedPassword));
	}
	
	public static boolean isStrongPassword(String password) {
		return password.length()<=MIN_LENGTH && containsUppercaseLetter(password) && containsDigit(password);
	}
	
	private static boolean containsUppercaseLetter(String password) {
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher matcher = uppercasePattern.matcher(password);
        return matcher.find();
    }
	
	private static boolean containsDigit(String password) {
        Pattern digitPattern = Pattern.compile("\\d");
        Matcher matcher = digitPattern.matcher(password);
        return matcher.find();
    }
}
