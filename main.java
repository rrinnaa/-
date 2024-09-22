public class Main {
    private static final double GALLON_TO_LITERS = 3.78541;

    public static double convert(int gallons) {
        return gallons * GALLON_TO_LITERS;
    }

    public static void main(String[] args) {
        System.out.println("Gallons to Liters:");
        System.out.println(convert(5)); // 18.925
        System.out.println(convert(3)); // 11.355
        System.out.println(convert(8)); // 30.28328
    }
}

public class FitnessApp {
    public static int fitCalc(int minutes, int intensity) {
        int caloriesPerMinute = 0;

        switch (intensity) {
            case 1:
                caloriesPerMinute = 1;
                break;
            case 2:
                caloriesPerMinute = 2;
                break;
            case 3:
                caloriesPerMinute = 3;
                break;
            default:
                System.out.println("Неправильная интенсивность. Введите значение от 1 до 3.");
                return 0;
        }

        return minutes * caloriesPerMinute;
    }

    public static void main(String[] args) {
        System.out.println("Fitness App Calories:");
        System.out.println(fitCalc(15, 1)); // 15
        System.out.println(fitCalc(24, 2)); // 48
        System.out.println(fitCalc(41, 3)); // 123
    }
}

public class Warehouse {
    public static int containers(int boxes, int bags, int barrels) {
        int itemsInBox = 20;
        int itemsInBag = 50;
        int itemsInBarrel = 100;

        int totalItems = (boxes * itemsInBox) + (bags * itemsInBag) + (barrels * itemsInBarrel);
        return totalItems;
    }

    public static void main(String[] args) {
        System.out.println("Warehouse Container Calculation:");
        System.out.println(containers(3, 4, 2)); 
        System.out.println(containers(5, 0, 2)); 
        System.out.println(containers(4, 1, 4)); 
    }
}

public class Triangle {
    public static String triangleType(int x, int y, int z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "not a triangle";
        }

        if (x == y && y == z) {
            return "equilateral";
        } else if (x == y || x == z || y == z) {
            return "isosceles";
        } else {
            return "different-sided";
        }
    }

    public static void main(String[] args) {
        System.out.println("Triangle Type:");
        System.out.println(triangleType(5, 5, 5)); 
        System.out.println(triangleType(5, 4, 5)); 
        System.out.println(triangleType(3, 4, 5)); 
        System.out.println(triangleType(5, 1, 1)); 
    }
}

public class TernaryExample {
    public static int ternaryEvaluation(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        System.out.println("Ternary Evaluation:");
        System.out.println(ternaryEvaluation(8, 4));  
        System.out.println(ternaryEvaluation(1, 11)); 
        System.out.println(ternaryEvaluation(5, 9));  
    }
}

public class FabricCalculator {
    public static int howManyItems(int n, double w, double h) {
        double totalFabric = n * 2;
        double itemArea = w * h * 2;

        int items = 0;
        while (totalFabric >= itemArea) {
            totalFabric -= itemArea;
            items++;
        }

        return items;
    }

    public static void main(String[] args) {
        System.out.println("Fabric Calculator:");
        System.out.println(howManyItems(22, 1.4, 2));  
        System.out.println(howManyItems(45, 1.8, 1.9)); 
        System.out.println(howManyItems(100, 2, 2));   
    }
}

public class FactorialCalculator {
    public static int factorial(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Factorial Calculator:");
        System.out.println(factorial(3));  
        System.out.println(factorial(5));  
        System.out.println(factorial(7));  
    }
}

public class GCDCalculator {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("GCD Calculator:");
        System.out.println(gcd(48, 18)); 
        System.out.println(gcd(52, 8));  
        System.out.println(gcd(259, 28)); 
    }
}

public class TicketSales {
    public static int ticketSaler(int numberOfTickets, int ticketPrice) {
        return numberOfTickets * ticketPrice;
    }

    public static void main(String[] args) {
        System.out.println("Ticket Sales:");
        System.out.println(ticketSaler(70, 1500)); 
        System.out.println(ticketSaler(24, 950));  
        System.out.println(ticketSaler(53, 1250)); 
    }
}

public class TableCalculator {
    public static int tables(int students, int desks) {
        int studentsPerDesk = 2;

        int requiredDesks = (int) Math.ceil((double) students / studentsPerDesk);

        int missingDesks = requiredDesks - desks;

        return Math.max(missingDesks, 0);
    }

    public static void main(String[] args) {
        System.out.println("Table Calculator:");
        System.out.println(tables(5, 2)); 
        System.out.println(tables(31, 20)); 
        System.out.println(tables(123, 58));
    }
}
