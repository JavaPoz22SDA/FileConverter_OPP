import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader implements Reader {
    private Path path;

    @Override
    public List<Map<String, Object>> read(String inputFilePath) {
        List<Map<String, Object>> result = new ArrayList<>();

        try{
            path = Paths.get(inputFilePath);
            byte[] bytes = Files.readAllBytes(path);
            String content = new String(bytes);
            String[] newContent = content.split("\\r");

            for (int i = 1; i < newContent.length; i++){
                Map<String, Object> res = new HashMap<>();
                String[] keys = newContent[0].split(";");
                String[] objects = newContent[i].split(";");
                for (int j = 0; j < objects.length; j++){
                    res.put(keys[j], objects[j]);
                }
                result.add(res);

            }




        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;

    }
}
