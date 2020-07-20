package poi01;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OutTest {
	
	public void out() {
		
		
	//1.实例化工作薄
	XSSFWorkbook wb = new XSSFWorkbook();
	//2.创建sheet页
	XSSFSheet sheet = wb.createSheet();
	//3.创建行row
	XSSFRow row01 = sheet.createRow(0);
	//4.创建单元格并赋值
	XSSFCell cell= row01.createCell(0);
	//5.导出
	
	
		
		
		
	}
}
