import java.util.Scanner;

public class Main {
    public static double somar(double a, double b){
            return a + b;
        }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Número 1: ");
        double n1 = scan.nextDouble();

        System.out.println("Número 2: ");
        double n2 = scan.nextDouble();

        double result = somar(n1, n2);
        System.out.println("O resultado dessa soma é: " + result);
        scan.close();
    }
}
