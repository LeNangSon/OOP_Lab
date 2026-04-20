import java.util.Scanner;

public class Ex2_2_5 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.println("Enter second number: ");
        double num2 = scanner.nextDouble();

        double sum = num1 + num2;
        double subtract = num1 - num2;
        double product = num1 * num2;

        System.out.println("Sum: " + sum);
        System.out.println("Subtract (num1-num2): " + subtract);
        System.out.println("Product: " + product);

        if(num2 == 0){
            System.out.println("Error! Divisors equal to zero");
        }
        else {
            double divide = num1 / num2;
            System.out.println("Divide (num1/num2):  " + divide);
        }
    }
}
