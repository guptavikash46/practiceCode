import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamFunctions {

    public static void main(String[] args) {

        // Map<Integer, String> map = new HashMap<>();
        // map.put(20, "apple");
        // map.put(10, "orange");
        // map.put(40, "banana");
        // map.put(30, "watermelon");
        // map.put(50, "dragonfruit");

    

        // map.entrySet().stream().filter(v -> v.getValue().startsWith("a"))
        // .map(k -> k.getValue()).forEach(System.out::println);

        Stream.of(3,4,1,2,9,4,6,3).distinct().sorted((v1, v2) -> v2.compareTo(v1)).forEach(System.out::println);
        Collections.sort(List.of(1, 4, 2));
    }
}