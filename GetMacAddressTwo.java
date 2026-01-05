import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetMacAddressTwo { 

    private static final List<String> KEYWORDS_TO_FILTER = List.of(
        "Virtual", "VPN", "Hyper-V", "Disconnected", "Disabled"
    );
    private static final String MAC_ADDRESS_REGEX = "([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})";
    private static final Pattern MAC_PATTERN = Pattern.compile(MAC_ADDRESS_REGEX);
    
    public static void main(String[] args) {
        try {
            
            ProcessBuilder processBuilder = new ProcessBuilder(
                "cmd.exe", "/c", "getmac /v /fo table"
            );

           
            Process process = processBuilder.start();

            // Read the output
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
            // List to store MAC addresses
            List<String> macAddresses = new ArrayList<>();

            // Regular expression to match MAC addresses
            Pattern macPattern = Pattern.compile("([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})");

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("Original: "+sb.toString());
            System.out.println("Filtered: "+filterKeywords(sb.toString()));
            System.out.println("MAC: "+ filterOutMac(filterKeywords(sb.toString())));
        
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Command executed with errors.");
            }
            // Close reader
            // reader.close();
            
            // Print results
            // if (macAddresses.isEmpty()) {
            //     System.out.println("No MAC addresses found.");
            // } else {
            //     System.out.println("MAC Addresses found:");
            //     for (int i = 0; i < macAddresses.size(); i++) {
            //         System.out.println(macAddresses.get(i));
            //     }
            // }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String filterKeywords(String input) {
        // Split the input into words, filter out keywords, and rejoin
        return Stream.of(input.split(" "))
            .filter(word -> !KEYWORDS_TO_FILTER.stream()
                .anyMatch(keyword -> word.equalsIgnoreCase(keyword)))
            .collect(Collectors.joining(" "));
    }

    public static String filterOutMac(String input) {
        return Stream.of(input.split("\\s+|,")) // Split by whitespace or commas
            .filter(word -> MAC_PATTERN.matcher(word).matches())
            .collect(Collectors.joining(", "));
    }
}
