package com.fortney.controller;

import com.fortney.persistence.CoffeeDao ;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Created by Neil on 2/15/2017.
 */

@WebServlet(
        urlPatterns = {"/home"}
)

public class Home extends HttpServlet {
    private final Logger log = Logger.getLogger( this.getClass() ) ;

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp )
            throws ServletException, IOException {

        RequestDispatcher dispatcher = null ;

        CoffeeDao coffee = new CoffeeDao() ;

        log.info( req.getParameter( "findString" ) ) ;
        log.info( req.getParameter( "submit" ) ) ;

        if ( req.getParameter( "submit" ).equals( "Find" ) ) {
            log.info( req.getParameter( "findString" ) ) ;
//            req.setAttribute( "users", userData.getUsersByLastName(req.getParameter( "searchTerm" ) ) ) ;
        }
        else if ( req.getParameter( "submit" ).equals( "setup1" ) ) {
            log.info( "Setup1" ) ;
//            req.setAttribute( "users", userData.getAllUsers() ) ;
            dispatcher = req.getRequestDispatcher("/admin.jsp" ) ;
        }
        else if ( req.getParameter( "submit" ).equals( "setup2" ) ) {
            log.info( "Setup2" ) ;
//            req.setAttribute( "", "" ) ;
            dispatcher = req.getRequestDispatcher("/emp.jsp" ) ;
        }
        else if ( req.getParameter( "submit" ).equals( "coffees" ) ) {
            log.info( "Coffees" ) ;
            req.setAttribute( "coffeeList", coffee.getAllCoffees() ) ;
            dispatcher = req.getRequestDispatcher("/coffees.jsp" ) ;
        }

        if ( null == dispatcher ) {
            dispatcher = req.getRequestDispatcher( "/index.jsp" ) ;
        }
        dispatcher.forward( req, resp);
    }

}
