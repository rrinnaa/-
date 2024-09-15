public class Palindrome {
    public static String reverseString(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String word = args[i];
            boolean isPalindrome = isPalindrome(word);
            System.out.println(word + " is a palindrome: " + isPalindrome);
        }
    }
}