/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addbranch;
import com.mycompany.loginmodule.Addpackage;
import com.mycompany.loginmodule.Batch_member;
import com.mycompany.loginmodule.Batches;
import com.mycompany.loginmodule.Gympackage;
import com.mycompany.loginmodule.Pack_facility;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import operations.DataOperation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelGymBatches extends HttpServlet {

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
            HttpSession session=request.getSession(true);  
         // session.setAttribute("getbranch",ab);
        
            System.out.println("===========");
            
                           HSSFWorkbook workbook = new HSSFWorkbook(); 
      //Create a blank sheet
                          System.out.println("ttttttttttttttt");
      HSSFSheet sheet = workbook.createSheet("GymPackage Info");

        // Create a blank sheet 
       // XSSFSheet sheet = workbook.createSheet("student Details"); 
              // Workbook workbook = null;
		
		
		          System.out.println("-------------------");
		//Sheet sheet = workbook.createSheet("Countries");
		 String branchid= session.getAttribute("branchid").toString();
         //  System.out.println("gymid==="+l2.getId());
         System.out.println("view batches");
          // DataOperation pko=new DataOperation(scx,id);
            //Addgym gym = pko.getGymID(id);
           Addbranch ab=pko.getBranch(branchid);
            if(ab!=null){
                     Set<Batches> countryList=ab.getBatches();
                  //  Iterator it= countryList.iterator();
              
		Iterator<Batches> iterator = countryList.iterator();
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
			cell0.setCellValue("Batch Name");
			Cell cell1 = row.createCell(2);
			cell1.setCellValue("Time from");
                        Cell cell2 = row.createCell(3);
			cell2.setCellValue("Time to");
                         Cell cell3 = row.createCell(4);
			cell3.setCellValue("role");
                          Cell cell4 = row.createCell(5);
			cell4.setCellValue("Members");
                        rowIndex++;
                          }
                          
                          while(iterator.hasNext()){
		          Batches country = iterator.next();
			Row row = sheet.createRow(rowIndex);
                        Cell cell = row.createCell(0);
			cell.setCellValue(country.getId());
			Cell cell0 = row.createCell(1);
			cell0.setCellValue(country.getBatch_name());
			Cell cell1 = row.createCell(2);
			cell1.setCellValue(country.getTime_from());
                        Cell cell2 = row.createCell(3);
                        cell2.setCellValue(country.getTime_to());
                          Cell cell7 = row.createCell(4);
                        cell7.setCellValue(country.getFacility_batches().getName());
                       Iterator it1= country.getBatche_member().iterator();
                       int q=1;
                               if(it1!=null)
                               {
                                   while(it1.hasNext())
                                   {
                                    Batch_member pf=(Batch_member)it1.next();
                               
                                     
                                    if(q==1)
                                    {
                                        System.out.println("if   "+rowIndex);
                                   Cell cell5 = row.createCell(5);
		              	cell5.setCellValue(pf.getMemb().getFirstname()+" "+pf.getMemb().getLastname());
                               //  System.out.println(""+pf.getFacc().getName());
                                rowIndex++;
                                q++;
                                    }
                                    else
                                    {
                                        System.out.println("else  "+rowIndex);
                                      //  System.out.println(""+pf.getMemb().);
                                        Row row1 = sheet.createRow(rowIndex);
                                         Cell cell5 = row1.createCell(5);
		              	cell5.setCellValue(pf.getMemb().getFirstname()+" "+pf.getMemb().getLastname());
                                rowIndex++;
                                q++;
                                    }
                                   }
                               }
                               else
                               {
//			Cell cell3 = row.createCell(4);
//                        cell3.setCellValue(country.getTime());
                        rowIndex++;
                               }
                          }
                          
            }
		          System.out.println("oooooooooooooooo");
		//lets write the excel data to file now
		 System.out.println(scx.getRealPath("/")+"/GYMBatch.xls");
      File f=new File(scx.getRealPath("/")+"/GYMBatch.xls");
      f.createNewFile();
            System.out.println("lllllllllllllll");
            try (FileOutputStream out1 = new FileOutputStream(f)) {
                workbook.write(out1);
            }
            System.out.println("++++++++++++++++++");
      // FileInputStream fis = new FileInputStream(f);
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
             String fn="GYMBatch.xls";
                String headerValue = String.format("attachment; filename=\"%s\"",fn);
                response.setHeader(headerKey, headerValue);
//response.setHeader("Content-Disposition", "attachment; filename=Leave Details.xls");
OutputStream outStream = response.getOutputStream();
            System.out.println("==="+outStream.toString());
outStream.write(outArray, 0, outArray.length); 
response.sendRedirect(scx.getContextPath()+"/gymui/pannel/managebatches1.jsp");
        
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
}
