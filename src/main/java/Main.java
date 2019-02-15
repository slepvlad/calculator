import java.util.Scanner;

public class Main {


    public static void main(String[] arg){
        System.out.println("Поддерживаемые операции:\n" +
                "a + b = сложение a,b \n" +
                "a - b = вычитание a,b \n" +
                "a * b = умножение a,b \n" +
                "a / b = деление a,b \n" +
                "a ^ b = возведение a в степень b \n" +
                "a @ b = извлечение корня степени b из a \n");

        Scanner in = new Scanner(System.in);
        while (true){
            String input= in.nextLine();
            if(ValidatorUtils.isValid(input)){
                Calculate task0 = new Calculate(input);
                System.out.println(task0.getResult());
            }
            else{
                System.out.println("Sorry, the string is wrong.");
            }
        }
    }
}
