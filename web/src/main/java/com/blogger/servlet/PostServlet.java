package com.blogger.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kolyan on 31.01.16.
 */
@WebServlet("/post")
public class PostServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("post.html").forward(req, resp);
    }
}
