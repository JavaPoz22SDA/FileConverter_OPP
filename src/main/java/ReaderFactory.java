public class ReaderFactory {
    public Reader produce(String filePath){

        if(filePath.endsWith(".json")){
            return new JSONReader();
        } else if(filePath.endsWith(".csv")){
            return new CSVReader();
        }
        /*
        TODO: CSVReader, ExcelReader ify
         */
        return null;
    }
}
