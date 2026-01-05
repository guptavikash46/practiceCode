import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllCharFromStringStream {
    
    public static void main(String[] args) {
        List<String> s = Arrays.asList("Java", "articles", "are", "Awesome");
        s.stream().flatMap(words -> words.chars().mapToObj(c -> (char) c))
        .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entries -> entries.getValue() > 1L)
        .map(entries -> entries.getKey())
        .findFirst()
        .ifPresent(System.out::println);
        


        List<String> sentences = Arrays.asList(
        "Java streams are powerful",
        "flatMap is useful",
        "streams make code clean"
        );

        sentences.stream().flatMap(eachSentence -> Arrays.stream(eachSentence.split(" ")))
        .forEach(System.out::println);

        
    }
}
