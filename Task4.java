import java.util.*;
import java.util.stream.Collectors;

public class Task4 {

    // 1.
    public static String nonRepeat(String str) {
        str = str.toLowerCase();
        StringBuilder result = new StringBuilder();
        Map<Character, Long> frequencyMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        for (char c : str.toCharArray()) {
            if (frequencyMap.get(c) <= 3) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 2.
    public static List<String> bruteForce(int n, int k) {
        if (n > k) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        bruteForceHelper(n, k, "", result);
        return result;
    }

    private static void bruteForceHelper(int n, int k, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!current.contains(String.valueOf(i))) {
                bruteForceHelper(n, k, current + i, result);
            }
        }
    }

    // 3.
    public static List<Integer> decode(String message, String key) {
        List<Integer> decoded = new ArrayList<>();
        for (int i = 0; i < message.length(); i++) {
            decoded.add(message.charAt(i) ^ key.charAt(i));
        }
        return decoded;
    }

    public static String encode(List<Integer> code, String key) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < code.size(); i++) {
            encoded.append((char) (code.get(i) ^ key.charAt(i)));
        }
        return encoded.toString();
    }

    // 4.
    public static List<String> split(String s) {
        List<String> result = new ArrayList<>();
        int balance = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == '(' ? 1 : -1;
            if (balance == 0) {
                result.add(s.substring(start, i + 1));
                start = i + 1;
            }
        }
        return result;
    }

    // 5.
    public static String shortHand(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            result.append(s.charAt(i)).append(count > 1 ? "*" + count : "");
        }
        return result.toString();
    }

    // 6.
    public static String convertToRome(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(romans[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    // 7.
    public static String uniqueSubstring(String s) {
        Map<Character, Integer> evenCounts = new HashMap<>();
        Map<Character, Integer> oddCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Map<Character, Integer> counts = (i % 2 == 0) ? evenCounts : oddCounts;
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        int maxEven = evenCounts.values().stream().max(Integer::compareTo).orElse(0);
        int maxOdd = oddCounts.values().stream().max(Integer::compareTo).orElse(0);
        return maxEven >= maxOdd ? "чет" : "нечет";
    }

    // 8.
    public static String labirint(int[][] matrix) {
        int n = matrix.length;

        if (matrix[0][0] < 0 || matrix[n - 1][n - 1] < 0) return "Прохода нет";

        int[][] dp = new int[n][n];
        String[][] path = new String[n][n];

        dp[n - 1][n - 1] = matrix[n - 1][n - 1];
        path[n - 1][n - 1] = String.valueOf(matrix[n - 1][n - 1]);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] < 0) continue;

                int fromRight = (j + 1 < n && dp[i][j + 1] != 0) ? dp[i][j + 1] + matrix[i][j] : Integer.MAX_VALUE;
                int fromBelow = (i + 1 < n && dp[i + 1][j] != 0) ? dp[i + 1][j] + matrix[i][j] : Integer.MAX_VALUE;

                if (i != n - 1 || j != n - 1) {
                    if (fromRight < fromBelow) {
                        dp[i][j] = fromRight;
                        path[i][j] = path[i][j + 1] + "-" + matrix[i][j];
                    } else if (fromBelow < Integer.MAX_VALUE) {
                        dp[i][j] = fromBelow;
                        path[i][j] = path[i + 1][j] + "-" + matrix[i][j];
                    }
                }
            }
        }

        return dp[0][0] == 0 ? "Прохода нет" : "[" + path[0][0] + "," + dp[0][0] + "]";
    }

    // 9.
    public static String numericOrder(String str) {
        String[] words = str.split(" ");
        Arrays.sort(words, Comparator.comparingInt(word -> Integer.parseInt(word.replaceAll("\\D", ""))));
        return Arrays.stream(words).map(word -> word.replaceAll("\\d", "")).collect(Collectors.joining(" "));
    }

    // 10.
    public static boolean fibString(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : str.toCharArray()) countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        List<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts);
        return isFibonacci(counts);
    }

    private static boolean isFibonacci(List<Integer> counts) {
        if (counts.size() < 3) return false;
        for (int i = 2; i < counts.size(); i++) {
            if (counts.get(i) != counts.get(i - 1) + counts.get(i - 2)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Тесты для всех функций
        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));
        System.out.println(bruteForce(2, 2));
        System.out.println(bruteForce(5, 3));
        System.out.println(bruteForce(1, 5));
        System.out.println(encode(Arrays.asList(0, 31, 28, 10, 29), "MKIIT"));
        System.out.println(decode("MTUCI", "MKIIT"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(shortHand("abbccc"));
        System.out.println(shortHand("vvvvaajaaaaa"));
        System.out.println(convertToRome(1234));
        System.out.println(convertToRome(52));
        System.out.println(convertToRome(8));
        System.out.println(uniqueSubstring("31312131"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("12223234333"));
        int[][] matrix = {{2, -7, 3}, {-4, -1, 8}, {4, 5, 9}};
        System.out.println(labirint(matrix));
        int[][] matrixx = {{1, 3, 1}, {1, -1, 1}, {4, 2, 1}};
        System.out.println(labirint(matrixx));
        System.out.println(numericOrder("ol2d has1 he4 the3"));
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(fibString("ABC"));
        System.out.println(fibString("CCCABDD"));
    }
}
