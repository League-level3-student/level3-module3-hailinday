package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
    	StringBuilder builder = new StringBuilder(str);
    	String append = builder.append(characters).toString();
        return append;
    }
    
    public static String reverse(String str) {
    	StringBuilder builder = new StringBuilder(str);
    	String reverse = builder.reverse().toString();
    	return reverse;
    }
    
    public static String insert(String str, int index, char newChar) {
    	StringBuilder builder = new StringBuilder(str);
    	String insert = builder.insert(index, newChar).toString();
        return insert;
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	StringBuilder builder = new StringBuilder(str);
    	String delete = builder.delete(startIndex, endIndex).toString();
        return delete;
    }
}