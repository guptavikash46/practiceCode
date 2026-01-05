import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestWork {
    
    public static void main(String[] args) {
        //find the first non-repeating element in a List (Ex. 2, 3, 5, 3, 2, 7, 7)
        //2, 2, 3, 3, 5, 7, 7

        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> ls = Arrays.asList(2, 3, 5, 3, 2, 7, 7);
        //List<Integer> counts = new ArrayList<>();
        int tempCount = 0;

        // for(int i = 0; i < ls.size(); i++) {
        //     mp.put(ls.get(i), null)
        // }

        for(int i = 0; i < ls.size(); i++) {
           // mp.put(ls.get(i), mp.get(ls.get(i)));
            for(int j = 1; j < 100; j++) {
                if (ls.get(i) == j) {
                    if (mp.get(ls.get(i)) == null) {
                        mp.put(ls.get(i), 1);
                    }
                    else {
                        int incr = mp.get(ls.get(i));
                        incr += 1;
                        mp.put(ls.get(i),incr);
                    }

                }
            }

        //mp.entrySet().stream().filter(v -> v.getValue() == 1).forEach(System.out::println);
        


    }
}
}
