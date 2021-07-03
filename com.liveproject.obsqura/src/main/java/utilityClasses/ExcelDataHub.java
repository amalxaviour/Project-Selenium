package utilityClasses;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataHub {

	XSSFSheet sheet;
	XSSFWorkbook workbook;

	public ExcelDataHub() {
		try {

			String path=System.getProperty("user.dir")+"\\src\\main\\resources\\LoginDetails.xlsx";
			File src = new File(path);

			FileInputStream fi = new FileInputStream(src);

			workbook = new XSSFWorkbook(fi);
		} catch (Exception e) {
			System.out.println("file not found");
		}
	}

	public String getDataFromExcel(int s, int r, int c) {
		sheet = workbook.getSheetAt(s);

		XSSFRow row = sheet.getRow(r);
		XSSFCell cell = row.getCell(c);

		switch (cell.getCellType()) {

		case STRING: {
			String x;
			x = cell.getStringCellValue();
			return x;
		}
		case NUMERIC: {
			long d = (long) cell.getNumericCellValue();
			return String.valueOf(d);

		}

		default:
			return null;

		}

	}

	
	
	
}
