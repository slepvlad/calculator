import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {

    private static final Pattern WRONG_SYMBOLS = Pattern.compile("^\\D|[^0-9\\+\\-\\/\\*\\^\\@\\s]|\\D$|[\\+\\-\\/\\*]{2,}");


    public static boolean isValid(String str){
        str = str.trim();
        Matcher isHasWrongSymbols = WRONG_SYMBOLS.matcher(str);
        return !(str.isEmpty() || isHasWrongSymbols.find());
    }
}
