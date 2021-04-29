import java.util.Scanner;

class Driver2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("INPUT:\t");
        String input = sc.nextLine();
        EditStr obj = new EditStr(input);
        System.out.println(obj);
        sc.close();
    }
}