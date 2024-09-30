import java.util.Arrays;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    // 1.
    public static String duplicateChars(String str1, String str2) {
        return str1.chars()
                .filter(c -> str2.indexOf(c) == -1)
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining());
    }

    // 2.
    public static int dividedByThree(int[] arr) {
        return (int) Arrays.stream(arr)
                .filter(n -> n % 3 == 0 && n % 2 != 0)
                .count();
    }

    // 3.
    public static String getInitials(String fullName) {
        String[] names = fullName.split(" ");
        String initials = names[1].charAt(0) + "." + names[2].charAt(0) + ".";
        return initials.toUpperCase() + names[0].substring(0, 1).toUpperCase() + names[0].substring(1);
    }


    // 4.
    public static double[] normalizator(double[] arr) {
        double min = Arrays.stream(arr).min().orElse(0);
        double max = Arrays.stream(arr).max().orElse(0);

        if (max == min) {
            return new double[arr.length];
        }

        return Arrays.stream(arr)
                .map(x -> (x - min) / (max - min))
                .map(x -> new BigDecimal(Double.toString(x)).setScale(4, RoundingMode.HALF_UP).doubleValue())
                .toArray();
    }

    // 5.
    public static int[] compressedNums(double[] arr) {
        return Arrays.stream(arr)
                .mapToInt(x -> (int) x)
                .filter(x -> x != 0)
                .distinct()
                .sorted()
                .toArray();
    }

    // 6.
    public static String camelToSnake(String str) {
        return str.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }

    // 7.
    public static int secondBiggest(int[] arr) {
        return Arrays.stream(arr)
                .distinct()
                .sorted()
                .toArray()[arr.length - 2];
    }

    // 8.
    public static String localReverse(String str, char marker) {
        StringBuilder result = new StringBuilder();
        int first = str.indexOf(marker);
        if (first == -1 || str.lastIndexOf(marker) == first) {
            return str;
        }
        while (first != -1) {
            int last = str.indexOf(marker, first + 1);

            if (last == -1) {
                break;
            }
            result.append(str, 0, first + 1);
            String middle = new StringBuilder(str.substring(first + 1, last)).reverse().toString();
            result.append(middle);
            result.append(str.substring(last));
            str = result.toString();
            first = str.indexOf(marker, last + 1);
            result.setLength(0);
        }
        return str;
    }

    // 9.
    public static int equal(int a, int b, int c) {
        if (a == b && b == c) return 3;
        if (a == b || b == c || a == c) return 2;
        return 0;
    }

    // 10.
    public static boolean isAnagram(String str1, String str2) {
        String normalizedStr1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String normalizedStr2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();
        char[] arr1 = normalizedStr1.toCharArray();
        char[] arr2 = normalizedStr2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {


        System.out.println(duplicateChars("Draco", "Malfoy"));
        System.out.println(dividedByThree(new int[]{3, 12, 7, 81, 52}));
        System.out.println(getInitials("Merkulova Marina Aleksandrovna")); //
        System.out.println(Arrays.toString(normalizator(new double[]{3.5, 7.0, 1.5, 9.0, 5.5})));
        System.out.println(Arrays.toString(normalizator(new double[]{10.0, 10.0, 10.0, 10.0, 10.0, 10.0})));
        System.out.println(Arrays.toString(compressedNums(new double[]{1.6, 0, 212.3, 34.8, 0, 27.5})));
        System.out.println(camelToSnake("helloWorld"));
        System.out.println(secondBiggest(new int[]{3, 5, 8, 1, 2, 4}));
        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));
        System.out.println(equal(8, 1, 8));
        System.out.println(equal(5, 5, 5));
        System.out.println(equal(4, 9, 6));
        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println(isAnagram("hello", "world"));
    }
}