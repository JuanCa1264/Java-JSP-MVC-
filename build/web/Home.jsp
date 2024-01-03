<%-- 
    Document   : Home
    Created on : 19 sep. 2019, 13:15:43
    Author     : JC
--%>

<%@page import="com.modelo.Proveedor"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.DaoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <% DaoProducto dp = new DaoProducto(); %>
    <body>
        <h1>Principal</h1>
        <div aling="center">
            <h2>Reportes</h2>
            <ul>
                <li><a href="Reporte1.jsp">Reporte 1 no parametrizado</a></li>
                
            </ul>
            <form action="Reporte2.jsp">
                <select name="parametros">
                    <% List<Proveedor> lst = dp.listarProveedores();
                        for(Proveedor pro: lst){
                    %>
                    <option value='<%= pro.getCodigoProveedor()%>'><%= pro.getNombre() %></option>
                    <% } %>
                </select>
                <input type="submit" name="b1" value="Reporte parametrizado">
            </form>
        </div>
    </body>
</html>
