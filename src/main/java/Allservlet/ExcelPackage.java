/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import Excel.WriteExcel;
import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Addpackage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import operations.DataOperation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Shravan
 */
public class ExcelPackage extends HttpServlet {

     ServletContext scx;
public void init(ServletConfig sc) throws ServletException 
     {        
         super.init(sc);
         scx = getServletContext();
         System.out.println("sssss");
        try {          
            scx = sc.getServletContext();
            System.out.println("..."+scx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      //  PrintWriter out=response.getWriter();
        
       DataOperation pko=new DataOperation(scx);
     
        try {
            System.out.println("//////////");
             HashSet<Addpackage> countryList =pko.getpackage();
           
            System.out.println("===========");
            
                           HSSFWorkbook workbook = new HSSFWorkbook(); 
      //Create a blank sheet
                          System.out.println("ttttttttttttttt");
      HSSFSheet sheet = workbook.createSheet("Package Info");

        // Create a blank sheet 
       // XSSFSheet sheet = workbook.createSheet("student Details"); 
              // Workbook workbook = null;
		
		
		          System.out.println("-------------------");
		//Sheet sheet = workbook.createSheet("Countries");
		
		Iterator<Addpackage> iterator = countryList.iterator();
                System.out.println("======="+countryList.size());
		          System.out.println("++++++++++++++++");
		int rowIndex = 0;
                System.out.println("-----");
		
                          if(rowIndex==0)
                          {
                              Row row = sheet.createRow(rowIndex);
                              Cell cell = row.createCell(0);
			cell.setCellValue("ID");
			Cell cell0 = row.createCell(1);
			cell0.setCellValue("PAckage Name");
			Cell cell1 = row.createCell(2);
			cell1.setCellValue("Amount");
                        Cell cell2 = row.createCell(3);
			cell2.setCellValue("no of branches");
                         Cell cell3 = row.createCell(4);
			cell3.setCellValue("time period");
                        rowIndex++;
                          }
                          while(iterator.hasNext()){
		          Addpackage country = iterator.next();
			Row row = sheet.createRow(rowIndex);
                        Cell cell = row.createCell(0);
			cell.setCellValue(country.getId());
			Cell cell0 = row.createCell(1);
			cell0.setCellValue(country.getName());
			Cell cell1 = row.createCell(2);
			cell1.setCellValue(country.getAmount());
                        Cell cell2 = row.createCell(3);
			cell2.setCellValue(country.getNo_of_branches());
                         Cell cell3 = row.createCell(4);
			cell3.setCellValue(country.getTime());
                        rowIndex++;
                          }
                          
		
		          System.out.println("oooooooooooooooo");
		//lets write the excel data to file now
		 System.out.println(scx.getRealPath("/")+"/Package.xls");
      File f=new File(scx.getRealPath("/")+"/Package.xls");
      f.createNewFile();
            System.out.println("lllllllllllllll");
            try (FileOutputStream out1 = new FileOutputStream(f)) {
                workbook.write(out1);
            }
            System.out.println("++++++++++++++++++");
            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
//wb.write(outByteStream);
             FileInputStream fis = new FileInputStream(f);
       byte[]outArray=new byte[fis.available()];
       fis.read(outArray);
//byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length); 
response.setHeader("Expires:", "0"); // eliminates browser caching
 String headerKey = "Content-Disposition";
             String fn="Package.xls";
                String headerValue = String.format("attachment; filename=\"%s\"",fn);
                response.setHeader(headerKey, headerValue);
//response.setHeader("Content-Disposition", "attachment; filename=Leave Details.xls");
OutputStream outStream = response.getOutputStream();
            System.out.println("==="+outStream.toString());
outStream.write(outArray, 0, outArray.length);
//outStream.flush();
//////////////////////////////////////////////////
//            File file = new File(scx.getRealPath("/")+"/Package.xls");
//
//		ResponseBuilder response1 = Response.ok((Object) file);
//		response1.header("Content-Disposition",
//			"attachment; filename=new-excel-file.xls");
//                response1.build();
		//return response.build();

////////////////////////////////////////////////////////////////////////
//       FileInputStream fis = new FileInputStream(f);
//       byte[]byteStream=new byte[fis.available()];
//       fis.read(byteStream);
//      System.out.println("Writesheet.xlsx written successfully");
//   response.setContentType("application/ms-excel");
//                OutputStream outStream = response.getOutputStream();
//                String headerKey = "Content-Disposition";
//             String fn="Package.xls";
//                String headerValue = String.format("attachment; filename=\"%s\"",fn);
//                response.setHeader(headerKey, headerValue);
//                response.setContentLength(byteStream.length);
//                outStream.write(byteStream, 0, byteStream.length);
           response.sendRedirect(scx.getContextPath()+"/gymui/pannel/managepackage1.jsp");
              
          
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
}
