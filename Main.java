import java.util.Scanner;

public class Main {
    public static double calcularExpressao(String exp) {
    exp = exp.trim().replaceAll("\\s+", "");
    double resultado = 0;
    String numeroAtual = "";
    char operador = '+';
    for (int i = 0; i < exp.length(); i++) {
        char c = exp.charAt(i);
        if (Character.isDigit(c) || c == '.') {
            numeroAtual += c;
        }
        if ((!Character.isDigit(c) && c != '.') || i == exp.length() - 1) {
            double num = Double.parseDouble(numeroAtual);
            switch (operador) {
                case '+':
                    resultado += num;
                    break;
                case '-':
                    resultado -= num;   
                    break;
                case '*':
                    resultado *= num;
                    break;
                case '/':
                    if (num == 0)
                        throw new ArithmeticException("Divisão por zero");
                    resultado /= num;
                    break;
            }
            operador = c;
            numeroAtual = "";
        }
    }

    return resultado;
}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite expressão (ex: 5+2, 4-3, 5*2,6/2): ");
        String entrada = scan.nextLine();
        double result = calcularExpressao(entrada);
        System.out.println("Resultado: " + result);
        scan.close();
    }
}
