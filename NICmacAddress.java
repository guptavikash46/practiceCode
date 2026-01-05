import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NICmacAddress {

    public static void main(String[] args) {
        // try {
        //     // Define the command to execute
        //     String command = "cmd.exe /c getmac /v /fo table | findstr /i /v \"Virtual VPN Hyper-V Disabled Disconnected\"";

        //     // Create ProcessBuilder to run the command
        //     ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+\\|?\\s*"));
        //     processBuilder.redirectErrorStream(true); // Combine stdout and stderr

        //     // Start the process
        //     Process process = processBuilder.start();

        //     // Read the output
        //     BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        //     String line;
        //     System.out.println("Active Physical NIC MAC Addresses:");
        //     while ((line = reader.readLine()) != null) {
        //         System.out.println(line);
        //     }

        //     // Wait for the process to complete and check exit code
        //     int exitCode = process.waitFor();
        //     if (exitCode != 0) {
        //         System.err.println("Command failed with exit code: " + exitCode);
        //     }

        // } catch (IOException | InterruptedException e) {
        //     System.err.println("Error executing command: " + e.getMessage());
        //     e.printStackTrace();
        // }
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString());

    }
    
}