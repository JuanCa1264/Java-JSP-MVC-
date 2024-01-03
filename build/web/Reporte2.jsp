<%-- 
    Document   : Reporte2
    Created on : 19 sep. 2019, 13:56:23
    Author     : JC
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="com.conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report 2</title>
        <% Conexion con = new Conexion(); %>
    </head>
    <body>
        <h1>Reporte 2</h1>
        <% 
            
        int codigoProducto;
        
        if (request.getParameter("parametros")!=null) {
                codigoProducto = Integer.parseInt(request.getParameter("parametros"));
            }
        else{
            codigoProducto = 1;
        }
        
        con.conectar();
        
        File reporte = new File(application.getRealPath("Reportes/reporteProducto.jasper"));
        Map param = new HashMap();
        param.put("codigoP", codigoProducto);
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
