import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {

    private static final Pattern PATTERN_LETTER = Pattern.compile("[А-Я]|[а-я]|[A-Z]|[a-z]|[\\(\\)\\~\\#\\$\\%\\&\\_\\=\\.\\,\\?\\:\\;\\'\\|]");
    private static final Pattern START_END_SYMBOL = Pattern.compile("^\\D|\\D$");
    private static final Pattern TWO_OR_MORE_OPERATION = Pattern.compile("[\\+\\-\\/\\*]{2,}");


    public static boolean isValid(String str){
        str = str.trim();
        if(str.length() == 0){ return false;}
        Matcher isHasWrongSymbols = PATTERN_LETTER.matcher(str);
        if(isHasWrongSymbols.find()){return false;}
        Matcher isHasStartOrEndNotDigital = START_END_SYMBOL.matcher(str);
        if(isHasStartOrEndNotDigital.find()){return false;}
        Matcher isTwoOrMoreOperations = TWO_OR_MORE_OPERATION.matcher(str);
        if(isTwoOrMoreOperations.find()){return false;}

        return true;
    }
}
