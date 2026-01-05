import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MachineInfo {

    public static void main(String[] args) {
        String NEWLINE = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        try {

            //Process pb = new ProcessBuilder("cmd", "/c", "vol").start();
            // Process pb = new ProcessBuilder( "wmic", "diskdrive", "get", "serialnumber").start();
            Process pb = new ProcessBuilder( "getmac", "/v").start();
            InputStream in = pb.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line + NEWLINE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Volume serial: "+buffer.toString());
    }
}
