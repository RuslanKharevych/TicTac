package Servlets;

import Beans.UserList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GameServlet")
public class GameS extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("player")!=null && request.getParameter("victory")!=null){
            if(request.getParameter("victory").equals("true")){
                new UserList().addVictory(((String)request.getSession().getAttribute("player")));
            }
            else{
                new UserList().addLoss(((String)request.getSession().getAttribute("player")));
            }
            response.sendRedirect("main.jsp");
        }
        else{
            response.sendRedirect("main.jsp");
        }

    }
}
