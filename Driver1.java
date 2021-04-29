import java.util.Scanner;
import static java.lang.System.out;

class Driver1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        out.print("INPUT:\tDAY NUMBER\t:\t");
        int dayNo = sc.nextInt();
        out.print("      \tYEAR\t\t:\t");
        int year = sc.nextInt();
        out.print("      \tDATE AFTER\t:\t");
        int dateAfter = sc.nextInt();
        DateFunc obj = new DateFunc(dayNo, year, dateAfter);
        System.out.println(obj);
        sc.close();
    }
}