<%-- 
    Document   : proveedor
    Created on : 15 sep. 2019, 10:46:56
    Author     : JC
--%>

<%@page import="java.util.*"%>
<%@page import="com.modelo.Proveedor"%>
<%@page import="com.modelo.DaoProveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script lang="JavaScript">
            function cargar(codigo, nombre, direccion, telefono){
                document.frmProveedor.txtCodigo.value = codigo;
                document.frmProveedor.txtNombre.value = nombre;
                document.frmProveedor.txtDireccion.value = direccion;
                document.frmProveedor.txtTelefono.value = telefono;
            }
            </script>
            <%
                if (request.getSession().getAttribute("msj")!=null) {
                        
                    
            %>
            <script type="text/javascript">
                alert('<%= request.getSession().getAttribute("msj") %>')
                </script>
                <% 
                    }
                %>
    </head>
    <% DaoProveedor dp = new DaoProveedor(); %>
    <body>
        <h1>Hello World!</h1>
    <center>
        <table border="1">
            <form action="procesarProveedor" method="POST" name="frmProveedor">
                <tr>
                    <td>Código:</td>
                    <td><input type="text" name="txtCodigo"></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="txtNombre"</td>
                </tr>
                <tr>
                    <td>Dirección:</td>
                    <td><input type="text" name="txtDireccion"</td>
                </tr>
                <tr>
                    <td>Teléfono:</td>
                    <td><input type="text" name="txtTelefono"</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="btnInsertar" value="Insertar">
                        <input type="submit" name="btnModificar" value="Modificar"
                               onclick="return confirm('¿Desea modificar al proveedor?')">
                        <input type="submit" name="btnEliminar" value="Eliminar"
                               onclick="return confirm('¿Desea eliminar al proveedor?')">
                        <input type="reset" name="btnLimpiar" value="Limpiar">
                    </td>
                </tr> 
            </form>
        </table>
        <br>
        <br>
        <hr>
        <table border="2">
            <thead>
                <tr>
                    <th>Código Proveedor</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Teléfono</th>
                    <th>Seleccionar</th>
                </tr>
            </thead>
            <tbody>
                <%  List<Proveedor> lst = new ArrayList();
                    lst = dp.mostrarProveedor();
                     for(Proveedor pro:lst){
                %>
                <tr>
                    <td><%= pro.getCodigoProveedor() %></td>
                    <td><%= pro.getNombre()%></td>
                    <td><%= pro.getDireccion() %></td>
                    <td><%= pro.getTelefono() %> </td>
                    <td><a href="javascript:cargar(<%= pro.getCodigoProveedor() %>,
                           '<%= pro.getNombre() %>','<%= pro.getDireccion() %>',
                           '<%= pro.getTelefono() %>')">Seleccionar</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </center>
    </body>
</html>
