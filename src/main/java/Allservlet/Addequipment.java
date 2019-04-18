/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Equipment;
import com.mycompany.loginmodule.Gallery;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import operations.DataOperation;
import operations.DropBoxOperation;

/**
 *
 * @author Shravan
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class Addequipment extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String at = scx.getInitParameter("accesstoken");
        DropBoxOperation dbo = new DropBoxOperation(at);
        DataOperation doo = new DataOperation(scx);
        HttpSession hs = request.getSession(true);
        int gymid = Integer.parseInt(hs.getAttribute("gymid").toString());
       // Addgym gym = doo.getGymID(gymid);

//           Set<Equipment> ab = new HashSet<Equipment>();
//       ab = gym.getEqui();
        Collection<Part> colpart = request.getParts();
        Iterator<Part> itp = colpart.iterator();
        ArrayList<String> image = new ArrayList<>();

        while (itp.hasNext()) {
            Part p = itp.next();
            String ctrln = p.getName();

            if (ctrln.equals("equimage")) {
                InputStream is = p.getInputStream();
                String filen = extractFileName(p);
                String url = dbo.uploadFile(filen, is);
                System.out.println("pop" + url);
                image.add(url);
            }
        }

        String title[] = request.getParameterValues("title");
        String desc[] = request.getParameterValues("desc");
//         for(int i=0;i<title.length;i++)
//         {
//             Equipment e=new Equipment();
//             e.setTitle(title[i]);
//             e.setDescr(desc[i]);
//             e.setUrl(image.get(i));
//             e.setAdgym(gym);
//             ab.add(e);
//         }
//         //gym.setEqui(ab);
        doo.addequipment(gymid, title, desc, image);
        response.sendRedirect(scx.getContextPath() + "/gymui/pannel/equipmentediting.jsp");
    }

    private String extractFileName(Part part) {

        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }

        }
        return "";
    }
}
