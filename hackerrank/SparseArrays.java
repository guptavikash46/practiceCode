package hackerrank;

import java.util.Arrays;
import java.util.List;

public class SparseArrays {

    public static void main(String[] args) {

        SparseArrays sa = new SparseArrays();
        List<String> values = Arrays.asList("aba", "baba", "aba", "xzxb");
        List<String> queries = Arrays.asList("aba", "xzxb", "ab");
        System.out.println("result: "+ sa.matchingStrings(values, queries));
    }

    public List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
        Integer[] result = new Integer[queries.size()];
        // System.out.println("result init: "+ result[0]);
        for (int i = 0; i < stringList.size(); i++) {
            if (i >= queries.size()) {
                break;
            }
            String q = queries.get(i);
            if (q.equals(stringList.get(i))) {
                if (result[i] == null) {
                    result[i] = 1;
                } else {
                    int currentCount = result[i];
                    result[i] = currentCount + 1;
                }

            }
        }
        return Arrays.asList(result);

    }
}
