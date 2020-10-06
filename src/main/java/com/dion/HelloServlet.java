package com.dion;

import com.dion.entity.bo.HeadLine;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
@Slf4j
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("初始化servlet ...");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "我的简易框架";
        req.setAttribute("name", name);
        log.debug("name is " + name);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);

        HeadLine headLine = new HeadLine();
        headLine.setLineId(1L);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("是我执行了doGet，我才是入口");
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy...");
    }
}
