package Allservlet;
import com.mycompany.loginmodule.Members;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
public class Memberreport extends HttpServlet {
 ServletContext scx;

    @Override
    public void init(ServletConfig sc) throws ServletException {
        super.init(sc);
        scx = getServletContext();

        try {
            scx = sc.getServletContext();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("------in get----");
            myServletMethod(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void myServletMethod(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
        JasperReport jasperReport = null;
        JasperDesign jasperDesign = null;

//        String sn = request.getParameter("msg");
//        System.out.println("------" + sn);
//        System.out.println("-----------------------59");
      
        Map parameters = new HashMap();
 HttpSession hs=request.getSession(true);
        Members m= (Members)hs.getAttribute("member");
        int memberid=m.getId();
        System.out.println(memberid);
        System.out.println("------memberid"+memberid);
        parameters.put("memberid",memberid);
        String path = getServletContext().getRealPath("/");
        System.out.println("path==68-----" + path);
        jasperDesign = JRXmlLoader.load(path + "/gymui/Jasperreport/MembersReport.jrxml");
        System.out.println("---------------------70");
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Systemadminreport.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cgs","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Systemadminreport.class.getName()).log(Level.SEVERE, null, ex);
        }
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport,parameters,con);
        System.out.println("--" + byteStream.length);
        File f = new File(path + "MEMBERREPORT.pdf");
        System.out.println("--------------------74");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(byteStream);
        response.setContentType("application/pdf");
        OutputStream outStream = response.getOutputStream();
        String headerKey = "Content-Disposition";
        String fn = "MEMBER_REPORT.pdf";

        outStream.write(byteStream, 0, byteStream.length);
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Systemadminreport.class.getName()).log(Level.SEVERE, null, ex);
        }
        // if  download file
//        String headerValue = String.format("attachment; filename=\"%s\"", fn);
//        response.setHeader(headerKey, headerValue);
//        response.setContentLength(byteStream.length);
          //outStream.write(byteStream, 0, byteStream.length);
        System.out.println("-----------------85");
        //response.sendRedirect(scx.getContextPath() + "/UserPannelDesign/PurchaseOrder.jsp");
    }
   

    

}
