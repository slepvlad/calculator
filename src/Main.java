import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern PATTERN_LETTER = Pattern.compile("[А-Я]|[а-я]|[A-Z]|[a-z]|[\\(\\)\\~\\@\\#\\$\\%\\^\\&\\_\\=\\.\\,\\?\\:\\;\\'\\|]");
    private static final Pattern START_END_SYMBOL = Pattern.compile("^\\D|\\D$");
    private static final Pattern TWO_OR_MORE_OPERATION = Pattern.compile("[\\+\\-\\/\\*]{2,}");

    public static void main(String[] arg){

        Scanner in = new Scanner(System.in);
        while (true){
            String input= in.nextLine();
            if(isValid(input)){
                Calculate task0 = new Calculate(input);
                System.out.println(task0.getResult());
            }
            else{
                System.out.println("Sorry, the string is wrong.");
            }
        }
    }


    private static boolean isValid(String str){
        str = str.trim();
        if(str.length() == 0){ return false;}
        Matcher isCorrect = PATTERN_LETTER.matcher(str);
        Matcher isSymbol = START_END_SYMBOL.matcher(str);
        Matcher isTwoOrMoreOperations = TWO_OR_MORE_OPERATION.matcher(str);
        if(isCorrect.find()){return false;}
        if(isSymbol.find()){return false;}
        if(isTwoOrMoreOperations.find()){return false;}

        return true;
    }
}
