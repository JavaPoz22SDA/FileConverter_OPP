import java.util.List;
import java.util.Map;

public class Conventer {
    public void convert(String sourceFilePath, String outputFilePath){
 // w klasie Conventer w metodzie convert wyświetlić
        //            zwróconą mapę przez metodę read
        ReaderFactory readerFactory = new ReaderFactory();
        Reader reader = readerFactory.produce(sourceFilePath);
        List<Map<String, Object>> result = reader.read(sourceFilePath);
        System.out.println(result);
        if (reader instanceof JSONReader){
            System.out.println("Dziala, mam obiekt JSONReader");
        }


    }
}
