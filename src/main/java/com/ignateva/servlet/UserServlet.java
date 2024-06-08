package com.ignateva.servlet;

import com.ignateva.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

import static com.ignateva.servlet.UserType.ADMIN;
import static com.ignateva.servlet.UserType.USER;

@WebServlet(name="UserServlet", value = "/userServlet")
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("/enter_page.html").forward(req, resp);
        HttpSession session = req.getSession();
        String login =req.getParameter("login");
        String pass=req.getParameter("pass");
        UserService userService=new UserService();
        if(userService.checkUser(login,pass)==USER){
            if (session.getAttribute("login") == null) {
                session.setAttribute("login", login);

            }
            req.getRequestDispatcher("/form.jsp").forward(req,resp);
        } else if (userService.checkUser(login,pass)==ADMIN){
            if (session.getAttribute("login") == null) {
                session.setAttribute("login", login);

            }
            req.getRequestDispatcher("/admin.jsp").forward(req,resp);

        } else  {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h1>неверное имя или пароль</h1>");
            //out.println("<a href=\"/views/user/registration.html\">Зарегистрироваться</a>");
            out.println("<a href=\"/views/user/enter_page.html\">Попробовать еще раз</a>");
            //req.getRequestDispatcher("/enter_page.html").forward(req,resp);
        }

    }

}


