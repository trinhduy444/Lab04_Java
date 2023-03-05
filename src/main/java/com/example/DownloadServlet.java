package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(urlPatterns = {"/download"})
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String file = request.getParameter("file");
        if(file == null) {
            response.getWriter().write("File not found");
        }
        else
        {
            try {
                ServletContext context = getServletContext();
                String fullPath = context.getRealPath("/images/"+file);

                Path path = Paths.get(fullPath);
                byte[] data = Files.readAllBytes(path);

                response.setContentType("application/octet-stream");
                response.setHeader("Content-disposition", "attachment; filename="+file);

                response.setContentLength(data.length);
                InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
                OutputStream outStream = response.getOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outStream.close();
            }catch (Exception e) {
                // TODO: handle exception
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
