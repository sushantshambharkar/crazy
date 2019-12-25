package excelutil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

public class saveproductinexcel {

	public List<String> testexcel = new ArrayList<String>();

	public File crazyfile = new File("c:/excel/crazyexcel.xlsx");

	public XSSFWorkbook workbook = new XSSFWorkbook();

	public XSSFSheet prodsheet = workbook.createSheet("Products");

	public void createexcel() {

		testexcel.add("I am sushanth");

		testexcel.add("test");

	}

	public void writeexcel() {

		Row row = prodsheet.createRow(1);
		int x = 0;

		for (String s : testexcel) {
			row.getCell(x).setCellValue(s.toString());
		}
	}

}
