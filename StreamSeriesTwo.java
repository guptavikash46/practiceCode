import java.util.Arrays;
import java.util.function.Predicate;

public class StreamSeriesTwo {

    public static void main(String[] args) {
        
        // Arrays.asList(10,15,8,49,25,98,98,32,15)
        // .stream().sorted((v1, v2) -> v2.compareTo(v1)).forEach(System.out::println);
        
        int e = 5;
        int b = 6;
        
        CalcSquare result = (a, c) -> e * b ;
        System.out.println(result.getSquare(e, b));

        String email = "vikas.gupta@soprasteria.com";
        Predicate<String> isValidEmail = (m) -> email.contains("@") && email.contains(".") && email.split("@")[1].length() > 5;
        System.out.println(isValidEmail.test(email));
;
    }
    
}

@FunctionalInterface
interface CalcSquare {

    long getSquare(int num1, int num2);
}
