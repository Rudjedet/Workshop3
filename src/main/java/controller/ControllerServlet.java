/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sonja
 */

public class ControllerServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();

        //wanneer de webshop wordt ingegaan
        if (userPath.equals("/shop")) {
            // TODO: shop aanvraag implementeren

        //wanneer de winkelwagen bekeken wordt
        } else if (userPath.equals("/bekijkWinkelwagen")) {
            // TODO: Implement winkelwagen page request

            userPath = "/winkelwagen";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if voegToeAanWinkelwagen action is called
        if (userPath.equals("/voegToeAanWinkelwagen")) {
            // TODO: Implement add product to winkelwagen action

        // if updateWinkelwagen action is called
        } else if (userPath.equals("/updateWinkelwagen")) {
            // TODO: Implement update winkelwagen action

        // if bestellen action is called
        } else if (userPath.equals("/bestellen")) {
            // TODO: Implement purchase action

            userPath = "/bevestiging";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }


}
