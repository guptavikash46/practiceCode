import java.io.IOException;

public class JsonToHex {

    public static void main(String[] args) {
        try {
            //String json = "{\"name\":\"John\",\"age\":30}";
            String json = "{\"activationToken\": {"+
                                "\"osHostname\": \"ITEM-S119638\","+
                                "\"osName\": \"Windows 11\","+
                                "\"hardwareSysArch\": \"adad2b4b-e3e4-3eab-b63d-1a7bd9d05ea6\","+
                                "\"hardwareSysHostname\": \"bd7f1694-6b2f-3dc1-8a09-889980941e46\" "+
                                "}"+
                                "}";
            System.out.println("Json: "+ json);
            String hex = jsonToHex(json);
            System.out.println("Hexadecimal: " + hex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String jsonToHex(String jsonString) throws IOException {
        // Convert JSON string to byte array
        // ObjectMapper mapper = new ObjectMap();
        // byte[] jsonBytes = mapper.writeValue(jsonString, byte[].class);
        byte[] jsonBytes = jsonString.getBytes();

        // Convert bytes to hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : jsonBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();

    }
}
