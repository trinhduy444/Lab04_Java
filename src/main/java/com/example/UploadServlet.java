package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = {"/upload"})
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("upload.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {


            response.setContentType("text/html");

            List<String> extensions = new ArrayList<String>(Arrays.asList("txt", "doc", "docx", "jpg", "png", "pdf", "rar", "zip"));

            String customFileName = request.getParameter("filename");
            String override = request.getParameter("override");
            Part part = request.getPart("file");
            String fileName = part.getSubmittedFileName();
            //String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();

            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

            if (!extensions.contains(extension)) {
                out.print("<h2>File's type is invalid</h2>");
                return;
            }

            String realPath = request.getServletContext().getRealPath("uploads");
            String newFileName = Path.of(customFileName + "." + extension).getFileName().toString();

            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectory(Path.of(realPath));
            }

            if (Files.exists(Path.of(realPath + "/" + newFileName))) {
                if (override != null) {
                    int i = 0;
                    while (Files.exists(Path.of(realPath + "/" + newFileName))) {
                        newFileName = Path.of(customFileName + "-(" + i + ")." + extension).getFileName().toString();
                        i += 1;
                    }
                } else {
                    out.print("<h2>File is exist</h2>");
                    out.print("<a href='/UploadServlet'>Back</a>");
                    return;
                }
            }

            part.write(realPath + "/" + newFileName);

            out.print("<h2>Upload file successfully!</h2>");
            out.print("<p>Click <a href='/download?file="+newFileName+"'>here</a> to visite file</p>");
            out.print("<a href='/upload'>Back</a>");

        } catch (Exception e) {
            e.printStackTrace();
            out.print("<h2>Error</h2>");
        }
    }
}
