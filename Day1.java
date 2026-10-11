
public class Day1 {

    public static int reverseNum(int nums) {
        int res = 0;
        while (nums > 0) {
            int n = nums % 10;
            res = (res * 10) + n;
            nums /= 10;
        }
        return res;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static long ncr(int n, int r) {
        if (r < 0 || n < 0 || r > n) {
            return 0;
        }
        long nFact = factorial(n);
        long rFact = factorial(r);
        long nmrFact = factorial(n - r);

        return nFact / (rFact * nmrFact);
    }

    public static int binToDec(int n) {
        int res = 0;
        int pow = 0;
        while (n > 0) {
            int i = n % 10;
            res = res + (i * (int) Math.pow(2, pow));
            pow++;
            n /= 10;
        }
        return res;
    }

    public static int decToBin(int n) {
        int res = 0, pow = 0;
        while (n > 0) {
            int i = n % 2;
            res = res + (i * (int) Math.pow(10, pow));
            pow++;
            n /= 2;
        }
        return res;
    }

    public static void printHollowRect(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Q1. Reverse a Number
        int num1 = 12345; //Output -> 54321
        System.out.println(reverseNum(num1));

        // Q2. Check Prime
        int num2 = 29; //Output -> True
        System.out.println(isPrime(num2));

        // Q3. Factorial and nCr
        int n = 5, r = 2; //Output ->10
        System.out.println(ncr(n, r));

        // Q4. Binary to Decimal and Decimal to Binary
        int bin = 101; //Output -> 5;
        int dec = 5; //Output -> 101;
        System.out.println(binToDec(bin));
        System.out.println(decToBin(dec));

        // Q5. Pattern: Hollow Rectangle
        //    * * * * *
        //    *       *
        //    *       *
        //    * * * * *
        int rows = 4, cols = 5;
        printHollowRect(rows, cols);
    }
}
