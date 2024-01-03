/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.DaoProveedor;
import com.modelo.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JC
 */
public class ProcesarProveedor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Proveedor p = new Proveedor();
        DaoProveedor dp = new DaoProveedor();
        String msj = null;
        try {
            p.setCodigoProveedor(Integer.parseInt(request.getParameter("txtCodigo")));
            p.setNombre(request.getParameter("txtNombre"));
            p.setDireccion(request.getParameter("txtDireccion"));
            p.setTelefono(request.getParameter("txtTelefono"));
            if (request.getParameter("btnInsertar")!=null) {
                dp.insertarProveedor(p);
                msj="Datos Insertardos";
            }
            else if (request.getParameter("btnModificar")!=null) {
                dp.modificarProveedor(p);
                msj="Datos Modificados";
            }
            else{
                dp.eliminarProveedor(p);
                msj="Datos Eliminados";
            }
            response.sendRedirect("proveedor.jsp");
            request.getSession().setAttribute("msj", msj);
        } catch (Exception e) {
            request.getSession().setAttribute("error", e.toString());
        }
    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
