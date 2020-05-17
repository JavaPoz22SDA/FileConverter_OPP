import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelReader implements Reader {
    @Override
    public List<Map<String, Object>> read(String inputFilePath){
        List<Map<String, Object>> result = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(
                    new File(inputFilePath)
            );

            Workbook workbook = new XSSFWorkbook(inputFilePath);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.rowIterator();
            int size = (sheet.getRow(0).getPhysicalNumberOfCells());
            Row headRow = sheet.getRow(0);

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if(row.getRowNum() > 0){
                    Map<String, Object> map = new HashMap<>();
                    for (int i = 0; i < size; i++) {
                        map.put(headRow.getCell(i).toString(), row.getCell(i));
                    }
                    result.add(map);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  result;
    }
}
