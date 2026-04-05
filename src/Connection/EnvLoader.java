package Connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnvLoader {

    private static final Map<String, String> envValues = new HashMap<>();

    public static void readFileEnv(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;

            String[] linesEnv = line.split("=");
            if (linesEnv.length == 2) {
                String key = linesEnv[0];
                String value = linesEnv[1];
                envValues.put(key, value);
            }
        }
    }

    public static String get(String key) {
        return envValues.get(key);
    }

    public static String get(String key, String defaultValue) {
        return envValues.getOrDefault(key, defaultValue);
    }
}
