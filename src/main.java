import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan Angka antara 1 - 100: ");
        int a = input.nextInt();

        String gage = oddEven(a);
        System.out.println(gage);
    }

    /* Ryan Salim */

    static String oddEven(int a) {
        if (a % 2 == 0) {
            if (a >= 2 && a <= 5 || a > 20) {
                return "Tidak AJAIB";
            } else if (a > 5) {
                return "AJAIB";
            } else {
                return "AJAIB";
            }
        } else {
            return "AJAIB";
        }
    }
}
