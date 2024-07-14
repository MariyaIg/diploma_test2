package com.ignateva.servlet;

import com.ignateva.service.FormService;
import com.ignateva.service.LoadService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="IndustryServlet", value = "/industry-servlet")
@MultipartConfig(maxFileSize = 16177215)//16mb
public class IndustryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getContentType();
        Part filePart = req.getPart("file");
        LoadService loadService=new LoadService();

        String mess = loadService.createIndustriesFromFileExl(filePart);

        resp.setContentType("text/html");


        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + mess + "</h1>");
        out.println("</body></html>");


        //   req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //  Part filePart = req.getPart("file");
       // FormService formService=new FormService();
    //  String mess = formService.createIndustriesFromFileExl(filePart);


/*
        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" +"mess" + "</h1>");
        out.println("</body></html>");

*/
    }
}
