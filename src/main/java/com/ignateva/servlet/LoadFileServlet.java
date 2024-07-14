package com.ignateva.servlet;

import com.oreilly.servlet.MultipartRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name ="LoadFileServlet", value = "/loadFile-servlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)//16mb
public class LoadFileServlet  extends HttpServlet{
    private static final String UPLOAD_DIRECTORY = "C:\\Users\\Мария\\apache-tomcat-10.1.19\\apache-tomcat-10.1.19\\webapps\\diploma_test2_war";
    private static final int MEMORY_THRESHOLD = 1024 * 1024;
    private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 5 * 5;
    private static final long MAX_FILE_SIZE = 1024 * 1024 * 5;



    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
/*
        request.getPart("file");
            //if (ServletFileUpload.isMultipartContent((RequestContext) request.getPart("file"))){

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);
            String uploadPath = getServletContext().getRealPath("")
                    + File.separator + UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            List<FileItem> formItems = null;
            try {
                formItems = upload.parseRequest((RequestContext) request);
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        try {
                            item.write(storeFile);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        request.setAttribute("message", "File "
                                + fileName + " has uploaded successfully!");
                    }
                }
            }
        //}*/
    }
}
