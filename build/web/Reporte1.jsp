<%-- 
    Document   : Reporte1
    Created on : 19 sep. 2019, 13:27:20
    Author     : JC
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.io.File"%>
<%@page import="com.conexion.Conexion"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report 1</title>
        <% Conexion con = new Conexion(); %>
    </head>
    <body>
        <h1>Reporte 1</h1>
        <%
            
            con.conectar();
            
            File reporte = new File(application.getRealPath("Reportes/reporteProveedor.jasper"));
            Map param = new HashMap();
            byte[] bytes = JasperRunManager.runReportToPdf(reporte.getPath(), param, con.getCon());
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream output = response.getOutputStream();
            response.getOutputStream();
            output.write(bytes,0,bytes.length);
            output.flush();
            output.close();
        %>
    </body>
</html>
