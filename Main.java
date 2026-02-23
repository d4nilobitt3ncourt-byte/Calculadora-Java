import java.util.Scanner;

public class Main {
    public static double CalcularExpressao(String exp){
            if (exp.contains("+")) {
                String[] partes = exp.split("\\+");
                double a = Double.parseDouble(partes[0]);
                double b = Double.parseDouble(partes[1]);
                return a+b;
            }
            else if (exp.contains("-")) {
                String[] partes = exp.split("\\-");
                double a = Double.parseDouble(partes[0]);
                double b = Double.parseDouble(partes[1]);
                return a-b;
            }
            else if (exp.contains("*")) {
                String[] partes = exp.split("\\*");
                double a = Double.parseDouble(partes[0]);
                double b = Double.parseDouble(partes[1]);
                return a*b;
            }
            else if (exp.contains("/")) {
                String[] partes = exp.split("\\/");
                double a = Double.parseDouble(partes[0]);
                double b = Double.parseDouble(partes[1]);
                if (a == 0 || b == 0) {
                    throw new ArithmeticException("Divisão por zero não é permitida!");
                }
                return a/b;
            }
            else {
                throw new IllegalArgumentException("Operação inválida! por favor escrever expressão corretamente");
            }
        }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite expressão de soma ou diferença (ex: 5+2, 4-3, 5*2,6/2): ");
        String entrada = scan.nextLine();
        double result = CalcularExpressao(entrada);
        System.out.println("Resultado: " + result);
        scan.close();
    }
}
