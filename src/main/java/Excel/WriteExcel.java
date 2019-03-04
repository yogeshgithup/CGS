/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Excel;

import com.mycompany.loginmodule.Addgym;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class WriteExcel {
    
   static ServletContext scx=null;
     public WriteExcel(ServletContext scx) {
        this.scx = scx;
    }
    
    public static void writeGym(HashSet<Addgym> countryList) throws Exception{
		 //XSSFWorkbook workbook = new XSSFWorkbook(); 
  
//        XSSFWorkbook workbook = new XSSFWorkbook(); 
//      //Create a blank sheet
//      XSSFSheet sheet = workbook.createSheet(" Employee Info ");
//
//        // Create a blank sheet 
//       // XSSFSheet sheet = workbook.createSheet("student Details"); 
//              // Workbook workbook = null;
//		
//		
//		
//		//Sheet sheet = workbook.createSheet("Countries");
//		
//		Iterator<Addgym> iterator = countryList.iterator();
//		
//		int rowIndex = 0;
//		while(iterator.hasNext()){
//		          Addgym country = iterator.next();
//                          if(rowIndex==0)
//                          {
//                              Row row = sheet.createRow(rowIndex++);
//			Cell cell0 = row.createCell(0);
//			cell0.setCellValue("Gym Name");
//			Cell cell1 = row.createCell(1);
//			cell1.setCellValue("Owner Name");
//                        Cell cell2 = row.createCell(2);
//			cell2.setCellValue("Package Name");
//                          }
//                          else
//                          {
//			Row row = sheet.createRow(rowIndex++);
//			Cell cell0 = row.createCell(0);
//			cell0.setCellValue(country.getGymname());
//			Cell cell1 = row.createCell(1);
//			cell1.setCellValue(country.getOwnername());
//                        Cell cell2 = row.createCell(2);
//			cell2.setCellValue(country.getAdpack().getName());
//                          }
//		}
//		
//		//lets write the excel data to file now
//		 System.out.println(scx.getRealPath("/")+"/Writesheet.xlsx");
//      File f=new File(scx.getRealPath("/")+"/Writesheet.xlsx");
//      f.createNewFile();
//      FileOutputStream out = new FileOutputStream(f);
//      workbook.write(out);
//      out.close();
//       FileInputStream fis = new FileInputStream(f);
//       byte[]byteStream=new byte[fis.available()];
//       fis.read(byteStream);
//      System.out.println("Writesheet.xlsx written successfully");
//   response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sh");
//                OutputStream outStream = response.getOutputStream();
//                String headerKey = "Content-Disposition";
//             String fn="Writesheet.xlsx";
//                String headerValue = String.format("attachment; filename=\"%s\"",fn);
//                response.setHeader(headerKey, headerValue);
//                response.setContentLength(byteStream.length);
//                outStream.write(byteStream, 0, byteStream.length);

        // This data needs to be written (Object[]) 
        
  
        // Iterate over data and write to sheet 
       
       
	}
}
