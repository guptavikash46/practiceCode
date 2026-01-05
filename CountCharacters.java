import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountCharacters {
    
    public static void main(String[] args) {
        String s = "I love my city";
        // Map<String, Long> countChars = Stream.of(s.split(""))
        // .filter(chars -> !chars.equals(" ")).map(String::toLowerCase)
        // .collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
        //System.out.println(countChars);
        
        Map<String, Long> countChars = Stream.of(s.split(" ")).map(String::toLowerCase)
        .collect(Collectors.groupingBy(words -> words, LinkedHashMap::new, Collectors.counting()));
        System.out.println(countChars);

        // Abc abc = new Abc("test");
        // Abc abc2 = new Abc("test");
        // System.out.println(abc == abc2);

    }
}
class Abc {
    private String msg;
     Abc(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Abc abc = (Abc) obj;
        if (this.msg == null) {
            return false;
        }
        else {
            return this.msg.equals(abc.msg);
        }
    }
}
