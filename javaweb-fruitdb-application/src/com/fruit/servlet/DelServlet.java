package com.fruit.servlet;

import com.fruit.dao.FruitDAO;
import com.fruit.dao.impl.FruitDAOImpl;
import com.myssm.myspringmvc.ViewBaseServlet;
import com.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();
    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        String fidStr = request.getParameter("fid");
        if(!StringUtil.isEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);
            fruitDAO.delFruit(fid);

            //super.processTemplate("index",request,response);
            response.sendRedirect("index");
        }
    }
}
