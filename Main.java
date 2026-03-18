import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    // Parser para montar a expressão.
    public static void parser(String exp, List<Double> numeros, List<Character> operadores){
        exp = exp.trim().replaceAll("\\s+", "");
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
    }
    //Calcular portencia e raiz
    public static void potenciaEraiz(List<Double>numeros, List<Character> operadores){
        for (int i = operadores.size()-1; i>=0; i--){
            char op = operadores.get(i);
            if (op == 'r'||op == '^') {
                double a = numeros.get(i);
                double b = numeros.get(i+1);
                double resultado = (op == 'r') ? Math.pow(b, 1.0/a) : Math.pow(a,b);
                numeros.set(i, resultado);
                numeros.remove(i+1);
                operadores.remove(i);
            }
        }
    }
    //calcular divisão, multiplicação e porcentagem
    public static void divEmultiEporcent(List<Double>numeros, List<Character> operadores){
        for (int i = 0; i<operadores.size();i++) {
            char op = operadores.get(i);
            if (op == '*' || op == '/' || op == '%') {
                double a = numeros.get(i);
                double b = numeros.get(i+1);
                double resultado;
                if (op == '*') resultado = a*b;
                else if (op == '/') resultado = a/b;
                else resultado = a * (b/100);
                numeros.set(i, resultado);
                numeros.remove(i+1);
                operadores.remove(i);
                i--;
            }
        }
    }
    //calcular soma e diferença
    public static Double somaEdiferenca(List<Double>numeros, List<Character> operadores){
        double resultado = numeros.get(0);
        for (int i = 0; i < operadores.size(); i++){
            char op = operadores.get(i);
            double num = numeros.get(i+1);
            if (op == '+') resultado += num;
            else resultado -= num;
        }
        return resultado;
    }
    //Executar toda a lógica e a prioridade matemática de uma só vez
    public static double calcularExpressao(String exp){
        List<Double> numeros = new ArrayList<>();
        List<Character> operadores = new ArrayList<>();

        parser(exp, numeros, operadores);
        potenciaEraiz(numeros, operadores);
        divEmultiEporcent(numeros, operadores);
        return somaEdiferenca(numeros, operadores);
    }
    //entrada do usuário
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite uma expressão(Ex: 1+2, 1-2, 1*2, 1/2, 2^3, 2r4, 10%20): ");
        String entrada = scan.nextLine();   
        double result = calcularExpressao(entrada);
        System.out.println("Resultado: " + result);
        scan.close();
    }
}
