import java.util.Scanner;

public class Ex2_2_6_1 {
    public void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Solve linear equation: ax + b = 0\nEnter the value of a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter the value of b: ");
        double b = scanner.nextDouble();
        if(a == 0){
            if(b != 0) System.out.println("No solution");

        }
    }

}
