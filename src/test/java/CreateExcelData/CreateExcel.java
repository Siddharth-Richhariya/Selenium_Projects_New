package CreateExcelData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class CreateExcel {

    public static void main(String[] args) throws IOException {
        Map<String, Object> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginID", "Email", "Password"});
        data.put("2", new Object[]{"1", "Sid@chart.com", "admin23"});
        data.put("3", new Object[]{"2", "Sid@cap.com", "admin123"});
        data.put("4", new Object[]{"3", "Sid@gami.com", "admin1234"});
        data.put("5", new Object[]{"4", "Sid@micro.com", "UBABDH4587@"});
        data.put("6", new Object[]{"5", "Sid@out.com", "Saidjf"});

        createExcel("New3.xlsx", data);
    }


    public static void createExcel(String name , Map data) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");
        int rownum = 0;
        Cell cell = null;
        for(Object key : data.keySet()){
            Row row = sheet.createRow(rownum++);
            Object[] a =  (Object[]) data.get(key);
            int cellnum = 0;

            for (Object o : a){
               cell = row.createCell(cellnum++);
                cell.setCellValue((String) o);
            }
        }

        FileOutputStream outputStream = new FileOutputStream(name);
        workbook.write(outputStream);
        outputStream.close();

    }
}
