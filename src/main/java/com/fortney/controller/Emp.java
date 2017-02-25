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
 * Created by Neil on 2/25/2017.
 */

@WebServlet(
        urlPatterns = {"/emp"}
)

public class Emp extends HttpServlet {
    private final Logger log = Logger.getLogger( this.getClass() ) ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp )
            throws ServletException, IOException {

        RequestDispatcher dispatcher = null ;

        if ( req.getParameter( "submit" ).equals( "setup2" ) ) {
            log.info( "Setup2" ) ;
            dispatcher = req.getRequestDispatcher("/emp.jsp" ) ;
        }

        if (null == dispatcher) {
            dispatcher = req.getRequestDispatcher("/index.jsp" ) ;
        }

        dispatcher.forward( req, resp ) ;
    }
}
