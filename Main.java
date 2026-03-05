import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static double calcularExpressao(String exp) {
        exp = exp.trim().replaceAll("\\s+", "");

        List<Double> numeros = new ArrayList<>();
        List<Character> operadores = new ArrayList<>();

        String numeroAtual = "";

        for (int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if (Character.isDigit(c) || c == '.'){  
                numeroAtual += c;
            }
            else{
                numeros.add(Double.parseDouble(numeroAtual));
                numeroAtual = "";

                operadores.add(c);
            }
        }
        numeros.add(Double.parseDouble(numeroAtual));
        
        for (int i = 0; i<operadores.size(); i++){
            char op = operadores.get(i);
            if (op == '*' || op == '/') {
                double a = numeros.get(i);
                double b = numeros.get(i+1);
                double resultado;
                if (op == '*'){
                    resultado = a*b;
                }
                else {
                    if (b == 0 || a == 0)
                        throw new ArithmeticException("Divisão por zero não pode!");
                    resultado = a/b;
                }
                numeros.set(i,resultado);
                numeros.remove(i+1);
                operadores.remove(i);

                i--;
            }
        }
        double resultado = numeros.get(0);
        for (int i = 0; i < operadores.size(); i++){
            char op = operadores.get(i);
            double num = numeros.get(i+1);
            if (op == '+'){
                resultado += num;
            }
            else{
                resultado -= num;
            }
        }
        return resultado;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite uma expressão(Ex: 1+2, 2-1, 4+2*3): ");
        String entrada = scan.nextLine();
        double result = calcularExpressao(entrada);
        System.out.println("Resultado: " + result);
        scan.close();
    }
}
