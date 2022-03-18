package _00_Intro_To_String_Methods;

import java.util.Base64;
import java.util.Iterator;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
        if (s1.length() > s2.length()) {
        	return s1;
		}
    	return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	if (s.contains("underscores")) {
    		String replacedStr = s.replace(' ', '_');
    		return replacedStr;
    	}
    	return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
        String answer;
        String holder;
    	String se1 = s1.trim();
        String se2 = s2.trim();
        String se3 = s3.trim();
        int se11 = se1.length() - 1;
        int se22 = se2.length() - 1;
        int se33 = se3.length() - 1;
        String ind1 = se1.substring(se11);
        String ind2 = se2.substring(se22);
        String ind3 = se3.substring(se33);
        if (ind1.compareTo(ind2) < 0) {
			answer = se1;
			holder = ind1;
		} else {
			answer = se2;
			holder = ind2;
		}
        if (ind3.compareTo(holder) < 0) {
			answer = se3;
		}
        
    	return answer;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int sum = 0;
    	for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) == true) {
				String b = s.charAt(i) + "";
				int a = Integer.parseInt(b);
				sum += a;
			}
    	}
        return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
        int numOccurances = 0;
        int index = s.indexOf(substring);
        while( index != -1 ) {
            numOccurances++;
            index = s.indexOf(substring, index + substring.length());
        }
        return numOccurances;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
        byte b = (byte)key;
        byte[] a = new byte [s.length()];
        for (int i = 0; i < s.length(); i++) {
			a[i] += (byte) s.charAt(i);
		}
    	return Utilities.encrypt(a, b);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	byte b = (byte)key;
        return Utilities.decrypt(s, b);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	int a = substring.length();
    	int num = 0;
    	for (int i = a; i < s.length(); i++) {
			if (s.charAt(i) == ' ' || i == s.length()-1) {
				String sub = s.substring(i-a,i);
				if (sub.equalsIgnoreCase(substring)) {
					num++;
				}
			}
		}
        return num;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	int start = 0;
    	int end = 0;
    	for (int i = 0; i < s.length(); i++) {
			if (s.substring(i,i+substring.length()).equals(substring)) {
				start = i;
				break;
			}
		}
    	for (int i = s.length(); i > 0; i--) {
    		if (s.substring(i-substring.length(),i).equals(substring)) {
    			end = i-substring.length();
    			break;
    		}
		}
    	int finals = end - start - substring.length();
        return finals;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	String trim = s.trim();
    	String backward = "";
    	String newtrim = trim.replaceAll("[?. ,:'+=;-]", "");
    	for (int i = newtrim.length()-1; i >= 0; i--) {
			backward += newtrim.charAt(i);
		}
    	System.out.println(newtrim + "|||| " + backward);
    	if (backward.equalsIgnoreCase(newtrim)) {
			return true;
		}
        return false;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
