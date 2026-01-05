import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamSeries {
    
    public static void main(String[] args) {
        String a = "Priya Arora";
        
        // Character firstNonRepeat = a.chars()
        //     .mapToObj(obj -> Character.toLowerCase(Character.valueOf((char) obj)))
        //     .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        //     .entrySet()
        //     .stream()
        //     .filter(vals -> vals.getValue() == 1)
        //     .map(keys -> keys.getKey())
        //     .findFirst()
        //     .get();

        // System.out.println(firstNonRepeat);

        char firsRepeated = a.chars()
        .mapToObj(obj -> Character.valueOf((char) obj))
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(set -> set.getValue() > 1)
        .map(keys -> keys.getKey())
        .findFirst()
        .get();

        System.out.println("first repeated char: "+ firsRepeated);

        //To count each word or entry seperated by space.
        Map<String, Long> counts = Arrays.asList(a.split(" "))
        .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(counts);

        
    }

}
