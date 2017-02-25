package com.fortney.controller;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Neil on 2/23/2017.
 */

@WebServlet(
        urlPatterns = {"/admin"}
)

public class Admin extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp )
            throws ServletException, IOException {

        RequestDispatcher dispatcher = null ;

        if ( req.getParameter( "submit" ).equals( "setup1" ) ) {
            log.info( "Setup1" ) ;
            dispatcher = req.getRequestDispatcher("/admin.jsp" ) ;
        }

        if (null == dispatcher) {
            dispatcher = req.getRequestDispatcher("/index.jsp" ) ;
        }

        dispatcher.forward( req, resp ) ;
    }
}
