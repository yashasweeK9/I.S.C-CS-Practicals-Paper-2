import java.util.Scanner;

class Driver3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("INPUT:\t");
        int input = sc.nextInt();
        Mobius obj = new Mobius(input);
        System.out.println(obj);
        sc.close();
    }
}