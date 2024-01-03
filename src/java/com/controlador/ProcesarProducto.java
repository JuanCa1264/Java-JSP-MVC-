/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.DaoProducto;
import com.modelo.DaoProveedor;
import com.modelo.Producto;
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
public class ProcesarProducto extends HttpServlet {

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
        try {
            DaoProducto dp = new DaoProducto();
            Producto p = new Producto();
            String msj = null;
            Proveedor pro = new Proveedor();
            
            p.setCodigoProducto(Integer.parseInt(request.getParameter("txtCodigo")));
            p.setNombre(request.getParameter("txtNombre"));
            p.setCategoria(request.getParameter("txtCategoria"));
            p.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
            p.setAnioFabricacion(Integer.parseInt(request.getParameter("txtAnioFabricacion")));
            p.setAnioVencimiento(Integer.parseInt(request.getParameter("txtAnioVencimiento")));
            pro.setCodigoProveedor(Integer.parseInt(request.getParameter("selectProveedor")));
            p.setProveedor(pro);
            
            if (request.getParameter("btnSave")!=null) {
                dp.insertarProducto(p);
                msj = "Insertado Correctamente";
            }
            else if(request.getParameter("btnModificar")!=null){
                dp.modificarProducto(p);
                msj = "Modificar Correctamente";
            }
            else{
                dp.eliminarProducto(p);
                msj = "Eliminado Correctamente";
            }
            response.sendRedirect("producto.jsp");
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
