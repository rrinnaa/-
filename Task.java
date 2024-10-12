import java.util.*;

public class Task {

    // 1.
    public static boolean isStrangePair(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) return true;
        return str1.charAt(0) == str2.charAt(str2.length() - 1) && str1.charAt(str1.length() - 1) == str2.charAt(0);
    }

    // 2.
    public static String[][] sale(List<String[]> products, int discount) {
        List<String[]> newPrices = new ArrayList<>();
        for (String[] product : products) {
            String name = product[0];
            int price = Integer.parseInt(product[1]);
            int discountedPrice = Math.max(1, (int) Math.round(price * (1 - discount / 100.0)));
            newPrices.add(new String[]{name, String.valueOf(discountedPrice)});
        }
        return newPrices.toArray(new String[0][]);
    }

    // 3.
    public static boolean sucsessShoot(double x, double y, double r, double m, double n) {
        double distance = Math.sqrt(Math.pow(m - x, 2) + Math.pow(n - y, 2));
        return distance <= r;
    }

    // 4.
    public static boolean parityAnalysis(int num) {
        int sum = 0, temp = num;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return (num % 2 == sum % 2);
    }

    // 5.
    public static String rps(String player1, String player2) {
        if (player1.equals(player2)) return "Tie";
        if ((player1.equals("rock") && player2.equals("scissors")) ||
                (player1.equals("scissors") && player2.equals("paper")) ||
                (player1.equals("paper") && player2.equals("rock"))) {
            return "Player 1 wins";
        }
        return "Player 2 wins";
    }

    // 6.
    public static int bugger(int num) {
        int count = 0;
        while (num > 9) {
            int product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }
            num = product;
            count++;
        }
        return count;
    }

    // 7.
    public static String mostExpensive(List<String[]> inventory) {
        String maxItem = "";
        int maxCost = 0;
        for (String[] item : inventory) {
            String name = item[0];
            int price = Integer.parseInt(item[1]);
            int quantity = Integer.parseInt(item[2]);
            int totalCost = price * quantity;
            if (totalCost > maxCost) {
                maxCost = totalCost;
                maxItem = name;
            }
        }
        return "Наиб. общ. стоимость у предмета " + maxItem + " - " + maxCost;
    }

    // 8.
    public static String longestUnique(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            Set<Character> seen = new HashSet<>();
            StringBuilder current = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (seen.contains(s.charAt(j))) break;
                seen.add(s.charAt(j));
                current.append(s.charAt(j));
            }
            if (current.length() > longest.length()) longest = current.toString();
        }
        return longest;
    }

    // 9.
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }

    // 10.
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
                (a <= w && c <= h) || (a <= h && c <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w);
    }

    public static void main(String[] args) {
        System.out.println(isStrangePair("bush", "hubris"));

        List<String[]> products = new ArrayList<>();
        products.add(new String[]{"Laptop", "124200"});
        products.add(new String[]{"Phone", "51450"});
        products.add(new String[]{"Headphones", "13800"});

        System.out.println(Arrays.deepToString(sale(products, 25)));

        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));

        System.out.println(parityAnalysis(12));

        System.out.println(rps("paper", "rock"));

        System.out.println(bugger(999));

        List<String[]> inventory = new ArrayList<>();
        inventory.add(new String[]{"Скакалка", "550", "8"});
        inventory.add(new String[]{"Шлем", "3750", "40"});
        inventory.add(new String[]{"Мяч", "2900", "10"});
        System.out.println(mostExpensive(inventory));

        System.out.println(longestUnique("abcbafafaga"));

        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "sub-"));

        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
    }
}
