public class ReaderFactory {
    public Reader produce(String filePath){

        if(filePath.endsWith(".json")){
            return new JSONReader();
        } else if(filePath.endsWith(".csv")){
            return new CSVReader();
        } else if ( filePath.endsWith(".xlsx")){
            return new ExcelReader();
        }
        /*
        TODO: CSVReader, ExcelReader ify
         */
        return null;
    }
}
