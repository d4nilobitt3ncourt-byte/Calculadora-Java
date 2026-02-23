import java.util.Scanner;

public class Main {
    public static double calcularExpressao(String exp) {

    exp = exp.trim().replaceAll("\\s+", "");

    double resultado = 0;
    double numeroAtual = 0;
    char operador = '+';

    for (int i = 0; i < exp.length(); i++) {

        char c = exp.charAt(i);

        if (Character.isDigit(c) || c == '.') {
            numeroAtual = numeroAtual * 10 + (c - '0');
        }

        if (!Character.isDigit(c) || i == exp.length() - 1) {

            switch (operador) {
                case '+':
                    resultado += numeroAtual;
                    break;
                case '-':
                    resultado -= numeroAtual;
                    break;
                case '*':
                    resultado *= numeroAtual;
                    break;
                case '/':
                    if (numeroAtual == 0)
                        throw new ArithmeticException("Divisão por zero");
                    resultado /= numeroAtual;
                    break;
            }

            operador = c;
            numeroAtual = 0;
        }
    }

    return resultado;
}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite expressão de soma ou diferença (ex: 5+2, 4-3, 5*2,6/2): ");
        String entrada = scan.nextLine();
        double result = calcularExpressao(entrada);
        System.out.println("Resultado: " + result);
        scan.close();
    }
}
