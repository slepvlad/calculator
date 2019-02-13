import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        while (true){
            String input= in.nextLine();

            Pattern patternLetter = Pattern.compile("[А-Я]|[а-я]|[A-Z]|[a-z]|[\\(\\)\\~\\@\\#\\$\\%\\^\\&\\_\\=\\.\\,\\?\\:\\;\\'\\|]");
            Pattern endSymbol = Pattern.compile("^\\D|\\D$");
            Matcher isCorrect = patternLetter.matcher(input);
            Matcher isSymbol = endSymbol.matcher(input);
            if(isCorrect.find() || isSymbol.find()){
                System.out.println("Sorry, the string is wrong.");
            }
            else{
                Calculate task0 = new Calculate(input);
                System.out.println(task0.getResult());
            }

        }

    }
}
